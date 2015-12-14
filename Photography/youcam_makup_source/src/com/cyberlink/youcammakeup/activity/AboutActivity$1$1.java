// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            AboutActivity, TestSettingActivity

class a
    implements Runnable
{

    final a a;

    public void run()
    {
        a(a, false);
        a(a, 0);
    }

    y(y y)
    {
        a = y;
        super();
    }

    // Unreferenced inner class com/cyberlink/youcammakeup/activity/AboutActivity$1

/* anonymous class */
    class AboutActivity._cls1
        implements android.view.View.OnTouchListener
    {

        final AboutActivity a;
        private boolean b;
        private int c;

        static int a(AboutActivity._cls1 _pcls1, int i)
        {
            _pcls1.c = i;
            return i;
        }

        static boolean a(AboutActivity._cls1 _pcls1, boolean flag)
        {
            _pcls1.b = flag;
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
                    view.postDelayed(new AboutActivity._cls1._cls1(this), 600L);
                }
                c = c + 1;
            }
            if (c >= 5)
            {
                view = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/TestSettingActivity);
                a.startActivity(view);
            }
            return true;
        }

            
            {
                a = aboutactivity;
                super();
                b = false;
                c = 0;
            }
    }

}
