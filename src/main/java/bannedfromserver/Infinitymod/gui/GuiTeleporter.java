package bannedfromserver.Infinitymod.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

import bannedfromserver.Infinitymod.init.ModBlocks;
import bannedfromserver.Infinitymod.util.Reference;

public class GuiTeleporter extends GuiContainer {
	
	// location for gui texture
	private static final ResourceLocation BG_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/teleporter.png");
	
	// Stores player's inventory
	private InventoryPlayer playerInv;
	
	// Constructor
	public GuiTeleporter(Container container, InventoryPlayer playerInv) {
		super(container);
		this.playerInv = playerInv;
	}
	
	// Renders the background, behind the slots
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1, 1, 1, 1);
		mc.getTextureManager().bindTexture(BG_TEXTURE);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
	
	// Renders in front of the background and the slots
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String name = I18n.format(ModBlocks.TELEPORTER.getUnlocalizedName() + ".name");
		fontRenderer.drawString(name, xSize / 2 - fontRenderer.getStringWidth(name) / 2, 6, 0xCC0066);
		fontRenderer.drawString("Fuel Value: ", 4, 18, 0xCC0066);
		fontRenderer.drawString("Iron_Ingot = 1", 4, 30, 0x404040);
		fontRenderer.drawString("Gold_Ingot = 3", 4, 42, 0x404040);
		fontRenderer.drawString("Diamond = 5", 4, 54, 0x404040);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize - 94, 0x404040);
	}
}
