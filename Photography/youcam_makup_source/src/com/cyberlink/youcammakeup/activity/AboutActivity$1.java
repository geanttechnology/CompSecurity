// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            AboutActivity, TestSettingActivity

class c
    implements android.view.ener
{

    final AboutActivity a;
    private boolean b;
    private int c;

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
        if (motionevent.getActionMasked() == 0)
        {
            if (!b)
            {
                b = true;
                c = 0;
                view.postDelayed(new Runnable() {

                    final AboutActivity._cls1 a;

                    public void run()
                    {
                        AboutActivity._cls1.a(a, false);
                        AboutActivity._cls1.a(a, 0);
                    }

            
            {
                a = AboutActivity._cls1.this;
                super();
            }
                }, 600L);
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

    _cls1.a(AboutActivity aboutactivity)
    {
        a = aboutactivity;
        super();
        b = false;
        c = 0;
    }
}
