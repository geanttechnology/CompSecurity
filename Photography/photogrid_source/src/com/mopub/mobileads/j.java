// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


final class j
{

    static final int a[];

    static 
    {
        a = new int[com.mopub.network.MoPubNetworkError.Reason.values().length];
        try
        {
            a[com.mopub.network.MoPubNetworkError.Reason.WARMING_UP.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[com.mopub.network.MoPubNetworkError.Reason.NO_FILL.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
