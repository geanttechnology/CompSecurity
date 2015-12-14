// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nhaarman.listviewanimations.widget;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.nhaarman.listviewanimations.widget:
//            DynamicListView

class this._cls0
    implements android.widget.LongClickListener
{

    final DynamicListView this$0;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        if (DynamicListView.access$000(DynamicListView.this) == 0)
        {
            DynamicListView.access$102(DynamicListView.this, true);
            DynamicListView.access$200(DynamicListView.this);
            return true;
        } else
        {
            return false;
        }
    }

    ()
    {
        this$0 = DynamicListView.this;
        super();
    }
}
