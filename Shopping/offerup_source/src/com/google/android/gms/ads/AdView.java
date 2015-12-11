// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.client.zza;
import com.google.android.gms.ads.internal.client.zzz;
import com.google.android.gms.ads.purchase.InAppPurchaseListener;
import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest, AdSize, AdListener

public final class AdView extends ViewGroup
{

    private final zzz zznT;

    public AdView(Context context)
    {
        super(context);
        zznT = new zzz(this);
    }

    public AdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        zznT = new zzz(this, attributeset, false);
    }

    public AdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        zznT = new zzz(this, attributeset, false);
    }

    public final void destroy()
    {
        zznT.destroy();
    }

    public final AdListener getAdListener()
    {
        return zznT.getAdListener();
    }

    public final AdSize getAdSize()
    {
        return zznT.getAdSize();
    }

    public final String getAdUnitId()
    {
        return zznT.getAdUnitId();
    }

    public final InAppPurchaseListener getInAppPurchaseListener()
    {
        return zznT.getInAppPurchaseListener();
    }

    public final String getMediationAdapterClassName()
    {
        return zznT.getMediationAdapterClassName();
    }

    public final boolean isLoading()
    {
        return zznT.isLoading();
    }

    public final void loadAd(AdRequest adrequest)
    {
        zznT.zza(adrequest.zzaF());
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
            AdSize adsize = getAdSize();
            if (adsize != null)
            {
                Context context = getContext();
                l = adsize.getWidthInPixels(context);
                k = adsize.getHeightInPixels(context);
            } else
            {
                l = 0;
            }
        }
        l = Math.max(l, getSuggestedMinimumWidth());
        k = Math.max(k, getSuggestedMinimumHeight());
        setMeasuredDimension(View.resolveSize(l, i), View.resolveSize(k, j));
    }

    public final void pause()
    {
        zznT.pause();
    }

    public final void resume()
    {
        zznT.resume();
    }

    public final void setAdListener(AdListener adlistener)
    {
        zznT.setAdListener(adlistener);
        if (adlistener != null && (adlistener instanceof zza))
        {
            zznT.zza((zza)adlistener);
        } else
        if (adlistener == null)
        {
            zznT.zza(null);
            return;
        }
    }

    public final void setAdSize(AdSize adsize)
    {
        zznT.setAdSizes(new AdSize[] {
            adsize
        });
    }

    public final void setAdUnitId(String s)
    {
        zznT.setAdUnitId(s);
    }

    public final void setInAppPurchaseListener(InAppPurchaseListener inapppurchaselistener)
    {
        zznT.setInAppPurchaseListener(inapppurchaselistener);
    }

    public final void setPlayStorePurchaseParams(PlayStorePurchaseListener playstorepurchaselistener, String s)
    {
        zznT.setPlayStorePurchaseParams(playstorepurchaselistener, s);
    }
}
