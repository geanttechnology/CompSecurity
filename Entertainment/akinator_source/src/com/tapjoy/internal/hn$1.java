// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            hn, ho

static final class r
{

    static final int a[];

    static 
    {
        a = new int[ho.values().length];
        try
        {
            a[ho.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[ho.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
