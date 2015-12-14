// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.os.AsyncTask;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.camera.y;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierManager;
import com.cyberlink.youcammakeup.kernelctrl.BeautifierTaskInfo;
import com.cyberlink.youcammakeup.kernelctrl.f;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.utility.MakeupMode;
import com.cyberlink.youcammakeup.utility.aa;
import com.cyberlink.youcammakeup.utility.o;
import com.cyberlink.youcammakeup.widgetpool.c.a;
import com.cyberlink.youcammakeup.widgetpool.common.MotionControlHelper;
import com.cyberlink.youcammakeup.widgetpool.dialogs.ah;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            EditViewActivity

class a
    implements f
{

    final EditViewActivity a;

    public void a(BeautifierTaskInfo beautifiertaskinfo)
    {
        BeautifierManager.a().b(EditViewActivity.q(a));
        (new AsyncTask(beautifiertaskinfo) {

            final BeautifierTaskInfo a;
            final EditViewActivity._cls8 b;

            protected transient Void a(Void avoid[])
            {
                MotionControlHelper.e().p();
                MotionControlHelper.e().t();
                MotionControlHelper.e().s();
                return null;
            }

            protected void a(Void void1)
            {
                EditViewActivity.d(b.a, false);
                EditViewActivity.r(b.a);
                if (a.a() && a.c())
                {
                    b.a.a(false, null);
                }
                b.a.j(false);
                int i;
                if (StatusManager.j().r() == MakeupMode.g && ah.b())
                {
                    i = 0;
                } else
                {
                    i = 8;
                }
                b.a.a(-1, -1, -1, -1, -1, -1, i, -1);
                StatusManager.j().a(Boolean.valueOf(true));
                Globals.d().i().b(false);
                Globals.d().i().h(b.a);
                Globals.d(new Runnable(this) {

                    final _cls1 a;

                    public void run()
                    {
                        if (y.a != null && (a.b.a.e instanceof a))
                        {
                            ((a)a.b.a.e).a(null);
                            aa.a(y.a);
                            y.a = null;
                        }
                    }

            
            {
                a = _pcls1;
                super();
            }
                });
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
                b = EditViewActivity._cls8.this;
                a = beautifiertaskinfo;
                super();
            }
        }).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
    }

    _cls1.a(EditViewActivity editviewactivity)
    {
        a = editviewactivity;
        super();
    }
}
