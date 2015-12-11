// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.net.url;

import com.pointinside.internal.ParameterCheck;
import com.pointinside.net.EndpointType;
import java.util.HashMap;

// Referenced classes of package com.pointinside.net.url:
//            URLBuilder

public class FeedsURLBuilder extends URLBuilder
{

    private static final String KEY_MAX_RESULTS = "maxResults".intern();
    private static final String KEY_MODIFIED_SINCE = "modifiedSince".intern();
    private static final String KEY_START_INDEX = "startIndex".intern();
    public Integer maxResults;
    public Long modifiedSince;
    public Integer startIndex;
    public String venueUUID;

    public FeedsURLBuilder()
    {
        this(EndpointType.FEED_MAP, null);
    }

    protected FeedsURLBuilder(EndpointType endpointtype, String s)
    {
        super(endpointtype, s);
        modifiedSince = null;
        startIndex = null;
        venueUUID = null;
    }

    public FeedsURLBuilder(String s)
    {
        this();
        ParameterCheck.throwIfNullOrEmpty("venueUUID", s);
        venueUUID = s;
    }

    public void onPrepareURL()
    {
        addProximityDataIfAvailable();
        setParameterOrClear(KEY_MODIFIED_SINCE, modifiedSince);
        setParameterOrClear(KEY_START_INDEX, startIndex);
        if (maxResults != null && maxResults.intValue() > 0)
        {
            parameters.put(KEY_MAX_RESULTS, maxResults.toString());
        }
        if (venueUUID != null)
        {
            setQualifiers(venueUUID);
        }
    }

    public void reset()
    {
        super.reset();
        modifiedSince = null;
        startIndex = null;
        maxResults = null;
    }

}
