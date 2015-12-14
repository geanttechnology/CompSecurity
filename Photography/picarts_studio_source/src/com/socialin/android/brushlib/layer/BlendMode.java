// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.brushlib.layer;

import android.graphics.PorterDuffXfermode;
import com.socialin.android.NoProGuard;
import java.util.ArrayList;
import java.util.List;
import myobfuscated.ar.b;

public abstract class BlendMode extends Enum
    implements NoProGuard
{

    private static final BlendMode $VALUES[];
    public static final BlendMode ADD;
    public static final BlendMode DARKEN;
    public static final BlendMode LIGHTEN;
    public static final BlendMode MULTIPLY;
    public static final BlendMode NORMAL;
    public static final BlendMode OVERLAY;
    public static final BlendMode SCREEN;
    public static final BlendMode XOR;
    private android.graphics.PorterDuff.Mode mode;
    private PorterDuffXfermode xfermode;

    private BlendMode(String s, int i, PorterDuffXfermode porterduffxfermode, android.graphics.PorterDuff.Mode mode1)
    {
        super(s, i);
        xfermode = porterduffxfermode;
        mode = mode1;
    }


    public static BlendMode convertFromObfuscatedVersion(b b1)
    {
        if (b1 == null)
        {
            return NORMAL;
        }
        final class _cls9
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[myobfuscated.ar.b.values().length];
                try
                {
                    b[b.NORMAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    b[b.MULTIPLY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    b[b.LIGHTEN.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    b[b.DARKEN.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    b[b.SCREEN.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[b.XOR.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    b[b.ADD.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    b[b.OVERLAY.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                a = new int[BlendMode.values().length];
                try
                {
                    a[BlendMode.ADD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[BlendMode.OVERLAY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (com.socialin.android.brushlib.layer._cls9.b[b1.ordinal()])
        {
        default:
            return NORMAL;

        case 1: // '\001'
            return NORMAL;

        case 2: // '\002'
            return MULTIPLY;

        case 3: // '\003'
            return LIGHTEN;

        case 4: // '\004'
            return DARKEN;

        case 5: // '\005'
            return SCREEN;

        case 6: // '\006'
            return XOR;

        case 7: // '\007'
            return ADD;

        case 8: // '\b'
            return OVERLAY;
        }
    }

    public static List getSupportedModes(boolean flag, boolean flag1)
    {
        ArrayList arraylist;
        BlendMode ablendmode[];
        int i;
        int j;
        arraylist = new ArrayList();
        ablendmode = values();
        j = ablendmode.length;
        i = 0;
_L2:
        BlendMode blendmode;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_154;
        }
        blendmode = ablendmode[i];
        switch (_cls9.a[blendmode.ordinal()])
        {
        default:
            arraylist.add(blendmode);
            break;

        case 1: // '\001'
            break; /* Loop/switch isn't completed */

        case 2: // '\002'
            break MISSING_BLOCK_LABEL_117;
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        if (flag)
        {
            blendmode.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.ADD));
            blendmode.setMode(android.graphics.PorterDuff.Mode.ADD);
            arraylist.add(blendmode);
        }
          goto _L3
        if (flag1)
        {
            blendmode.setXfermode(new PorterDuffXfermode(android.graphics.PorterDuff.Mode.OVERLAY));
            blendmode.setMode(android.graphics.PorterDuff.Mode.OVERLAY);
            arraylist.add(blendmode);
        }
          goto _L3
        return arraylist;
    }

    public static BlendMode valueOf(String s)
    {
        return (BlendMode)Enum.valueOf(com/socialin/android/brushlib/layer/BlendMode, s);
    }

    public static BlendMode[] values()
    {
        return (BlendMode[])$VALUES.clone();
    }

    public abstract String getDisplayName();

    public android.graphics.PorterDuff.Mode getMode()
    {
        return mode;
    }

    public PorterDuffXfermode getXfermode()
    {
        return xfermode;
    }

    public void setMode(android.graphics.PorterDuff.Mode mode1)
    {
        mode = mode1;
    }

    public void setXfermode(PorterDuffXfermode porterduffxfermode)
    {
        xfermode = porterduffxfermode;
    }

    static 
    {
        NORMAL = new BlendMode("NORMAL", 0, null, null) {

            public final String getDisplayName()
            {
                return "2131230807";
            }

            public final String toString()
            {
                return "Normal";
            }

        };
        MULTIPLY = new BlendMode("MULTIPLY", 1, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.MULTIPLY), android.graphics.PorterDuff.Mode.MULTIPLY) {

            public final String getDisplayName()
            {
                return "2131230806";
            }

            public final String toString()
            {
                return "Multiply";
            }

        };
        LIGHTEN = new BlendMode("LIGHTEN", 2, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.LIGHTEN), android.graphics.PorterDuff.Mode.LIGHTEN) {

            public final String getDisplayName()
            {
                return "2131230805";
            }

            public final String toString()
            {
                return "Lighten";
            }

        };
        DARKEN = new BlendMode("DARKEN", 3, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.DARKEN), android.graphics.PorterDuff.Mode.DARKEN) {

            public final String getDisplayName()
            {
                return "2131230804";
            }

            public final String toString()
            {
                return "Darken";
            }

        };
        SCREEN = new BlendMode("SCREEN", 4, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.SCREEN), android.graphics.PorterDuff.Mode.SCREEN) {

            public final String getDisplayName()
            {
                return "2131230809";
            }

            public final String toString()
            {
                return "Screen";
            }

        };
        XOR = new BlendMode("XOR", 5, new PorterDuffXfermode(android.graphics.PorterDuff.Mode.XOR), android.graphics.PorterDuff.Mode.XOR) {

            public final String getDisplayName()
            {
                return "2131230810";
            }

            public final String toString()
            {
                return "Xor";
            }

        };
        ADD = new BlendMode("ADD", 6, null, null) {

            public final String getDisplayName()
            {
                return "2131230803";
            }

            public final String toString()
            {
                return "Add";
            }

        };
        OVERLAY = new BlendMode("OVERLAY", 7, null, null) {

            public final String getDisplayName()
            {
                return "2131230808";
            }

            public final String toString()
            {
                return "Overlay";
            }

        };
        $VALUES = (new BlendMode[] {
            NORMAL, MULTIPLY, LIGHTEN, DARKEN, SCREEN, XOR, ADD, OVERLAY
        });
    }
}
