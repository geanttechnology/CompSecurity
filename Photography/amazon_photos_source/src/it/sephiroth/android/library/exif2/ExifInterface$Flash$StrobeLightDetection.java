// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;


// Referenced classes of package it.sephiroth.android.library.exif2:
//            ExifInterface

public static final class Q extends Enum
{

    private static final LIGHT_DETECTED $VALUES[];
    public static final LIGHT_DETECTED LIGHT_DETECTED;
    public static final LIGHT_DETECTED LIGHT_NOT_DETECTED;
    public static final LIGHT_DETECTED NO_DETECTION;
    public static final LIGHT_DETECTED RESERVED;

    public static Q valueOf(String s)
    {
        return (Q)Enum.valueOf(it/sephiroth/android/library/exif2/ExifInterface$Flash$StrobeLightDetection, s);
    }

    public static Q[] values()
    {
        return (Q[])$VALUES.clone();
    }

    static 
    {
        NO_DETECTION = new <init>("NO_DETECTION", 0);
        RESERVED = new <init>("RESERVED", 1);
        LIGHT_NOT_DETECTED = new <init>("LIGHT_NOT_DETECTED", 2);
        LIGHT_DETECTED = new <init>("LIGHT_DETECTED", 3);
        $VALUES = (new .VALUES[] {
            NO_DETECTION, RESERVED, LIGHT_NOT_DETECTED, LIGHT_DETECTED
        });
    }

    private Q(String s, int i)
    {
        super(s, i);
    }
}
