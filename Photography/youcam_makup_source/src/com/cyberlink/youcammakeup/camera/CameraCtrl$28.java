// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.camera;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.utility.ae;
import com.cyberlink.youcammakeup.utility.ca;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.utility.y;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import com.cyberlink.youcammakeup.widgetpool.panel.c.p;
import com.pf.common.utility.m;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.camera:
//            z, CameraCtrl, d

class a
    implements z
{

    final CameraCtrl a;

    public void a()
    {
        CameraCtrl.a(a).post(new Runnable() {

            final CameraCtrl._cls28 a;

            public void run()
            {
                com.cyberlink.youcammakeup.camera.CameraCtrl.o(a.a);
            }

            
            {
                a = CameraCtrl._cls28.this;
                super();
            }
        });
    }

    public void a(ImageBufferWrapper imagebufferwrapper, List list)
    {
        m.b("PICTURE_TAKEN", "[CameraCtrl] - onImageSaved");
        ViewEngine.a().a(-7L, imagebufferwrapper);
        StatusManager.j().a(-7L, CameraCtrl.a);
        StatusManager.j().g(true);
        StatusManager.j().c(list);
        p.a().a(CameraCtrl.D(a));
        CameraCtrl.a(a).post(new Runnable() {

            final CameraCtrl._cls28 a;

            public void run()
            {
                android.location.Location location = CameraCtrl.E(a.a).a();
                Object obj = location;
                if (location == null)
                {
                    m.b("CameraCtrl", "Can't get current loaction immediately. Try to get last know location.");
                    obj = y.a().a(Globals.d());
                }
                y.a().a(((android.location.Location) (obj)));
                m.e("onImageSaved", "startActivity");
                obj = new Intent(CameraCtrl.u(a.a).getApplicationContext(), com/cyberlink/youcammakeup/activity/EditViewActivity);
                CameraCtrl.u(a.a).startActivity(((Intent) (obj)));
            }

            
            {
                a = CameraCtrl._cls28.this;
                super();
            }
        });
    }

    public void b()
    {
        m.b("PICTURE_TAKEN", "[CameraCtrl] - onImageReady");
        CameraCtrl.d(a).d();
    }

    public void c()
    {
        CameraCtrl.a(a).post(new Runnable() {

            final CameraCtrl._cls28 a;

            public void run()
            {
                Globals.d().i().a(CameraCtrl.u(a.a), true, false, false, new w(this) {

                    final _cls3 a;

                    public void a(boolean flag)
                    {
                        Globals.d().i().h(CameraCtrl.u(a.a.a));
                        CameraCtrl.a(false);
                        CameraCtrl.a(a.a.a, false);
                        CameraCtrl.b(a.a.a, true);
                        CameraCtrl.d(a.a.a).c();
                        ca.b().a();
                    }

                    public void b(boolean flag)
                    {
                        ca.b().a();
                    }

            
            {
                a = _pcls3;
                super();
            }
                });
            }

            
            {
                a = CameraCtrl._cls28.this;
                super();
            }
        });
    }

    _cls3.a(CameraCtrl cameractrl)
    {
        a = cameractrl;
        super();
    }
}
