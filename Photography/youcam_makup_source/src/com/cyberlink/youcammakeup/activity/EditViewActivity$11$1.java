// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.DialogInterface;
import android.graphics.PointF;
import android.os.Handler;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.jniproxy.ah;
import com.cyberlink.youcammakeup.jniproxy.ai;
import com.cyberlink.youcammakeup.jniproxy.aj;
import com.cyberlink.youcammakeup.jniproxy.ax;
import com.cyberlink.youcammakeup.jniproxy.bn;
import com.cyberlink.youcammakeup.jniproxy.f;
import com.cyberlink.youcammakeup.jniproxy.y;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ImageBufferWrapper;
import com.cyberlink.youcammakeup.kernelctrl.viewengine.ViewEngine;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.dialogs.q;
import com.cyberlink.youcammakeup.widgetpool.dialogs.r;
import com.cyberlink.youcammakeup.widgetpool.dialogs.w;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements Runnable
{

    final erWrapper.m a;

    public void run()
    {
        com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a, new q(a.a, true));
        EditViewActivity.t(a.a).setOnCancelListener(new android.content.DialogInterface.OnCancelListener() {

            final EditViewActivity._cls11._cls1 a;

            public void onCancel(DialogInterface dialoginterface)
            {
                a.a.b.I();
            }

            
            {
                a = EditViewActivity._cls11._cls1.this;
                super();
            }
        });
        Object obj = new r() {

            final EditViewActivity._cls11._cls1 a;

            public void a()
            {
                EditViewActivity.t(a.a.b).dismiss();
                a.a.b.I();
            }

            public void a(PointF apointf[])
            {
                EditViewActivity.t(a.a.b).dismiss();
                long l1 = StatusManager.j().l();
                Object obj1 = ViewEngine.a().a(l1, 1.0D, null);
                if (obj1 == null || ((ImageBufferWrapper) (obj1)).j() == null)
                {
                    return;
                }
                Object obj5 = apointf[0];
                Object obj2 = apointf[1];
                Object obj3 = apointf[2];
                apointf = new y();
                Object obj4 = new ah();
                ((ah) (obj4)).a(((PointF) (obj5)).x);
                ((ah) (obj4)).b(((PointF) (obj5)).y);
                obj5 = new ah();
                ((ah) (obj5)).a(((PointF) (obj2)).x);
                ((ah) (obj5)).b(((PointF) (obj2)).y);
                obj2 = new ah();
                ((ah) (obj2)).a(((PointF) (obj3)).x);
                ((ah) (obj2)).b(((PointF) (obj3)).y);
                int i = EditViewActivity.u(a.a.b).a(((ImageBufferWrapper) (obj1)).j(), ((ah) (obj4)), ((ah) (obj5)), ((ah) (obj2)), apointf);
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] uiVenus.ManualGetFaceAlignmentData iRet=").append(i).toString());
                if (obj1 != null)
                {
                    ((ImageBufferWrapper) (obj1)).m();
                }
                obj2 = new ar(0);
                obj2.c = apointf;
                obj1 = new aj();
                i = EditViewActivity.u(a.a.b).a(1, ((aj) (obj1)));
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] uiVenus.GetFaceInfos iRet=").append(i).toString());
                if (((aj) (obj1)).b() == 0L)
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, "[ManualAdjustDialog] faceRectList.size() == 0");
                    a.a.b.I();
                    return;
                }
                obj3 = new ai(((aj) (obj1)).a(0));
                obj1 = new ax();
                i = EditViewActivity.u(a.a.b).a(((ai) (obj3)), ((ax) (obj1)));
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] face : uiVenus.GetIrisRadius iRet=").append(i).append(" iris radius = ").append(((ax) (obj1)).b()).toString());
                obj4 = new bn();
                i = EditViewActivity.u(a.a.b).a(((ai) (obj3)), ((bn) (obj4)));
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] face : uiVenus.GetAutoWigLuminanceParameter iRet=").append(i).append(" wig luminance = ").append(((bn) (obj4)).b()).toString());
                boolean flag = EditViewActivity.u(a.a.b).a(((ai) (obj3)));
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] face : uiVenus.DetectOpenMouth boolean = ").append(flag).toString());
                obj2.b = ((ai) (obj3));
                obj2.c = apointf;
                obj2.d = ((ax) (obj1));
                obj2.e = ((bn) (obj4));
                obj2.f = flag;
                obj1 = StatusManager.j().Q();
                apointf = ((PointF []) (obj1));
                if (obj1 == null)
                {
                    apointf = new ArrayList();
                }
                apointf.add(obj2);
                StatusManager.j().c(apointf);
                EditViewActivity.e(a.a.b, true);
                StatusManager.j().f(l1).e = -2;
                if (((ai) (obj3)).c() == ((ai) (obj3)).e() || ((ai) (obj3)).b() == ((ai) (obj3)).d())
                {
                    EditViewActivity.e(a.a.b, false);
                    a.a.b.I();
                    return;
                } else
                {
                    a.a.b.D();
                    return;
                }
            }

            
            {
                a = EditViewActivity._cls11._cls1.this;
                super();
            }
        };
        EditViewActivity.t(a.a).a(((r) (obj)));
        long l = StatusManager.j().l();
        obj = ViewEngine.a().a(l, 1.0D, null);
        EditViewActivity.t(a.a).a(((ImageBufferWrapper) (obj)).i());
        EditViewActivity.t(a.a).show();
        if (obj != null)
        {
            ((ImageBufferWrapper) (obj)).m();
        }
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$11

/* anonymous class */
    class EditViewActivity._cls11
        implements w
    {

        final boolean a;
        final EditViewActivity b;

        public void a(boolean flag)
        {
            YMKSavingPageEvent.a(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.FacedetectionClick.a);
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, System.currentTimeMillis(), com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.f, false, false));
            (new Handler()).post(new EditViewActivity._cls11._cls1(this));
        }

        public void b(boolean flag)
        {
            if (a)
            {
                YMKSavingPageEvent.a(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.FacedetectionClick.c);
            } else
            {
                YMKSavingPageEvent.a(com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.FacedetectionClick.b);
            }
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(YMKSavingPageEvent.b, System.currentTimeMillis(), com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.f, false, false));
            (new Handler()).post(new EditViewActivity._cls11._cls2());
        }

            
            {
                b = editviewactivity;
                a = flag;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$11$2

/* anonymous class */
        class EditViewActivity._cls11._cls2
            implements Runnable
        {

            final EditViewActivity._cls11 a;

            public void run()
            {
                Globals.d().i().b(false);
                Globals.d().i().h(a.b);
                a.b.I();
            }

                    
                    {
                        a = EditViewActivity._cls11.this;
                        super();
                    }
        }

    }

}
