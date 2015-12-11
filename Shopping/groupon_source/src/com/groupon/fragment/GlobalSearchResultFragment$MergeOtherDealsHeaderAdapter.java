// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.widget.Adapter;
import android.widget.ListAdapter;
import com.groupon.util.MergeAdapter;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchResultFragment

protected class this._cls0 extends MergeAdapter
{

    final GlobalSearchResultFragment this$0;

    protected int chooseAdapter(int i)
    {
        return ((Integer)GlobalSearchResultFragment.access$900(GlobalSearchResultFragment.this).get(i)).intValue();
    }

    public (ListAdapter listadapter, ListAdapter listadapter1, ListAdapter listadapter2, ListAdapter listadapter3, ListAdapter listadapter4, ListAdapter listadapter5)
    {
        this$0 = GlobalSearchResultFragment.this;
        super(new Adapter[] {
            listadapter, listadapter1, listadapter2, listadapter3, listadapter4, listadapter5
        });
    }
}
