// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search.viewit;

import android.hardware.Camera;
import android.util.Log;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.mShop.search.viewit:
//            CameraThread

class this._cls0
    implements Runnable
{

    final CameraThread this$0;

    public void run()
    {
        CameraThread.access$002(CameraThread.this, Camera.open());
        CameraThread.access$100(CameraThread.this).countDown();
        return;
        Object obj;
        obj;
        Log.e("CameraThread", (new StringBuilder()).append("Error camera open: ").append(((Throwable) (obj)).getMessage()).toString());
        CameraThread.access$100(CameraThread.this).countDown();
        return;
        obj;
        CameraThread.access$100(CameraThread.this).countDown();
        throw obj;
    }

    ()
    {
        this$0 = CameraThread.this;
        super();
    }
}
