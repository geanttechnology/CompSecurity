// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.a;
import com.cyberlink.youcammakeup.widgetpool.wigpreviewview.b;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            OpeningTutorialActivity, p, LauncherActivity

class o
    implements android.view.View.OnTouchListener, b
{

    final OpeningTutorialActivity a;
    private a b;
    private View c;
    private boolean d;
    private Handler e;

    public o(OpeningTutorialActivity openingtutorialactivity)
    {
        a = openingtutorialactivity;
        super();
        d = false;
        b = new a(openingtutorialactivity.getResources());
        b.a(this);
        e = new Handler(new p(this, null));
    }

    static a a(o o1)
    {
        return o1.b;
    }

    public void a()
    {
        d = true;
    }

    public void a(MotionEvent motionevent)
    {
        if (d)
        {
            return;
        }
        if (motionevent.getX() <= (float)(c.getWidth() / 2))
        {
            OpeningTutorialActivity.c(a).performClick();
            return;
        }
        int i = com.cyberlink.youcammakeup.activity.OpeningTutorialActivity.a(a).getAdapter().getCount();
        if (OpeningTutorialActivity.d(a) >= i - 1)
        {
            a();
            motionevent = new Intent(a.getApplicationContext(), com/cyberlink/youcammakeup/activity/LauncherActivity);
            a.startActivity(motionevent);
            a.finish();
            return;
        } else
        {
            OpeningTutorialActivity.e(a).performClick();
            return;
        }
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        c = view;
        com.cyberlink.youcammakeup.activity.OpeningTutorialActivity.a(a).dispatchTouchEvent(motionevent);
        view = MotionEvent.obtain(motionevent);
        view = e.obtainMessage(2, view);
        e.sendMessage(view);
        return true;
    }
}
