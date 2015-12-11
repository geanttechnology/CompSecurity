// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.k.f;

import android.content.ContentResolver;
import android.net.Uri;

// Referenced classes of package com.shazam.android.k.f:
//            v

public final class u
    implements v
{

    private final ContentResolver a;

    public u(ContentResolver contentresolver)
    {
        a = contentresolver;
    }

    public final void a(Uri uri)
    {
        a.notifyChange(uri, null);
    }
}
