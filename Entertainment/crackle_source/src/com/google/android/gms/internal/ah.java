// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;

// Referenced classes of package com.google.android.gms.internal:
//            ba, x, u, t, 
//            ac, z, v, af, 
//            ct

public final class ah
{

    private AppEventListener eI;
    private String eK;
    private final ba eW = new ba();
    private ac eX;
    private AdListener ev;
    private final Context mContext;

    public ah(Context context)
    {
        mContext = context;
    }

    private void j(String s)
        throws RemoteException
    {
        if (eK == null)
        {
            k(s);
        }
        eX = u.a(mContext, new x(), eK, eW);
        if (ev != null)
        {
            eX.a(new t(ev));
        }
        if (eI != null)
        {
            eX.a(new z(eI));
        }
    }

    private void k(String s)
    {
        if (eX == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("The ad unit ID must be set on InterstitialAd before ").append(s).append(" is called.").toString());
        } else
        {
            return;
        }
    }

    public void a(af af1)
    {
        try
        {
            if (eX == null)
            {
                j("loadAd");
            }
            if (eX.a(new v(mContext, af1)))
            {
                eW.c(af1.R());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (af af1)
        {
            ct.b("Failed to load ad.", af1);
        }
    }

    public AdListener getAdListener()
    {
        return ev;
    }

    public String getAdUnitId()
    {
        return eK;
    }

    public AppEventListener getAppEventListener()
    {
        return eI;
    }

    public boolean isLoaded()
    {
        if (eX == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = eX.isReady();
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Failed to check if ad is ready.", remoteexception);
            return false;
        }
        return flag;
    }

    public void setAdListener(AdListener adlistener)
    {
        ev = adlistener;
        if (eX == null) goto _L2; else goto _L1
_L1:
        ac ac1 = eX;
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        adlistener = new t(adlistener);
_L3:
        ac1.a(adlistener);
_L2:
        return;
        adlistener = null;
          goto _L3
        adlistener;
        ct.b("Failed to set the AdListener.", adlistener);
        return;
    }

    public void setAdUnitId(String s)
    {
        if (eK != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        } else
        {
            eK = s;
            return;
        }
    }

    public void setAppEventListener(AppEventListener appeventlistener)
    {
        eI = appeventlistener;
        if (eX == null) goto _L2; else goto _L1
_L1:
        ac ac1 = eX;
        if (appeventlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        appeventlistener = new z(appeventlistener);
_L3:
        ac1.a(appeventlistener);
_L2:
        return;
        appeventlistener = null;
          goto _L3
        appeventlistener;
        ct.b("Failed to set the AppEventListener.", appeventlistener);
        return;
    }

    public void show()
    {
        try
        {
            k("show");
            eX.showInterstitial();
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Failed to show interstitial.", remoteexception);
        }
    }
}
