// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.http.synchronous;

import android.content.Context;
import com.groupon.service.gdt.GdtService;
import java.net.URI;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.http.synchronous:
//            SyncHttp

public class GdtSyncHttp extends SyncHttp
{

    public transient GdtSyncHttp(Context context, Class class1, String s, Object aobj[])
    {
        super(context, class1, s, aobj);
    }

    public URI getURI()
        throws Exception
    {
        GdtService gdtservice = (GdtService)RoboGuice.getInjector(context).getInstance(com/groupon/service/gdt/GdtService);
        if (parsedUri != null) goto _L2; else goto _L1
_L1:
        String s = uri;
        if (s != null) goto _L4; else goto _L3
_L3:
        Object obj = gdtservice.getCurrentBaseUrl();
_L6:
        obj = new URI(((String) (obj)));
        if (method != "GET" && !"https".equalsIgnoreCase(((URI) (obj)).getScheme()))
        {
            obj = new URI("https", ((URI) (obj)).getUserInfo(), ((URI) (obj)).getHost(), ((URI) (obj)).getPort(), ((URI) (obj)).getPath(), ((URI) (obj)).getQuery(), ((URI) (obj)).getFragment());
        }
        Ln.d((new StringBuilder()).append("Using GDT Uri: ").append(Strings.toString(obj)).toString(), new Object[0]);
        parsedUri = ((URI) (obj));
_L2:
        return parsedUri;
_L4:
        obj = s;
        if (s.startsWith("/"))
        {
            obj = (new StringBuilder()).append(gdtservice.getCurrentBaseUrl()).append(s).toString();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }
}
