// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.playerplatform.drm.java.event;

import com.comcast.playerplatform.drm.java.client.SecurityTokenType;
import java.util.EventListener;

public abstract class AbstractDrmEventListener
    implements EventListener
{

    public AbstractDrmEventListener()
    {
    }

    public void deProvisionComplete()
    {
    }

    public void internalDRMError(SecurityTokenType securitytokentype, String s, String s1)
    {
    }

    public void provisionComplete()
    {
    }

    public void serverSecurityError(SecurityTokenType securitytokentype, String s, String s1, String s2)
    {
    }

    public void sessionCreated()
    {
    }

    public void unprovisionedError()
    {
    }

    public void xactCreated()
    {
    }
}
