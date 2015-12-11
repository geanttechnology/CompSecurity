// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;

// Referenced classes of package com.gotv.crackle.fragments:
//            BrowseShowsFragment

class this._cls0
    implements android.widget.ctedListener
{

    final BrowseShowsFragment this$0;

    public void onItemSelected(AdapterView adapterview, View view, int i, long l)
    {
        BrowseShowsFragment.access$102(BrowseShowsFragment.this, (String)adapterview.getAdapter().getItem(i));
        BrowseShowsFragment.access$200(BrowseShowsFragment.this);
    }

    public void onNothingSelected(AdapterView adapterview)
    {
    }

    ()
    {
        this$0 = BrowseShowsFragment.this;
        super();
    }
}
