// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Handler;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.be;
import com.google.android.gms.d.bf;
import com.google.android.gms.d.bi;
import com.google.android.gms.d.dg;
import com.google.android.gms.d.ec;
import com.google.android.gms.d.fb;
import com.google.android.gms.d.gb;
import com.google.android.gms.d.gm;
import com.google.android.gms.d.go;
import com.google.android.gms.d.he;
import com.google.android.gms.d.hf;
import com.google.android.gms.d.hg;

// Referenced classes of package com.google.android.gms.ads.internal:
//            b, g, q, p, 
//            d, e

public abstract class c extends com.google.android.gms.ads.internal.b
    implements g, ec
{

    public c(Context context, AdSizeParcel adsizeparcel, String s, dg dg, VersionInfoParcel versioninfoparcel, d d)
    {
        super(context, adsizeparcel, s, dg, versioninfoparcel, d);
    }

    protected he a(com.google.android.gms.d.gb.a a1, e e)
    {
        Object obj = c.f.getNextView();
        if (!(obj instanceof he)) goto _L2; else goto _L1
_L1:
        com.google.android.gms.ads.internal.util.client.b.a(3);
        obj = (he)obj;
        ((he) (obj)).a(c.c, c.i);
_L4:
        ((he) (obj)).i().a(this, this, this, this, false, this, null, e, this);
        ((he) (obj)).b(a1.a.z);
        ((he) (obj)).c(a1.a.x);
        return ((he) (obj));
_L2:
        if (obj != null)
        {
            c.f.removeView(((View) (obj)));
        }
        p.f();
        obj = hg.a(c.c, c.i, c.d, c.e, f);
        if (c.i.h == null)
        {
            a(((View) (((he) (obj)).getWebView())));
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final void a(bi bi)
    {
        w.b("setOnCustomRenderedAdLoadedListener must be called on the main UI thread.");
        c.x = bi;
    }

    protected final void a(com.google.android.gms.d.gb.a a1, be be)
    {
        if (a1.e != -2)
        {
            gm.a.post(new Runnable(a1) {

                final com.google.android.gms.d.gb.a a;
                final c b;

                public final void run()
                {
                    b.b(new gb(a));
                }

            
            {
                b = c.this;
                a = a1;
                super();
            }
            });
            return;
        }
        if (a1.d != null)
        {
            c.i = a1.d;
        }
        if (a1.b.h)
        {
            c.C = 0;
            q q1 = c;
            p.d();
            q1.h = fb.a(c.c, this, a1, c.d, null, g, this, be);
            return;
        } else
        {
            gm.a.post(new Runnable(a1, be) {

                final com.google.android.gms.d.gb.a a;
                final be b;
                final c c;

                public final void run()
                {
                    if (a.b.s && c.c.x != null)
                    {
                        Object obj = null;
                        if (a.b.b != null)
                        {
                            p.e();
                            obj = gm.a(a.b.b);
                        }
                        obj = new bf(c, ((String) (obj)), a.b.c);
                        c.c.C = 1;
                        try
                        {
                            c.c.x.a(((com.google.android.gms.d.bh) (obj)));
                            return;
                        }
                        catch (RemoteException remoteexception)
                        {
                            com.google.android.gms.ads.internal.util.client.b.a(5);
                        }
                    }
                    Object obj1 = new e();
                    he he1 = c.a(a, ((e) (obj1)));
                    obj1.a = new e.b(a, he1);
                    he1.setOnTouchListener(new android.view.View.OnTouchListener(this, ((e) (obj1))) {

                        final e a;
                        final _cls2 b;

                        public final boolean onTouch(View view, MotionEvent motionevent)
                        {
                            a.b = true;
                            return false;
                        }

            
            {
                b = _pcls2;
                a = e1;
                super();
            }
                    });
                    he1.setOnClickListener(new android.view.View.OnClickListener(this, ((e) (obj1))) {

                        final e a;
                        final _cls2 b;

                        public final void onClick(View view)
                        {
                            a.b = true;
                        }

            
            {
                b = _pcls2;
                a = e1;
                super();
            }
                    });
                    c.c.C = 0;
                    obj1 = c.c;
                    p.d();
                    obj1.h = fb.a(c.c.c, c, a, c.c.d, he1, c.g, c, b);
                }

            
            {
                c = c.this;
                a = a1;
                b = be;
                super();
            }
            });
            return;
        }
    }

    protected boolean a(gb gb1, gb gb2)
    {
        if (c.c() && c.f != null)
        {
            c.f.a.b = gb2.v;
        }
        return super.a(gb1, gb2);
    }

    public final void b(View view)
    {
        c.B = view;
        b(new gb(c.k));
    }

    public final void q()
    {
        a(c.j, false);
    }

    public final void x()
    {
        onAdClicked();
    }

    public final void y()
    {
        o();
    }

    public final void z()
    {
        m();
    }
}
