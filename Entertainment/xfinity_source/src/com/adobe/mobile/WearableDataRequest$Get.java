// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import com.google.android.gms.wearable.DataMap;

// Referenced classes of package com.adobe.mobile:
//            WearableDataRequest, RequestHandler

static class url extends WearableDataRequest
{

    protected static final String logPrefix = "Wearable GET Requested Forward";
    protected String url;

    protected DataMap getDataMap()
    {
        DataMap datamap = new DataMap();
        datamap.putString("ID", uuid);
        datamap.putInt("Timeout", timeOut);
        datamap.putString("Type", "GET");
        datamap.putString("URL", url);
        return datamap;
    }

    protected String getURL()
    {
        return url;
    }

    protected DataMap handle(Context context)
    {
        context = new DataMap();
        context.putByteArray("Result", RequestHandler.retrieveData(url, null, timeOut, "Wearable GET Requested Forward"));
        context.putString("ID", uuid);
        context.putString("Type", "GET");
        return context;
    }

    protected (DataMap datamap)
    {
        url = datamap.getString("URL");
        uuid = datamap.getString("ID");
        timeOut = datamap.getInt("Timeout");
    }

    protected etInt(String s, int i)
    {
        super(i);
        url = s;
    }
}
