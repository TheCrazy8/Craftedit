package com.thecrazy8.craftedit;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Main mod class for Craftedit
 * 
 * This mod provides functionality to edit and create recipes for various recipe types:
 * - Crafting table recipes
 * - Brewing stand recipes
 * - Furnace recipes (furnace, blast furnace, smoker)
 * - Botany Pot recipes
 * - Anvil recipes
 * - Smithing table recipes
 * 
 * Integrates with CraftTweaker for recipe manipulation and EMI for recipe viewing.
 * Works on both client and dedicated server environments.
 */
@Mod(Craftedit.MOD_ID)
public class Craftedit {
    public static final String MOD_ID = "craftedit";
    private static final Logger LOGGER = LogManager.getLogger();

    public Craftedit() {
        LOGGER.info("Initializing Craftedit - CraftTweaker Recipe Editor");
        LOGGER.info("Running on: {}", FMLEnvironment.dist);
        
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        
        LOGGER.info("Craftedit supports editing/creating recipes for:");
        LOGGER.info("  - Crafting Table");
        LOGGER.info("  - Brewing Stand");
        LOGGER.info("  - Furnaces (Furnace, Blast Furnace, Smoker)");
        LOGGER.info("  - Botany Pots");
        LOGGER.info("  - Anvil");
        LOGGER.info("  - Smithing Table");
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("Craftedit setup complete");
        LOGGER.info("CraftTweaker integration ready for recipe manipulation");
        LOGGER.info("Server-compatible: Recipe modifications work on dedicated servers");
    }
}
