// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.d;

import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.j.a.f.b;

// Referenced classes of package com.j.a.d:
//            ag, r

class p
    implements android.view.View.OnTouchListener
{

    final ag a;

    p(ag ag1)
    {
        a = ag1;
        super();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (!ag.i(a) && motionevent.getAction() == 1)
        {
            view = (TextView)ag.a(a).findViewById(b.d());
            TextView textview = (TextView)ag.a(a).findViewById(b.c());
            view.setText("Uploading view...");
            textview.setText("");
            Handler handler = new Handler();
            handler.postDelayed(new r(this, textview, handler, motionevent, view, new Handler()), 50L);
        }
        return false;
    }
}
