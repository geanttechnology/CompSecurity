// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            bu, bz

static final class r
{

    static final int a[];

    static 
    {
        a = new int[bz.values().length];
        try
        {
            a[bz.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror5) { }
        try
        {
            a[bz.c.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[bz.i.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[bz.h.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[bz.g.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[bz.f.ordinal()] = 6;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
