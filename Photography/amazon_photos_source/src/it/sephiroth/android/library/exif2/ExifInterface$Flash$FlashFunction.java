// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;


// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifInterface

public static final class  extends Enum
{

    private static final FUNCTION_NOR_PRESENT $VALUES[];
    public static final FUNCTION_NOR_PRESENT FUNCTION_NOR_PRESENT;
    public static final FUNCTION_NOR_PRESENT FUNCTION_PRESENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$FlashFunction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        FUNCTION_PRESENT = new <init>("FUNCTION_PRESENT", 0);
        FUNCTION_NOR_PRESENT = new <init>("FUNCTION_NOR_PRESENT", 1);
        $VALUES = (new .VALUES[] {
            FUNCTION_PRESENT, FUNCTION_NOR_PRESENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
