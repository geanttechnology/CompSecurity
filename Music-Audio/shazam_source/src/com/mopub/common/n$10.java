// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.d.f;

// Referenced classes of package com.mopub.common:
//            n, o

static final class it> extends n
{

    protected final void a(Context context, Uri uri, o o)
    {
        f.b(context, uri);
    }

    public final boolean a(Uri uri)
    {
        String s = uri.getScheme();
        uri = uri.getHost();
        return !TextUtils.isEmpty(s) && !TextUtils.isEmpty(uri);
    }

    t(String s)
    {
        super(s, 8, true, (byte)0);
    }
}
