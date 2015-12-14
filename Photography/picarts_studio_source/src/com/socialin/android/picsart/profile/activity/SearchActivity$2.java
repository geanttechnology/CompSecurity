// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.support.v7.widget.SearchView;
import android.view.View;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            SearchActivity

final class a
    implements android.view.ner
{

    private SearchActivity a;

    public final void onClick(View view)
    {
        SearchActivity.d(a);
        SearchActivity.e(a).setQuery("", false);
    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
