package me.luval.client.impl.utils;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.Vec3;
import org.lwjgl.opengl.GL11;

import java.awt.*;

import static java.awt.Color.HSBtoRGB;
import static net.minecraft.client.Minecraft.getMinecraft;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex3d;

/**
 * @author Zhn17
 **/
public class RenderUtils {
	private static Minecraft mc = Minecraft.getMinecraft();
    public static void drawOutlinedBoundingBox(AxisAlignedBB aa) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.startDrawing(3);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.minZ);
        tessellator.draw();
        worldRenderer.startDrawing(3);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.minZ);
        tessellator.draw();
        worldRenderer.startDrawing(1);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.maxZ);
        tessellator.draw();
    }



    public static void drawBorderedRectNameTag(final float x, final float y, final float x2, final float y2, final float l1, final int col1, final int col2) {
        drawRect(x, y, x2, y2, col2);
        final float f = (col1 >> 24 & 0xFF) / 255.0f;
        final float f2 = (col1 >> 16 & 0xFF) / 255.0f;
        final float f3 = (col1 >> 8 & 0xFF) / 255.0f;
        final float f4 = (col1 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(f2, f3, f4, f);
        GL11.glLineWidth(l1);
        GL11.glBegin(1);
        GL11.glVertex2d((double) x, (double) y);
        GL11.glVertex2d((double) x, (double) y2);
        GL11.glVertex2d((double) x2, (double) y2);
        GL11.glVertex2d((double) x2, (double) y);
        GL11.glVertex2d((double) x, (double) y);
        GL11.glVertex2d((double) x2, (double) y);
        GL11.glVertex2d((double) x, (double) y2);
        GL11.glVertex2d((double) x2, (double) y2);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }

    public static ScaledResolution getScaledRes() {
        return new ScaledResolution(getMinecraft(), getMinecraft().displayWidth, getMinecraft().displayHeight);
    }

    public static void drawRect(float g, float h, float i, float j, int col1) {
        float f = (col1 >> 24 & 0xFF) / 255.0F;
        float f1 = (col1 >> 16 & 0xFF) / 255.0F;
        float f2 = (col1 >> 8 & 0xFF) / 255.0F;
        float f3 = (col1 & 0xFF) / 255.0F;

        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);

        GL11.glPushMatrix();
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(7);
        GL11.glVertex2d(i, h);
        GL11.glVertex2d(g, h);
        GL11.glVertex2d(g, j);
        GL11.glVertex2d(i, j);
        GL11.glEnd();
        GL11.glPopMatrix();

        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }

    public static void enableGL3D(float lineWidth) {
        GL11.glDisable(3008);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glEnable(2884);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
        GL11.glLineWidth(lineWidth);
    }

    public static void disableGL3D() {
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(3042);
        GL11.glEnable(3008);
        GL11.glDepthMask(true);
        GL11.glCullFace(1029);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }

    public static void drawBorderedRect(float x, float y, float x1, float y1, float width, int internalColor, int borderColor) {
        enableGL2D();
        glColor(internalColor);
        drawRectZZ(x + width, y + width, x1 - width, y1 - width);
        glColor(borderColor);
        drawRectZZ(x + width, y, x1 - width, y + width);
        drawRectZZ(x, y, x + width, y1);
        drawRectZZ(x1 - width, y, x1, y1);
        drawRectZZ(x + width, y1 - width, x1 - width, y1);
        disableGL2D();
    }

    private static void enableGL2D() {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }

    private static void disableGL2D() {
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }

    public static void glColor(int hex) {
        float alpha = (hex >> 24 & 0xFF) / 255.0F;
        float red = (hex >> 16 & 0xFF) / 255.0F;
        float green = (hex >> 8 & 0xFF) / 255.0F;
        float blue = (hex & 0xFF) / 255.0F;
        GL11.glColor4f(red, green, blue, alpha);
    }

    public static void drawBorderRect(int left, int top, int right, int bottom, int bcolor, int icolor, int bwidth) {
        drawRect(left + bwidth, top + bwidth, right - bwidth, bottom - bwidth, icolor);
        drawRect(left, top + 1, left + bwidth, bottom - 1, bcolor);
        drawRect(left + bwidth, top, right, top + bwidth, bcolor);
        drawRect(left + bwidth, bottom - bwidth, right, bottom, bcolor);
        drawRect(right - bwidth, top + bwidth, right, bottom - bwidth, bcolor);
    }

    private static void drawRectZZ(float x, float y, float x1, float y1) {
        GL11.glBegin(7);
        GL11.glVertex2f(x, y1);
        GL11.glVertex2f(x1, y1);
        GL11.glVertex2f(x1, y);
        GL11.glVertex2f(x, y);
        GL11.glEnd();
    }

    public static void drawRect(int x, int y, int x1, int y1, int color) {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
        Gui.drawRect(x, y, x1, y1, color);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }

    private static void drawBoundingBox(AxisAlignedBB aa) {
        Tessellator tessellator = Tessellator.getInstance();
        WorldRenderer worldRenderer = tessellator.getWorldRenderer();
        worldRenderer.startDrawingQuads();
        worldRenderer.addVertex(aa.minX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.maxZ);
        tessellator.draw();
        worldRenderer.startDrawingQuads();
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.maxZ);
        tessellator.draw();
        worldRenderer.startDrawingQuads();
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.minZ);
        tessellator.draw();
        worldRenderer.startDrawingQuads();
        worldRenderer.addVertex(aa.minX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.minZ);
        tessellator.draw();
        worldRenderer.startDrawingQuads();
        worldRenderer.addVertex(aa.minX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.minZ);
        tessellator.draw();
        worldRenderer.startDrawingQuads();
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.maxZ);
        worldRenderer.addVertex(aa.minX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.minX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.minZ);
        worldRenderer.addVertex(aa.maxX, aa.maxY, aa.maxZ);
        worldRenderer.addVertex(aa.maxX, aa.minY, aa.maxZ);
        tessellator.draw();
    }

    public static void drawOutlinedBlockESP(double x, double y, double z, float red, float green, float blue, float alpha, float lineWidth) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);

        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glLineWidth(lineWidth);
        GL11.glColor4f(red, green, blue, alpha);
        drawOutlinedBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0D, y + 1.0D, z + 1.0D));
        GL11.glDisable(2848);
        GL11.glEnable(3553);

        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    public static void drawTracerLine(double x, double y, double z, Color color, float alpha, float lineWdith) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glLineWidth(lineWdith);
        glColor(color);

        GL11.glLoadIdentity();
        boolean bobbing = mc.gameSettings.viewBobbing;
        mc.gameSettings.viewBobbing = false;
        mc.entityRenderer.orientCamera(mc.timer.renderPartialTicks);
        GL11.glBegin(3);
        GL11.glVertex3d(0.0D, Minecraft.thePlayer.getEyeHeight(), 0.0D);
        GL11.glVertex3d(x, y, z);
        GL11.glVertex3d(x, y + Minecraft.thePlayer.getEyeHeight(), z);
        GL11.glEnd();
        mc.gameSettings.viewBobbing = bobbing;

        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    private static void glColor(Color color) {
        GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
    }

    public static void drawCircle(double d, double e, double r, int c) {
        float f = ((c >> 24) & 0xff) / 255F;
        float f1 = ((c >> 16) & 0xff) / 255F;
        float f2 = ((c >> 8) & 0xff) / 255F;
        float f3 = (c & 0xff) / 255F;
        GL11.glPushMatrix();
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(GL11.GL_LINE_LOOP);

        for (int i = 0; i <= 360; i++) {
            double x2 = Math.sin(((i * Math.PI) / 180)) * r;
            double y2 = Math.cos(((i * Math.PI) / 180)) * r;
            GL11.glVertex2d(d + x2, e + y2);
        }

        GL11.glEnd();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public static void drawFilledCircle(double x, double y, double r, int c) {
        float f = ((c >> 24) & 0xff) / 255F;
        float f1 = ((c >> 16) & 0xff) / 255F;
        float f2 = ((c >> 8) & 0xff) / 255F;
        float f3 = (c & 0xff) / 255F;
        GL11.glPushMatrix();
        GL11.glLineWidth(1F);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(f1, f2, f3, f);
        GL11.glBegin(GL11.GL_TRIANGLE_FAN);

        for (int i = 0; i <= 360; i++) {
            double x2 = Math.sin(((i * Math.PI) / 180)) * r;
            double y2 = Math.cos(((i * Math.PI) / 180)) * r;
            GL11.glVertex2d(x + x2, y + y2);
        }

        GL11.glEnd();
        GL11.glDisable(GL11.GL_LINE_SMOOTH);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_BLEND);
        GL11.glPopMatrix();
    }

    public static int getRainbow(int speed, int offset) {
        float hue = (float) ((System.currentTimeMillis() + offset) % speed);
        hue /= speed;
        return Color.getHSBColor(hue, 1.0F, 1.0F).getRGB();
    }

    public static void DrawArc(double cx, double cy, double r, double start_angle, double arc_angle, int num_segments, float lw, int c) {
        float f = (c >> 24 & 0xFF) / 255.0F;
        float f1 = (c >> 16 & 0xFF) / 255.0F;
        float f2 = (c >> 8 & 0xFF) / 255.0F;
        float f3 = (c & 0xFF) / 255.0F;
        GL11.glColor4f(f1, f2, f3, f);
        double theta = arc_angle / (num_segments - 1);

        double tangetial_factor = Math.tan(theta);
        double radial_factor = Math.cos(theta);

        double x = r * Math.cos(start_angle);
        double y = r * Math.sin(start_angle);

        GL11.glLineWidth(lw);
        GL11.glBegin(3);
        for (int ii = 0; ii < num_segments; ii++) {
            GL11.glVertex2d(x + cx, y + cy);

            double tx = -y;
            double ty = x;

            x += tx * tangetial_factor;
            y += ty * tangetial_factor;

            x *= radial_factor;
            y *= radial_factor;
        }
        GL11.glEnd();
    }

    public static void drawBlockESP2(double x, double y, double z, float red, float green, float blue, float alpha,
                                     float lineRed, float lineGreen, float lineBlue, float lineAlpha, float lineWidth) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4f(red, green, blue, alpha);
        drawBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
        GL11.glLineWidth(lineWidth);
        GL11.glColor4f(lineRed, lineGreen, lineBlue, lineAlpha);
        drawOutlinedBoundingBox(new AxisAlignedBB(x, y, z, x + 1.0, y + 1.0, z + 1.0));
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }

    public static void drawBorderedCircle(int i, int y, float size, int j, int k) {
    }

    public static class ColorUtils {

        public Color getRainbow(final long offset, final float fade) {
            final float hue = (System.nanoTime() + offset) / 5.0E9f % 1.0f;
            final long color = Long.parseLong(Integer.toHexString(HSBtoRGB(hue, 1.0f, 1.0f)), 16);
            final Color c = new Color((int) color);
            return new Color(c.getRed() / 255.0f * fade, c.getGreen() / 255.0f * fade, c.getBlue() / 255.0f * fade, c.getAlpha() / 255.0f);
        }

        public int darker(final int hex) {
            final Color meme = Color.getColor(null, hex);
            return meme.darker().getRGB();
        }

        public static int darker(final Color color, final double fraction) {
            int red = (int) Math.round(color.getRed() * (1.0 - fraction));
            int green = (int) Math.round(color.getGreen() * (1.0 - fraction));
            int blue = (int) Math.round(color.getBlue() * (1.0 - fraction));
            if (red < 0) {
                red = 0;
            } else if (red > 255) {
                red = 255;
            }
            if (green < 0) {
                green = 0;
            } else if (green > 255) {
                green = 255;
            }
            if (blue < 0) {
                blue = 0;
            } else if (blue > 255) {
                blue = 255;
            }
            final int alpha = color.getAlpha();
            return new Color(red, green, blue, alpha).getRGB();
        }

        public static Color blend(final Color color1, final Color color2, final double ratio) {
            final float r = (float) ratio;
            final float ir = 1.0f - r;
            final float[] rgb1 = new float[3];
            final float[] rgb2 = new float[3];
            color1.getColorComponents(rgb1);
            color2.getColorComponents(rgb2);
            final Color color3 = new Color(rgb1[0] * r + rgb2[0] * ir, rgb1[1] * r + rgb2[1] * ir, rgb1[2] * r + rgb2[2] * ir);
            return color3;
        }

        public static String hexFromInt(final int color) {
            return hexFromInt(new Color(color));
        }

        static String hexFromInt(final Color color) {
            return Integer.toHexString(color.getRGB()).substring(2);
        }
    }

    public static class Camera {
        private final Minecraft mc;
        private net.minecraft.util.Timer timer;
        private double posX;
        private double posY;
        private double posZ;
        private float rotationYaw;
        private float rotationPitch;

        public Camera(final Entity entity) {
            this.mc = getMinecraft();
            if (this.timer == null) {
                this.timer = mc.timer;
            }
            this.posX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * this.timer.renderPartialTicks;
            this.posY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * this.timer.renderPartialTicks;
            this.posZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * this.timer.renderPartialTicks;
            this.setRotationYaw(entity.rotationYaw);
            this.setRotationPitch(entity.rotationPitch);
            if (entity instanceof EntityPlayer && getMinecraft().gameSettings.viewBobbing && entity == Minecraft.thePlayer) {
                final EntityPlayer living1 = (EntityPlayer) entity;
                this.setRotationYaw(this.getRotationYaw() + living1.prevCameraYaw + (living1.cameraYaw - living1.prevCameraYaw) * this.timer.renderPartialTicks);
                this.setRotationPitch(this.getRotationPitch() + living1.prevCameraPitch + (living1.cameraPitch - living1.prevCameraPitch) * this.timer.renderPartialTicks);
            } else if (entity instanceof EntityLivingBase) {
                final EntityLivingBase living2 = (EntityLivingBase) entity;
                this.setRotationYaw(living2.rotationYawHead);
            }
        }

        public Camera(final Entity entity, final double offsetX, final double offsetY, final double offsetZ, final double offsetRotationYaw, final double offsetRotationPitch) {
            this.mc = getMinecraft();
            this.posX = entity.lastTickPosX + (entity.posX - entity.lastTickPosX) * this.timer.renderPartialTicks;
            this.posY = entity.lastTickPosY + (entity.posY - entity.lastTickPosY) * this.timer.renderPartialTicks;
            this.posZ = entity.lastTickPosZ + (entity.posZ - entity.lastTickPosZ) * this.timer.renderPartialTicks;
            this.setRotationYaw(entity.rotationYaw);
            this.setRotationPitch(entity.rotationPitch);
            if (entity instanceof EntityPlayer && getMinecraft().gameSettings.viewBobbing && entity == Minecraft.thePlayer) {
                final EntityPlayer player = (EntityPlayer) entity;
                this.setRotationYaw(this.getRotationYaw() + player.prevCameraYaw + (player.cameraYaw - player.prevCameraYaw) * this.timer.renderPartialTicks);
                this.setRotationPitch(this.getRotationPitch() + player.prevCameraPitch + (player.cameraPitch - player.prevCameraPitch) * this.timer.renderPartialTicks);
            }
            this.posX += offsetX;
            this.posY += offsetY;
            this.posZ += offsetZ;
            this.rotationYaw += (float) offsetRotationYaw;
            this.rotationPitch += (float) offsetRotationPitch;
        }

        public Camera(final double posX, final double posY, final double posZ, final float rotationYaw, final float rotationPitch) {
            this.mc = getMinecraft();
            this.setPosX(posX);
            this.posY = posY;
            this.posZ = posZ;
            this.setRotationYaw(rotationYaw);
            this.setRotationPitch(rotationPitch);
        }

        public double getPosX() {
            return this.posX;
        }

        public void setPosX(final double posX) {
            this.posX = posX;
        }

        public double getPosY() {
            return this.posY;
        }

        public void setPosY(final double posY) {
            this.posY = posY;
        }

        public double getPosZ() {
            return this.posZ;
        }

        public void setPosZ(final double posZ) {
            this.posZ = posZ;
        }

        public float getRotationYaw() {
            return this.rotationYaw;
        }

        public void setRotationYaw(final float rotationYaw) {
            this.rotationYaw = rotationYaw;
        }

        public float getRotationPitch() {
            return this.rotationPitch;
        }

        public void setRotationPitch(final float rotationPitch) {
            this.rotationPitch = rotationPitch;
        }
    }

    public static class R3DUtils {
        public static void startDrawing() {
            GL11.glEnable(3042);
            GL11.glEnable(3042);
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(2848);
            GL11.glDisable(3553);
            GL11.glDisable(2929);
            mc.entityRenderer.setupCameraTransform(mc.timer.renderPartialTicks, 0);
        }

        public static void drawTracerLine(Entity entity, Color color) {
            getMinecraft().getRenderManager();
            double x = entity.posX - RenderManager.renderPosX;
            getMinecraft().getRenderManager();
            double y = entity.posY + entity.height / 2.0F - RenderManager.renderPosY;
            getMinecraft().getRenderManager();
            double z = entity.posZ - RenderManager.renderPosZ;
            GL11.glBlendFunc(770, 771);
            GL11.glEnable(3042);
            GL11.glLineWidth(2.0F);
            GL11.glDisable(3553);
            GL11.glDisable(2929);
            GL11.glDepthMask(false);
            glColor(color);
            Vec3 eyes = new Vec3(0.0D, 0.0D, 1.0D).rotatePitch(-(float) Math.toRadians(Minecraft.thePlayer.rotationPitch)).rotateYaw(-(float) Math.toRadians(Minecraft.thePlayer.rotationYaw));
            GL11.glBegin(1);
            GL11.glVertex3d(eyes.xCoord, Minecraft.thePlayer.getEyeHeight() + eyes.yCoord, eyes.zCoord);
            GL11.glVertex3d(x, y, z);
            GL11.glEnd();
            GL11.glEnable(3553);
            GL11.glEnable(2929);
            GL11.glDepthMask(true);
            GL11.glDisable(3042);
        }

        static void glColor(Color color) {
            GL11.glColor4f(color.getRed() / 255.0F, color.getGreen() / 255.0F, color.getBlue() / 255.0F, color.getAlpha() / 255.0F);
        }
    }

    public static class R2DUtils {

        public static void drawRect(float x, float y, float x1, float y1, int color) {
            enableGL2D();
            glColor(color);
            drawRect(x, y, x1, y1);
            disableGL2D();
        }

        public static void enableGL2D() {
            GL11.glDisable(2929);
            GL11.glEnable(3042);
            GL11.glDisable(3553);
            GL11.glBlendFunc(770, 771);
            GL11.glDepthMask(true);
            GL11.glEnable(2848);
            GL11.glHint(3154, 4354);
            GL11.glHint(3155, 4354);
        }

        public static void disableGL2D() {
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            GL11.glEnable(2929);
            GL11.glDisable(2848);
            GL11.glHint(3154, 4352);
            GL11.glHint(3155, 4352);
        }

        public static void glColor(int hex) {
            float alpha = (hex >> 24 & 0xFF) / 255.0F;
            float red = (hex >> 16 & 0xFF) / 255.0F;
            float green = (hex >> 8 & 0xFF) / 255.0F;
            float blue = (hex & 0xFF) / 255.0F;
            GL11.glColor4f(red, green, blue, alpha);
        }

        public static void drawRect(float x, float y, float x1, float y1) {
            GL11.glBegin(7);
            GL11.glVertex2f(x, y1);
            GL11.glVertex2f(x1, y1);
            GL11.glVertex2f(x1, y);
            GL11.glVertex2f(x, y);
            GL11.glEnd();
        }

        public static void drawBorderedRect(float x, float y, float x1, float y1, float width, int internalColor,
                                            int borderColor) {
            enableGL2D();
            glColor(internalColor);
            drawRect(x + width, y + width, x1 - width, y1 - width);
            glColor(borderColor);
            drawRect(x + width, y, x1 - width, y + width);
            drawRect(x, y, x + width, y1);
            drawRect(x1 - width, y, x1, y1);
            drawRect(x + width, y1 - width, x1 - width, y1);
            disableGL2D();
        }

    }
}
