// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Activity;
import android.view.View;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
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
import com.cyberlink.youcammakeup.kernelctrl.status.b;
import com.cyberlink.youcammakeup.kernelctrl.status.d;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            FineTuneToolBar

class a
    implements e
{

    final d a;
    final b b;

    public void a(ImageStateChangedEvent imagestatechangedevent)
    {
        if (imagestatechangedevent.c().a().e != imagestatechangedevent.b().a().e)
        {
            StatusManager.j().N();
        }
        StatusManager.j().y();
        imagestatechangedevent = a.e();
        if (imagestatechangedevent != null)
        {
            Object obj = imagestatechangedevent.f();
            long l;
            if (obj != null && ((v) (obj)).h() != null)
            {
                MotionControlHelper.e().a(((v) (obj)).h(), false);
                Globals.d().t().O();
            } else
            {
                MotionControlHelper.e().a(null, false);
            }
        }
        if (FineTuneToolBar.g(b.b) != null)
        {
            FineTuneToolBar.g(b.b).k();
        }
        if (imagestatechangedevent != null)
        {
            obj = imagestatechangedevent.f();
            if (obj != null)
            {
                BeautifierEditCenter.a().a(((v) (obj)).f());
            } else
            {
                BeautifierEditCenter.a().a(null);
            }
            obj = j.a().g();
            if (FineTuneToolBar.g(b.b) != null && FineTuneToolBar.g(b.b).m != null && FineTuneToolBar.g(b.b).m.i != null && obj != null && ((List) (obj)).get(FineTuneToolBar.g(b.b).m.j) != null)
            {
                BeautifierEditCenter.a().a(((ar)FineTuneToolBar.g(b.b).m.i.get(FineTuneToolBar.g(b.b).m.j)).b, ((ar)((List) (obj)).get(FineTuneToolBar.g(b.b).m.j)).c, false, new BeautifierTaskInfo(false));
            }
            if (imagestatechangedevent.f() == null)
            {
                imagestatechangedevent = new i();
            } else
            {
                imagestatechangedevent = imagestatechangedevent.f().g();
            }
            StatusManager.j().a(imagestatechangedevent);
        }
        MotionControlHelper.e().l();
        l = StatusManager.j().l();
        imagestatechangedevent = StatusManager.j().j(l);
        j.a().a(imagestatechangedevent);
        FineTuneToolBar.h(b.b);
        StatusManager.j().a(Boolean.valueOf(true));
    }

    public volatile void a(Object obj)
    {
        a((ImageStateChangedEvent)obj);
    }

    public void a(Void void1)
    {
        StatusManager.j().a(Boolean.valueOf(true));
        FineTuneToolBar.h(b.b);
    }

    public void b(Object obj)
    {
        a((Void)obj);
    }

    public void b(Void void1)
    {
        StatusManager.j().a(Boolean.valueOf(true));
        FineTuneToolBar.h(b.b);
    }

    public void c(Object obj)
    {
        b((Void)obj);
    }

    t(t t, d d1)
    {
        b = t;
        a = d1;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/toolbar/FineTuneToolBar$9

/* anonymous class */
    class FineTuneToolBar._cls9
        implements android.view.View.OnClickListener
    {

        final FineTuneToolBar a;

        public void onClick(View view)
        {
            StatusManager.j().a(Boolean.valueOf(false));
            com.cyberlink.youcammakeup.widgetpool.toolbar.FineTuneToolBar.a(a, (ImageViewer)a.getActivity().findViewById(0x7f0c0720));
            long l = StatusManager.j().l();
            view = StatusManager.j().j(l);
            if (!view.j())
            {
                StatusManager.j().a(Boolean.valueOf(true));
                return;
            } else
            {
                FineTuneToolBar.f(a);
                (new b(view, new FineTuneToolBar._cls9._cls1(this, view))).executeOnExecutor(view.c(), new Void[0]);
                return;
            }
        }

            
            {
                a = finetunetoolbar;
                super();
            }
    }

}
