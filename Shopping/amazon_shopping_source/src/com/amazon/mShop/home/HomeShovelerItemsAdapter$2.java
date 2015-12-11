// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.home;

import android.view.View;
import android.view.ViewGroup;

// Referenced classes of package com.amazon.mShop.home:
//            HomeShovelerItemsAdapter

class this._cls0
    implements android.view.dapter._cls2
{

    final HomeShovelerItemsAdapter this$0;

    public void onFocusChange(View view, boolean flag)
    {
        ((ViewGroup)view.getParent()).getOnFocusChangeListener().onFocusChange(view, flag);
    }

    ()
    {
        this$0 = HomeShovelerItemsAdapter.this;
        super();
    }
}
