// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.d.f;

// Referenced classes of package com.mopub.common:
//            n, o

static final class nit> extends n
{

    protected final void a(Context context, Uri uri, o o)
    {
        f.a(context, uri, (new StringBuilder("Could not handle intent with URI: ")).append(uri).append("\n\tIs this intent supported on your phone?").toString());
    }

    public final boolean a(Uri uri)
    {
        uri = uri.getScheme();
        return "tel".equals(uri) || "voicemail".equals(uri) || "sms".equals(uri) || "mailto".equals(uri) || "geo".equals(uri) || "google.streetview".equals(uri);
    }

    xt(String s)
    {
        super(s, 2, true, (byte)0);
    }
}
