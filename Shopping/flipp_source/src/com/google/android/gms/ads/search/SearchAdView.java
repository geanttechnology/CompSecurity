// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.search;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.q;

// Referenced classes of package com.google.android.gms.ads.search:
//            SearchAdRequest

public final class SearchAdView extends ViewGroup
{

    private final q dZ;

    public SearchAdView(Context context)
    {
        super(context);
        dZ = new q(this);
    }

    public SearchAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        dZ = new q(this, attributeset, false);
    }

    public SearchAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        dZ = new q(this, attributeset, false);
    }

    public final void destroy()
    {
        dZ.a();
    }

    public final AdListener getAdListener()
    {
        return dZ.a;
    }

    public final AdSize getAdSize()
    {
        return dZ.b();
    }

    public final String getAdUnitId()
    {
        return dZ.d;
    }

    public final void loadAd(SearchAdRequest searchadrequest)
    {
        dZ.a(searchadrequest.v());
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
        AdSize adsize = getAdSize();
        int l;
        if (view != null && view.getVisibility() != 8)
        {
            measureChild(view, i, j);
            l = view.getMeasuredWidth();
            k = view.getMeasuredHeight();
        } else
        if (adsize != null)
        {
            Context context = getContext();
            l = adsize.getWidthInPixels(context);
            k = adsize.getHeightInPixels(context);
        } else
        {
            l = 0;
        }
        l = Math.max(l, getSuggestedMinimumWidth());
        k = Math.max(k, getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSize(l, i), View.resolveSize(k, j));
    }

    public final void pause()
    {
        dZ.c();
    }

    public final void resume()
    {
        dZ.d();
    }

    public final void setAdListener(AdListener adlistener)
    {
        dZ.a(adlistener);
    }

    public final void setAdSize(AdSize adsize)
    {
        dZ.a(new AdSize[] {
            adsize
        });
    }

    public final void setAdUnitId(String s)
    {
        dZ.a(s);
    }
}
