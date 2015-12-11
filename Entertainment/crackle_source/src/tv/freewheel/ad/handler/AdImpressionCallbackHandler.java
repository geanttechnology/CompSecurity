// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.handler;

import android.os.Bundle;
import java.net.MalformedURLException;
import tv.freewheel.ad.AdInstance;
import tv.freewheel.ad.EventCallback;
import tv.freewheel.ad.slot.Slot;

// Referenced classes of package tv.freewheel.ad.handler:
//            EventCallbackHandler

public class AdImpressionCallbackHandler extends EventCallbackHandler
{

    private boolean endImpressionSent;

    public AdImpressionCallbackHandler(EventCallback eventcallback)
        throws MalformedURLException
    {
        super(eventcallback);
        endImpressionSent = false;
    }

    public void send(Bundle bundle)
    {
        boolean flag = bundle.getBoolean("endAck");
        setParameter("metr", String.valueOf(bundle.getInt("metr")));
        if (flag)
        {
            if (adInstance.slot.getType() != 0)
            {
                return;
            }
            setParameter("init", "0");
            setParameter("last", "1");
            setParameter("ct", String.valueOf(bundle.getLong("ct")));
        } else
        {
            setParameter("init", "1");
            if (adInstance.slot.getType() == 0)
            {
                setParameter("last", "0");
                setParameter("ct", String.valueOf(bundle.getLong("ct")));
            } else
            {
                setParameter("last", "1");
            }
        }
        if (adInstance.imprSent && !adInstance.slot.isPauseMidroll() && !adInstance.isCompanionAdOfPauseAd)
        {
            if (!flag || endImpressionSent)
            {
                setParameter("init", "2");
            }
        } else
        if (!flag)
        {
            sendTrackingCallback();
            adInstance.imprSent = true;
        }
        send();
        if (flag)
        {
            endImpressionSent = true;
            adInstance.dispatchAdEvent("adEnd");
            return;
        } else
        {
            adInstance.dispatchAdEvent("defaultImpression");
            return;
        }
    }
}
