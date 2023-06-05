package com.pixilaremedia.pixeladditions.blocks;

import com.pixilaremedia.pixeladditions.container.EtchingContainer;
import com.pixilaremedia.pixeladditions.registries.StatsRegistry;
import com.pixilaremedia.pixeladditions.util.Ref;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;
import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

import static net.minecraft.world.level.block.state.properties.BlockStateProperties.HORIZONTAL_FACING;
import static net.minecraft.world.level.block.state.properties.BlockStateProperties.WATERLOGGED;

public class EtchingBlock extends HorizontalDirectionalBlock implements BucketPickup, LiquidBlockContainer {
    public static final Component TRANSLATION = Ref.containerTranslation("etching");
    private static final EnumMap<Direction, VoxelShape> SHAPE_BY_DIRECTION = new EnumMap<>(Direction.class);
    protected static final VoxelShape SHAPE = Block.box(0d,0d,0d,16d,9d,16d);

    public EtchingBlock() {
        super(BlockBehaviour.Properties.of(Material.WOOD).requiresCorrectToolForDrops().strength(3.5f));
        registerDefaultState(this.stateDefinition.any().setValue(HORIZONTAL_FACING, Direction.NORTH).setValue(WATERLOGGED, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = context.getLevel().getBlockState(context.getClickedPos());
        return defaultBlockState().setValue(HORIZONTAL_FACING, context.getHorizontalDirection().getOpposite()).setValue(WATERLOGGED, state.getBlock() != this && state.getFluidState().getType() == Fluids.WATER);
    }

    @Override
    public InteractionResult use(BlockState state, Level worldIn, BlockPos pos, Player player, InteractionHand handIn, BlockHitResult hit) {
        if (!worldIn.isClientSide()) {
            player.openMenu(state.getMenuProvider(worldIn, pos));
            player.awardStat(StatsRegistry.INTERACT_WITH_ETCHING_TABLE);
        }
        return InteractionResult.CONSUME; // required both sides to avoid swing arm
    }

    @Override
    @Nullable
    public MenuProvider getMenuProvider(BlockState state, Level worldIn, BlockPos pos) {
        return new SimpleMenuProvider((id, playerInventory, player) -> new EtchingContainer(id, playerInventory, ContainerLevelAccess.create(worldIn, pos)), TRANSLATION);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public boolean useShapeForLightOcclusion(BlockState state) {
        return true;
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, WATERLOGGED);
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter worldIn, BlockPos pos, PathComputationType type) {
        return false;
    }

    @Override
    @Nullable
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        return null;
    }

    @Override
    public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
        List<ItemStack> drops = super.getDrops(state, builder);
        drops.add(new ItemStack(this));
        return drops;
    }

    @Override
    public BlockState updateShape(BlockState olState, Direction facing, BlockState newState, LevelAccessor levelAccessor, BlockPos oldPos, BlockPos newPos) {
        if (olState.getValue(WATERLOGGED)) {
            levelAccessor.scheduleTick(oldPos, Fluids.WATER, Fluids.WATER.getTickDelay(levelAccessor));
        }
        return super.updateShape(olState, facing, newState, levelAccessor, oldPos, newPos);
    }

    @Override
    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : Fluids.EMPTY.defaultFluidState();
    }

    @Override
    public ItemStack pickupBlock(LevelAccessor levelAccessor, BlockPos pos, BlockState state) {
        if (state.getValue(WATERLOGGED)) {
            levelAccessor.setBlock(pos, state.setValue(WATERLOGGED, false), 3);
            return new ItemStack(Items.WATER_BUCKET);
        }
        return ItemStack.EMPTY;
    }

    @Override
    public Optional<SoundEvent> getPickupSound() {
        return Fluids.WATER.getPickupSound();
    }

    @Override
    public boolean canPlaceLiquid(BlockGetter blockGetter, BlockPos pos, BlockState state, Fluid fluid) {
        return !state.getValue(WATERLOGGED) && fluid == Fluids.WATER;
    }

    @Override
    public boolean placeLiquid(LevelAccessor levelAccessor, BlockPos pos, BlockState state, FluidState fluidState) {
        if (!state.getValue(WATERLOGGED) && fluidState.getType() == Fluids.WATER) {
            if (!levelAccessor.isClientSide()) {
                levelAccessor.setBlock(pos, state.setValue(WATERLOGGED, true), 3);
                levelAccessor.scheduleTick(pos, fluidState.getType(), fluidState.getType().getTickDelay(levelAccessor));
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean propagatesSkylightDown(BlockState state, BlockGetter blockGetter, BlockPos pos) {
        return true;
    }
}
