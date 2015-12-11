// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchFragment, DestinationsAdapter, GetawaysSearchViewPresenter

private class <init>
    implements android.widget.lickListener
{

    final GetawaysSearchFragment this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = GetawaysSearchFragment.access$400(GetawaysSearchFragment.this).getItem(i);
        if (GetawaysSearchFragment.access$400(GetawaysSearchFragment.this).isCurrentLocationPosition(i))
        {
            GetawaysSearchFragment.access$500(GetawaysSearchFragment.this).onCurrentLocationClicked();
            return;
        } else
        {
            GetawaysSearchFragment.access$500(GetawaysSearchFragment.this).onAutocompleteDestinationClicked(adapterview);
            return;
        }
    }

    private ()
    {
        this$0 = GetawaysSearchFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
