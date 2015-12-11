// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.handler;

import android.os.Bundle;
import java.net.MalformedURLException;
import tv.freewheel.hybrid.ad.EventCallback;

// Referenced classes of package tv.freewheel.hybrid.ad.handler:
//            EventCallbackHandler

public class QuartileCallbackHandler extends EventCallbackHandler
{

    public boolean imprSent;

    public QuartileCallbackHandler(EventCallback eventcallback)
        throws MalformedURLException
    {
        super(eventcallback);
        imprSent = false;
        setParameter("et", "i");
    }

    public void send(Bundle bundle)
    {
        if (imprSent)
        {
            return;
        } else
        {
            imprSent = true;
            long l = bundle.getLong("ct");
            int i = bundle.getInt("metr");
            setParameter("ct", String.valueOf(l));
            setParameter("metr", String.valueOf(i));
            send();
            sendTrackingCallback();
            return;
        }
    }
}
