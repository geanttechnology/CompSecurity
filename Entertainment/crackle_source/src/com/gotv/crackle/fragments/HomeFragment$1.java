// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.view.View;
import com.gotv.crackle.data.SlideShowList;
import com.gotv.crackle.model.SlideShowItem;
import com.gotv.crackle.views.HeroViewPager;
import java.util.List;

// Referenced classes of package com.gotv.crackle.fragments:
//            HomeFragment

class this._cls0
    implements android.view.tener
{

    final HomeFragment this$0;

    public void onClick(View view)
    {
        int i = HomeFragment.access$000(HomeFragment.this).getCurrentItem();
        int j = mSlideShowList.getItems().size();
        view.setTag((SlideShowItem)mSlideShowList.getItems().get(i % j));
        launchMediaDetails(view);
    }

    ()
    {
        this$0 = HomeFragment.this;
        super();
    }
}
