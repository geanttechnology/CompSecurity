// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.database.more.DatabaseOpenHelper;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.widgetpool.a.b;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            LauncherActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a(a, false);
        a(a, 0);
    }

    rkManager(rkManager rkmanager)
    {
        a = rkmanager;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/LauncherActivity$25

/* anonymous class */
    class LauncherActivity._cls25
        implements android.view.View.OnTouchListener
    {

        final LauncherActivity a;
        private boolean b;
        private int c;
        private Toast d;

        static int a(LauncherActivity._cls25 _pcls25, int i)
        {
            _pcls25.c = i;
            return i;
        }

        static boolean a(LauncherActivity._cls25 _pcls25, boolean flag)
        {
            _pcls25.b = flag;
            return flag;
        }

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (motionevent.getActionMasked() == 0)
            {
                if (!b)
                {
                    b = true;
                    c = 0;
                    view.postDelayed(new LauncherActivity._cls25._cls1(this), 600L);
                }
                c = c + 1;
            }
            if (c >= 4)
            {
                DatabaseOpenHelper.a();
            } else
            if (c >= 3)
            {
                view = com.cyberlink.youcammakeup.widgetpool.a.b.a().c();
                motionevent = NetworkManager.d();
                if (d != null)
                {
                    d.cancel();
                    d = null;
                }
                d = Toast.makeText(a.getApplicationContext(), (new StringBuilder()).append(view).append("(").append(motionevent).append(")").toString(), 1);
                d.show();
                return true;
            }
            return true;
        }

            
            {
                a = launcheractivity;
                super();
                b = false;
                c = 0;
            }
    }

}
