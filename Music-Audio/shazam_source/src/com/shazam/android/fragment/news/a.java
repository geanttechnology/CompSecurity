// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.news;

import android.content.Intent;
import com.shazam.k.o;

// Referenced classes of package com.shazam.android.fragment.news:
//            j

public final class a
    implements j
{

    private final o a;
    private final com.shazam.android.util.b.a b;

    public a(o o1, com.shazam.android.util.b.a a1)
    {
        a = o1;
        b = a1;
    }

    public final void a()
    {
        a.b();
        Intent intent = new Intent("com.shazam.android.action.RELOAD_NEWS_FEED");
        intent.putExtra("com.shazam.android.extra.FORCE_REFRESH_FEED", true);
        b.a(intent);
    }
}
