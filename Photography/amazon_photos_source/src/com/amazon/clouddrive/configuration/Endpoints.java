// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.configuration;

import com.amazon.clouddrive.utils.Optional;
import java.io.Serializable;

public class Endpoints
    implements Serializable
{

    private final String mContentEndpoint;
    private final Optional mMarketplace;
    private final String mMetaDataEndpoint;

    public Endpoints(String s, String s1)
    {
        this(s, s1, null);
    }

    public Endpoints(String s, String s1, String s2)
    {
        mMetaDataEndpoint = s;
        mContentEndpoint = s1;
        mMarketplace = Optional.fromNullable(s2);
    }

    public String getContentEndpoint()
    {
        return mContentEndpoint;
    }

    public String getMetaDataEndpoint()
    {
        return mMetaDataEndpoint;
    }
}
