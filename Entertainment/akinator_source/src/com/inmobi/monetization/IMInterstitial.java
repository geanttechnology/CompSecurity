// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inmobi.monetization;

import android.app.Activity;
import com.inmobi.commons.internal.Log;
import com.inmobi.monetization.internal.AdErrorCode;
import com.inmobi.monetization.internal.IMAdListener;
import com.inmobi.monetization.internal.InterstitialAd;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.inmobi.monetization:
//            IMErrorCode, IMInterstitialListener, IMIncentivisedListener

public class IMInterstitial
{

    InterstitialAd a;
    boolean b;
    IMAdListener c;
    private IMInterstitialListener d;
    private IMIncentivisedListener e;
    private long f;
    private Activity g;
    private State h;
    private String i;

    public IMInterstitial(Activity activity, long l)
    {
        f = -1L;
    /* block-local class not found */
    class State {}

        h = State.INIT;
        i = null;
        b = false;
        c = new _cls1();
        g = activity;
        f = l;
        a();
    }

    public IMInterstitial(Activity activity, String s)
    {
        f = -1L;
        h = State.INIT;
        i = null;
        b = false;
        c = new _cls1();
        g = activity;
        i = s;
        a();
    }

    static State a(IMInterstitial iminterstitial, State state)
    {
        iminterstitial.h = state;
        return state;
    }

    static IMInterstitialListener a(IMInterstitial iminterstitial)
    {
        return iminterstitial.d;
    }

    private void a()
    {
        if (f > 0L)
        {
            a = new InterstitialAd(g, f);
        } else
        {
            a = new InterstitialAd(g, i);
        }
        a.setAdListener(c);
    }

    private void a(int j, AdErrorCode aderrorcode, Map map)
    {
        if (d == null)
        {
            return;
        } else
        {
            g.runOnUiThread(new _cls2(j, aderrorcode, map));
            return;
        }
    }

    static void a(IMInterstitial iminterstitial, int j, AdErrorCode aderrorcode, Map map)
    {
        iminterstitial.a(j, aderrorcode, map);
    }

    static IMIncentivisedListener b(IMInterstitial iminterstitial)
    {
        return iminterstitial.e;
    }

    public void destroy()
    {
    }

    public void disableHardwareAcceleration()
    {
        b = true;
    }

    public State getState()
    {
        return h;
    }

    public void loadInterstitial()
    {
        if (a != null)
        {
            if (h == State.LOADING)
            {
                IMErrorCode imerrorcode = IMErrorCode.INVALID_REQUEST;
                imerrorcode.setMessage("Ad download in progress. Your request cannot be processed at this time. Try again later.");
                Log.debug("[InMobi]-[Monetization]", "Ad download in progress. Your request cannot be processed at this time. Try again later.");
                d.onInterstitialFailed(this, imerrorcode);
                return;
            }
            if (h == State.ACTIVE)
            {
                IMErrorCode imerrorcode1 = IMErrorCode.INVALID_REQUEST;
                imerrorcode1.setMessage("Interstitial ad is in ACTIVE state. Try again after sometime.");
                Log.debug("[InMobi]-[Monetization]", "Interstitial ad is in ACTIVE state. Try again after sometime.");
                d.onInterstitialFailed(this, imerrorcode1);
                return;
            } else
            {
                h = State.LOADING;
                a.loadAd();
                return;
            }
        } else
        {
            IMErrorCode imerrorcode2 = IMErrorCode.INVALID_REQUEST;
            Log.debug("[InMobi]-[Monetization]", "Interstitial ad is in ACTIVE state. Try again after sometime.");
            d.onInterstitialFailed(this, imerrorcode2);
            return;
        }
    }

    public void setAppId(String s)
    {
        if (a != null)
        {
            a.setAppId(s);
        }
    }

    public void setIMIncentivisedListener(IMIncentivisedListener imincentivisedlistener)
    {
        e = imincentivisedlistener;
    }

    public void setIMInterstitialListener(IMInterstitialListener iminterstitiallistener)
    {
        d = iminterstitiallistener;
    }

    public void setKeywords(String s)
    {
        if (s == null || "".equals(s.trim()))
        {
            Log.debug("[InMobi]-[Monetization]", "Keywords cannot be null or blank.");
        } else
        if (a != null)
        {
            a.setKeywords(s);
            return;
        }
    }

    public void setRefTagParam(String s, String s1)
    {
        if (s == null || s1 == null)
        {
            Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be null");
        } else
        {
            if (s.trim().equals("") || s1.trim().equals(""))
            {
                Log.debug("[InMobi]-[Monetization]", "Key or Value cannot be empty");
                return;
            }
            HashMap hashmap = new HashMap();
            hashmap.put(s, s1);
            if (a != null)
            {
                a.setRequestParams(hashmap);
                return;
            }
        }
    }

    public void setRequestParams(Map map)
    {
        if (map == null || map.isEmpty())
        {
            Log.debug("[InMobi]-[Monetization]", "Request params cannot be null or empty.");
        } else
        if (a != null)
        {
            a.setRequestParams(map);
            return;
        }
    }

    public void setSlotId(long l)
    {
        if (a != null)
        {
            a.setSlotId(l);
        }
    }

    public void show()
    {
        if (a != null && h == State.READY)
        {
            a.show();
            return;
        } else
        {
            Log.debug("[InMobi]-[Monetization]", (new StringBuilder()).append("Interstitial ad is not in the 'READY' state. Current state: ").append(h).toString());
            return;
        }
    }

    public void show(long l)
    {
        if (a != null)
        {
            a.show(l);
        }
    }

    public void stopLoading()
    {
        if (a != null)
        {
            a.stopLoading();
        }
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
