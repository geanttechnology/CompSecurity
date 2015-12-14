// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import org.apache.commons.httpclient.Credentials;

// Referenced classes of package org.apache.commons.httpclient.auth:
//            CredentialsNotAvailableException, AuthScheme

public interface CredentialsProvider
{

    public static final String PROVIDER = "http.authentication.credential-provider";

    public abstract Credentials getCredentials(AuthScheme authscheme, String s, int i, boolean flag)
        throws CredentialsNotAvailableException;
}
