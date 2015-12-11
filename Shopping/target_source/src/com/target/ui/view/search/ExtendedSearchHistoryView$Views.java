// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.view.View;
import android.widget.ListView;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.search:
//            ExtendedSearchHistoryView, ExtendedSearchHistoryFooterView

static class <init> extends a
{

    ExtendedSearchHistoryFooterView footer;
    ListView listView;

    (View view)
    {
        super(view);
        footer = new ExtendedSearchHistoryFooterView(view.getContext());
    }
}
