// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.auth;

import org.apache.commons.httpclient.ProtocolException;

public class MalformedChallengeException extends ProtocolException
{

    public MalformedChallengeException()
    {
    }

    public MalformedChallengeException(String s)
    {
        super(s);
    }

    public MalformedChallengeException(String s, Throwable throwable)
    {
        super(s, throwable);
    }
}
