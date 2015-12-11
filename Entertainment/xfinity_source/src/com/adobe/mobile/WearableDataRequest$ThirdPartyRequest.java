// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import com.google.android.gms.wearable.DataMap;
import java.util.HashMap;

// Referenced classes of package com.adobe.mobile:
//            WearableDataRequest, RequestHandler

static class postType extends postType
{

    protected static final String logPrefix = "Wearable Third Party Request Forward";
    protected String postType;

    protected DataMap getDataMap()
    {
        DataMap datamap = super.postType();
        datamap.putString("Type", "ThirdParty");
        datamap.putString("PostType", postType);
        return datamap;
    }

    protected DataMap handle(Context context)
    {
        DataMap datamap = new DataMap();
        HashMap hashmap = new HashMap();
        hashmap.put("Accept-Language", getDefaultAcceptLanguage(context));
        hashmap.put("User-Agent", getDefaultUserAgent(context));
        datamap.putBoolean("Result", RequestHandler.sendThirdPartyRequest(url, body, hashmap, timeOut, postType, "Wearable Third Party Request Forward"));
        datamap.putString("ID", uuid);
        datamap.putString("Type", "ThirdParty");
        return datamap;
    }

    protected (DataMap datamap)
    {
        super(datamap);
        postType = datamap.getString("PostType");
    }

    protected postType(String s, String s1, int i)
    {
        super(s, s1, i);
    }

    protected postType(String s, String s1, int i, String s2)
    {
        this(s, s1, i);
        postType = s2;
    }
}
