// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.tooltip;


// Referenced classes of package it.sephiroth.android.library.tooltip:
//            TooltipManager

public static final class A extends Enum
{

    private static final CENTER $VALUES[];
    public static final CENTER BOTTOM;
    public static final CENTER CENTER;
    public static final CENTER LEFT;
    public static final CENTER RIGHT;
    public static final CENTER TOP;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(it/sephiroth/android/library/tooltip/TooltipManager$Gravity, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        LEFT = new <init>("LEFT", 0);
        RIGHT = new <init>("RIGHT", 1);
        TOP = new <init>("TOP", 2);
        BOTTOM = new <init>("BOTTOM", 3);
        CENTER = new <init>("CENTER", 4);
        $VALUES = (new .VALUES[] {
            LEFT, RIGHT, TOP, BOTTOM, CENTER
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
