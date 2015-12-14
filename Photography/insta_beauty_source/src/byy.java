// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.crashlytics.android.Crashlytics;
import jp.co.cyberagent.android.gpuimage.camera.BeautyCameraGLSurfaceView;

public class byy
    implements Runnable
{

    final jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE a;
    final BeautyCameraGLSurfaceView b;

    public byy(BeautyCameraGLSurfaceView beautycameraglsurfaceview, jp.co.cyberagent.android.gpuimage.grafika.GPUImageBeautyFilterFactory.BEAUTYCAM_FILTER_TYPE beautycam_filter_type)
    {
        b = beautycameraglsurfaceview;
        a = beautycam_filter_type;
        super();
    }

    public void run()
    {
        try
        {
            ((cee)b.mRender).a(a);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
    }
}
