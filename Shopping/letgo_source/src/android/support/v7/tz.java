// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.app.Activity;
import com.google.android.gms.ads.internal.zzp;

// Referenced classes of package android.support.v7:
//            tp, tq

public final class tz
{

    private Activity a;
    private boolean b;
    private boolean c;
    private boolean d;
    private android.view.ViewTreeObserver.OnGlobalLayoutListener e;
    private android.view.ViewTreeObserver.OnScrollChangedListener f;

    public tz(Activity activity, android.view.ViewTreeObserver.OnGlobalLayoutListener ongloballayoutlistener, android.view.ViewTreeObserver.OnScrollChangedListener onscrollchangedlistener)
    {
        a = activity;
        e = ongloballayoutlistener;
        f = onscrollchangedlistener;
    }

    private void e()
    {
        while (a == null || b) 
        {
            return;
        }
        if (e != null)
        {
            zzp.zzbx().a(a, e);
        }
        if (f != null)
        {
            zzp.zzbx().a(a, f);
        }
        b = true;
    }

    private void f()
    {
        while (a == null || !b) 
        {
            return;
        }
        if (e != null)
        {
            zzp.zzbz().a(a, e);
        }
        if (f != null)
        {
            zzp.zzbx().b(a, f);
        }
        b = false;
    }

    public void a()
    {
        d = true;
        if (c)
        {
            e();
        }
    }

    public void a(Activity activity)
    {
        a = activity;
    }

    public void b()
    {
        d = false;
        f();
    }

    public void c()
    {
        c = true;
        if (d)
        {
            e();
        }
    }

    public void d()
    {
        c = false;
        f();
    }
}
