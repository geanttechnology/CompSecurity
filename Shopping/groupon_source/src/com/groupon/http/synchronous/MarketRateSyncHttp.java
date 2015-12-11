// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http.synchronous;

import android.content.Context;
import com.groupon.service.marketrate.MarketRateServiceBase;
import java.net.URI;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.http.synchronous:
//            SyncHttp

public class MarketRateSyncHttp extends SyncHttp
{

    public MarketRateSyncHttp(Context context, Class class1, String s)
    {
        super(context, class1, s);
    }

    public transient MarketRateSyncHttp(Context context, Class class1, String s, Object aobj[])
    {
        super(context, class1, s, aobj);
    }

    public URI getURI()
        throws Exception
    {
        MarketRateServiceBase marketrateservicebase = (MarketRateServiceBase)RoboGuice.getInjector(context).getInstance(com/groupon/service/marketrate/MarketRateServiceBase);
        if (parsedUri != null) goto _L2; else goto _L1
_L1:
        String s = uri;
        if (s != null) goto _L4; else goto _L3
_L3:
        Object obj = marketrateservicebase.getCurrentBaseUrl();
_L6:
        obj = new URI(((String) (obj)));
        if (!Strings.equals(method, "GET") && !Strings.equals("https", ((URI) (obj)).getScheme()))
        {
            obj = new URI("https", ((URI) (obj)).getUserInfo(), ((URI) (obj)).getHost(), ((URI) (obj)).getPort(), ((URI) (obj)).getPath(), ((URI) (obj)).getQuery(), ((URI) (obj)).getFragment());
        }
        Ln.d((new StringBuilder()).append("Using MarketRate Uri: ").append(Strings.toString(obj)).toString(), new Object[0]);
        parsedUri = ((URI) (obj));
_L2:
        return parsedUri;
_L4:
        obj = s;
        if (s.startsWith("/"))
        {
            obj = (new StringBuilder()).append(marketrateservicebase.getCurrentBaseUrl()).append(s).toString();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
