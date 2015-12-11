// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.intentsoftware.addapptr.ad;

import android.app.Activity;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import com.intentsoftware.addapptr.FallbackAdDismissListener;
import com.intentsoftware.addapptr.PlacementSize;
import com.intentsoftware.addapptr.module.LocationUtils;
import com.intentsoftware.addapptr.module.Logger;

// Referenced classes of package com.intentsoftware.addapptr.ad:
//            AdInteractionListener, AdLoadListener

public abstract class Ad
{

    private Activity activity;
    private String adId;
    private FallbackAdDismissListener fallbackDismissListener;
    private Handler handler;
    private AdInteractionListener interactionListener;
    private AdLoadListener loadListener;
    private boolean loading;

    public Ad()
    {
        handler = new Handler(Looper.getMainLooper());
    }

    protected void fallbackNotifyListenerThatAdWasDismissed()
    {
        handler.post(new _cls7());
    }

    protected Activity getActivity()
    {
        return activity;
    }

    protected String getAdId()
    {
        return adId;
    }

    public Location getLocation()
    {
        return LocationUtils.getLocation();
    }

    public void load(Activity activity1, String s, PlacementSize placementsize)
    {
        activity = activity1;
        adId = s;
        loading = true;
    }

    protected void notifyListenerThatAdFailedToLoad(String s)
    {
        if (loading)
        {
            loading = false;
            handler.post(new _cls3(s));
        } else
        if (Logger.isLoggable(5))
        {
            Logger.w(this, String.format("Redundant 'failed to load ad' notification from %s.", new Object[] {
                getClass().getSimpleName()
            }));
            return;
        }
    }

    protected void notifyListenerThatAdIsShown()
    {
        handler.post(new _cls5());
    }

    protected void notifyListenerThatAdWasClicked()
    {
        handler.post(new _cls4());
    }

    protected void notifyListenerThatAdWasLoaded()
    {
        if (loading)
        {
            loading = false;
            handler.post(new _cls1());
        } else
        if (Logger.isLoggable(5))
        {
            Logger.w(this, String.format("Redundant 'ad loaded' notification from %s.", new Object[] {
                getClass().getSimpleName()
            }));
            return;
        }
    }

    protected void notifyListenerThatShowingEmpty()
    {
        handler.post(new _cls2());
    }

    protected void notifyListenerThatUserEarnedIncentive()
    {
        handler.post(new _cls6());
    }

    public void pause()
    {
    }

    public void resume(Activity activity1)
    {
        activity = activity1;
    }

    public void setFallbackDismissListener(FallbackAdDismissListener fallbackaddismisslistener)
    {
        fallbackDismissListener = fallbackaddismisslistener;
    }

    public void setInteractionListener(AdInteractionListener adinteractionlistener)
    {
        interactionListener = adinteractionlistener;
    }

    public void setLoadListener(AdLoadListener adloadlistener)
    {
        loadListener = adloadlistener;
    }

    public abstract void unload();




    /* member class not found */
    class _cls7 {}


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls5 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls6 {}

}
