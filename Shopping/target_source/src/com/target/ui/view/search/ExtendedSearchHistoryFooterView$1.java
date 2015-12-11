// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.View;

// Referenced classes of package com.target.ui.view.search:
//            ExtendedSearchHistoryFooterView

class this._cls0
    implements android.view.FooterView._cls1
{

    final ExtendedSearchHistoryFooterView this$0;

    public void onClick(View view)
    {
        if (ExtendedSearchHistoryFooterView.a(ExtendedSearchHistoryFooterView.this) == null)
        {
            return;
        } else
        {
            ExtendedSearchHistoryFooterView.a(ExtendedSearchHistoryFooterView.this).a();
            return;
        }
    }

    A()
    {
        this$0 = ExtendedSearchHistoryFooterView.this;
        super();
    }
}
