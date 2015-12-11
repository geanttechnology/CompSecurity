// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.handler;

import java.net.MalformedURLException;
import tv.freewheel.hybrid.ad.EventCallback;

// Referenced classes of package tv.freewheel.hybrid.ad.handler:
//            EventCallbackHandler

public class ResellerNoAdCallbackHandler extends EventCallbackHandler
{

    private boolean imprSent;

    public ResellerNoAdCallbackHandler(EventCallback eventcallback)
        throws MalformedURLException
    {
        super(eventcallback);
        imprSent = false;
        setParameter("et", "i");
        setParameter("cn", "resellerNoAd");
    }

    public void send()
    {
        if (imprSent)
        {
            return;
        } else
        {
            imprSent = true;
            super.send();
            return;
        }
    }
}
