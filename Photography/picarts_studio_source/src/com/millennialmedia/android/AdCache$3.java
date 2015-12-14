// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import android.content.Context;

// Referenced classes of package com.millennialmedia.android:
//            AdCache, MMLog

final class a
    implements Runnable
{

    private Context a;

    public final void run()
    {
        MMLog.b("AdCache", "AdCache");
        AdCache.c(a);
        AdCache.d(a);
    }

    (Context context)
    {
        a = context;
        super();
    }
}
