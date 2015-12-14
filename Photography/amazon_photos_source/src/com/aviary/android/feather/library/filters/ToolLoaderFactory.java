// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.filters;

import com.aviary.android.feather.headless.filters.IFilter;
import com.aviary.android.feather.headless.filters.NativeFilter;
import com.aviary.android.feather.headless.filters.NativeRangeFilter;
import com.aviary.android.feather.headless.filters.NativeToolFilter;
import com.aviary.android.feather.headless.filters.NativeVignetteToolFilter;
import com.aviary.android.feather.headless.filters.impl.AdjustColorFilter;
import com.aviary.android.feather.headless.filters.impl.AdjustExposureFilter;
import com.aviary.android.feather.headless.filters.impl.CropFilter;
import com.aviary.android.feather.headless.filters.impl.EffectFilter;
import java.util.Locale;

// Referenced classes of package com.aviary.android.feather.library.filters:
//            MemeFilter, EnhanceFilter, AdjustFilter, BorderFilter, 
//            OverlayFilter, TextFilter

public final class ToolLoaderFactory
{
    public static final class Tools extends Enum
    {

        private static final Tools $VALUES[];
        public static final Tools BLEMISH;
        public static final Tools BLUR;
        public static final Tools COLOR;
        public static final Tools CROP;
        public static final Tools DRAW;
        public static final Tools EFFECTS;
        public static final Tools ENHANCE;
        public static final Tools FOCUS;
        public static final Tools FRAMES;
        public static final Tools LIGHTING;
        public static final Tools MEME;
        public static final Tools ORIENTATION;
        public static final Tools OVERLAYS;
        public static final Tools REDEYE;
        public static final Tools SHARPNESS;
        public static final Tools SPLASH;
        public static final Tools STICKERS;
        public static final Tools TEXT;
        public static final Tools VIGNETTE;
        public static final Tools WHITEN;

        public static Tools valueOf(String s)
        {
            return (Tools)Enum.valueOf(com/aviary/android/feather/library/filters/ToolLoaderFactory$Tools, s);
        }

        public static Tools[] values()
        {
            return (Tools[])$VALUES.clone();
        }

        static 
        {
            SHARPNESS = new Tools("SHARPNESS", 0);
            EFFECTS = new Tools("EFFECTS", 1);
            REDEYE = new Tools("REDEYE", 2);
            CROP = new Tools("CROP", 3);
            WHITEN = new Tools("WHITEN", 4);
            DRAW = new Tools("DRAW", 5);
            STICKERS = new Tools("STICKERS", 6);
            TEXT = new Tools("TEXT", 7);
            BLEMISH = new Tools("BLEMISH", 8);
            MEME = new Tools("MEME", 9);
            ORIENTATION = new Tools("ORIENTATION", 10);
            ENHANCE = new Tools("ENHANCE", 11);
            FRAMES = new Tools("FRAMES", 12);
            SPLASH = new Tools("SPLASH", 13);
            FOCUS = new Tools("FOCUS", 14);
            BLUR = new Tools("BLUR", 15);
            VIGNETTE = new Tools("VIGNETTE", 16);
            LIGHTING = new Tools("LIGHTING", 17);
            COLOR = new Tools("COLOR", 18);
            OVERLAYS = new Tools("OVERLAYS", 19);
            $VALUES = (new Tools[] {
                SHARPNESS, EFFECTS, REDEYE, CROP, WHITEN, DRAW, STICKERS, TEXT, BLEMISH, MEME, 
                ORIENTATION, ENHANCE, FRAMES, SPLASH, FOCUS, BLUR, VIGNETTE, LIGHTING, COLOR, OVERLAYS
            });
        }

        private Tools(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int TOOLS_VERSION = 11;

    private ToolLoaderFactory()
    {
    }

    public static Tools findToolByName(String s)
    {
        try
        {
            s = Tools.valueOf(s.toUpperCase(Locale.US));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    public static IFilter get(Tools tools)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[];

            static 
            {
                $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools = new int[Tools.values().length];
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.LIGHTING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.COLOR.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.CROP.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.MEME.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.ENHANCE.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.ORIENTATION.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.SHARPNESS.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.WHITEN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.REDEYE.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.BLUR.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.BLEMISH.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.EFFECTS.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.FRAMES.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.OVERLAYS.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.SPLASH.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.FOCUS.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.TEXT.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.VIGNETTE.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.STICKERS.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$aviary$android$feather$library$filters$ToolLoaderFactory$Tools[Tools.DRAW.ordinal()] = 20;
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
            return null;

        case 1: // '\001'
            return new AdjustExposureFilter();

        case 2: // '\002'
            return new AdjustColorFilter();

        case 3: // '\003'
            return new CropFilter();

        case 4: // '\004'
            return new MemeFilter();

        case 5: // '\005'
            return new EnhanceFilter();

        case 6: // '\006'
            return new AdjustFilter();

        case 7: // '\007'
            return new NativeRangeFilter("sharpness", "value");

        case 8: // '\b'
            return new NativeToolFilter("whiten", com.aviary.android.feather.headless.filters.NativeToolFilter.NativeToolType.Whiten);

        case 9: // '\t'
            return new NativeToolFilter("redeye", com.aviary.android.feather.headless.filters.NativeToolFilter.NativeToolType.RedEye);

        case 10: // '\n'
            return new NativeToolFilter("blur", com.aviary.android.feather.headless.filters.NativeToolFilter.NativeToolType.Blur);

        case 11: // '\013'
            return new NativeToolFilter("blemish", com.aviary.android.feather.headless.filters.NativeToolFilter.NativeToolType.Blemish);

        case 12: // '\f'
            return new EffectFilter();

        case 13: // '\r'
            return new BorderFilter();

        case 14: // '\016'
            return new OverlayFilter();

        case 15: // '\017'
            return new NativeToolFilter("colorsplash", com.aviary.android.feather.headless.filters.NativeToolFilter.NativeToolType.ColorSplash);

        case 16: // '\020'
            return new NativeToolFilter("tiltshift", com.aviary.android.feather.headless.filters.NativeToolFilter.NativeToolType.TiltShift);

        case 17: // '\021'
            return new TextFilter();

        case 18: // '\022'
            return new NativeVignetteToolFilter();
        }
    }

    public static NativeFilter get(String s)
    {
        return new NativeFilter(new String[] {
            s
        });
    }

    public static String[] getAllTools()
    {
        return (new String[] {
            Tools.ENHANCE.name(), Tools.EFFECTS.name(), Tools.FRAMES.name(), Tools.STICKERS.name(), Tools.OVERLAYS.name(), Tools.VIGNETTE.name(), Tools.CROP.name(), Tools.FOCUS.name(), Tools.ORIENTATION.name(), Tools.LIGHTING.name(), 
            Tools.COLOR.name(), Tools.SHARPNESS.name(), Tools.SPLASH.name(), Tools.DRAW.name(), Tools.TEXT.name(), Tools.REDEYE.name(), Tools.WHITEN.name(), Tools.BLUR.name(), Tools.BLEMISH.name(), Tools.MEME.name()
        });
    }

    public static String[] getDefaultTools()
    {
        return (new String[] {
            Tools.ENHANCE.name(), Tools.EFFECTS.name(), Tools.FRAMES.name(), Tools.STICKERS.name(), Tools.OVERLAYS.name(), Tools.VIGNETTE.name(), Tools.CROP.name(), Tools.FOCUS.name(), Tools.ORIENTATION.name(), Tools.LIGHTING.name(), 
            Tools.COLOR.name(), Tools.SHARPNESS.name(), Tools.SPLASH.name(), Tools.DRAW.name(), Tools.TEXT.name(), Tools.REDEYE.name(), Tools.WHITEN.name(), Tools.BLEMISH.name(), Tools.BLUR.name()
        });
    }

    public static String getToolId(Tools tools)
    {
        return getToolName(tools);
    }

    public static String getToolName(Tools tools)
    {
        return tools.name().toLowerCase(Locale.US);
    }

    public static int getToolVersion(Tools tools)
    {
        return 1;
    }
}
