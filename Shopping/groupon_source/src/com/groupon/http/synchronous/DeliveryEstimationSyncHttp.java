// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http.synchronous;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import java.net.URI;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.http.synchronous:
//            SyncHttp

public class DeliveryEstimationSyncHttp extends SyncHttp
{

    public static final String BASE_URL_DELIVERY_ESTIMATES = "base_url_delivery_estimates";
    protected Application application;
    private SharedPreferences prefs;

    public DeliveryEstimationSyncHttp(Context context, Class class1, String s)
    {
        super(context, class1, s);
    }

    public URI getURI()
        throws Exception
    {
        if (parsedUri != null) goto _L2; else goto _L1
_L1:
        String s = uri;
        if (s != null) goto _L4; else goto _L3
_L3:
        Object obj = prefs.getString("base_url_delivery_estimates", application.getString(0x7f0804c0));
_L6:
        obj = new URI(((String) (obj)));
        if (!Strings.equals(method, "GET") && !Strings.equals("https", ((URI) (obj)).getScheme()))
        {
            obj = new URI("https", ((URI) (obj)).getUserInfo(), ((URI) (obj)).getHost(), ((URI) (obj)).getPort(), ((URI) (obj)).getPath(), ((URI) (obj)).getQuery(), ((URI) (obj)).getFragment());
        }
        parsedUri = ((URI) (obj));
_L2:
        return parsedUri;
_L4:
        obj = s;
        if (s.startsWith("/"))
        {
            obj = (new StringBuilder()).append(prefs.getString("base_url_delivery_estimates", application.getString(0x7f0804c0))).append(s).toString();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
