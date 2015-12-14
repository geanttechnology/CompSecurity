// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.drawee.drawable;


// Referenced classes of package com.facebook.drawee.drawable:
//            ScalingUtils

public static final class _cls9 extends Enum
{

    private static final FOCUS_CROP $VALUES[];
    public static final FOCUS_CROP CENTER;
    public static final FOCUS_CROP CENTER_CROP;
    public static final FOCUS_CROP CENTER_INSIDE;
    public static final FOCUS_CROP FIT_CENTER;
    public static final FOCUS_CROP FIT_END;
    public static final FOCUS_CROP FIT_START;
    public static final FOCUS_CROP FIT_XY;
    public static final FOCUS_CROP FOCUS_CROP;

    public static _cls9 fromString(String s)
    {
        if (s.equals("none"))
        {
            return null;
        }
        if (s.equals("fitXY"))
        {
            return FIT_XY;
        }
        if (s.equals("fitStart"))
        {
            return FIT_START;
        }
        if (s.equals("fitCenter"))
        {
            return FIT_CENTER;
        }
        if (s.equals("fitEnd"))
        {
            return FIT_END;
        }
        if (s.equals("center"))
        {
            return CENTER;
        }
        if (s.equals("centerInside"))
        {
            return CENTER_INSIDE;
        }
        if (s.equals("centerCrop"))
        {
            return CENTER_CROP;
        }
        if (s.equals("focusCrop"))
        {
            return FOCUS_CROP;
        } else
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Unrecognized scale type: ").append(s).append("; use a value defined in the ScalingUtils.fromString method").toString());
        }
    }

    public static FOCUS_CROP valueOf(String s)
    {
        return (FOCUS_CROP)Enum.valueOf(com/facebook/drawee/drawable/ScalingUtils$ScaleType, s);
    }

    public static FOCUS_CROP[] values()
    {
        return (FOCUS_CROP[])$VALUES.clone();
    }

    static 
    {
        FIT_XY = new <init>("FIT_XY", 0);
        FIT_START = new <init>("FIT_START", 1);
        FIT_CENTER = new <init>("FIT_CENTER", 2);
        FIT_END = new <init>("FIT_END", 3);
        CENTER = new <init>("CENTER", 4);
        CENTER_INSIDE = new <init>("CENTER_INSIDE", 5);
        CENTER_CROP = new <init>("CENTER_CROP", 6);
        FOCUS_CROP = new <init>("FOCUS_CROP", 7);
        $VALUES = (new .VALUES[] {
            FIT_XY, FIT_START, FIT_CENTER, FIT_END, CENTER, CENTER_INSIDE, CENTER_CROP, FOCUS_CROP
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
