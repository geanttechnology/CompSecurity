// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;
import com.cyberlink.youcammakeup.Globals;
import com.cyberlink.youcammakeup.kernelctrl.networkmanager.NetworkManager;
import com.cyberlink.youcammakeup.kernelctrl.z;

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

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/LauncherActivity$26

/* anonymous class */
    class LauncherActivity._cls26
        implements android.view.View.OnTouchListener
    {

        final LauncherActivity a;
        private boolean b;
        private int c;
        private Toast d;

        static int a(LauncherActivity._cls26 _pcls26, int i)
        {
            _pcls26.c = i;
            return i;
        }

        static boolean a(LauncherActivity._cls26 _pcls26, boolean flag)
        {
            _pcls26.b = flag;
            return flag;
        }

        public boolean onTouch(View view, MotionEvent motionevent)
        {
            if (!Globals.u() && !NetworkManager.e())
            {
                return false;
            }
            if (motionevent.getActionMasked() == 0)
            {
                if (!b)
                {
                    b = true;
                    c = 0;
                    view.postDelayed(new LauncherActivity._cls26._cls1(this), 600L);
                }
                c = c + 1;
            }
            if (c >= 3)
            {
                if (d != null)
                {
                    d.cancel();
                    d = null;
                }
                z.a();
                d = Toast.makeText(a.getApplicationContext(), "All preference cleared!!", 1);
                d.show();
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
