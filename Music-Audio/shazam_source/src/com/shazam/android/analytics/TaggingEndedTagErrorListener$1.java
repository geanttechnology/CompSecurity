// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics;

import com.shazam.android.ay.b;

// Referenced classes of package com.shazam.android.analytics:
//            TaggingEndedTagErrorListener

static class A
{

    static final int a[];

    static 
    {
        a = new int[b.values().length];
        try
        {
            a[b.c.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
    }
}
