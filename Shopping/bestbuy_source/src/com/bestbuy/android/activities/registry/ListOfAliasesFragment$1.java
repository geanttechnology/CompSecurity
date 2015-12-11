// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.view.View;
import android.widget.AdapterView;
import cn;
import com.bestbuy.android.api.lib.models.registry.AliasesList;
import java.util.ArrayList;
import java.util.List;
import jl;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            ListOfAliasesFragment

class a
    implements android.widget.istener
{

    final ListOfAliasesFragment a;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (i < ListOfAliasesFragment.a(a).size())
        {
            adapterview = (AliasesList)ListOfAliasesFragment.b(a).a.get(i);
            (new jl(a.d, a, ListOfAliasesFragment.c(a), adapterview.getAlias(), adapterview.getDescription())).execute(new Void[0]);
        }
    }

    (ListOfAliasesFragment listofaliasesfragment)
    {
        a = listofaliasesfragment;
        super();
    }
}
