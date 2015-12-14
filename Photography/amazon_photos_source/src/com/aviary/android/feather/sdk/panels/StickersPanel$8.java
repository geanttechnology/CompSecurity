// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.sdk.panels;

import android.database.Cursor;
import android.view.View;
import it.sephiroth.android.library.widget.AdapterView;

// Referenced classes of package com.aviary.android.feather.sdk.panels:
//            StickersPanel

class this._cls0
    implements it.sephiroth.android.library.widget.emClickListener
{

    final StickersPanel this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        adapterview = (ickersAdapter)adapterview.getAdapter();
        view = (Cursor)adapterview.getItem(i);
        view = view.getString(view.getColumnIndex("item_identifier"));
        boolean _tmp = StickersPanel.access$300(StickersPanel.this);
        StickersPanel.access$400(StickersPanel.this, adapterview.getContentPath(), view, null);
    }

    ickersAdapter()
    {
        this$0 = StickersPanel.this;
        super();
    }
}
