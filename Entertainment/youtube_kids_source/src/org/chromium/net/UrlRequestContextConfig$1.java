// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;


class tpCache
{

    static final int a[];

    static 
    {
        a = new int[tpCache.values().length];
        try
        {
            a[tpCache.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[tpCache.c.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[tpCache.d.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[tpCache.b.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
