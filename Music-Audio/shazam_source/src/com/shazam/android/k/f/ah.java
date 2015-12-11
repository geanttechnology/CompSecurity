// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import android.net.Uri;

// Referenced classes of package com.shazam.android.k.f:
//            ac

public final class ah
    implements ac
{

    public ah()
    {
    }

    public final Uri a(Uri uri)
    {
        String s = uri.getScheme();
        return uri.buildUpon().scheme("cast").appendQueryParameter("urlscheme", s).build();
    }
}
