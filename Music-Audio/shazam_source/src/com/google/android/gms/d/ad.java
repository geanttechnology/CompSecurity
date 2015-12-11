// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.m;
import com.google.android.gms.ads.internal.e;
import com.google.android.gms.ads.internal.overlay.g;
import com.google.android.gms.ads.internal.overlay.n;
import com.google.android.gms.ads.internal.p;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.ads.internal.util.client.a;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

// Referenced classes of package com.google.android.gms.d:
//            ab, hg, he, gm, 
//            hf, ag, o, cb, 
//            ce, af

public final class ad
    implements ab
{

    final he a;

    public ad(Context context, VersionInfoParcel versioninfoparcel, o o)
    {
        p.f();
        a = com.google.android.gms.d.hg.a(context, new AdSizeParcel(), false, false, o, versioninfoparcel);
        a.setWillNotDraw(true);
    }

    private static void a(Runnable runnable)
    {
        m.a();
        if (com.google.android.gms.ads.internal.util.client.a.b())
        {
            runnable.run();
            return;
        } else
        {
            com.google.android.gms.d.gm.a.post(runnable);
            return;
        }
    }

    public final void a()
    {
        a.destroy();
    }

    public final void a(com.google.android.gms.ads.internal.client.a a1, g g, cb cb, n n)
    {
        a.i().a(a1, g, cb, n, false, null, null, new e((byte)0), null);
    }

    public final void a(ab.a a1)
    {
        a.i().d = new hf.a(a1) {

            final ab.a a;
            final ad b;

            public final void a(he he1, boolean flag)
            {
                a.a();
            }

            
            {
                b = ad.this;
                a = a1;
                super();
            }
        };
    }

    public final void a(String s)
    {
        a(new Runnable(String.format("<!DOCTYPE html><html><head><script src=\"%s\"></script></head><body></body></html>", new Object[] {
            s
        })) {

            final String a;
            final ad b;

            public final void run()
            {
                b.a.loadData(a, "text/html", "UTF-8");
            }

            
            {
                b = ad.this;
                a = s;
                super();
            }
        });
    }

    public final void a(String s, ce ce)
    {
        a.i().a(s, ce);
    }

    public final void a(String s, String s1)
    {
        a(new Runnable(s, s1) {

            final String a;
            final String b;
            final ad c;

            public final void run()
            {
                c.a.a(a, b);
            }

            
            {
                c = ad.this;
                a = s;
                b = s1;
                super();
            }
        });
    }

    public final void a(String s, JSONObject jsonobject)
    {
        a(new Runnable(s, jsonobject) {

            final String a;
            final JSONObject b;
            final ad c;

            public final void run()
            {
                c.a.b(a, b);
            }

            
            {
                c = ad.this;
                a = s;
                b = jsonobject;
                super();
            }
        });
    }

    public final af b()
    {
        return new ag(this);
    }

    public final void b(String s)
    {
        a(new Runnable(s) {

            final String a;
            final ad b;

            public final void run()
            {
                b.a.loadUrl(a);
            }

            
            {
                b = ad.this;
                a = s;
                super();
            }
        });
    }

    public final void b(String s, ce ce)
    {
        hf hf1 = a.i();
        Object obj = hf1.c;
        obj;
        JVM INSTR monitorenter ;
        s = (List)hf1.b.get(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_39;
        }
        obj;
        JVM INSTR monitorexit ;
        return;
        s.remove(ce);
        obj;
        JVM INSTR monitorexit ;
        return;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void c(String s)
    {
        a(new Runnable(s) {

            final String a;
            final ad b;

            public final void run()
            {
                b.a.loadData(a, "text/html", "UTF-8");
            }

            
            {
                b = ad.this;
                a = s;
                super();
            }
        });
    }
}
