// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jp.co.cyberagent.android.gpuimage.camera;

import ahh;
import com.crashlytics.android.Crashlytics;

// Referenced classes of package jp.co.cyberagent.android.gpuimage.camera:
//            BeautyCameraGLSurfaceView

class a
    implements Runnable
{

    final jp.co.cyberagent.android.gpuimage.grafika.BEAUTYCAM_FILTER_TYPE a;
    final BeautyCameraGLSurfaceView b;

    public void run()
    {
        try
        {
            ((ahh)b.mRender).a(a);
            return;
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            Crashlytics.logException(exception);
            return;
        }
    }

    .BEAUTYCAM_FILTER_TYPE(BeautyCameraGLSurfaceView beautycameraglsurfaceview, jp.co.cyberagent.android.gpuimage.grafika.BEAUTYCAM_FILTER_TYPE beautycam_filter_type)
    {
        b = beautycameraglsurfaceview;
        a = beautycam_filter_type;
        super();
    }
}
