// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.an.a;


// Referenced classes of package com.shazam.android.an.a:
//            e

static final class ioError
{

    static final int a[];

    static 
    {
        a = new int[com.rdio.android.sdk..RdioError.values().length];
        try
        {
            a[com.rdio.android.sdk..RdioError.AUTHORIZATION.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror) { }
    }
}
