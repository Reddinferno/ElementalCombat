package elementalcombat.common.entity.element.earth;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import elementalcombat.common.entity.EntityElement;

public class EntityBlock extends EntityElement
{
	public Block block;
    public NBTTagCompound tileEntityNBT;

	public EntityBlock(World world)
	{
		super(world);
		setSize(0.95F, 0.95F);
		posY -= 15.0D;
	}
	
	public EntityBlock(World world, int x, int y, int z)
	{
		super(world);
		posY -= 15.0D;
		setSize(0.95F, 0.95F);
		TileEntity tile = world.getTileEntity(x, y, z);
        if(tile != null && block instanceof ITileEntityProvider)
        {
            world.setTileEntity(x, y, z, ((ITileEntityProvider)block).createNewTileEntity(world, getMeta()));

            tileEntityNBT = new NBTTagCompound();
            tile.writeToNBT(tileEntityNBT);

            tile.invalidate();
        }

        world.setBlockToAir(x, y, z);

        setLocationAndAngles(x + 0.5D, y + 0.5D - (double)yOffset, z + 0.5D, 0F, 0F);
	}
	
    public void setBlock(Block block)
    {
        this.block = block;
        dataWatcher.updateObject(16, Block.getIdFromBlock(block));
    }

    public Block getBlock()
    {
        if(block == null)
        {
            block = Block.getBlockById(dataWatcher.getWatchableObjectInt(16));
        }
        return block == null ? Blocks.bedrock : block;
    }

    public void setMeta(int i)
    {
        dataWatcher.updateObject(17, i);
    }

    public int getMeta()
    {
        return dataWatcher.getWatchableObjectInt(17);
    }
    
    @Override
    protected void entityInit()
    {
        dataWatcher.addObject(16, Block.getIdFromBlock(Blocks.bedrock));//blockID
        dataWatcher.addObject(17, 0);//metadata
    }

	@Override
	public void onEntityUpdate()
	{
	}

	@Override
	public void entityImpact(Entity entity)
	{
	}

	@Override
	public void blockImpact(World world, int x, int y, int z)
	{
	}

	@Override
	public void waterImpact(World world, int x, int y, int z)
	{
	}

	@Override
	public float speedMotion()
	{
		return 0;
	}

	@Override
	public float gravityMotion()
	{
		return 0;
	}

	@Override
	public int maxLife()
	{
		return 10;
	}

}
