// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.auth;

import cz.msebera.android.httpclient.auth.AuthenticationException;

public class NTLMEngineException extends AuthenticationException
{

    private static final long serialVersionUID = 0x53a7b11389b895f8L;

    public NTLMEngineException()
    {
    }

    public NTLMEngineException(String s)
    {
        super(s);
    }

    public NTLMEngineException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
