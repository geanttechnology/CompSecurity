// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.TextView;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            PageProductsFragment

class a
    implements android.widget.Listener
{

    final PageProductsFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i == 0)
        {
            adapterview = "";
        } else
        {
            adapterview = ((TextView)view).getText().toString();
        }
        view = PageProductsFragment.e(a).getFilter();
        if (view != null)
        {
            view.filter(adapterview);
        }
    }

    (PageProductsFragment pageproductsfragment)
    {
        a = pageproductsfragment;
        super();
    }
}
