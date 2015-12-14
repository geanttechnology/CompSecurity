// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;


// Referenced classes of package it.sephiroth.android.library.tooltip:
//            TooltipManager

public static final class  extends Enum
{

    private static final None $VALUES[];
    public static final None None;
    public static final None TouchInside;
    public static final None TouchOutside;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(it/sephiroth/android/library/tooltip/TooltipManager$ClosePolicy, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        TouchInside = new <init>("TouchInside", 0);
        TouchOutside = new <init>("TouchOutside", 1);
        None = new <init>("None", 2);
        $VALUES = (new .VALUES[] {
            TouchInside, TouchOutside, None
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
