// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.os.Handler;
import android.view.MotionEvent;
import android.widget.TextView;
import com.j.a.e.a;

// Referenced classes of package com.j.a.d:
//            p, ag, s, e, 
//            t

class r
    implements Runnable
{

    final TextView a;
    final Handler b;
    final MotionEvent c;
    final TextView d;
    final Handler e;
    final p f;

    r(p p1, TextView textview, Handler handler, MotionEvent motionevent, TextView textview1, Handler handler1)
    {
        f = p1;
        a = textview;
        b = handler;
        c = motionevent;
        d = textview1;
        e = handler1;
        super();
    }

    public void run()
    {
        com.j.a.d.ag.a(f.a, true);
        ag.b(f.a, true);
        Object obj = new s(this);
        b.post(((Runnable) (obj)));
        obj = com.j.a.d.ag.a(f.a, c.getX(), c.getY(), com.j.a.d.ag.a(f.a));
        com.j.a.d.e.e().l().a(((org.json.JSONArray) (obj)), new t(this));
    }
}
