// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.widget;

import android.database.DataSetObserver;

// Referenced classes of package co.vine.android.widget:
//            SectionAdapter

class this._cls0 extends DataSetObserver
{

    final SectionAdapter this$0;

    public void onChanged()
    {
        if (mNotifyOnChange)
        {
            notifyDataSetChanged();
        }
    }

    public void onInvalidated()
    {
        notifyDataSetInvalidated();
    }

    ()
    {
        this$0 = SectionAdapter.this;
        super();
    }
}
