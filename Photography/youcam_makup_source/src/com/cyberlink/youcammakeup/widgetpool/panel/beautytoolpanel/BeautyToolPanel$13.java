// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.ar;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.j;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.ImageViewer;
import com.cyberlink.youcammakeup.kernelctrl.panzoomviewer.q;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;
import java.util.List;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a extends AsyncTask
{

    final a a;
    final BeautyToolPanel b;

    protected transient Void a(Void avoid[])
    {
        MotionControlHelper.e().t();
        MotionControlHelper.e().r();
        MotionControlHelper.e().v();
        return null;
    }

    protected void a(Void void1)
    {
        Object obj = null;
        if (a != null && a.f() != null)
        {
            BeautifierEditCenter.a().a(a.f().f());
            if (BeautyToolPanel.g(b) != null && BeautyToolPanel.g(b).m != null)
            {
                com.cyberlink.youcammakeup.jniproxy.y y;
                List list;
                if (BeautyToolPanel.g(b).m.i != null && BeautyToolPanel.g(b).m.j >= 0 && BeautyToolPanel.g(b).m.i.size() > BeautyToolPanel.g(b).m.j)
                {
                    void1 = ((ar)BeautyToolPanel.g(b).m.i.get(BeautyToolPanel.g(b).m.j)).b;
                } else
                {
                    void1 = null;
                }
                list = j.a().g();
                y = obj;
                if (list != null)
                {
                    y = obj;
                    if (BeautyToolPanel.g(b).m.j >= 0)
                    {
                        y = obj;
                        if (list.size() > BeautyToolPanel.g(b).m.j)
                        {
                            y = ((ar)j.a().g().get(BeautyToolPanel.g(b).m.j)).c;
                        }
                    }
                }
                if (void1 != null && y != null)
                {
                    BeautifierEditCenter.a().a(void1, y, false, new BeautifierTaskInfo(false));
                }
            }
        }
        com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel.BeautyToolPanel.a(b, true);
        BeautifierManager.a().a(b);
        if (b.b != null && b.b.p())
        {
            MotionControlHelper.e().n();
            if (!MotionControlHelper.e().a(StatusManager.j().d(), new BeautifierTaskInfo(false)))
            {
                b.a(new BeautifierTaskInfo(false));
            }
        } else
        {
            BeautifierEditCenter.a().a(new BeautifierTaskInfo(true));
        }
        if (BeautyToolPanel.f(b) != null)
        {
            BeautyToolPanel.f(b).a(Boolean.valueOf(false));
        }
    }

    protected Object doInBackground(Object aobj[])
    {
        return a((Void[])aobj);
    }

    protected void onPostExecute(Object obj)
    {
        a((Void)obj);
    }

    protected void onPreExecute()
    {
        b.b(a);
        j.a().h();
    }

    (BeautyToolPanel beautytoolpanel, a a1)
    {
        b = beautytoolpanel;
        a = a1;
        super();
    }
}
