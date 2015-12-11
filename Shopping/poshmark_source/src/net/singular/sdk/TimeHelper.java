// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;


class TimeHelper
{

    TimeHelper()
    {
    }

    public long currentTimeMillis()
    {
        return System.currentTimeMillis();
    }

    public long currentTimeSeconds()
    {
        return currentTimeMillis() / 1000L;
    }
}
