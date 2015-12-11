// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad.handler;

import java.net.MalformedURLException;
import tv.freewheel.ad.EventCallback;

// Referenced classes of package tv.freewheel.ad.handler:
//            EventCallbackHandler

public class StandardCallbackHandler extends EventCallbackHandler
{

    public StandardCallbackHandler(EventCallback eventcallback)
        throws MalformedURLException
    {
        super(eventcallback);
        setParameter("et", "s");
    }

    public void send()
    {
        super.send();
        sendTrackingCallback();
    }
}
