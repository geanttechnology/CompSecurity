// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.xip;


public class XipServer
{

    private final String serverUri;

    public XipServer(String s)
    {
        serverUri = s;
    }

    public String getURI()
    {
        return serverUri;
    }

    public String toString()
    {
        return getURI();
    }
}
