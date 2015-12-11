// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client;

import com.comcast.cim.httpcomponentsandroid.auth.AuthScope;
import com.comcast.cim.httpcomponentsandroid.auth.Credentials;

public interface CredentialsProvider
{

    public abstract Credentials getCredentials(AuthScope authscope);
}
