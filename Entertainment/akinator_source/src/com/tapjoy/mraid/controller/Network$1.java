// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;


// Referenced classes of package com.tapjoy.mraid.controller:
//            Network

static final class 
{

    static final int a[];

    static 
    {
        a = new int[android.net.o.State.values().length];
        try
        {
            a[android.net.o.State.UNKNOWN.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[android.net.o.State.DISCONNECTED.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
