// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.search;

import android.os.Handler;
import android.support.v7.widget.SearchView;

// Referenced classes of package com.shazam.android.activities.search:
//            SearchActivity

final class c
    implements android.support.v7.widget.Activity._cls3
{

    final Handler a = new Handler();
    final b b;
    final SearchActivity c;

    public final boolean a()
    {
        a.removeCallbacks(b);
        b.run();
        SearchActivity.b(c).clearFocus();
        return true;
    }

    public final boolean a(String s)
    {
        SearchActivity.a(c, s);
        a.removeCallbacks(b);
        a.postDelayed(b, 200L);
        return true;
    }

    (SearchActivity searchactivity)
    {
        c = searchactivity;
        super();
        b = new <init>(c, (byte)0);
    }
}
