// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;


// Referenced classes of package com.tapjoy.internal:
//            ca, bx

static final class r
{

    static final int a[];

    static 
    {
        a = new int[bx.values().length];
        try
        {
            a[bx.f.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            a[bx.a.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            a[bx.b.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            a[bx.d.ordinal()] = 4;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[bx.g.ordinal()] = 5;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
