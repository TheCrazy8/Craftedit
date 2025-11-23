package com.thecrazy8.craftedit.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

/**
 * Main GUI editor screen for Craftedit
 * 
 * Provides a visual interface for creating and editing recipe scripts
 * without needing to manually write CraftTweaker scripts.
 * 
 * Supports creating recipes for:
 * - Crafting Table
 * - Brewing Stand
 * - Furnaces (Furnace, Blast Furnace, Smoker)
 * - Botany Pots
 * - Anvil
 * - Smithing Table
 */
@OnlyIn(Dist.CLIENT)
public class RecipeEditorScreen extends Screen {
    private static final Component TITLE = Component.literal("Craftedit Recipe Editor");
    
    // Recipe type buttons
    private Button craftingTableButton;
    private Button brewingStandButton;
    private Button furnaceButton;
    private Button botanyPotButton;
    private Button anvilButton;
    private Button smithingTableButton;
    
    public RecipeEditorScreen() {
        super(TITLE);
    }
    
    @Override
    protected void init() {
        super.init();
        
        int buttonWidth = 150;
        int buttonHeight = 20;
        int centerX = this.width / 2;
        int startY = 60;
        int spacing = 25;
        
        // Create buttons for each recipe type
        this.craftingTableButton = Button.builder(
            Component.literal("Crafting Table Recipes"),
            button -> openRecipeEditor(RecipeType.CRAFTING_TABLE)
        )
        .bounds(centerX - buttonWidth / 2, startY, buttonWidth, buttonHeight)
        .build();
        
        this.brewingStandButton = Button.builder(
            Component.literal("Brewing Stand Recipes"),
            button -> openRecipeEditor(RecipeType.BREWING_STAND)
        )
        .bounds(centerX - buttonWidth / 2, startY + spacing, buttonWidth, buttonHeight)
        .build();
        
        this.furnaceButton = Button.builder(
            Component.literal("Furnace Recipes"),
            button -> openRecipeEditor(RecipeType.FURNACE)
        )
        .bounds(centerX - buttonWidth / 2, startY + spacing * 2, buttonWidth, buttonHeight)
        .build();
        
        this.botanyPotButton = Button.builder(
            Component.literal("Botany Pot Recipes"),
            button -> openRecipeEditor(RecipeType.BOTANY_POT)
        )
        .bounds(centerX - buttonWidth / 2, startY + spacing * 3, buttonWidth, buttonHeight)
        .build();
        
        this.anvilButton = Button.builder(
            Component.literal("Anvil Recipes"),
            button -> openRecipeEditor(RecipeType.ANVIL)
        )
        .bounds(centerX - buttonWidth / 2, startY + spacing * 4, buttonWidth, buttonHeight)
        .build();
        
        this.smithingTableButton = Button.builder(
            Component.literal("Smithing Table Recipes"),
            button -> openRecipeEditor(RecipeType.SMITHING_TABLE)
        )
        .bounds(centerX - buttonWidth / 2, startY + spacing * 5, buttonWidth, buttonHeight)
        .build();
        
        // Add all buttons
        addRenderableWidget(this.craftingTableButton);
        addRenderableWidget(this.brewingStandButton);
        addRenderableWidget(this.furnaceButton);
        addRenderableWidget(this.botanyPotButton);
        addRenderableWidget(this.anvilButton);
        addRenderableWidget(this.smithingTableButton);
    }
    
    private void openRecipeEditor(RecipeType type) {
        // Open specific recipe editor based on type
        // This will be implemented to open the appropriate editor screen
        if (minecraft != null) {
            minecraft.setScreen(new SpecificRecipeEditorScreen(type, this));
        }
    }
    
    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTick) {
        // Render background
        this.renderBackground(graphics, mouseX, mouseY, partialTick);
        
        // Render title
        graphics.drawCenteredString(this.font, this.title, this.width / 2, 20, 0xFFFFFF);
        
        // Render subtitle
        Component subtitle = Component.literal("Select a recipe type to edit or create");
        graphics.drawCenteredString(this.font, subtitle, this.width / 2, 35, 0xAAAAAA);
        
        // Render widgets
        super.render(graphics, mouseX, mouseY, partialTick);
    }
    
    @Override
    public boolean isPauseScreen() {
        return false;
    }
    
    /**
     * Enum representing the different recipe types supported
     */
    public enum RecipeType {
        CRAFTING_TABLE("Crafting Table"),
        BREWING_STAND("Brewing Stand"),
        FURNACE("Furnace"),
        BOTANY_POT("Botany Pot"),
        ANVIL("Anvil"),
        SMITHING_TABLE("Smithing Table");
        
        private final String displayName;
        
        RecipeType(String displayName) {
            this.displayName = displayName;
        }
        
        public String getDisplayName() {
            return displayName;
        }
    }
}
