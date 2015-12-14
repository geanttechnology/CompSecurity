// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.cloudfront;

import android.net.Uri;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpGetMessage;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import java.net.URI;

// Referenced classes of package com.amazon.gallery.framework.network.cloudfront:
//            CloudFrontConfig

public abstract class CloudFrontOperation extends AbstractHttpGetMessage
{

    protected Uri cloudFrontUri;

    public CloudFrontOperation(CloudFrontConfig cloudfrontconfig, HttpFactory httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent metricsevent)
        throws InvalidParameterException
    {
        super(httpfactory, metricsevent);
        cloudFrontUri = cloudfrontconfig.getCloudFrontURI(getConfigPath());
        endpoint = new Endpoint(cloudFrontUri);
    }

    protected abstract String getConfigPath();

    protected URI getURI(String s)
    {
        return URI.create(cloudFrontUri.toString());
    }
}
