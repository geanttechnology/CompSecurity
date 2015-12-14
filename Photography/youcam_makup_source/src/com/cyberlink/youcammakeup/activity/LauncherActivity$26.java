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

class c
    implements android.view.
{

    final LauncherActivity a;
    private boolean b;
    private int c;
    private Toast d;

    static int a(c c1, int i)
    {
        c1.c = i;
        return i;
    }

    static boolean a(c c1, boolean flag)
    {
        c1.b = flag;
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
                view.postDelayed(new Runnable() {

                    final LauncherActivity._cls26 a;

                    public void run()
                    {
                        LauncherActivity._cls26.a(a, false);
                        LauncherActivity._cls26.a(a, 0);
                    }

            
            {
                a = LauncherActivity._cls26.this;
                super();
            }
                }, 600L);
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

    _cls1.a(LauncherActivity launcheractivity)
    {
        a = launcheractivity;
        super();
        b = false;
        c = 0;
    }
}
