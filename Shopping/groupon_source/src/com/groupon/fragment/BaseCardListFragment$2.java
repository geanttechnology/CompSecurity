// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.groupon.fragment:
//            BaseCardListFragment

class this._cls0
    implements android.view.alLayoutListener
{

    final BaseCardListFragment this$0;

    public void onGlobalLayout()
    {
        if (getActivity() != null && !isRemoving())
        {
            forceReload();
        }
        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
    }

    Listener()
    {
        this$0 = BaseCardListFragment.this;
        super();
    }
}
