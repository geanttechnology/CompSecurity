// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.dynamic.c;

// Referenced classes of package com.google.android.gms.internal:
//            ba, aa, x, cs, 
//            ac, ct, u, t, 
//            z, v, af

public final class ag
{

    private AppEventListener eI;
    private AdSize eJ[];
    private String eK;
    private final ba eW;
    private ac eX;
    private ViewGroup eY;
    private AdListener ev;

    public ag(ViewGroup viewgroup)
    {
        eW = new ba();
        eY = viewgroup;
    }

    public ag(ViewGroup viewgroup, AttributeSet attributeset, boolean flag)
    {
        eW = new ba();
        eY = viewgroup;
        android.content.Context context = viewgroup.getContext();
        try
        {
            attributeset = new aa(context, attributeset);
            eJ = attributeset.c(flag);
            eK = attributeset.getAdUnitId();
        }
        // Misplaced declaration of an exception variable
        catch (AttributeSet attributeset)
        {
            cs.a(viewgroup, new x(context, AdSize.BANNER), attributeset.getMessage(), attributeset.getMessage());
            return;
        }
        if (viewgroup.isInEditMode())
        {
            cs.a(viewgroup, new x(context, eJ[0]), "Ads by Google");
        }
    }

    private void T()
    {
        com.google.android.gms.dynamic.b b = eX.x();
        if (b == null)
        {
            return;
        }
        try
        {
            eY.addView((View)c.b(b));
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Failed to get an ad frame.", remoteexception);
        }
        return;
    }

    private void U()
        throws RemoteException
    {
        if ((eJ == null || eK == null) && eX == null)
        {
            throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
        }
        android.content.Context context = eY.getContext();
        eX = u.a(context, new x(context, eJ), eK, eW);
        if (ev != null)
        {
            eX.a(new t(ev));
        }
        if (eI != null)
        {
            eX.a(new z(eI));
        }
        T();
    }

    public void a(af af1)
    {
        try
        {
            if (eX == null)
            {
                U();
            }
            if (eX.a(new v(eY.getContext(), af1)))
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

    public transient void a(AdSize aadsize[])
    {
        eJ = aadsize;
        try
        {
            if (eX != null)
            {
                eX.a(new x(eY.getContext(), eJ));
            }
        }
        // Misplaced declaration of an exception variable
        catch (AdSize aadsize[])
        {
            ct.b("Failed to set the ad size.", aadsize);
        }
        eY.requestLayout();
    }

    public void destroy()
    {
        try
        {
            if (eX != null)
            {
                eX.destroy();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Failed to destroy AdView.", remoteexception);
        }
    }

    public AdListener getAdListener()
    {
        return ev;
    }

    public AdSize getAdSize()
    {
        AdSize adsize;
        if (eX == null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        adsize = eX.y().P();
        return adsize;
        RemoteException remoteexception;
        remoteexception;
        ct.b("Failed to get the current AdSize.", remoteexception);
        if (eJ != null)
        {
            return eJ[0];
        } else
        {
            return null;
        }
    }

    public AdSize[] getAdSizes()
    {
        return eJ;
    }

    public String getAdUnitId()
    {
        return eK;
    }

    public AppEventListener getAppEventListener()
    {
        return eI;
    }

    public void pause()
    {
        try
        {
            if (eX != null)
            {
                eX.pause();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Failed to call pause.", remoteexception);
        }
    }

    public void recordManualImpression()
    {
        try
        {
            eX.H();
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Failed to record impression.", remoteexception);
        }
    }

    public void resume()
    {
        try
        {
            if (eX != null)
            {
                eX.resume();
            }
            return;
        }
        catch (RemoteException remoteexception)
        {
            ct.b("Failed to call resume.", remoteexception);
        }
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

    public transient void setAdSizes(AdSize aadsize[])
    {
        if (eJ != null)
        {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        } else
        {
            a(aadsize);
            return;
        }
    }

    public void setAdUnitId(String s)
    {
        if (eK != null)
        {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
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
}
