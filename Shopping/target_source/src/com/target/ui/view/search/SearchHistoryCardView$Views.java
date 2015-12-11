// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.search;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.search:
//            SearchHistoryCardView, SearchHistoryHeader, SearchHistoryFooter

static class footer extends a
{

    final SearchHistoryFooter footer;
    final SearchHistoryHeader header;
    ListView listView;

    (Context context, View view)
    {
        super(view);
        header = new SearchHistoryHeader(context);
        footer = new SearchHistoryFooter(context);
    }
}
