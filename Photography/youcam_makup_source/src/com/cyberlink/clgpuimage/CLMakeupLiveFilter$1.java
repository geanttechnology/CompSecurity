// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.clgpuimage;


// Referenced classes of package com.cyberlink.clgpuimage:
//            CLMakeupLiveFilter

class IP_MODE
{

    static final int a[];

    static 
    {
        a = new int[IP_MODE.values().length];
        try
        {
            a[IP_MODE.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[IP_MODE.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[IP_MODE.a.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
