// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;


// Referenced classes of package co.vine.android.util:
//            ViewUtil

public static final class  extends Enum
{

    private static final COLLAPSE_HEIGHT $VALUES[];
    public static final COLLAPSE_HEIGHT COLLAPSE_HEIGHT;
    public static final COLLAPSE_HEIGHT COLLAPSE_WIDTH;
    public static final COLLAPSE_HEIGHT EXPAND_HEIGHT;
    public static final COLLAPSE_HEIGHT EXPAND_WIDTH;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(co/vine/android/util/ViewUtil$ResizeAnimationType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EXPAND_WIDTH = new <init>("EXPAND_WIDTH", 0);
        EXPAND_HEIGHT = new <init>("EXPAND_HEIGHT", 1);
        COLLAPSE_WIDTH = new <init>("COLLAPSE_WIDTH", 2);
        COLLAPSE_HEIGHT = new <init>("COLLAPSE_HEIGHT", 3);
        $VALUES = (new .VALUES[] {
            EXPAND_WIDTH, EXPAND_HEIGHT, COLLAPSE_WIDTH, COLLAPSE_HEIGHT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
