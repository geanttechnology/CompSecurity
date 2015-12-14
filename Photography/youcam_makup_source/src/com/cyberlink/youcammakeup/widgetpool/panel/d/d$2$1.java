// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.d;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.d:
//            d

class a
    implements Runnable
{

    final lBar.a a;

    public void run()
    {
        if (d.p(a.a) != null)
        {
            d.p(a.a).a(Boolean.valueOf(false));
        }
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/d/d$2

/* anonymous class */
    class d._cls2 extends AsyncTask
    {

        final d a;

        protected transient Void a(Void avoid[])
        {
            MotionControlHelper.e().q();
            MotionControlHelper.e().t();
            MotionControlHelper.e().r();
            MotionControlHelper.e().a(a.a(), true);
            MotionControlHelper.e().v();
            return null;
        }

        protected void a(Void void1)
        {
            StatusManager.j().a(Boolean.valueOf(true));
            if ((a.getActivity() instanceof EditViewActivity) && ah.b)
            {
                ((EditViewActivity)a.getActivity()).b(false, true);
            }
            d.n(a);
            d.o(a);
            Globals.d(new d._cls2._cls1(this));
        }

        protected Object doInBackground(Object aobj[])
        {
            return a((Void[])aobj);
        }

        protected void onPostExecute(Object obj)
        {
            a((Void)obj);
        }

            
            {
                a = d1;
                super();
            }
    }

}
