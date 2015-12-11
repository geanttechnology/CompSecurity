// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.auth.AuthScheme;

public interface AuthCache
{

    public abstract AuthScheme get(HttpHost httphost);

    public abstract void put(HttpHost httphost, AuthScheme authscheme);

    public abstract void remove(HttpHost httphost);
}
