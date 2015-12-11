// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.liverail.library.a.c;
import com.liverail.library.a.d;
import com.liverail.library.events.VPAIDEvent;
import com.liverail.library.events.VPAIDEventListener;
import com.liverail.library.events.a;
import com.liverail.library.events.b;
import com.liverail.library.f.i;
import com.liverail.library.g.e;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Map;

// Referenced classes of package com.liverail.library:
//            a, b, c

public class AdView extends RelativeLayout
    implements a
{

    private final b a;
    private Map b;
    private final d c;
    private final com.liverail.library.c.a d;
    private final com.liverail.library.c.e e;
    private final com.liverail.library.d.a f;
    private e g;
    private boolean h;
    private ListIterator i;
    private com.liverail.library.g.a j;
    private ListIterator k;
    private int l;
    private int m;
    private boolean n;
    private boolean o;
    private boolean p;
    private Runnable q;
    private com.liverail.library.f.a r;
    private final i s;

    public AdView(Context context)
    {
        super(context);
        a = new b(this);
        c = new d();
        d = new com.liverail.library.c.a(c);
        e = new com.liverail.library.a(this);
        f = new com.liverail.library.d.a(c);
        q = new com.liverail.library.b(this);
        s = new com.liverail.library.c(this);
        a();
    }

    public AdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a = new b(this);
        c = new d();
        d = new com.liverail.library.c.a(c);
        e = new com.liverail.library.a(this);
        f = new com.liverail.library.d.a(c);
        q = new com.liverail.library.b(this);
        s = new com.liverail.library.c(this);
        a();
    }

    public AdView(Context context, AttributeSet attributeset, int i1)
    {
        super(context, attributeset, i1);
        a = new b(this);
        c = new d();
        d = new com.liverail.library.c.a(c);
        e = new com.liverail.library.a(this);
        f = new com.liverail.library.d.a(c);
        q = new com.liverail.library.b(this);
        s = new com.liverail.library.c(this);
        a();
    }

    private void a()
    {
        c.c = getContext();
    }

    static void a(AdView adview)
    {
        adview.c();
    }

    static void a(AdView adview, int i1)
    {
        adview.m = i1;
    }

    static void a(AdView adview, com.liverail.library.a.b b1)
    {
        adview.a(b1);
    }

    static void a(AdView adview, boolean flag)
    {
        adview.p = flag;
    }

    private void a(com.liverail.library.a.b b1)
    {
        d.a(null);
        f.a(b1);
        dispatchEvent(new VPAIDEvent("AdError"));
    }

    private void a(com.liverail.library.g.a a1)
    {
        if (r == null)
        {
            com.liverail.library.b.a.a("Creating Linear Renderer instance.");
            r = new com.liverail.library.f.a(getContext());
            r.setPublisherData(c);
        }
        r.setListener(s);
        if (indexOfChild(r) == -1)
        {
            com.liverail.library.b.a.a("Adding linear renderer to the view.");
            addView(r, new android.widget.RelativeLayout.LayoutParams(-1, -1));
        }
        r.a(a1, m, l);
    }

    private void b()
    {
        com.liverail.library.b.a.a("initializing new ad request");
        if (b != null)
        {
            com.liverail.library.b.a.a("Ingest LR_ run-time parameters");
            c.a(b);
            b = null;
        }
        String s1 = c.a();
        if (s1 == null || s1.length() == 0)
        {
            a(new com.liverail.library.a.b(c.e));
            return;
        } else
        {
            d.a(e);
            d.a();
            return;
        }
    }

    static void b(AdView adview)
    {
        adview.b();
    }

    static void b(AdView adview, boolean flag)
    {
        adview.h = flag;
    }

    static int c(AdView adview)
    {
        return adview.m;
    }

    private void c()
    {
        com.liverail.library.g.d d1;
        StringBuilder stringbuilder;
        int i1;
        int k1;
        d.a(null);
        d1 = d.b();
        f.a(d1.j);
        l = 0;
        m = 0;
        stringbuilder = new StringBuilder("Ad Map:");
        k1 = d1.l.size();
        i1 = 0;
_L8:
        if (i1 < k1) goto _L2; else goto _L1
_L1:
        com.liverail.library.b.a.a(stringbuilder.toString());
        if (!d1.l.isEmpty()) goto _L4; else goto _L3
_L3:
        com.liverail.library.b.a.c("No ad-slots received, probably due to publisher freq cap.");
        dispatchEvent(new VPAIDEvent("AdError"));
_L6:
        return;
_L2:
        e e1 = (e)d.b().l.get(i1);
        StringBuilder stringbuilder1 = stringbuilder.append("\n- adSlot[").append(String.valueOf(i1)).append("] '");
        String s1;
        int l1;
        if (e1.c == 1)
        {
            s1 = "in";
        } else
        {
            s1 = "ov";
        }
        stringbuilder1.append(s1).append("' / ads:");
        l1 = e1.d.size();
        if (l1 == 0)
        {
            stringbuilder.append(" unfilled");
        } else
        {
            l = l + 1;
            int j1 = 0;
            while (j1 < l1) 
            {
                com.liverail.library.g.a a1 = (com.liverail.library.g.a)e1.d.get(j1);
                if (j1 > 0)
                {
                    stringbuilder.append(",");
                }
                stringbuilder.append(" [").append(a1.b).append("]");
                j1++;
            }
        }
        i1++;
        continue; /* Loop/switch isn't completed */
_L4:
        dispatchEvent(new VPAIDEvent("AdLoaded"));
        if (!n) goto _L6; else goto _L5
_L5:
        com.liverail.library.b.a.a("startAd() was delayed. start ad playback.");
        n = false;
        d();
        return;
        if (true) goto _L8; else goto _L7
_L7:
    }

    static com.liverail.library.d.a d(AdView adview)
    {
        return adview.f;
    }

    private void d()
    {
        if (i.hasNext())
        {
            com.liverail.library.b.a.b((new StringBuilder("----- Start inventory slot[")).append(i.nextIndex()).append("] -----").toString());
            g = (e)i.next();
            h = false;
            k = g.d.listIterator();
            f.a(g, "adslot");
            e();
            return;
        } else
        {
            com.liverail.library.b.a.b("Completed all inventory slots.");
            f();
            return;
        }
    }

    static com.liverail.library.g.a e(AdView adview)
    {
        return adview.j;
    }

    private void e()
    {
        if (!h && k.hasNext())
        {
            int i1 = k.nextIndex();
            j = (com.liverail.library.g.a)k.next();
            com.liverail.library.b.a.b((new StringBuilder("Begin ad[")).append(i1).append("] ").append(j.toString()).toString());
            f.a(j, "adslot");
            a(j);
            return;
        }
        if (!h)
        {
            com.liverail.library.b.a.d("Current inventory slot unfilled.");
            if (!g.d.isEmpty())
            {
                l = l - 1;
            }
        }
        com.liverail.library.b.a.a("Finished processing current inventory slot.");
        d();
    }

    private void f()
    {
        if (p)
        {
            dispatchEvent(new VPAIDEvent("AdStopped"));
            return;
        } else
        {
            dispatchEvent(new VPAIDEvent("AdError"));
            return;
        }
    }

    static void f(AdView adview)
    {
        adview.g();
    }

    private void g()
    {
        if (!h)
        {
            com.liverail.library.b.a.d("Current ad failed to generate impression");
        }
        e();
    }

    private void h()
    {
        com.liverail.library.b.a.a("destroy configuration");
        n = false;
        o = false;
        p = false;
        if (d != null)
        {
            d.a(null);
            d.d();
        }
        if (r != null)
        {
            r.setListener(null);
            r.d();
        }
        removeCallbacks(q);
        j = null;
        removeAllViews();
    }

    public void addEventListener(String s1, VPAIDEventListener vpaideventlistener)
    {
        a.addEventListener(s1, vpaideventlistener);
    }

    public void dispatchEvent(VPAIDEvent vpaidevent)
    {
        a.dispatchEvent(vpaidevent);
    }

    public double getAdDuration()
    {
        if (j != null && r != null)
        {
            double d1 = (double)r.getVideoDuration() / 1000D;
            if (d1 > 0.0D)
            {
                return d1;
            } else
            {
                return -2D;
            }
        } else
        {
            return -2D;
        }
    }

    public double getAdRemainingTime()
    {
        if (j != null && r != null)
        {
            double d1 = (double)(r.getVideoDuration() - r.getVideoProgress()) / 1000D;
            if (d1 < 0.0D)
            {
                return 0.0D;
            } else
            {
                return d1;
            }
        } else
        {
            return -2D;
        }
    }

    public boolean hasEventListener(String s1, VPAIDEventListener vpaideventlistener)
    {
        return a.hasEventListener(s1, vpaideventlistener);
    }

    public void initAd(Map map)
    {
        com.liverail.library.b.a.c(">> initAd()");
        h();
        b = map;
        post(q);
    }

    protected void onSizeChanged(int i1, int j1, int k1, int l1)
    {
        super.onSizeChanged(i1, j1, k1, l1);
        if (i1 > 0 && j1 > 0 && (i1 != c.i.a || j1 != c.i.b))
        {
            com.liverail.library.b.a.a((new StringBuilder("onSizeChanged() w=")).append(i1).append(" h=").append(j1).append(" from oldw=").append(k1).append(" oldh=").append(l1).toString());
            c.i.a = i1;
            c.i.b = j1;
        }
    }

    public void pauseAd()
    {
        if (j != null && r != null)
        {
            r.a();
        }
    }

    public void removeEventListener(String s1, VPAIDEventListener vpaideventlistener)
    {
        a.removeEventListener(s1, vpaideventlistener);
    }

    public void resumeAd()
    {
        if (j != null && r != null)
        {
            r.b();
        }
    }

    public void setDebug(boolean flag)
    {
        com.liverail.library.b.a.a = flag;
        StringBuilder stringbuilder = new StringBuilder("LiveRail init SDK version ");
        c.getClass();
        com.liverail.library.b.a.c(stringbuilder.append("2.1.0").toString());
        com.liverail.library.b.a.c((new StringBuilder(">> setDebug(")).append(flag).append(")").toString());
    }

    public void startAd()
    {
        com.liverail.library.b.a.c(">> startAd()");
        if (o)
        {
            com.liverail.library.b.a.d("Duplicate call to startAd() (ignoring)");
            return;
        }
        o = true;
        n = false;
        if (d.c() == 1)
        {
            com.liverail.library.b.a.d("startAd() called but LiveRail still initializing (start delayed)");
            n = true;
            f.a(new com.liverail.library.a.b(c.f));
            return;
        }
        if (d.c() == 2)
        {
            dispatchEvent(new VPAIDEvent("AdStarted"));
            i = d.b().l.listIterator();
            d();
            return;
        } else
        {
            com.liverail.library.b.a.e("Cannot call startAd() without calling initAd() first.");
            f.a(new com.liverail.library.a.b(c.f, (new StringBuilder("AdProvider state=")).append(d.c()).toString()));
            dispatchEvent(new VPAIDEvent("AdError"));
            return;
        }
    }

    public void stopAd()
    {
        com.liverail.library.b.a.c(">> stopAd()");
        h();
    }
}
