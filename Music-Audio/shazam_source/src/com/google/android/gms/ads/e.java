// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.a;
import com.google.android.gms.ads.internal.client.aa;
import com.google.android.gms.ads.internal.client.t;
import com.google.android.gms.ads.internal.util.client.b;
import com.google.android.gms.d.er;

// Referenced classes of package com.google.android.gms.ads:
//            c, d, a

public final class e extends ViewGroup
{

    public final aa a = new aa(this);

    public e(Context context)
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

    public final com.google.android.gms.ads.a getAdListener()
    {
        return a.a;
    }

    public final d getAdSize()
    {
        return a.b();
    }

    public final String getAdUnitId()
    {
        return a.d;
    }

    public final com.google.android.gms.ads.purchase.a getInAppPurchaseListener()
    {
        return a.f;
    }

    public final String getMediationAdapterClassName()
    {
        return a.e();
    }

    protected final void onLayout(boolean flag, int i, int j, int k, int l)
    {
        View view = getChildAt(0);
        if (view != null && view.getVisibility() != 8)
        {
            int i1 = view.getMeasuredWidth();
            int j1 = view.getMeasuredHeight();
            i = (k - i - i1) / 2;
            j = (l - j - j1) / 2;
            view.layout(i, j, i1 + i, j1 + j);
        }
    }

    protected final void onMeasure(int i, int j)
    {
        int k = 0;
        View view = getChildAt(0);
        int l;
        if (view != null && view.getVisibility() != 8)
        {
            measureChild(view, i, j);
            l = view.getMeasuredWidth();
            k = view.getMeasuredHeight();
        } else
        {
            d d1 = getAdSize();
            if (d1 != null)
            {
                Context context = getContext();
                l = d1.b(context);
                k = d1.a(context);
            } else
            {
                l = 0;
            }
        }
        l = Math.max(l, getSuggestedMinimumWidth());
        k = Math.max(k, getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSize(l, i), View.resolveSize(k, j));
    }

    public final void setAdListener(com.google.android.gms.ads.a a1)
    {
        a.a(a1);
        if (a1 != null && (a1 instanceof a))
        {
            a.a((a)a1);
        } else
        if (a1 == null)
        {
            a.a(null);
            return;
        }
    }

    public final void setAdSize(d d1)
    {
        a.a(new d[] {
            d1
        });
    }

    public final void setAdUnitId(String s)
    {
        a.a(s);
    }

    public final void setInAppPurchaseListener(com.google.android.gms.ads.purchase.a a1)
    {
        Object obj;
        obj = a;
        if (((aa) (obj)).g != null)
        {
            throw new IllegalStateException("Play store purchase parameter has already been set.");
        }
        obj.f = a1;
        if (((aa) (obj)).b == null) goto _L2; else goto _L1
_L1:
        obj = ((aa) (obj)).b;
        if (a1 == null)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        a1 = new er(a1);
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
}
