// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.local;

import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.net.IHeaders;
import com.google.gson.Gson;
import java.net.URL;

public abstract class BaseEbayNowRequest extends EbayRequest
{

    private final transient String iafToken;
    private final transient boolean isPost;
    private transient URL url;

    protected BaseEbayNowRequest(String s, boolean flag)
    {
        iafToken = s;
        isPost = flag;
        errorLanguage = null;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        if (isPost)
        {
            return defaultRequestMapper.toJson(this).getBytes();
        } else
        {
            return super.buildRequest();
        }
    }

    protected abstract URL formatUrl();

    public URL getRequestUrl()
    {
        if (url == null)
        {
            url = formatUrl();
        }
        return url;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
        super.onAddHeaders(iheaders);
        if (iafToken != null)
        {
            iheaders.setHeader("Authorization", (new StringBuilder()).append("IAF ").append(iafToken).toString());
        }
        iheaders.setHeader("Content-Type", "application/json");
        iheaders.setHeader("accept", "application/json");
    }
}
