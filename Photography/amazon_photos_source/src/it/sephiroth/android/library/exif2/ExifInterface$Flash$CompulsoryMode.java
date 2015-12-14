// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;


// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifInterface

public static final class  extends Enum
{

    private static final AUTO $VALUES[];
    public static final AUTO AUTO;
    public static final AUTO FIRING;
    public static final AUTO SUPPRESSION;
    public static final AUTO UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$CompulsoryMode, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        FIRING = new <init>("FIRING", 1);
        SUPPRESSION = new <init>("SUPPRESSION", 2);
        AUTO = new <init>("AUTO", 3);
        $VALUES = (new .VALUES[] {
            UNKNOWN, FIRING, SUPPRESSION, AUTO
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
