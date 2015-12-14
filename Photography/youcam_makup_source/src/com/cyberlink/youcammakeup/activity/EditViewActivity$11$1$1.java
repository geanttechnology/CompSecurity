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
    implements android.content.Listener
{

    final a a;

    public void onCancel(DialogInterface dialoginterface)
    {
        a.a.a.I();
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


    // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$11$1

/* anonymous class */
    class EditViewActivity._cls11._cls1
        implements Runnable
    {

        final EditViewActivity._cls11 a;

        public void run()
        {
            com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.b, new q(a.b, true));
            EditViewActivity.t(a.b).setOnCancelListener(new EditViewActivity._cls11._cls1._cls1(this));
            Object obj = new EditViewActivity._cls11._cls1._cls2();
            EditViewActivity.t(a.b).a(((r) (obj)));
            long l = StatusManager.j().l();
            obj = ViewEngine.a().a(l, 1.0D, null);
            EditViewActivity.t(a.b).a(((ImageBufferWrapper) (obj)).i());
            EditViewActivity.t(a.b).show();
            if (obj != null)
            {
                ((ImageBufferWrapper) (obj)).m();
            }
        }

            
            {
                a = _pcls11;
                super();
            }

        // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$11$1$2

/* anonymous class */
        class EditViewActivity._cls11._cls1._cls2
            implements r
        {

            final EditViewActivity._cls11._cls1 a;

            public void a()
            {
                EditViewActivity.t(a.a.b).dismiss();
                a.a.b.I();
            }

            public void a(PointF apointf[])
            {
                EditViewActivity.t(a.a.b).dismiss();
                long l = StatusManager.j().l();
                Object obj = ViewEngine.a().a(l, 1.0D, null);
                if (obj == null || ((ImageBufferWrapper) (obj)).j() == null)
                {
                    return;
                }
                Object obj4 = apointf[0];
                Object obj1 = apointf[1];
                Object obj2 = apointf[2];
                apointf = new y();
                Object obj3 = new ah();
                ((ah) (obj3)).a(((PointF) (obj4)).x);
                ((ah) (obj3)).b(((PointF) (obj4)).y);
                obj4 = new ah();
                ((ah) (obj4)).a(((PointF) (obj1)).x);
                ((ah) (obj4)).b(((PointF) (obj1)).y);
                obj1 = new ah();
                ((ah) (obj1)).a(((PointF) (obj2)).x);
                ((ah) (obj1)).b(((PointF) (obj2)).y);
                int i = EditViewActivity.u(a.a.b).a(((ImageBufferWrapper) (obj)).j(), ((ah) (obj3)), ((ah) (obj4)), ((ah) (obj1)), apointf);
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] uiVenus.ManualGetFaceAlignmentData iRet=").append(i).toString());
                if (obj != null)
                {
                    ((ImageBufferWrapper) (obj)).m();
                }
                obj1 = new ar(0);
                obj1.c = apointf;
                obj = new aj();
                i = EditViewActivity.u(a.a.b).a(1, ((aj) (obj)));
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] uiVenus.GetFaceInfos iRet=").append(i).toString());
                if (((aj) (obj)).b() == 0L)
                {
                    com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, "[ManualAdjustDialog] faceRectList.size() == 0");
                    a.a.b.I();
                    return;
                }
                obj2 = new ai(((aj) (obj)).a(0));
                obj = new ax();
                i = EditViewActivity.u(a.a.b).a(((ai) (obj2)), ((ax) (obj)));
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] face : uiVenus.GetIrisRadius iRet=").append(i).append(" iris radius = ").append(((ax) (obj)).b()).toString());
                obj3 = new bn();
                i = EditViewActivity.u(a.a.b).a(((ai) (obj2)), ((bn) (obj3)));
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] face : uiVenus.GetAutoWigLuminanceParameter iRet=").append(i).append(" wig luminance = ").append(((bn) (obj3)).b()).toString());
                boolean flag = EditViewActivity.u(a.a.b).a(((ai) (obj2)));
                com.cyberlink.youcammakeup.activity.EditViewActivity.a(a.a.b, (new StringBuilder()).append("[ManualAdjustDialog] face : uiVenus.DetectOpenMouth boolean = ").append(flag).toString());
                obj1.b = ((ai) (obj2));
                obj1.c = apointf;
                obj1.d = ((ax) (obj));
                obj1.e = ((bn) (obj3));
                obj1.f = flag;
                obj = StatusManager.j().Q();
                apointf = ((PointF []) (obj));
                if (obj == null)
                {
                    apointf = new ArrayList();
                }
                apointf.add(obj1);
                StatusManager.j().c(apointf);
                EditViewActivity.e(a.a.b, true);
                StatusManager.j().f(l).e = -2;
                if (((ai) (obj2)).c() == ((ai) (obj2)).e() || ((ai) (obj2)).b() == ((ai) (obj2)).d())
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
        }

    }

}
