// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;


// Referenced classes of package co.vine.android.util:
//            Util

public static final class  extends Enum
{

    private static final LARGE $VALUES[];
    public static final LARGE LARGE;
    public static final LARGE MEDIUM;
    public static final LARGE SMALL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(co/vine/android/util/Util$ProfileImageSize, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SMALL = new <init>("SMALL", 0);
        MEDIUM = new <init>("MEDIUM", 1);
        LARGE = new <init>("LARGE", 2);
        $VALUES = (new .VALUES[] {
            SMALL, MEDIUM, LARGE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
