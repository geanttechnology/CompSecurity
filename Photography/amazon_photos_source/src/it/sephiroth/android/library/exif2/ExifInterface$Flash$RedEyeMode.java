// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;


// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifInterface

public static final class  extends Enum
{

    private static final SUPPORTED $VALUES[];
    public static final SUPPORTED NONE;
    public static final SUPPORTED SUPPORTED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$RedEyeMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        SUPPORTED = new <init>("SUPPORTED", 1);
        $VALUES = (new .VALUES[] {
            NONE, SUPPORTED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
