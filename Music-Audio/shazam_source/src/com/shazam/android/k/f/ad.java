// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import android.net.Uri;

// Referenced classes of package com.shazam.android.k.f:
//            ac

public final class ad
    implements ac
{

    private final String a;

    public ad(String s)
    {
        a = s;
    }

    public final Uri a(Uri uri)
    {
        return uri.buildUpon().scheme(a).appendQueryParameter("urlscheme", uri.getScheme()).build();
    }
}
