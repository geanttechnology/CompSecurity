// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.Context;
import atz;
import java.util.HashMap;

// Referenced classes of package com.adobe.mobile:
//            RequestHandler

class postType extends postType
{

    protected static final String logPrefix = "Wearable Third Party Request Forward";
    protected String postType;

    protected atz getDataMap()
    {
        atz atz1 = super.postType();
        atz1.a("Type", "ThirdParty");
        atz1.a("PostType", postType);
        return atz1;
    }

    protected atz handle(Context context)
    {
        atz atz1 = new atz();
        HashMap hashmap = new HashMap();
        hashmap.put("Accept-Language", getDefaultAcceptLanguage(context));
        hashmap.put("User-Agent", getDefaultUserAgent(context));
        atz1.a("Result", RequestHandler.sendThirdPartyRequest(url, body, hashmap, timeOut, postType, "Wearable Third Party Request Forward"));
        atz1.a("ID", uuid);
        atz1.a("Type", "ThirdParty");
        return atz1;
    }

    protected (atz atz1)
    {
        super(atz1);
        postType = atz1.f("PostType");
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
