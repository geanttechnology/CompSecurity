// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.f;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.Button;
import android.widget.FrameLayout;
import com.j.a.a.d;
import com.j.a.b.g;
import com.j.a.d.ag;
import com.j.a.g.b;
import com.j.a.g.m;
import com.j.a.g.o;
import com.j.a.g.w;
import org.json.JSONArray;
import org.json.JSONObject;

public class e extends FrameLayout
    implements android.view.GestureDetector.OnGestureListener
{

    private long a;
    private float b;
    private float c;
    private g d;

    public e(Context context)
    {
        super(context);
        d = new g(context, this);
    }

    public boolean onDown(MotionEvent motionevent)
    {
        a = System.currentTimeMillis();
        b = motionevent.getX();
        c = motionevent.getY();
        return true;
    }

    public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return true;
    }

    public void onLongPress(MotionEvent motionevent)
    {
    }

    public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
    {
        return true;
    }

    public void onShowPress(MotionEvent motionevent)
    {
        if (m.a(b.s))
        {
            return;
        }
        if (System.currentTimeMillis() - a >= 1000L || o.a(b, c, motionevent.getX(), motionevent.getY()) >= 15F || com.j.a.d.e.e().k() == null) goto _L2; else goto _L1
_L1:
        Button button;
        motionevent = com.j.a.d.e.e().k().j();
        button = o.b(b, c, ag.c().d());
        if (button == null) goto _L2; else goto _L3
_L3:
        int i = 0;
_L4:
        if (i >= motionevent.length())
        {
            break; /* Loop/switch isn't completed */
        }
        JSONObject jsonobject = motionevent.optJSONObject(i);
        if (button.getId() == jsonobject.optJSONObject("initProperties").optInt("anID"))
        {
            com.j.a.d.e.e().n().a("touchUp", jsonobject);
            com.j.a.d.e.e().t();
        }
        i++;
        if (true) goto _L4; else goto _L2
        motionevent;
        w.b("Touch Overlay Problem", motionevent);
_L2:
    }

    public boolean onSingleTapUp(MotionEvent motionevent)
    {
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        d.a(motionevent);
        return super.onTouchEvent(motionevent);
    }
}
