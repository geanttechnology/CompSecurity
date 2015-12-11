// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import atz;

// Referenced classes of package com.adobe.mobile:
//            WearableDataRequest, RequestHandler

class url extends WearableDataRequest
{

    protected static final String logPrefix = "Wearable GET Requested Forward";
    protected String url;

    protected atz getDataMap()
    {
        atz atz1 = new atz();
        atz1.a("ID", uuid);
        atz1.a("Timeout", timeOut);
        atz1.a("Type", "GET");
        atz1.a("URL", url);
        return atz1;
    }

    protected String getURL()
    {
        return url;
    }

    protected atz handle(Context context)
    {
        context = new atz();
        context.a("Result", RequestHandler.retrieveData(url, null, timeOut, "Wearable GET Requested Forward"));
        context.a("ID", uuid);
        context.a("Type", "GET");
        return context;
    }

    protected (atz atz1)
    {
        url = atz1.f("URL");
        uuid = atz1.f("ID");
        timeOut = atz1.d("Timeout");
    }

    protected timeOut(String s, int i)
    {
        super(i);
        url = s;
    }
}
