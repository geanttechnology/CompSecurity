// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.a.b.u;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.facebook.ads:
//            k, c

private final class <init>
    implements android.view..OnClickListener, android.view..OnTouchListener
{

    final k a;
    private int b;
    private int c;
    private int d;
    private int e;
    private float f;
    private float g;
    private int h;
    private int i;
    private boolean j;

    public final void onClick(View view)
    {
        if (k.a(a) != null)
        {
            k.a(a).b(a);
        }
        if (!j)
        {
            Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
        }
        view = new HashMap();
        view.put("clickX", Integer.valueOf(b));
        view.put("clickY", Integer.valueOf(c));
        view.put("width", Integer.valueOf(d));
        view.put("height", Integer.valueOf(e));
        view.put("adPositionX", Float.valueOf(f));
        view.put("adPositionY", Float.valueOf(g));
        view.put("visibleWidth", Integer.valueOf(i));
        view.put("visibleHeight", Integer.valueOf(h));
        if (k.h(a) != null)
        {
            view.put("nti", String.valueOf(k.h(a).a()));
        }
        if (k.i(a))
        {
            view.put("nhs", String.valueOf(k.i(a)));
        }
        k.e(a).b(view);
    }

    public final boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 && k.f(a) != null)
        {
            d = k.f(a).getWidth();
            e = k.f(a).getHeight();
            int ai[] = new int[2];
            k.f(a).getLocationInWindow(ai);
            f = ai[0];
            g = ai[1];
            Rect rect = new Rect();
            k.f(a).getGlobalVisibleRect(rect);
            i = rect.width();
            h = rect.height();
            int ai1[] = new int[2];
            view.getLocationInWindow(ai1);
            b = ((int)motionevent.getX() + ai1[0]) - ai[0];
            int l = (int)motionevent.getY();
            c = (ai1[1] + l) - ai[1];
            j = true;
        }
        return k.m(a) != null && k.m(a).onTouch(view, motionevent);
    }

    private ent(k k1)
    {
        a = k1;
        super();
    }

    t>(k k1, byte byte0)
    {
        this(k1);
    }
}
