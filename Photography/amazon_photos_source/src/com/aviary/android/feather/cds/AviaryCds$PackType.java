// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;

import java.util.Locale;

// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCds

public static final class  extends Enum
{

    private static final OVERLAY $VALUES[];
    public static final OVERLAY EFFECT;
    public static final OVERLAY FRAME;
    public static final OVERLAY OVERLAY;
    public static final OVERLAY STICKER;

    public static  fromString(String s)
    {
        if ("effect".equals(s))
        {
            return EFFECT;
        }
        if ("frame".equals(s))
        {
            return FRAME;
        }
        if ("sticker".equals(s))
        {
            return STICKER;
        }
        if ("overlay".equals(s))
        {
            return OVERLAY;
        } else
        {
            return null;
        }
    }

    public static OVERLAY valueOf(String s)
    {
        return (OVERLAY)Enum.valueOf(com/aviary/android/feather/cds/AviaryCds$PackType, s);
    }

    public static OVERLAY[] values()
    {
        return (OVERLAY[])$VALUES.clone();
    }

    public String toCdsString()
    {
        return name().toLowerCase(Locale.US);
    }

    static 
    {
        FRAME = new <init>("FRAME", 0);
        EFFECT = new <init>("EFFECT", 1);
        STICKER = new <init>("STICKER", 2);
        OVERLAY = new <init>("OVERLAY", 3);
        $VALUES = (new .VALUES[] {
            FRAME, EFFECT, STICKER, OVERLAY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
