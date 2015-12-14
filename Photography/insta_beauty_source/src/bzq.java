// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.Log;
import com.crashlytics.android.Crashlytics;
import java.util.concurrent.Executor;

public class bzq
{

    Camera a;
    Executor b;
    android.graphics.SurfaceTexture.OnFrameAvailableListener c;
    boolean d;
    boolean e;
    ced f;

    public bzq()
    {
        d = false;
        e = false;
    }

    private void a()
    {
        if (d && e)
        {
            ced ced1 = f;
            android.graphics.SurfaceTexture.OnFrameAvailableListener onframeavailablelistener = c;
            Camera camera = a;
            if (camera != null)
            {
                try
                {
                    ced1.d().setOnFrameAvailableListener(onframeavailablelistener);
                    ced1.a(camera);
                    return;
                }
                catch (Exception exception)
                {
                    Log.e("SurfaceTextureUtil", exception.toString());
                    Crashlytics.logException(exception);
                    exception.printStackTrace();
                    return;
                }
            }
        }
    }

    public void a(android.graphics.SurfaceTexture.OnFrameAvailableListener onframeavailablelistener, Camera camera, Executor executor)
    {
        c = onframeavailablelistener;
        a = camera;
        b = executor;
        d = true;
        a();
    }

    public void a(ced ced1)
    {
        f = ced1;
        e = true;
        a();
    }
}
