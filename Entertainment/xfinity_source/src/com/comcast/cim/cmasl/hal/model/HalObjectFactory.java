// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.hal.model;

import com.comcast.cim.cmasl.hal.http.HalHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Referenced classes of package com.comcast.cim.cmasl.hal.model:
//            MicrodataPropertyResolver, HalParseable

public abstract class HalObjectFactory
{

    private static final Logger LOG = LoggerFactory.getLogger(com/comcast/cim/cmasl/hal/model/HalObjectFactory);

    public HalObjectFactory()
    {
    }

    public HalParseable createWithUrl(String s, HalHttpClient halhttpclient)
    {
        HalParseable halparseable = get();
        halparseable.parseHalContent(new MicrodataPropertyResolver(halhttpclient.fetchMicroData(s)));
        return halparseable;
    }

    protected abstract HalParseable get();

}
