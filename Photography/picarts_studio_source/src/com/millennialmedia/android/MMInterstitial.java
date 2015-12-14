// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            MMAd, MMAdImpl, MMLog, MMException, 
//            MMAdImplController, AdCache, CachedAd, HandShake, 
//            MMSDK, MMRequest, RequestListener

public final class MMInterstitial
    implements MMAd
{

    private MMAdImpl a;

    public MMInterstitial(Context context)
    {
        a = new MMInterstitialAdImpl(context.getApplicationContext());
        a.e = "i";
    }

    private void a()
    {
        if (isAdAvailable())
        {
            MMLog.b("MMInterstitial", "Ad already fetched and ready for display...");
            MMSDK.Event.a(a, new MMException(17));
            return;
        } else
        {
            MMLog.b("MMInterstitial", "Fetching new ad...");
            a.f();
            return;
        }
    }

    private int b()
    {
        MMAdImpl mmadimpl;
        CachedAd cachedad;
        MMAdImplController.a(a);
        if (a.h == null)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        mmadimpl = a;
        cachedad = AdCache.c(mmadimpl.i(), mmadimpl.j());
        if (cachedad == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if (!cachedad.canShow(mmadimpl.i(), mmadimpl, true))
        {
            break MISSING_BLOCK_LABEL_99;
        }
        MMSDK.Event.c(mmadimpl);
        AdCache.a(mmadimpl.i(), mmadimpl.j(), null);
        cachedad.show(mmadimpl.i(), mmadimpl.f);
        HandShake.a(mmadimpl.i()).a(mmadimpl.i(), mmadimpl.e);
        return 0;
        int i = MMAdImplController.a(mmadimpl, cachedad);
        return i;
        return 20;
        Exception exception;
        exception;
        MMLog.a("MMInterstitial", "There was an exception displaying a cached ad. ", exception);
        exception.printStackTrace();
        return 100;
    }

    public final boolean display()
    {
        return display(false);
    }

    public final boolean display(boolean flag)
    {
        if (MMSDK.a()) goto _L2; else goto _L1
_L1:
        MMLog.e("MMInterstitial", MMException.getErrorCodeMessage(3));
_L4:
        return false;
_L2:
        int i = b();
        if (i == 0 || !flag)
        {
            continue; /* Loop/switch isn't completed */
        }
        throw new MMException(i);
        Exception exception;
        exception;
        if (!flag) goto _L4; else goto _L3
_L3:
        throw new MMException(exception);
        if (i != 0) goto _L4; else goto _L5
_L5:
        return true;
    }

    public final void fetch()
    {
        if (a != null && a.b != null)
        {
            fetch(a.a, a.b);
            return;
        } else
        {
            a();
            return;
        }
    }

    public final void fetch(MMRequest mmrequest)
    {
        if (a != null && a.b != null)
        {
            fetch(mmrequest, a.b);
            return;
        } else
        {
            a();
            return;
        }
    }

    public final void fetch(MMRequest mmrequest, RequestListener requestlistener)
    {
        if (a != null)
        {
            a.a = mmrequest;
            a.b = requestlistener;
        }
        a();
    }

    public final String getApid()
    {
        return a.getApid();
    }

    public final boolean getIgnoresDensityScaling()
    {
        return a.getIgnoresDensityScaling();
    }

    public final RequestListener getListener()
    {
        return a.getListener();
    }

    public final MMRequest getMMRequest()
    {
        return a.getMMRequest();
    }

    public final boolean isAdAvailable()
    {
        if (MMSDK.a()) goto _L2; else goto _L1
_L1:
        MMLog.e("MMInterstitial", MMException.getErrorCodeMessage(3));
_L4:
        return false;
_L2:
        MMAdImplController.a(a);
        if (a.h == null) goto _L4; else goto _L3
_L3:
        MMAdImpl mmadimpl;
        CachedAd cachedad;
        mmadimpl = a;
        cachedad = AdCache.c(mmadimpl.i(), mmadimpl.j());
        if (cachedad == null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        int i;
        if (cachedad.canShow(mmadimpl.i(), mmadimpl, true))
        {
            i = 0;
        } else
        {
            try
            {
                i = MMAdImplController.a(mmadimpl, cachedad);
            }
            catch (Exception exception)
            {
                MMLog.a("MMInterstitial", "There was an exception checking for a cached ad. ", exception);
                exception.printStackTrace();
                return false;
            }
        }
        continue; /* Loop/switch isn't completed */
        MMLog.c("MMAdImplController", "No next ad.");
        i = 20;
        if (i != 0) goto _L4; else goto _L5
_L5:
        return true;
    }

    public final void setApid(String s)
    {
        a.setApid(s);
    }

    public final void setIgnoresDensityScaling(boolean flag)
    {
        a.setIgnoresDensityScaling(flag);
    }

    public final void setListener(RequestListener requestlistener)
    {
        a.setListener(requestlistener);
    }

    public final void setMMRequest(MMRequest mmrequest)
    {
        a.setMMRequest(mmrequest);
    }

    private class MMInterstitialAdImpl extends MMAdImpl
    {

        private MMInterstitial k;

        final volatile MMAd d()
        {
            return k;
        }

        public MMInterstitialAdImpl(Context context)
        {
            k = MMInterstitial.this;
            super(context);
        }
    }

}
