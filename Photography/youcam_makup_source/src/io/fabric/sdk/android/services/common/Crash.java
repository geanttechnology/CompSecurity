// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.fabric.sdk.android.services.common;


public abstract class Crash
{

    private final String sessionId;

    public Crash(String s)
    {
        sessionId = s;
    }

    public String getSessionId()
    {
        return sessionId;
    }
}
