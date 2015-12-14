// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.support.v7.widget.SearchView;
import android.view.View;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookMainActivity, FacebookPagingFragment, a

final class a
    implements android.view.okMainActivity._cls2
{

    private FacebookPagingFragment a;
    private FacebookMainActivity b;

    public final void onClick(View view)
    {
        if (a != null && a.d != null)
        {
            view = a.c;
            view.setItems(((a) (view)).a);
            view.notifyDataSetChanged();
        }
        FacebookMainActivity.a(b).setQuery("", false);
    }

    (FacebookMainActivity facebookmainactivity, FacebookPagingFragment facebookpagingfragment)
    {
        b = facebookmainactivity;
        a = facebookpagingfragment;
        super();
    }
}
