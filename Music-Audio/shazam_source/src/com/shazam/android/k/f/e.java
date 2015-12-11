// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import android.content.ContentResolver;
import android.net.Uri;

// Referenced classes of package com.shazam.android.k.f:
//            ab

public final class e
    implements ab
{

    private final ContentResolver b;
    private final Uri c;

    public e(Uri uri, ContentResolver contentresolver)
    {
        c = uri;
        b = contentresolver;
    }

    private void a(Uri uri)
    {
        b.notifyChange(uri, null);
    }

    public final void a()
    {
        a(c);
    }

    public final void a(String s)
    {
        a(Uri.withAppendedPath(c, s));
    }
}
