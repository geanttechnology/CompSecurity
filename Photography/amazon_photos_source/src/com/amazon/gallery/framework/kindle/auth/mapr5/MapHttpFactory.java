// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.auth.mapr5;

import android.content.Context;
import com.amazon.clouddrive.configuration.SourceInfoCache;
import com.amazon.clouddrive.internal.BasicSourceInfo;
import com.amazon.gallery.foundation.utils.di.BeanAwareApplication;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.http.rest.http.AbstractHttpFactory;
import com.amazon.gallery.thor.cds.SharedPreferenceSourceInfoCache;
import com.amazon.identity.auth.device.api.AuthenticatedHttpGet;
import com.amazon.identity.auth.device.api.AuthenticatedHttpPost;
import com.amazon.identity.auth.device.api.AuthenticationAwareHttpClient;
import com.amazon.identity.auth.device.api.AuthenticationMethod;
import com.amazon.identity.auth.device.api.AuthenticationMethodFactory;
import com.amazon.identity.auth.device.api.AuthenticationType;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

public class MapHttpFactory extends AbstractHttpFactory
{

    private AuthenticationMethod authenticator;
    private Context context;
    private String directedId;
    private BasicSourceInfo sourceInfo;
    private SourceInfoCache sourceInfoCache;

    public MapHttpFactory(Context context1)
    {
        context = context1;
    }

    public AuthenticationMethod getAuthenticator()
        throws InvalidParameterException
    {
        this;
        JVM INSTR monitorenter ;
        if (authenticator == null)
        {
            if (directedId == null)
            {
                directedId = (new MAPAccountManager(context)).getAccount();
            }
            if (directedId != null)
            {
                authenticator = (new AuthenticationMethodFactory(context, directedId)).newAuthenticationMethod(AuthenticationType.OAuth);
                sourceInfoCache = new SharedPreferenceSourceInfoCache((BeanAwareApplication)context, directedId);
                sourceInfo = null;
            }
            if (authenticator == null)
            {
                throw new InvalidParameterException("Must have an authenticator in order to make a DCP Call");
            }
        }
        break MISSING_BLOCK_LABEL_115;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        AuthenticationMethod authenticationmethod = authenticator;
        this;
        JVM INSTR monitorexit ;
        return authenticationmethod;
    }

    public HttpClient getHttpClient(Context context1)
    {
        return new AuthenticationAwareHttpClient(super.getHttpClient(context1));
    }

    public HttpGet getHttpGetRequest()
        throws InvalidParameterException
    {
        return new AuthenticatedHttpGet(getAuthenticator());
    }

    public HttpPost getHttpPostRequest()
        throws InvalidParameterException
    {
        return new AuthenticatedHttpPost(getAuthenticator());
    }

    public BasicSourceInfo getSourceInfo()
    {
        if (sourceInfo == null && sourceInfoCache.isSourceInfoCached())
        {
            sourceInfo = sourceInfoCache.getSourceInfo();
        }
        return sourceInfo;
    }

    public void onAccountDeregistered()
    {
        this;
        JVM INSTR monitorenter ;
        directedId = null;
        authenticator = null;
        if (sourceInfoCache != null)
        {
            sourceInfoCache.clear();
        }
        sourceInfo = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void onAccountRegistered()
    {
        this;
        JVM INSTR monitorenter ;
        directedId = (new MAPAccountManager(context)).getAccount();
        authenticator = null;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }
}
