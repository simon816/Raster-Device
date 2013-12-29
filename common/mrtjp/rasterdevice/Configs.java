package mrtjp.rasterdevice;

import java.io.File;

import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.Property;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class Configs
{
    protected static File _configFolder;
    protected static File _configFile;

    /** Constants **/
    public static final String modName = "Project Red";
    public static final String version = "@VERSION@";
    public static final String buildnumber = "@BUILD_NUMBER@";

   
    /** Item IDs **/
    public static int item_RasterDevice;

    /** Settings **/

    
    /** Render **/


    public static void init(FMLPreInitializationEvent event)
    {
        _configFolder = event.getModConfigurationDirectory();
        _configFile = new File(_configFolder.getAbsolutePath() + "/RasterDevice.cfg");
        loadPropertiesFromFile(_configFile);
    }

    public static void loadPropertiesFromFile(File file)
    {
        Configuration localConfig = new Configuration(file);
        localConfig.load();

        item_RasterDevice = localConfig.getItem("item_RasterDevice", 5024).getInt();

        localConfig.save();
    }
}