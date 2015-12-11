// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.http;

import com.comcast.cim.cmasl.utils.provider.Provider;

// Referenced classes of package com.comcast.cim.cmasl.hal.http:
//            HalHttpClient, HalResponseHandler

class val.halSource
    implements Provider
{

    final HalHttpClient this$0;
    final String val$halSource;

    public HalResponseHandler get()
    {
        return new HalResponseHandler(HalHttpClient.access$000(HalHttpClient.this), val$halSource);
    }

    public volatile Object get()
    {
        return get();
    }

    er()
    {
        this$0 = final_halhttpclient;
        val$halSource = String.this;
        super();
    }
}
