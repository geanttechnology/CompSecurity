// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;


// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifInterface

public static final class  extends Enum
{

    private static final YES $VALUES[];
    public static final YES NO;
    public static final YES YES;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$FlashFired, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NO = new <init>("NO", 0);
        YES = new <init>("YES", 1);
        $VALUES = (new .VALUES[] {
            NO, YES
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
