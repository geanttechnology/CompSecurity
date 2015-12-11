// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import com.wishabi.flipp.widget.ca;
import com.wishabi.flipp.widget.cb;

final class av
{

    static final int a[];
    static final int b[];

    static 
    {
        b = new int[cb.values().length];
        try
        {
            b[cb.a.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror4) { }
        try
        {
            b[cb.b.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror3) { }
        try
        {
            b[cb.c.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        a = new int[ca.a().length];
        try
        {
            a[ca.b - 1] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            a[ca.c - 1] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
