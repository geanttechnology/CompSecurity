// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;


// Referenced classes of package co.vine.android:
//            RecordingFragment

public static final class  extends Enum
{

    private static final IMAGE_STAB $VALUES[];
    public static final IMAGE_STAB ANTI_BANDING;
    public static final IMAGE_STAB COLOR_EFFECTS;
    public static final IMAGE_STAB EXPOSURE;
    public static final IMAGE_STAB FLASH;
    public static final IMAGE_STAB IMAGE_STAB;
    public static final IMAGE_STAB SCENE_MODE;
    public static final IMAGE_STAB STOP_MOTION;
    public static final IMAGE_STAB TIME_LAPSE;
    public static final IMAGE_STAB WHITE_BALANCE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(co/vine/android/RecordingFragment$SecretModes, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STOP_MOTION = new <init>("STOP_MOTION", 0);
        WHITE_BALANCE = new <init>("WHITE_BALANCE", 1);
        EXPOSURE = new <init>("EXPOSURE", 2);
        FLASH = new <init>("FLASH", 3);
        TIME_LAPSE = new <init>("TIME_LAPSE", 4);
        SCENE_MODE = new <init>("SCENE_MODE", 5);
        COLOR_EFFECTS = new <init>("COLOR_EFFECTS", 6);
        ANTI_BANDING = new <init>("ANTI_BANDING", 7);
        IMAGE_STAB = new <init>("IMAGE_STAB", 8);
        $VALUES = (new .VALUES[] {
            STOP_MOTION, WHITE_BALANCE, EXPOSURE, FLASH, TIME_LAPSE, SCENE_MODE, COLOR_EFFECTS, ANTI_BANDING, IMAGE_STAB
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
