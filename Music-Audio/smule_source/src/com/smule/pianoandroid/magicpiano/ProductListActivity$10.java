// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.text.TextUtils;
import android.view.View;
import android.widget.SearchView;
import com.smule.android.c.aa;
import com.smule.pianoandroid.data.db.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity, ProductListFragment

class c
    implements android.widget.istener
{

    final SearchView a;
    final ProductListActivity b;
    private boolean c;

    public boolean onQueryTextChange(String s)
    {
        aa.a(ProductListActivity.a, (new StringBuilder()).append("onQueryTextChange - ").append(s).append(" submitted ").append(c).toString());
        if (c)
        {
            c = false;
            return true;
        }
        if (!TextUtils.isEmpty(s))
        {
            b.findViewById(0x7f0a01d0).setVisibility(8);
        } else
        {
            b.findViewById(0x7f0a01d0).setVisibility(0);
        }
        ProductListActivity.d(b).a().a(s, Boolean.TRUE);
        return true;
    }

    public boolean onQueryTextSubmit(String s)
    {
        aa.a(ProductListActivity.a, (new StringBuilder()).append("onQueryTextSubmit - ").append(s).toString());
        c = true;
        b.findViewById(0x7f0a00a9).setVisibility(8);
        a.clearFocus();
        return true;
    }

    (ProductListActivity productlistactivity, SearchView searchview)
    {
        b = productlistactivity;
        a = searchview;
        super();
        c = false;
    }
}
