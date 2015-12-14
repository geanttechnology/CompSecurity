// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class nb
{

    public static final int a[];
    public static final int b[];

    static 
    {
        b = new int[jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.values().length];
        try
        {
            b[jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_TAKE_PHOTO.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror8) { }
        try
        {
            b[jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINUOUS_PHOTO.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror7) { }
        try
        {
            b[jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_CONTINOUS_RECORD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror6) { }
        try
        {
            b[jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_PREPARE_SEPERATE_RECORD.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            b[jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_CONTINOUS_RECORD.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            b[jp.co.cyberagent.android.gpuimage.camera.CameraGLSurfaceView.EnumCameraCaptureState.STATE_SEPERATE_RECORD.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        a = new int[jp.co.cyberagent.android.gpuimage.grafika.CameraCaptureActivity.EnumRecordResult.values().length];
        try
        {
            a[jp.co.cyberagent.android.gpuimage.grafika.CameraCaptureActivity.EnumRecordResult.RESULT_SUCCESS.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[jp.co.cyberagent.android.gpuimage.grafika.CameraCaptureActivity.EnumRecordResult.RESULT_FAIL_NOT_PREPARE.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[jp.co.cyberagent.android.gpuimage.grafika.CameraCaptureActivity.EnumRecordResult.RESULT_FAIL_PERMISSION_DENY.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
