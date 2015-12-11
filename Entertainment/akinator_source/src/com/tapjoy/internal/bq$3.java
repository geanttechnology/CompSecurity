// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            bq, bz

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
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[bz.c.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
