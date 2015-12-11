// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;

// Referenced classes of package com.ebay.mobile.search:
//            SearchResultFragmentActivity

class val.refinementLayout
    implements android.view.Listener
{

    final SearchResultFragmentActivity this$0;
    final ViewGroup val$refinementLayout;

    public void onGlobalLayout()
    {
        findViewById(0x7f1005fe).requestFocus();
        calculateResultVerticalSpacing(false);
        val$refinementLayout.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    ()
    {
        this$0 = final_searchresultfragmentactivity;
        val$refinementLayout = ViewGroup.this;
        super();
    }
}
