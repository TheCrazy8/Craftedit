package com.thecrazy8.craftedit.client;

import com.mojang.blaze3d.platform.InputConstants;
import com.thecrazy8.craftedit.Craftedit;
import com.thecrazy8.craftedit.gui.RecipeEditorScreen;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

/**
 * Client-side key bindings for Craftedit
 * 
 * Provides a keybinding to open the recipe editor GUI
 */
@Mod.EventBusSubscriber(modid = Craftedit.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class KeyBindings {
    
    public static final String KEY_CATEGORY = "key.categories.craftedit";
    public static final String KEY_OPEN_EDITOR = "key.craftedit.open_editor";
    
    public static KeyMapping openEditorKey;
    
    @Mod.EventBusSubscriber(modid = Craftedit.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ModEventHandler {
        @SubscribeEvent
        public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
            openEditorKey = new KeyMapping(
                KEY_OPEN_EDITOR,
                InputConstants.Type.KEYSYM,
                GLFW.GLFW_KEY_R, // Default: R key
                KEY_CATEGORY
            );
            event.register(openEditorKey);
        }
    }
    
    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft minecraft = Minecraft.getInstance();
        
        if (openEditorKey.consumeClick() && minecraft.screen == null) {
            minecraft.setScreen(new RecipeEditorScreen());
        }
    }
}
