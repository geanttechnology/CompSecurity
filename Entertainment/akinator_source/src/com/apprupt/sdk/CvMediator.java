// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import android.content.Context;
import com.apprupt.sdk.mediation.AdWrapper;
import com.apprupt.sdk.mediation.Adapter;
import com.apprupt.sdk.mediation.Mediator;
import com.apprupt.sdk.mediation.ValueExchangeCompletion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.apprupt.sdk:
//            Logger, CvContentOptions, CvViewHelper

public class CvMediator
    implements Mediator
{
    public static interface Completion
    {

        public abstract void onFailure(String s);

        public abstract void onSuccess(AdWrapper adwrapper);
    }


    private final HashMap adapters = new HashMap();
    private volatile boolean canceled;
    private final Completion completion;
    private final CvContentOptions contentOptions;
    private final Context context;
    private boolean fallbackLoading;
    private final com.apprupt.sdk.mediation.AdWrapper.Listener listener;
    private final Logger.log llog = Logger.get("Lifecycle.Mediator");
    private volatile boolean loading;
    private final Logger.log log = Logger.get("Mediator");
    private final ArrayList order = new ArrayList();

    CvMediator(Context context1, CvContentOptions cvcontentoptions, Completion completion1, com.apprupt.sdk.mediation.AdWrapper.Listener listener1)
    {
        canceled = false;
        loading = false;
        fallbackLoading = false;
        context = context1;
        contentOptions = cvcontentoptions;
        completion = completion1;
        listener = listener1;
    }

    private void next()
    {
        Adapter adapter;
        if (isCanceled())
        {
            return;
        }
_L3:
        if (order.size() > 0)
        {
            adapter = (Adapter)order.remove(0);
            if ((fallbackLoading || adapter.canMediate(this)) && adapter.isReadyToServe(this))
            {
                llog.i(new Object[] {
                    "Loading with adapter", adapter.name()
                });
                if (contentOptions.interstitial)
                {
                    adapter.loadInterstitialAd(this);
                    return;
                } else
                {
                    adapter.loadInlineAd(this);
                    return;
                }
            }
        } else
        {
            llog.e(new Object[] {
                "Cannot load ad (no more adapters)."
            });
            completion.onFailure("Cannot load ad");
            return;
        }
        if (true) goto _L2; else goto _L1
_L2:
        llog.w(new Object[] {
            "Adapter not ready for mediation", adapter.name()
        });
        fallbackLoading = false;
        if (true) goto _L3; else goto _L1
_L1:
    }

    public void adDidFinishLoading(AdWrapper adwrapper)
    {
        llog.i(new Object[] {
            "Ad loaded with", adwrapper.getAdapter().name()
        });
        if (!isCanceled())
        {
            completion.onSuccess(adwrapper);
        }
    }

    public void adFailedToLoad(AdWrapper adwrapper)
    {
        if (adwrapper.shouldRunFallback())
        {
            adwrapper = adwrapper.getFallbackToIdentifier();
            if (adwrapper != null)
            {
                if (adapters.containsKey(adwrapper))
                {
                    fallbackLoading = true;
                    order.add(0, adapters.get(adwrapper));
                } else
                {
                    log.w(new Object[] {
                        "Got fallback of type", adwrapper, "but cannot find such adapter!"
                    });
                }
            }
        }
        next();
    }

    public void cancel()
    {
        this;
        JVM INSTR monitorenter ;
        canceled = true;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public String getAdSpaceId()
    {
        return contentOptions.adSpaceId;
    }

    CvContentOptions getContentOptions()
    {
        return contentOptions;
    }

    public Context getContext()
    {
        return context;
    }

    public com.apprupt.sdk.mediation.AdWrapper.Listener getListener()
    {
        return listener;
    }

    public ValueExchangeCompletion getValueExchangeCompletion()
    {
        return new _cls2();
    }

    public boolean isCanceled()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = canceled;
        this;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isSpaceHardwareAccelerated()
    {
        return getContentOptions().hardwareAcceleration;
    }

    public boolean isValueExchangeRequest()
    {
        return contentOptions.valueExchange;
    }

    void load(HashMap hashmap, List list)
    {
        adapters.putAll(hashmap);
        order.addAll(list);
        next();
    }

    void preloadedAd(AdWrapper adwrapper)
    {
        adwrapper.setMediator(this);
        CvViewHelper.runOnUIThread(new _cls1(adwrapper));
    }

    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls1 {}

}
