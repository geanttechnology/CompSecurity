// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.share.model;

import android.net.Uri;

// Referenced classes of package com.facebook.share.model:
//            ShareLinkContent

public static final class  extends 
{

    private String a;
    private String b;
    private Uri c;

    static String a( )
    {
        return .a;
    }

    static String b(a a1)
    {
        return a1.b;
    }

    static Uri c(b b1)
    {
        return b1.c;
    }

    public c a(String s)
    {
        a = s;
        return this;
    }

    public ShareLinkContent a()
    {
        return new ShareLinkContent(this, null);
    }

    public nit> b(Uri uri)
    {
        c = uri;
        return this;
    }

    public c b(String s)
    {
        b = s;
        return this;
    }

    public ()
    {
    }
}
