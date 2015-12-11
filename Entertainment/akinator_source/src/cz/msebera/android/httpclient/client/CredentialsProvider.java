// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client;

import cz.msebera.android.httpclient.auth.AuthScope;
import cz.msebera.android.httpclient.auth.Credentials;

public interface CredentialsProvider
{

    public abstract void clear();

    public abstract Credentials getCredentials(AuthScope authscope);

    public abstract void setCredentials(AuthScope authscope, Credentials credentials);
}
