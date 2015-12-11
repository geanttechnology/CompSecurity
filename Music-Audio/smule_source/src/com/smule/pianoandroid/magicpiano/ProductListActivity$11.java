// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import com.smule.android.network.core.r;
import com.smule.pianoandroid.data.db.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ProductListActivity, ProductListFragment, MagicApplication

class a
    implements Runnable
{

    final SearchView a;
    final ProductListActivity b;

    public void run()
    {
        byte byte1 = 8;
        Object obj = a.getQuery().toString();
        boolean flag = ProductListActivity.d(b).a().a(((String) (obj)), Boolean.TRUE);
        obj = ProductListActivity.i(b);
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        ((TextView) (obj)).setVisibility(byte0);
        if (flag)
        {
            ProductListActivity.d(b).b();
        }
        if (r.a(MagicApplication.getContext()))
        {
            View view = ProductListActivity.j(b);
            if (ProductListActivity.d(b).a().e().booleanValue())
            {
                byte0 = byte1;
            } else
            {
                byte0 = 0;
            }
            view.setVisibility(byte0);
            return;
        } else
        {
            ProductListActivity.j(b).setVisibility(8);
            return;
        }
    }

    (ProductListActivity productlistactivity, SearchView searchview)
    {
        b = productlistactivity;
        a = searchview;
        super();
    }
}
