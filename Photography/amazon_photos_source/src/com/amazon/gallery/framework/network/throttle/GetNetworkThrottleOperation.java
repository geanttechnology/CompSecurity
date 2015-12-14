// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.throttle;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontConfig;
import com.amazon.gallery.framework.network.cloudfront.CloudFrontOperation;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.exceptions.TransientException;
import com.amazon.gallery.framework.network.http.rest.http.HttpFactory;
import org.json.JSONException;
import org.json.JSONObject;

public class GetNetworkThrottleOperation extends CloudFrontOperation
{

    private static final String TAG = com/amazon/gallery/framework/network/throttle/GetNetworkThrottleOperation.getName();
    private final String PATH_TO_DELAY = "photos/network/delay.json";
    private final String THROTTLE_DELAY_KEY = "delay";

    public GetNetworkThrottleOperation(CloudFrontConfig cloudfrontconfig, HttpFactory httpfactory)
        throws InvalidParameterException
    {
        super(cloudfrontconfig, httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent.GetNetworkThrottle);
    }

    public Long buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        if (jsonobject != null && jsonobject.has("delay"))
        {
            long l;
            try
            {
                l = jsonobject.getLong("delay");
                GLogger.d(TAG, "Received updated delay: %dms", new Object[] {
                    Long.valueOf(l)
                });
            }
            // Misplaced declaration of an exception variable
            catch (JSONObject jsonobject)
            {
                GLogger.ex(TAG, "Encountered a JSONException when unpackaging result", jsonobject);
                throw new TerminalException(jsonobject);
            }
            return Long.valueOf(l);
        } else
        {
            return Long.valueOf(-1L);
        }
    }

    public volatile Object buildResponse(JSONObject jsonobject)
        throws TerminalException, TransientException
    {
        return buildResponse(jsonobject);
    }

    protected String getConfigPath()
    {
        return "photos/network/delay.json";
    }

}
