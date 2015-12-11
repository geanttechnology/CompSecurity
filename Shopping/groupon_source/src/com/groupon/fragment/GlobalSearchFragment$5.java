// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.ViewTreeObserver;
import com.groupon.util.SearchInterfaceProvider;
import com.groupon.view.ClearableEditText;

// Referenced classes of package com.groupon.fragment:
//            GlobalSearchFragment

class this._cls0
    implements android.view.alLayoutListener
{

    final GlobalSearchFragment this$0;

    public void onGlobalLayout()
    {
        locationSearchView.setWidth(GlobalSearchFragment.access$300(GlobalSearchFragment.this).getMeasuredWidth());
        locationSearchView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    Listener()
    {
        this$0 = GlobalSearchFragment.this;
        super();
    }
}
