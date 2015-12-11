// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.params;

import com.comcast.cim.httpcomponentsandroid.HttpVersion;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.params:
//            HttpAbstractParamBean, HttpProtocolParams

public class HttpProtocolParamBean extends HttpAbstractParamBean
{

    public void setContentCharset(String s)
    {
        HttpProtocolParams.setContentCharset(params, s);
    }

    public void setHttpElementCharset(String s)
    {
        HttpProtocolParams.setHttpElementCharset(params, s);
    }

    public void setUseExpectContinue(boolean flag)
    {
        HttpProtocolParams.setUseExpectContinue(params, flag);
    }

    public void setUserAgent(String s)
    {
        HttpProtocolParams.setUserAgent(params, s);
    }

    public void setVersion(HttpVersion httpversion)
    {
        HttpProtocolParams.setVersion(params, httpversion);
    }
}
