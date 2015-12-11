// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.widget.SearchView;
import com.smule.android.c.aa;
import com.smule.pianoandroid.data.db.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity, ProductListFragment

class a
    implements android.view.roductListActivity._cls8
{

    final SearchView a;
    final ProductListActivity b;

    public void onClick(View view)
    {
        aa.a(ProductListActivity.a, "setOnSearchClickListener");
        view = ProductListActivity.d(b).a().g();
        if (view != null && view.length() != 0)
        {
            a.setQuery(view, false);
            aa.a(ProductListActivity.a, (new StringBuilder()).append("setOnSearchClickListener - ").append(view).toString());
        }
    }

    (ProductListActivity productlistactivity, SearchView searchview)
    {
        b = productlistactivity;
        a = searchview;
        super();
    }
}
