// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playnow.provider.downloads;

import com.penthera.virtuososdk.database.impl.provider.VirtuosoSDKContentProvider;

public class DownloadsContentProvider extends VirtuosoSDKContentProvider
{

    public DownloadsContentProvider()
    {
    }

    protected String getAuthority()
    {
        return "com.xfinity.playnow.provider.downloads";
    }

    static 
    {
        setAuthority("com.xfinity.playnow.provider.downloads");
    }
}
