// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.internal.ak;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest, AdSize, AdListener

public final class AdView extends ViewGroup
{

    private final ak kD;

    public AdView(Context context)
    {
        super(context);
        kD = new ak(this);
    }

    public AdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        kD = new ak(this, attributeset, false);
    }

    public AdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        kD = new ak(this, attributeset, false);
    }

    public void destroy()
    {
        kD.destroy();
    }

    public AdListener getAdListener()
    {
        return kD.getAdListener();
    }

    public AdSize getAdSize()
    {
        return kD.getAdSize();
    }

    public String getAdUnitId()
    {
        return kD.getAdUnitId();
    }

    public void loadAd(AdRequest adrequest)
    {
        kD.a(adrequest.N());
    }

    protected void onLayout(boolean flag, int i, int j, int k, int l)
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

    protected void onMeasure(int i, int j)
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

    public void pause()
    {
        kD.pause();
    }

    public void resume()
    {
        kD.resume();
    }

    public void setAdListener(AdListener adlistener)
    {
        kD.setAdListener(adlistener);
    }

    public void setAdSize(AdSize adsize)
    {
        kD.setAdSizes(new AdSize[] {
            adsize
        });
    }

    public void setAdUnitId(String s)
    {
        kD.setAdUnitId(s);
    }
}
