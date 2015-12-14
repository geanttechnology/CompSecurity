// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.activity.EditViewActivity;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;
import com.cyberlink.youcammakeup.widgetpool.toolbar.TopToolBar;

// Referenced classes of package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel:
//            BeautyToolPanel

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        if (BeautyToolPanel.f(a.a) != null)
        {
            BeautyToolPanel.f(a.a).a(Boolean.valueOf(false));
        }
    }

    (Y y)
    {
        a = y;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$10

/* anonymous class */
    class BeautyToolPanel._cls10 extends AsyncTask
    {

        final BeautyToolPanel a;

        protected transient Void a(Void avoid[])
        {
            MotionControlHelper.e().q();
            MotionControlHelper.e().t();
            MotionControlHelper.e().r();
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
            a.f();
            BeautyToolPanel.e(a);
            a.l();
            Globals.d(new BeautyToolPanel._cls10._cls1(this));
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
                a = beautytoolpanel;
                super();
            }
    }

}
