// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.et;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.kz;
import com.google.android.gms.internal.q;

// Referenced classes of package com.google.android.gms.ads.doubleclick:
//            PublisherAdRequest, AppEventListener

public final class PublisherAdView extends ViewGroup
{

    private final q dZ;

    public PublisherAdView(Context context)
    {
        super(context);
        dZ = new q(this);
    }

    public PublisherAdView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        dZ = new q(this, attributeset, true);
    }

    public PublisherAdView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        dZ = new q(this, attributeset, true);
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

    public final AdSize[] getAdSizes()
    {
        return dZ.c;
    }

    public final String getAdUnitId()
    {
        return dZ.d;
    }

    public final AppEventListener getAppEventListener()
    {
        return dZ.e;
    }

    public final void loadAd(PublisherAdRequest publisheradrequest)
    {
        dZ.a(publisheradrequest.v());
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

    public final void recordManualImpression()
    {
        q q1 = dZ;
        try
        {
            q1.b.h();
            return;
        }
        catch (RemoteException remoteexception)
        {
            et.a("Failed to record impression.", remoteexception);
        }
    }

    public final void resume()
    {
        dZ.d();
    }

    public final void setAdListener(AdListener adlistener)
    {
        dZ.a(adlistener);
    }

    public final transient void setAdSizes(AdSize aadsize[])
    {
        if (aadsize == null || aadsize.length <= 0)
        {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        } else
        {
            dZ.b(aadsize);
            return;
        }
    }

    public final void setAdUnitId(String s)
    {
        dZ.a(s);
    }

    public final void setAppEventListener(AppEventListener appeventlistener)
    {
        Object obj = dZ;
        obj.e = appeventlistener;
        if (((q) (obj)).b == null) goto _L2; else goto _L1
_L1:
        obj = ((q) (obj)).b;
        if (appeventlistener == null)
        {
            break MISSING_BLOCK_LABEL_43;
        }
        appeventlistener = new kz(appeventlistener);
_L3:
        ((f) (obj)).a(appeventlistener);
_L2:
        return;
        appeventlistener = null;
          goto _L3
        appeventlistener;
        et.a("Failed to set the AppEventListener.", appeventlistener);
        return;
    }
}
