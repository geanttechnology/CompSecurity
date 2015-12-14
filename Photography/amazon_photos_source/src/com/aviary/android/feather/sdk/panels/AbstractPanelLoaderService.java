// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import com.aviary.android.feather.common.log.LoggerFactory;
import com.aviary.android.feather.library.content.ToolEntry;
import com.aviary.android.feather.library.services.BaseContextService;
import com.aviary.android.feather.library.services.IAviaryController;
import com.aviary.android.feather.sdk.FeatherActivity;
import com.aviary.android.feather.sdk.utils.Maturity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            AdjustEffectPanel, ConsolidatedAdjustToolsPanel, NativeEffectRangePanel, EnhanceEffectPanel, 
//            EffectsPanel, BordersPanel, CropPanel, DelayedSpotDrawPanel, 
//            BlemishPanel, DrawingPanel, StickersPanel, TextPanel, 
//            MemePanel, ColorSplashPanel, TiltShiftPanel, VignettePanel, 
//            OverlaysPanel, AbstractPanel

public class AbstractPanelLoaderService extends BaseContextService
{
    private static final class PanelMode extends Enum
    {

        private static final PanelMode $VALUES[];
        public static final PanelMode DEFAULT;
        public static final PanelMode FREETIME;

        public static PanelMode valueOf(String s)
        {
            return (PanelMode)Enum.valueOf(com/aviary/android/feather/sdk/panels/AbstractPanelLoaderService$PanelMode, s);
        }

        public static PanelMode[] values()
        {
            return (PanelMode[])$VALUES.clone();
        }

        static 
        {
            FREETIME = new PanelMode("FREETIME", 0);
            DEFAULT = new PanelMode("DEFAULT", 1);
            $VALUES = (new PanelMode[] {
                FREETIME, DEFAULT
            });
        }

        private PanelMode(String s, int i)
        {
            super(s, i);
        }
    }


    private List mAllEntries;

    public AbstractPanelLoaderService(IAviaryController iaviarycontroller)
    {
        super(iaviarycontroller);
    }

    public static int getToolDisplayName(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[];
            static final int $SwitchMap$com$aviary$android$feather$sdk$panels$AbstractPanelLoaderService$PanelMode[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$sdk$panels$AbstractPanelLoaderService$PanelMode = new int[PanelMode.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$panels$AbstractPanelLoaderService$PanelMode[PanelMode.DEFAULT.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$sdk$panels$AbstractPanelLoaderService$PanelMode[PanelMode.FREETIME.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools = new int[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.ORIENTATION.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.LIGHTING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.COLOR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.SHARPNESS.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.ENHANCE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.EFFECTS.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.FRAMES.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.CROP.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.REDEYE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.WHITEN.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.BLUR.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.BLEMISH.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.DRAW.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.STICKERS.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.TEXT.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.MEME.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.SPLASH.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.FOCUS.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.VIGNETTE.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.OVERLAYS.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools[tools.ordinal()])
        {
        default:
            return 0;

        case 4: // '\004'
            return com.aviary.android.feather.sdk.R.string.feather_sharpen;

        case 6: // '\006'
            return com.aviary.android.feather.sdk.R.string.feather_effects;

        case 9: // '\t'
            return com.aviary.android.feather.sdk.R.string.feather_red_eye;

        case 8: // '\b'
            return com.aviary.android.feather.sdk.R.string.feather_crop;

        case 10: // '\n'
            return com.aviary.android.feather.sdk.R.string.feather_whiten;

        case 13: // '\r'
            return com.aviary.android.feather.sdk.R.string.feather_draw;

        case 14: // '\016'
            return com.aviary.android.feather.sdk.R.string.feather_stickers;

        case 15: // '\017'
            return com.aviary.android.feather.sdk.R.string.feather_text;

        case 12: // '\f'
            return com.aviary.android.feather.sdk.R.string.feather_blemish;

        case 16: // '\020'
            return com.aviary.android.feather.sdk.R.string.feather_meme;

        case 1: // '\001'
            return com.aviary.android.feather.sdk.R.string.feather_adjust;

        case 5: // '\005'
            return com.aviary.android.feather.sdk.R.string.feather_enhance;

        case 7: // '\007'
            return com.aviary.android.feather.sdk.R.string.feather_borders;

        case 17: // '\021'
            return com.aviary.android.feather.sdk.R.string.feather_tool_colorsplash;

        case 18: // '\022'
            return com.aviary.android.feather.sdk.R.string.feather_tool_tiltshift;

        case 11: // '\013'
            return com.aviary.android.feather.sdk.R.string.feather_blur;

        case 19: // '\023'
            return com.aviary.android.feather.sdk.R.string.feather_vignette;

        case 2: // '\002'
            return com.aviary.android.feather.sdk.R.string.feather_tool_lighting;

        case 3: // '\003'
            return com.aviary.android.feather.sdk.R.string.feather_tool_color;

        case 20: // '\024'
            return com.aviary.android.feather.sdk.R.string.feather_overlays;
        }
    }

    private void setToolEntries(PanelMode panelmode)
    {
        mAllEntries = new ArrayList();
        boolean flag;
        if (panelmode == PanelMode.FREETIME)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        switch (_cls1..SwitchMap.com.aviary.android.feather.sdk.panels.AbstractPanelLoaderService.PanelMode[panelmode.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.ENHANCE, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_enhance, com.aviary.android.feather.sdk.R.string.feather_enhance));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.FOCUS, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_focus, com.aviary.android.feather.sdk.R.string.feather_tool_tiltshift));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.EFFECTS, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_effects, com.aviary.android.feather.sdk.R.string.feather_effects));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.FRAMES, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_frames, com.aviary.android.feather.sdk.R.string.feather_borders));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.LIGHTING, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_lighting, com.aviary.android.feather.sdk.R.string.feather_brightness));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.BLUR, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_blur, com.aviary.android.feather.sdk.R.string.feather_blur));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.SHARPNESS, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_sharpen, com.aviary.android.feather.sdk.R.string.feather_sharpen));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.COLOR, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_color, com.aviary.android.feather.sdk.R.string.feather_acc_color));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.REDEYE, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_redeye, com.aviary.android.feather.sdk.R.string.feather_red_eye));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.WHITEN, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_whiten, com.aviary.android.feather.sdk.R.string.feather_whiten));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.BLEMISH, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_blemish, com.aviary.android.feather.sdk.R.string.feather_blemish));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.MEME, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_meme, com.aviary.android.feather.sdk.R.string.feather_meme));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.SPLASH, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_colorsplash, com.aviary.android.feather.sdk.R.string.feather_tool_colorsplash));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.FOCUS, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_focus, com.aviary.android.feather.sdk.R.string.feather_tool_tiltshift));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.OVERLAYS, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_overlay, com.aviary.android.feather.sdk.R.string.feather_overlays));
            mAllEntries.add(new ToolEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.VIGNETTE, com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_vignette, com.aviary.android.feather.sdk.R.string.feather_vignette));
            // fall through

        case 2: // '\002'
            panelmode = mAllEntries;
            break;
        }
        com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools = com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.STICKERS;
        int i;
        int j;
        if (flag)
        {
            j = com.aviary.android.feather.sdk.R.drawable.aviary_tool_ft_ic_stickers_selector;
        } else
        {
            j = com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_stickers;
        }
        panelmode.add(new ToolEntry(tools, j, com.aviary.android.feather.sdk.R.string.feather_stickers));
        panelmode = mAllEntries;
        tools = com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.CROP;
        if (flag)
        {
            j = com.aviary.android.feather.sdk.R.drawable.aviary_tool_ft_ic_crop_selector;
        } else
        {
            j = com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_crop;
        }
        panelmode.add(new ToolEntry(tools, j, com.aviary.android.feather.sdk.R.string.feather_crop));
        panelmode = mAllEntries;
        tools = com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.ORIENTATION;
        if (flag)
        {
            j = com.aviary.android.feather.sdk.R.drawable.aviary_tool_ft_ic_orientation_selector;
        } else
        {
            j = com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_orientation;
        }
        panelmode.add(new ToolEntry(tools, j, com.aviary.android.feather.sdk.R.string.feather_adjust));
        panelmode = mAllEntries;
        tools = com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.DRAW;
        if (flag)
        {
            j = com.aviary.android.feather.sdk.R.drawable.aviary_tool_ft_ic_free_selector;
        } else
        {
            j = com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_draw;
        }
        panelmode.add(new ToolEntry(tools, j, com.aviary.android.feather.sdk.R.string.feather_draw));
        panelmode = mAllEntries;
        tools = com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.TEXT;
        if (flag)
        {
            i = com.aviary.android.feather.sdk.R.drawable.aviary_tool_ft_ic_text_selector;
        } else
        {
            i = com.aviary.android.feather.sdk.R.drawable.aviary_tool_ic_text;
        }
        panelmode.add(new ToolEntry(tools, i, com.aviary.android.feather.sdk.R.string.feather_text));
    }

    public AbstractPanel createNew(ToolEntry toolentry)
    {
        IAviaryController iaviarycontroller = getContext();
        switch (_cls1..SwitchMap.com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools[toolentry.name.ordinal()])
        {
        default:
            LoggerFactory.getLogger("EffectLoaderService", com.aviary.android.feather.common.log.LoggerFactory.LoggerType.ConsoleLoggerType).error((new StringBuilder()).append("Effect with ").append(toolentry.name).append(" could not be found").toString());
            return null;

        case 1: // '\001'
            return new AdjustEffectPanel(iaviarycontroller, toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.ORIENTATION);

        case 2: // '\002'
            return new ConsolidatedAdjustToolsPanel(iaviarycontroller, toolentry);

        case 3: // '\003'
            return new ConsolidatedAdjustToolsPanel(iaviarycontroller, toolentry);

        case 4: // '\004'
            return new NativeEffectRangePanel(iaviarycontroller, toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.SHARPNESS, "sharpen");

        case 5: // '\005'
            return new EnhanceEffectPanel(iaviarycontroller, toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.ENHANCE);

        case 6: // '\006'
            return new EffectsPanel(iaviarycontroller, toolentry);

        case 7: // '\007'
            return new BordersPanel(iaviarycontroller, toolentry);

        case 8: // '\b'
            return new CropPanel(iaviarycontroller, toolentry);

        case 9: // '\t'
            return new DelayedSpotDrawPanel(iaviarycontroller, toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.REDEYE);

        case 10: // '\n'
            return new DelayedSpotDrawPanel(iaviarycontroller, toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.WHITEN);

        case 11: // '\013'
            return new DelayedSpotDrawPanel(iaviarycontroller, toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.BLUR);

        case 12: // '\f'
            return new BlemishPanel(iaviarycontroller, toolentry, com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools.BLEMISH);

        case 13: // '\r'
            return new DrawingPanel(iaviarycontroller, toolentry);

        case 14: // '\016'
            return new StickersPanel(iaviarycontroller, toolentry);

        case 15: // '\017'
            return new TextPanel(iaviarycontroller, toolentry);

        case 16: // '\020'
            return new MemePanel(iaviarycontroller, toolentry);

        case 17: // '\021'
            return new ColorSplashPanel(iaviarycontroller, toolentry);

        case 18: // '\022'
            return new TiltShiftPanel(iaviarycontroller, toolentry);

        case 19: // '\023'
            return new VignettePanel(iaviarycontroller, toolentry);

        case 20: // '\024'
            return new OverlaysPanel(iaviarycontroller, toolentry);
        }
    }

    public void dispose()
    {
    }

    public ToolEntry findEntry(com.aviary.android.feather.library.filters.ToolLoaderFactory.Tools tools)
    {
        for (Iterator iterator = mAllEntries.iterator(); iterator.hasNext();)
        {
            ToolEntry toolentry = (ToolEntry)iterator.next();
            if (toolentry.name.equals(tools))
            {
                return toolentry;
            }
        }

        return null;
    }

    public ToolEntry findEntry(String s)
    {
        for (Iterator iterator = mAllEntries.iterator(); iterator.hasNext();)
        {
            ToolEntry toolentry = (ToolEntry)iterator.next();
            if (toolentry.name.name().equals(s))
            {
                return toolentry;
            }
        }

        return null;
    }

    public ToolEntry[] getToolsEntries()
    {
        if (mAllEntries == null)
        {
            PanelMode panelmode;
            if (FeatherActivity.MATURITY.isKidsFriendly())
            {
                panelmode = PanelMode.FREETIME;
            } else
            {
                panelmode = PanelMode.DEFAULT;
            }
            setToolEntries(panelmode);
        }
        return (ToolEntry[])mAllEntries.toArray(new ToolEntry[mAllEntries.size()]);
    }
}
