// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.handler;

import android.net.Uri;
import android.os.Bundle;
import java.net.MalformedURLException;
import tv.freewheel.hybrid.ad.AdInstance;
import tv.freewheel.hybrid.ad.EventCallback;

// Referenced classes of package tv.freewheel.hybrid.ad.handler:
//            EventCallbackHandler

public class ErrorCallbackHandler extends EventCallbackHandler
{

    public ErrorCallbackHandler(EventCallback eventcallback)
        throws MalformedURLException
    {
        super(eventcallback);
        setParameter("et", "e");
    }

    public void send(Bundle bundle)
    {
        String s = bundle.getString("errorCode");
        String s1 = bundle.getString("errorInfo");
        bundle = bundle.getString("errorModule");
        bundle = (new StringBuilder()).append(Uri.encode("renderer")).append("=").append(Uri.encode(bundle)).toString();
        bundle = (new StringBuilder()).append(bundle).append("&").append(Uri.encode("additional")).append("=").append(Uri.encode(s1)).toString();
        setParameter("cn", s);
        setParameter("kv", bundle);
        send();
        adInstance.dispatchAdEvent("_e_unknown");
    }
}
