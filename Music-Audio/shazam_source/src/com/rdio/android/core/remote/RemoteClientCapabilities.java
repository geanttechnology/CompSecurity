// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.core.remote;


public class RemoteClientCapabilities
{

    private final boolean canRemote;
    private final String name;

    public RemoteClientCapabilities(String s, boolean flag)
    {
        name = s;
        canRemote = flag;
    }

    public boolean canRemote()
    {
        return canRemote;
    }

    public String getName()
    {
        return name;
    }
}
