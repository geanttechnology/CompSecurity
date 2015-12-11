// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.search;

import android.support.v7.widget.SearchView;

// Referenced classes of package com.shazam.android.activities.search:
//            SearchActivity

final class a
    implements Runnable
{

    final SearchActivity a;

    public final void run()
    {
        SearchActivity.b(a).clearFocus();
    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
