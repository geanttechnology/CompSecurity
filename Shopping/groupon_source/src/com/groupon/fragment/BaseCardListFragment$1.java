// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.view.ViewGroup;
import commonlib.adapter.JavaListAdapter;

// Referenced classes of package com.groupon.fragment:
//            BaseCardListFragment

class this._cls0 extends JavaListAdapter
{

    final BaseCardListFragment this$0;

    public long getItemId(int i)
    {
        return (long)getItem(i).hashCode();
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        return getCardView(this, i, view, viewgroup);
    }

    ()
    {
        this$0 = BaseCardListFragment.this;
        super();
    }
}
