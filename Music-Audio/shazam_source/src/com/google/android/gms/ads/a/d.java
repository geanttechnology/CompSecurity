// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.a;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.a;
import com.google.android.gms.ads.internal.client.aa;
import com.google.android.gms.ads.internal.client.l;
import com.google.android.gms.ads.internal.client.t;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.bj;

// Referenced classes of package com.google.android.gms.ads.a:
//            c, a, b

public final class d extends ViewGroup
{

    private final aa a = new aa(this);

    public d(Context context)
    {
        super(context);
    }

    public final void a()
    {
        a.a();
    }

    public final void a(c c1)
    {
        a.a(c1.b);
    }

    public final void b()
    {
        a.c();
    }

    public final void c()
    {
        a.d();
    }

    public final a getAdListener()
    {
        return a.a;
    }

    public final com.google.android.gms.ads.d getAdSize()
    {
        return a.b();
    }

    public final com.google.android.gms.ads.d[] getAdSizes()
    {
        return a.c;
    }

    public final String getAdUnitId()
    {
        return a.d;
    }

    public final com.google.android.gms.ads.a.a getAppEventListener()
    {
        return a.e;
    }

    public final String getMediationAdapterClassName()
    {
        return a.e();
    }

    public final com.google.android.gms.ads.a.b getOnCustomRenderedAdLoadedListener()
    {
        return a.h;
    }

    protected final void onLayout(boolean flag, int i, int j, int k, int i1)
    {
        View view = getChildAt(0);
        if (view != null && view.getVisibility() != 8)
        {
            int j1 = view.getMeasuredWidth();
            int k1 = view.getMeasuredHeight();
            i = (k - i - j1) / 2;
            j = (i1 - j - k1) / 2;
            view.layout(i, j, j1 + i, k1 + j);
        }
    }

    protected final void onMeasure(int i, int j)
    {
        int k = 0;
        View view = getChildAt(0);
        int i1;
        if (view != null && view.getVisibility() != 8)
        {
            measureChild(view, i, j);
            i1 = view.getMeasuredWidth();
            k = view.getMeasuredHeight();
        } else
        {
            com.google.android.gms.ads.d d1 = getAdSize();
            if (d1 != null)
            {
                Context context = getContext();
                i1 = d1.b(context);
                k = d1.a(context);
            } else
            {
                i1 = 0;
            }
        }
        i1 = Math.max(i1, getSuggestedMinimumWidth());
        k = Math.max(k, getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSize(i1, i), View.resolveSize(k, j));
    }

    public final void setAdListener(a a1)
    {
        a.a(a1);
    }

    public final transient void setAdSizes(com.google.android.gms.ads.d ad[])
    {
        if (ad == null || ad.length <= 0)
        {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        } else
        {
            a.b(ad);
            return;
        }
    }

    public final void setAdUnitId(String s)
    {
        a.a(s);
    }

    public final void setAppEventListener(com.google.android.gms.ads.a.a a1)
    {
        Object obj = a;
        obj.e = a1;
        if (((aa) (obj)).b == null) goto _L2; else goto _L1
_L1:
        obj = ((aa) (obj)).b;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        a1 = new l(a1);
_L3:
        ((t) (obj)).a(a1);
_L2:
        return;
        a1 = null;
          goto _L3
        a1;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        return;
    }

    public final void setManualImpressionsEnabled(boolean flag)
    {
        aa aa1 = a;
        aa1.i = flag;
        try
        {
            if (aa1.b != null)
            {
                aa1.b.a(aa1.i);
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            com.google.android.gms.ads.internal.util.client.b.a(5);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(com.google.android.gms.ads.a.b b1)
    {
        Object obj;
        obj = a;
        obj.h = b1;
        if (((aa) (obj)).b == null) goto _L2; else goto _L1
_L1:
        obj = ((aa) (obj)).b;
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        b1 = new bj(b1);
_L3:
        ((t) (obj)).a(b1);
_L2:
        return;
        b1 = null;
          goto _L3
        b1;
        com.google.android.gms.ads.internal.util.client.b.a(5);
        return;
    }
}
