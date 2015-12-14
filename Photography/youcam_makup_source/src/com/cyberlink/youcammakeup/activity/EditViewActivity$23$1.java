// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent;
import com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent;
import com.cyberlink.youcammakeup.clflurry.b;
import com.cyberlink.youcammakeup.e;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.status.ImageStateChangedEvent;
import com.cyberlink.youcammakeup.kernelctrl.status.SessionState;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity, k, g

class a
    implements e
{

    final d a;
    final b b;

    public void a(ImageStateChangedEvent imagestatechangedevent)
    {
        Globals.d().e("EditViewActivity RedoTask complete start");
        if (imagestatechangedevent.c().a().e != imagestatechangedevent.b().a().e)
        {
            StatusManager.j().N();
        }
        StatusManager.j().y();
        Object obj = a.e();
        if (obj != null)
        {
            Object obj1 = ((a) (obj)).f();
            Object obj2;
            int l;
            int j1;
            if (obj1 != null && ((v) (obj1)).h() != null)
            {
                MotionControlHelper.e().a(((v) (obj1)).h(), false);
                b.b.O();
            } else
            {
                MotionControlHelper.e().a(null, false);
            }
        }
        obj1 = (ImageViewer)b.b.findViewById(0x7f0c0720);
        if (obj1 != null)
        {
            ((ImageViewer) (obj1)).k();
        }
        if (obj != null)
        {
            obj2 = ((a) (obj)).f();
            if (obj2 != null)
            {
                BeautifierEditCenter.a().a(((v) (obj2)).f());
            } else
            {
                BeautifierEditCenter.a().a(null);
            }
            obj2 = j.a().g();
            if (obj1 != null && ((ImageViewer) (obj1)).m != null && ((ImageViewer) (obj1)).m.i != null && obj2 != null && ((List) (obj2)).get(((ImageViewer) (obj1)).m.j) != null)
            {
                BeautifierEditCenter.a().a(((ar)((ImageViewer) (obj1)).m.i.get(((ImageViewer) (obj1)).m.j)).b, ((ar)((List) (obj2)).get(((ImageViewer) (obj1)).m.j)).c, false, new BeautifierTaskInfo(false));
            }
            if (((a) (obj)).f() == null)
            {
                obj = new i();
            } else
            {
                obj = ((a) (obj)).f().g();
            }
            StatusManager.j().a(((i) (obj)));
        }
        if (StatusManager.j().s() != BeautyMode.D || StatusManager.j().r() != MakeupMode.g)
        {
            obj = (k[])EditViewActivity.F(b.b).toArray(new k[0]);
            j1 = obj.length;
            for (l = 0; l < j1; l++)
            {
                obj[l].b(imagestatechangedevent);
            }

        }
        MotionControlHelper.e().l();
        long l1 = StatusManager.j().l();
        int i1;
        if (StatusManager.j().z())
        {
            imagestatechangedevent = StatusManager.j().c(l1);
        } else
        {
            imagestatechangedevent = StatusManager.j().g(l1);
        }
        j.a().a(imagestatechangedevent);
        Globals.d().i().h(b.b);
        if (StatusManager.j().s() == BeautyMode.D && StatusManager.j().r() != MakeupMode.a)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (ah.b() && i1 != 0)
        {
            i1 = 0;
        } else
        {
            i1 = 8;
        }
        b.b.a(-1, -1, -1, -1, -1, -1, i1, -1);
        StatusManager.j().a(Boolean.valueOf(true));
        Globals.d().e("EditViewActivity RedoTask complete end");
    }

    public volatile void a(Object obj)
    {
        a((ImageStateChangedEvent)obj);
    }

    public void a(Void void1)
    {
        StatusManager.j().a(Boolean.valueOf(true));
        Globals.d().i().h(b.b);
    }

    public void b(Object obj)
    {
        a((Void)obj);
    }

    public void b(Void void1)
    {
        StatusManager.j().a(Boolean.valueOf(true));
        Globals.d().i().h(b.b);
    }

    public void c(Object obj)
    {
        b((Void)obj);
    }

    ration(ration ration, d d1)
    {
        b = ration;
        a = d1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/EditViewActivity$23

/* anonymous class */
    class EditViewActivity._cls23
        implements android.view.View.OnClickListener
    {

        final EditViewActivity a;

        public void onClick(View view)
        {
            while (!StatusManager.j().E().booleanValue() || EditViewActivity.E(a) != null && EditViewActivity.E(a).b(view)) 
            {
                return;
            }
            Globals.d().e("EditViewActivity onRedoBtnClick start");
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKFeatureRoomLookEvent(com.cyberlink.youcammakeup.clflurry.YMKFeatureRoomLookEvent.Operation.f, 0L, 0L, null, YMKFeatureRoomLookEvent.e(), null));
            com.cyberlink.youcammakeup.clflurry.b.a(new YMKSavingPageEvent(0L, 0L, com.cyberlink.youcammakeup.clflurry.YMKSavingPageEvent.Operation.l, false, false));
            StatusManager.j().a(Boolean.valueOf(false));
            long l = StatusManager.j().l();
            if (StatusManager.j().z())
            {
                view = StatusManager.j().c(l);
            } else
            {
                view = StatusManager.j().g(l);
            }
            if (!view.j())
            {
                StatusManager.j().a(Boolean.valueOf(true));
                return;
            } else
            {
                Globals.d().i().b(a);
                (new com.cyberlink.youcammakeup.kernelctrl.status.b(view, new EditViewActivity._cls23._cls1(this, view))).executeOnExecutor(view.c(), new Void[0]);
                return;
            }
        }

            
            {
                a = editviewactivity;
                super();
            }
    }

}
