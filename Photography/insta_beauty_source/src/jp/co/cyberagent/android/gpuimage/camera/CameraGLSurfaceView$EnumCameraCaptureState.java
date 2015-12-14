// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;


public final class Y extends Enum
{

    private static final STATE_SEPERATE_RECORD $VALUES[];
    public static final STATE_SEPERATE_RECORD STATE_CONTINOUS_RECORD;
    public static final STATE_SEPERATE_RECORD STATE_CONTINUOUS_PHOTO;
    public static final STATE_SEPERATE_RECORD STATE_PREPARE_CONTINOUS_RECORD;
    public static final STATE_SEPERATE_RECORD STATE_PREPARE_SEPERATE_RECORD;
    public static final STATE_SEPERATE_RECORD STATE_SEPERATE_RECORD;
    public static final STATE_SEPERATE_RECORD STATE_TAKE_PHOTO;

    public static Y valueOf(String s)
    {
        return (Y)Enum.valueOf(jp/co/cyberagent/android/gpuimage/camera/CameraGLSurfaceView$EnumCameraCaptureState, s);
    }

    public static Y[] values()
    {
        return (Y[])$VALUES.clone();
    }

    static 
    {
        STATE_TAKE_PHOTO = new <init>("STATE_TAKE_PHOTO", 0);
        STATE_CONTINUOUS_PHOTO = new <init>("STATE_CONTINUOUS_PHOTO", 1);
        STATE_PREPARE_CONTINOUS_RECORD = new <init>("STATE_PREPARE_CONTINOUS_RECORD", 2);
        STATE_PREPARE_SEPERATE_RECORD = new <init>("STATE_PREPARE_SEPERATE_RECORD", 3);
        STATE_CONTINOUS_RECORD = new <init>("STATE_CONTINOUS_RECORD", 4);
        STATE_SEPERATE_RECORD = new <init>("STATE_SEPERATE_RECORD", 5);
        $VALUES = (new .VALUES[] {
            STATE_TAKE_PHOTO, STATE_CONTINUOUS_PHOTO, STATE_PREPARE_CONTINOUS_RECORD, STATE_PREPARE_SEPERATE_RECORD, STATE_CONTINOUS_RECORD, STATE_SEPERATE_RECORD
        });
    }

    private Y(String s, int i)
    {
        super(s, i);
    }
}
