// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.hardware.Camera;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            CameraThread

class this._cls0
    implements Runnable
{

    final CameraThread this$0;

    public void run()
    {
        Exception exception;
        try
        {
            CameraThread.access$000(CameraThread.this).setPreviewCallback(null);
            CameraThread.access$000(CameraThread.this).stopPreview();
            CameraThread.access$000(CameraThread.this).release();
            CameraThread.access$002(CameraThread.this, null);
            shutdownCameraThread();
        }
        catch (Throwable throwable)
        {
            CameraThread.access$200(CameraThread.this).countDown();
            return;
        }
        finally
        {
            CameraThread.access$200(CameraThread.this).countDown();
        }
        CameraThread.access$200(CameraThread.this).countDown();
        return;
        throw exception;
    }

    ()
    {
        this$0 = CameraThread.this;
        super();
    }
}
