// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage;


public final class  extends Enum
{

    private static final HORIZONTAL $VALUES[];
    public static final HORIZONTAL HORIZONTAL;
    public static final HORIZONTAL VERTICAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(jp/co/cyberagent/android/gpuimage/OpenGlUtils$Direction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        VERTICAL = new <init>("VERTICAL", 0);
        HORIZONTAL = new <init>("HORIZONTAL", 1);
        $VALUES = (new .VALUES[] {
            VERTICAL, HORIZONTAL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
