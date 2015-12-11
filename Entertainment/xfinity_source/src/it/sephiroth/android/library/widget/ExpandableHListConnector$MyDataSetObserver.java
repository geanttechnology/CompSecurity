// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.widget;

import android.database.DataSetObserver;

// Referenced classes of package it.sephiroth.android.library.widget:
//            ExpandableHListConnector

protected class this._cls0 extends DataSetObserver
{

    final ExpandableHListConnector this$0;

    public void onChanged()
    {
        ExpandableHListConnector.access$000(ExpandableHListConnector.this, true, true);
        notifyDataSetChanged();
    }

    public void onInvalidated()
    {
        ExpandableHListConnector.access$000(ExpandableHListConnector.this, true, true);
        notifyDataSetInvalidated();
    }

    protected ()
    {
        this$0 = ExpandableHListConnector.this;
        super();
    }
}
