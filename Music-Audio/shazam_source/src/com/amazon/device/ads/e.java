// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.webkit.WebViewDatabase;
import android.widget.FrameLayout;

// Referenced classes of package com.amazon.device.ads:
//            bf, dx, dw, cq, 
//            eb, cx, d, am

public final class e extends FrameLayout
    implements bf
{
    static final class a
    {

        a()
        {
        }
    }


    dw a;
    final cq b;
    boolean c;
    String d;
    String e;
    boolean f;
    cx g;
    private boolean h;

    public e(Context context, d d1)
    {
        this(context, d1, new dx());
    }

    private e(Context context, d d1, dx dx1)
    {
        super(context);
        c = false;
        h = true;
        dx1.a = this;
        a = new dw(dx1.a);
        setContentDescription("adContainerObject");
        b = new cq(this, d1);
    }

    public final void a()
    {
        dw dw1 = a;
        dw1.a(new WebView[] {
            dw1.d, dw1.e, dw1.f
        });
        dw1.d = null;
        dw1.e = null;
        dw1.f = null;
    }

    public final void a(int i, int j, int k)
    {
        dw dw1 = a;
        dw1.h = i;
        dw1.g = j;
        dw1.i = k;
        dw1.c();
    }

    public final void a(android.view.View.OnKeyListener onkeylistener)
    {
        a.a(onkeylistener);
    }

    public final void a(String s, String s1, boolean flag, cx cx)
    {
        d = s;
        e = s1;
        f = flag;
        g = cx;
        if (s != null)
        {
            dw dw1 = a;
            if (flag)
            {
                if (cx != null)
                {
                    dw1.d().setWebViewClient(new dw.b(dw1, cx));
                }
                dw1.d().loadDataWithBaseURL(s, s1, "text/html", "UTF-8", null);
                return;
            } else
            {
                dw1.b().loadDataWithBaseURL(s, s1, "text/html", "UTF-8", null);
                return;
            }
        }
        s = a;
        if (flag)
        {
            if (cx != null)
            {
                s.d().setWebViewClient(new dw.b(s, cx));
            }
            s.d().loadData(s1, "text/html", "UTF-8");
            return;
        } else
        {
            s.b().loadData(s1, "text/html", "UTF-8");
            return;
        }
    }

    public final void a(boolean flag)
    {
        c = flag;
        if (a != null)
        {
            a.j = c;
        }
    }

    public final boolean b()
    {
        dw dw1 = a;
        Context context = dw.a(dw1.a);
        return dw1.b.b(context) && WebViewDatabase.getInstance(context) != null;
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionevent)
    {
        return !h;
    }

    public final void setAdWebViewClient(am am)
    {
        dw dw1 = a;
        dw1.c = am;
        if (dw1.a())
        {
            dw1.b().setWebViewClient(dw1.c);
        }
    }

    public final void setViewHeight(int i)
    {
        dw dw1 = a;
        dw1.g = i;
        dw1.c();
    }
}
