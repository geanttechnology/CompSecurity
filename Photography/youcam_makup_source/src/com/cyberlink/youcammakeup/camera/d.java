// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.hardware.Camera;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            CameraCtrl

class d extends HandlerThread
{

    final CameraCtrl a;
    private Handler b;

    d(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super("CameraHandlerThread");
        b = null;
        start();
        b = new Handler(getLooper());
    }

    void a()
    {
        b.post(new Runnable() {

            final d a;

            public void run()
            {
                if (CameraCtrl.q(a.a) == null)
                {
                    break MISSING_BLOCK_LABEL_26;
                }
                CameraCtrl.q(a.a).startPreview();
                return;
                Exception exception;
                exception;
                if (CameraCtrl.q(a.a) != null)
                {
                    try
                    {
                        CameraCtrl.q(a.a).release();
                    }
                    catch (Exception exception1) { }
                }
                CameraCtrl.a(a.a, null);
                return;
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    void b()
    {
        b.post(new Runnable() {

            final d a;

            public void run()
            {
                CameraCtrl.S(a.a);
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    void c()
    {
        b.post(new Runnable() {

            final d a;

            public void run()
            {
                CameraCtrl.T(a.a);
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    void d()
    {
        b.post(new Runnable() {

            final d a;

            public void run()
            {
                a.a.h();
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    void e()
    {
        b.post(new Runnable() {

            final d a;

            public void run()
            {
                CameraCtrl.U(a.a);
            }

            
            {
                a = d.this;
                super();
            }
        });
    }

    void f()
    {
        b.post(new Runnable() {

            final d a;

            public void run()
            {
                Looper.myLooper().quit();
            }

            
            {
                a = d.this;
                super();
            }
        });
    }
}
