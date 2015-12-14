// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.activity;

import android.text.TextUtils;
import com.socialin.android.picsart.profile.adapter.ap;

// Referenced classes of package com.socialin.android.picsart.profile.activity:
//            SearchActivity, l

final class nit> extends android.support.v4.view.nPageChangeListener
{

    private SearchActivity a;

    public final void onPageSelected(int i)
    {
        super.onPageSelected(i);
        SearchActivity.a(a, i);
        if (SearchActivity.a(a) != null && ((l)SearchActivity.a(a).getItem(SearchActivity.b(a))).d() && !TextUtils.isEmpty(SearchActivity.c(a)))
        {
            ((l)SearchActivity.a(a).getItem(SearchActivity.b(a))).a(false);
            a.a();
        }
    }

    (SearchActivity searchactivity)
    {
        a = searchactivity;
        super();
    }
}
