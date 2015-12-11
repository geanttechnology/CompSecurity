// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;


// Referenced classes of package com.wishabi.flipp.widget:
//            ca, cb

final class bx
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[ca.a().length];
        try
        {
            b[ca.a - 1] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        a = new int[cb.values().length];
        try
        {
            a[cb.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[cb.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[cb.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
