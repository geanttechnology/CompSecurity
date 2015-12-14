// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.facebook.ads.internal.adapters.n;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.facebook.ads:
//            NativeAd, AdListener

class <init>
    implements android.view.kListener, android.view.hListener
{

    final NativeAd a;
    private int b;
    private int c;
    private int d;
    private int e;
    private float f;
    private float g;
    private int h;
    private int i;
    private boolean j;

    public Map a()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("clickX", Integer.valueOf(b));
        hashmap.put("clickY", Integer.valueOf(c));
        hashmap.put("width", Integer.valueOf(d));
        hashmap.put("height", Integer.valueOf(e));
        hashmap.put("adPositionX", Float.valueOf(f));
        hashmap.put("adPositionY", Float.valueOf(g));
        hashmap.put("visibleWidth", Integer.valueOf(i));
        hashmap.put("visibleHeight", Integer.valueOf(h));
        return hashmap;
    }

    public void onClick(View view)
    {
        if (NativeAd.a(a) != null)
        {
            NativeAd.a(a).onAdClicked(a);
        }
        if (!j)
        {
            Log.e("FBAudienceNetworkLog", "No touch data recorded, please ensure touch events reach the ad View by returning false if you intercept the event.");
        }
        view = a();
        if (NativeAd.i(a) != null)
        {
            view.put("nti", String.valueOf(NativeAd.i(a).getValue()));
        }
        if (NativeAd.j(a))
        {
            view.put("nhs", String.valueOf(NativeAd.j(a)));
        }
        NativeAd.f(a).b(view);
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        if (motionevent.getAction() == 0 && NativeAd.g(a) != null)
        {
            d = NativeAd.g(a).getWidth();
            e = NativeAd.g(a).getHeight();
            int ai[] = new int[2];
            NativeAd.g(a).getLocationInWindow(ai);
            f = ai[0];
            g = ai[1];
            Rect rect = new Rect();
            NativeAd.g(a).getGlobalVisibleRect(rect);
            i = rect.width();
            h = rect.height();
            int ai1[] = new int[2];
            view.getLocationInWindow(ai1);
            b = ((int)motionevent.getX() + ai1[0]) - ai[0];
            int k = (int)motionevent.getY();
            c = (ai1[1] + k) - ai[1];
            j = true;
        }
        return com.facebook.ads.NativeAd.n(a) != null && com.facebook.ads.NativeAd.n(a).onTouch(view, motionevent);
    }

    private apters.n(NativeAd nativead)
    {
        a = nativead;
        super();
    }

    a(NativeAd nativead, a a1)
    {
        this(nativead);
    }
}
