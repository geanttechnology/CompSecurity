// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.AppEventListener;

// Referenced classes of package com.google.android.gms.internal:
//            be, ab, y, x, 
//            ag, ad, z, aj, 
//            da

public final class al
{

    private final be lF = new be();
    private ag lG;
    private AdListener lc;
    private AppEventListener lq;
    private String ls;
    private final Context mContext;

    public al(Context context)
    {
        mContext = context;
    }

    private void k(String s)
        throws RemoteException
    {
        if (ls == null)
        {
            l(s);
        }
        lG = y.a(mContext, new ab(), ls, lF);
        if (lc != null)
        {
            lG.a(new x(lc));
        }
        if (lq != null)
        {
            lG.a(new ad(lq));
        }
    }

    private void l(String s)
    {
        if (lG == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("The ad unit ID must be set on InterstitialAd before ").append(s).append(" is called.").toString());
        } else
        {
            return;
        }
    }

    public void a(aj aj1)
    {
        try
        {
            if (lG == null)
            {
                k("loadAd");
            }
            if (lG.a(new z(mContext, aj1)))
            {
                lF.c(aj1.ak());
            }
            return;
        }
        // Misplaced declaration of an exception variable
        catch (aj aj1)
        {
            da.b("Failed to load ad.", aj1);
        }
    }

    public AdListener getAdListener()
    {
        return lc;
    }

    public String getAdUnitId()
    {
        return ls;
    }

    public AppEventListener getAppEventListener()
    {
        return lq;
    }

    public boolean isLoaded()
    {
        if (lG == null)
        {
            return false;
        }
        boolean flag;
        try
        {
            flag = lG.isReady();
        }
        catch (RemoteException remoteexception)
        {
            da.b("Failed to check if ad is ready.", remoteexception);
            return false;
        }
        return flag;
    }

    public void setAdListener(AdListener adlistener)
    {
        lc = adlistener;
        if (lG == null) goto _L2; else goto _L1
_L1:
        ag ag1 = lG;
        if (adlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        adlistener = new x(adlistener);
_L3:
        ag1.a(adlistener);
_L2:
        return;
        adlistener = null;
          goto _L3
        adlistener;
        da.b("Failed to set the AdListener.", adlistener);
        return;
    }

    public void setAdUnitId(String s)
    {
        if (ls != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
        } else
        {
            ls = s;
            return;
        }
    }

    public void setAppEventListener(AppEventListener appeventlistener)
    {
        lq = appeventlistener;
        if (lG == null) goto _L2; else goto _L1
_L1:
        ag ag1 = lG;
        if (appeventlistener == null)
        {
            break MISSING_BLOCK_LABEL_38;
        }
        appeventlistener = new ad(appeventlistener);
_L3:
        ag1.a(appeventlistener);
_L2:
        return;
        appeventlistener = null;
          goto _L3
        appeventlistener;
        da.b("Failed to set the AppEventListener.", appeventlistener);
        return;
    }

    public void show()
    {
        try
        {
            l("show");
            lG.showInterstitial();
            return;
        }
        catch (RemoteException remoteexception)
        {
            da.b("Failed to show interstitial.", remoteexception);
        }
    }
}
