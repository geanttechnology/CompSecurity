// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.list;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// Referenced classes of package com.target.ui.view.list:
//            RecentItemsCardView

private class <init>
    implements android.widget.kListener
{

    final RecentItemsCardView this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        while (RecentItemsCardView.a(RecentItemsCardView.this) == null || i < RecentItemsCardView.b(RecentItemsCardView.this).listView.getHeaderViewsCount()) 
        {
            return;
        }
        adapterview = (String)adapterview.getItemAtPosition(i);
        RecentItemsCardView.a(RecentItemsCardView.this).a(adapterview);
    }

    private ews()
    {
        this$0 = RecentItemsCardView.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
