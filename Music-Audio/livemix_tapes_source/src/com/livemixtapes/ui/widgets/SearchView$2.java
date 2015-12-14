// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.livemixtapes.ui.widgets;

import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

// Referenced classes of package com.livemixtapes.ui.widgets:
//            SearchView

class this._cls0
    implements android.view.ver.OnGlobalLayoutListener
{

    final SearchView this$0;

    public void onGlobalLayout()
    {
        widthHint = SearchView.access$1(SearchView.this).getWidth();
        SearchView.access$1(SearchView.this).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    }

    outListener()
    {
        this$0 = SearchView.this;
        super();
    }
}
