// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.toolbar;

import android.app.Activity;
import android.os.AsyncTask;
import com.cyberlink.youcammakeup.BaseActivity;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.BeautifierEditCenter;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.i;
import com.cyberlink.youcammakeup.kernelctrl.dataeditcenter.v;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.kernelctrl.status.a;
import com.cyberlink.youcammakeup.utility.BeautyMode;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.toolbar:
//            MakeupLooksBottomToolbar, b

class b extends AsyncTask
{

    final Activity a;
    final b b;
    final MakeupLooksBottomToolbar c;

    protected transient Void a(Void avoid[])
    {
        MotionControlHelper.e().p();
        MotionControlHelper.e().t();
        MotionControlHelper.e().s();
        MotionControlHelper.e().a(BeautyMode.j, true);
        MotionControlHelper.e().a(BeautyMode.k, true);
        return null;
    }

    protected void a(Void void1)
    {
        long l = StatusManager.j().l();
        void1 = StatusManager.j().f(l);
        if (void1 != null && void1.f() != null && void1.f().g() != null && void1.f().g().a() != null && MotionControlHelper.e().a(((a) (void1)).e))
        {
            BeautifierEditCenter.a().a(false);
            MotionControlHelper.e().b(((a) (void1)).e, false);
        }
        if (a instanceof BaseActivity)
        {
            ((BaseActivity)a).i();
        }
        MotionControlHelper.e().c(Boolean.valueOf(true));
        void1 = com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(c);
        if (void1 != null)
        {
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(c, void1, true);
            com.cyberlink.youcammakeup.widgetpool.toolbar.MakeupLooksBottomToolbar.a(c, void1);
        }
        if (b != null)
        {
            b.b();
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

    (MakeupLooksBottomToolbar makeuplooksbottomtoolbar, Activity activity, b b1)
    {
        c = makeuplooksbottomtoolbar;
        a = activity;
        b = b1;
        super();
    }
}
