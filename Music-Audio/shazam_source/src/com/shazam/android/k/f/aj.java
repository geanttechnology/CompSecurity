// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import android.net.Uri;

// Referenced classes of package com.shazam.android.k.f:
//            ac

public final class aj
    implements ac
{

    public aj()
    {
    }

    public final Uri a(Uri uri)
    {
        Uri uri1;
label0:
        {
            String s = uri.getScheme();
            if (!"http".equals(s))
            {
                uri1 = uri;
                if (!"https".equals(s))
                {
                    break label0;
                }
            }
            uri1 = uri.buildUpon().scheme("shazaminternal").appendQueryParameter("urlscheme", s).build();
        }
        return uri1;
    }
}
