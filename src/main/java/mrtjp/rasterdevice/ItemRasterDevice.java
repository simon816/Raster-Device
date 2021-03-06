package mrtjp.rasterdevice;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemRasterDevice extends Item
{
    public ItemRasterDevice()
    {
        setUnlocalizedName("rasterdevice.rasterdevice");
        setMaxStackSize(1);
        setMaxDamage(128);
        setNoRepair();
        setCreativeTab(CreativeTabs.tabTools);
        GameRegistry.registerItem(this, "rasterdevice.rasterdevice");
    }

    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World w, int x, int y, int z, int side, float par8, float par9, float par10)
    {
        openGui(player);
        return false;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World w, EntityPlayer player)
    {
        openGui(player);
        return super.onItemRightClick(stack, w, player);
    }
    
    private void openGui(EntityPlayer player)
    {
        Minecraft.getMinecraft().displayGuiScreen(new GuiRasterDevice());
    }
    
    @Override
    public boolean doesSneakBypassUse(World w, int x, int y, int z, EntityPlayer player)
    {
        return true;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon("rasterdevice:rasterdevice");
    }
}
