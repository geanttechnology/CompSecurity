// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.configuration;

import com.amazon.clouddrive.auth.AuthenticatedURLConnectionFactory;
import com.amazon.clouddrive.utils.AssertUtils;

// Referenced classes of package com.amazon.clouddrive.configuration:
//            EndpointsCache, SourceInfoCache

public class AccountConfiguration
{

    private AuthenticatedURLConnectionFactory mAuthenticatedURLConnectionFactory;
    private EndpointsCache mEndpointsCache;
    private SourceInfoCache mSourceInfoCache;

    public AccountConfiguration(AuthenticatedURLConnectionFactory authenticatedurlconnectionfactory, EndpointsCache endpointscache, SourceInfoCache sourceinfocache)
    {
        AssertUtils.assertNotNull(endpointscache, "endpointsCache was null");
        AssertUtils.assertNotNull(authenticatedurlconnectionfactory, "authenticatedURLConnectionFactory was null");
        mEndpointsCache = endpointscache;
        mSourceInfoCache = sourceinfocache;
        mAuthenticatedURLConnectionFactory = authenticatedurlconnectionfactory;
    }

    public AuthenticatedURLConnectionFactory getAuthenticatedURLConnectionFactory()
    {
        return mAuthenticatedURLConnectionFactory;
    }

    public EndpointsCache getEndpointsCache()
    {
        return mEndpointsCache;
    }

    public SourceInfoCache getSourceInfoCache()
    {
        return mSourceInfoCache;
    }
}
