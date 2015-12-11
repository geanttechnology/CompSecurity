// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a9.cameralibrary;

import android.hardware.Camera;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.a9.cameralibrary:
//            CameraOpenMode

class CameraConnectionRunnable
    implements Runnable
{

    private volatile Camera m_camera;
    private final CameraOpenMode m_cameraMode;
    private volatile Throwable m_error;
    private final CountDownLatch m_latch = new CountDownLatch(1);

    public CameraConnectionRunnable(CameraOpenMode cameraopenmode)
    {
        m_camera = null;
        m_error = null;
        m_cameraMode = cameraopenmode;
    }

    public void await(long l, TimeUnit timeunit)
        throws InterruptedException
    {
        m_latch.await(l, timeunit);
    }

    public Camera getCamera()
    {
        return m_camera;
    }

    public Throwable getError()
    {
        return m_error;
    }

    public void run()
    {
        android.hardware.Camera.CameraInfo camerainfo = new android.hardware.Camera.CameraInfo();
        static class _cls1
        {

            static final int $SwitchMap$com$a9$cameralibrary$CameraOpenMode[];

            static 
            {
                $SwitchMap$com$a9$cameralibrary$CameraOpenMode = new int[CameraOpenMode.values().length];
                try
                {
                    $SwitchMap$com$a9$cameralibrary$CameraOpenMode[CameraOpenMode.FIRST_BACK_FACING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$a9$cameralibrary$CameraOpenMode[CameraOpenMode.FIRST_FRONT_FACING.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.a9.cameralibrary.CameraOpenMode[m_cameraMode.ordinal()];
        JVM INSTR tableswitch 1 2: default 134
    //                   1 93
    //                   2 98;
           goto _L1 _L2 _L3
_L1:
        break MISSING_BLOCK_LABEL_134;
_L8:
        int l = Camera.getNumberOfCameras();
        int j;
        boolean flag;
        flag = false;
        j = 0;
_L9:
        int k = ((flag) ? 1 : 0);
        if (j >= l) goto _L5; else goto _L4
_L4:
        Camera.getCameraInfo(j, camerainfo);
        int i;
        if (camerainfo.facing != i) goto _L7; else goto _L6
_L6:
        k = j;
_L5:
        m_camera = Camera.open(k);
        m_latch.countDown();
        return;
_L2:
        i = 0;
          goto _L8
_L3:
        i = 1;
          goto _L8
_L7:
        j++;
          goto _L9
        Object obj;
        obj;
        m_error = ((Throwable) (obj));
        m_latch.countDown();
        return;
        obj;
        m_latch.countDown();
        throw obj;
        i = 0;
          goto _L8
    }
}
