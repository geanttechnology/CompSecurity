// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.cloudfront;

import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.framework.network.cloudfront:
//            CloudFrontOperation, CloudFrontConfig

public class GetUpdateConfigOperation extends CloudFrontOperation
{

    private final String CONFIG_PATH = "photos/update.json";

    public GetUpdateConfigOperation(CloudFrontConfig cloudfrontconfig, HttpFactory httpfactory)
        throws InvalidParameterException
    {
        super(cloudfrontconfig, httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.GetUpdateConfig);
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    public JSONObject buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return jsonobject;
    }

    protected String getConfigPath()
    {
        return "photos/update.json";
    }
}
