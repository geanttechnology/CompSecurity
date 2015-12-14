// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage;


public final class Rotation extends Enum
{

    private static final Rotation $VALUES[];
    public static final Rotation NORMAL;
    public static final Rotation ROTATION_180;
    public static final Rotation ROTATION_270;
    public static final Rotation ROTATION_90;

    private Rotation(String s, int i)
    {
        super(s, i);
    }

    public static Rotation valueOf(String s)
    {
        return (Rotation)Enum.valueOf(jp/co/cyberagent/android/gpuimage/Rotation, s);
    }

    public static Rotation[] values()
    {
        return (Rotation[])$VALUES.clone();
    }

    static 
    {
        NORMAL = new Rotation("NORMAL", 0);
        ROTATION_90 = new Rotation("ROTATION_90", 1);
        ROTATION_180 = new Rotation("ROTATION_180", 2);
        ROTATION_270 = new Rotation("ROTATION_270", 3);
        $VALUES = (new Rotation[] {
            NORMAL, ROTATION_90, ROTATION_180, ROTATION_270
        });
    }
}
