// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import opens.components.http.EOnlineDownType;

class bgi
{

    static final int a[];

    static 
    {
        a = new int[EOnlineDownType.values().length];
        try
        {
            a[EOnlineDownType.UPDATE.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[EOnlineDownType.NEWCOUNT.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[EOnlineDownType.FILTERDOWNLOAD.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
