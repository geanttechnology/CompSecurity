// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.handler;

import java.net.MalformedURLException;
import tv.freewheel.ad.EventCallback;

// Referenced classes of package tv.freewheel.ad.handler:
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
