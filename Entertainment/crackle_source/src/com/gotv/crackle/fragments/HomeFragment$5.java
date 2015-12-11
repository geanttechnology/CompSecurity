// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.widget.ProgressBar;
import com.gotv.crackle.MainActivity;
import com.gotv.crackle.adapters.BrowseGridAdapter;
import com.gotv.crackle.data.ItemsListRequest;
import com.gotv.crackle.data.MediaDetailsRequest;
import com.gotv.crackle.views.CrackleListView;

// Referenced classes of package com.gotv.crackle.fragments:
//            HomeFragment

class this._cls0
    implements Runnable
{

    final HomeFragment this$0;

    public void run()
    {
        if (HomeFragment.access$100(HomeFragment.this) != null)
        {
            if (HomeFragment.access$200(HomeFragment.this) != null)
            {
                HomeFragment.access$100(HomeFragment.this).setAdapter(new BrowseGridAdapter((MainActivity)HomeFragment.access$300(HomeFragment.this), mCrackleRequester.getItems(), HomeFragment.access$400(HomeFragment.this), com.gotv.crackle.base.pSection.HOME, HomeFragment.access$200(HomeFragment.this).getItem()));
            } else
            {
                HomeFragment.access$100(HomeFragment.this).setAdapter(new BrowseGridAdapter((MainActivity)HomeFragment.access$300(HomeFragment.this), mCrackleRequester.getItems(), HomeFragment.access$400(HomeFragment.this), com.gotv.crackle.base.pSection.HOME, null));
            }
        }
        HomeFragment.access$500(HomeFragment.this);
        HomeFragment.access$600(HomeFragment.this).setVisibility(4);
    }

    ion()
    {
        this$0 = HomeFragment.this;
        super();
    }
}
