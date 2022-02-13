package com.mrcrayfish.backpacked;

import com.mrcrayfish.backpacked.inventory.container.BackpackContainerMenu;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: MrCrayfish
 */
public class Config
{
    public static class Client
    {
        public final ForgeConfigSpec.BooleanValue hideConfigButton;

        Client(ForgeConfigSpec.Builder builder)
        {
            this.hideConfigButton = builder.comment("If enabled, hides the config button from the backpack screen").define("hideConfigButton", false);
        }
    }

    public static class Common
    {
        public final ForgeConfigSpec.BooleanValue keepBackpackOnDeath;
        public final ForgeConfigSpec.IntValue backpackInventorySizeColumns;
        public final ForgeConfigSpec.IntValue backpackInventorySizeRows;

        Common(ForgeConfigSpec.Builder builder)
        {
            builder.comment("Common configuration settings").push("common");
            this.keepBackpackOnDeath = builder
                    .comment("Determines whether or not the backpack should be dropped on death")
                    .translation("backpacked.configgui.keepBackpackOnDeath")
                    .define("keepBackpackOnDeath", false);
            this.backpackInventorySizeColumns = builder
                    .comment("The amount of slot columns in the backpack inventory.")
                    .translation("backpacked.configgui.backpackInventorySizeColumns")
                    .defineInRange("backpackInventorySizeColumns", 9, 1, BackpackContainerMenu.MAX_COLUMNS);
            this.backpackInventorySizeRows = builder
                    .comment("The amount of slot rows in the backpack inventory.")
                    .translation("backpacked.configgui.backpackInventorySizeRows")
                    .defineInRange("backpackInventorySize", 1, 1, BackpackContainerMenu.MAX_ROWS);
            builder.pop();
        }
    }

    public static class Server
    {
        public final ForgeConfigSpec.ConfigValue<List<? extends String>> bannedItems;
        public final ForgeConfigSpec.BooleanValue unlockAllBackpacks;
        public final ForgeConfigSpec.BooleanValue lockBackpackIntoSlot;
        public final ForgeConfigSpec.BooleanValue dropContentsFromShelf;
        public final ForgeConfigSpec.BooleanValue autoEquipBackpackOnPickup;
        public final ForgeConfigSpec.BooleanValue pickpocketBackpacks;
        public final ForgeConfigSpec.DoubleValue pickpocketMaxReachDistance;
        public final ForgeConfigSpec.DoubleValue pickpocketMaxRangeAngle;

        Server(ForgeConfigSpec.Builder builder)
        {
            builder.comment("Common configuration settings").push("common");
            this.bannedItems = builder.comment("A list of items that are not allowed inside a backpack. Note: It is recommended to ban items that have an inventory as this will create large NBT data and potentially crash the server!").defineList("bannedItems", Server::getDefaultBannedItems, Server::resourceLocationValidator);
            this.unlockAllBackpacks = builder.comment("Allows every player to use any backpack cosmetic variant without needing to complete the challenges. Side note, any progress to a challenge will not be tracked while enabled.").define("unlockAllBackpacks", false);
            this.lockBackpackIntoSlot = builder.comment("Stops players from removing the backpack if it's not empty. This prevents players from carrying multiple backpacks.").define("lockBackpackIntoSlot", true);
            this.dropContentsFromShelf = builder.comment("When breaking a shelf, the placed backpack will also drops it's items into the world. This prevents players from carrying multiple backpacks").define("dropContentsFromShelf", true);
            this.autoEquipBackpackOnPickup = builder.comment("When picking up a backpack (with items inside) off the ground, the item will automatically equip. Having this enabled may not be ideal for multiplayer servers.").define("autoEquipBackpackOnPickup", false);
            this.pickpocketBackpacks = builder.comment("If enabled, allows players to access the backpack of another player by interacting with the visible backpack on their back.").define("pickpocketBackpacks", true);
            this.pickpocketMaxReachDistance = builder.comment("The maximum reach distance of a player to interact with another player's backpack.").defineInRange("pickpocketDistance", 1.5, 0.0, 4.0);
            this.pickpocketMaxRangeAngle = builder.comment("The maximum angle at which another player's backpack can be accessed").defineInRange("pickpocketMaxRangeAngle", 80.0, 0.0, 90.0);
            builder.pop();
        }
        
        private static boolean resourceLocationValidator(Object o)
        {
            return ResourceLocation.tryParse(o.toString()) != null;
        }

        private static List<String> getDefaultBannedItems()
        {
            List<String> bannedItems = new ArrayList<>();
            bannedItems.add("travelersbackpack:custom_travelers_backpack");
            bannedItems.add("pinesbarrels:better_barrel");
            bannedItems.add("quark:seed_pouch");
            bannedItems.add("quark:backpack");
            bannedItems.add("sophisticatedbackpacks:backpack");
            bannedItems.add("sophisticatedbackpacks:iron_backpack");
            bannedItems.add("sophisticatedbackpacks:gold_backpack");
            bannedItems.add("sophisticatedbackpacks:diamond_backpack");
            bannedItems.add("sophisticatedbackpacks:netherite_backpack");
            bannedItems.add("improvedbackpacks:tiny_pocket");
            bannedItems.add("improvedbackpacks:medium_pocket");
            bannedItems.add("improvedbackpacks:large_pocket");
            bannedItems.add("improvedbackpacks:white_backpack");
            bannedItems.add("improvedbackpacks:orange_backpack");
            bannedItems.add("improvedbackpacks:magenta_backpack");
            bannedItems.add("improvedbackpacks:light_blue_backpack");
            bannedItems.add("improvedbackpacks:yellow_backpack");
            bannedItems.add("improvedbackpacks:lime_backpack");
            bannedItems.add("improvedbackpacks:pink_backpack");
            bannedItems.add("improvedbackpacks:gray_backpack");
            bannedItems.add("improvedbackpacks:light_gray_backpack");
            bannedItems.add("improvedbackpacks:cyan_backpack");
            bannedItems.add("improvedbackpacks:purple_backpack");
            bannedItems.add("improvedbackpacks:blue_backpack");
            bannedItems.add("improvedbackpacks:brown_backpack");
            bannedItems.add("improvedbackpacks:green_backpack");
            bannedItems.add("improvedbackpacks:red_backpack");
            bannedItems.add("improvedbackpacks:black_backpack");
            bannedItems.add("immersiveengineering:toolbox");
            bannedItems.add("immersiveengineering:crate");
            bannedItems.add("immersiveengineering:reinforced_crate");
            bannedItems.add("create:white_toolbox");
            bannedItems.add("create:orange_toolbox");
            bannedItems.add("create:magenta_toolbox");
            bannedItems.add("create:light_blue_toolbox");
            bannedItems.add("create:yellow_toolbox");
            bannedItems.add("create:lime_toolbox");
            bannedItems.add("create:pink_toolbox");
            bannedItems.add("create:gray_toolbox");
            bannedItems.add("create:light_gray_toolbox");
            bannedItems.add("create:cyan_toolbox");
            bannedItems.add("create:purple_toolbox");
            bannedItems.add("create:blue_toolbox");
            bannedItems.add("create:brown_toolbox");
            bannedItems.add("create:green_toolbox");
            bannedItems.add("create:red_toolbox");
            bannedItems.add("create:black_toolbox");
            bannedItems.add("mekanism:personal_chest");
            bannedItems.add("supplementaries:sack");
            return bannedItems;
        }
    }

    static final ForgeConfigSpec clientSpec;
    public static final Config.Client CLIENT;

    static final ForgeConfigSpec commonSpec;
    public static final Config.Common COMMON;

    static final ForgeConfigSpec serverSpec;
    public static final Config.Server SERVER;

    static
    {
        final Pair<Client, ForgeConfigSpec> clientPair = new ForgeConfigSpec.Builder().configure(Config.Client::new);
        clientSpec = clientPair.getRight();
        CLIENT = clientPair.getLeft();

        final Pair<Common, ForgeConfigSpec> commonPair = new ForgeConfigSpec.Builder().configure(Config.Common::new);
        commonSpec = commonPair.getRight();
        COMMON = commonPair.getLeft();

        final Pair<Server, ForgeConfigSpec> serverPair = new ForgeConfigSpec.Builder().configure(Config.Server::new);
        serverSpec = serverPair.getRight();
        SERVER = serverPair.getLeft();
    }
}
