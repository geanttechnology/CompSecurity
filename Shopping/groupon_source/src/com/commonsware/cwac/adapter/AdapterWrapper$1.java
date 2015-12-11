// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.commonsware.cwac.adapter;

import android.database.DataSetObserver;

// Referenced classes of package com.commonsware.cwac.adapter:
//            AdapterWrapper

class this._cls0 extends DataSetObserver
{

    final AdapterWrapper this$0;

    public void onChanged()
    {
        notifyDataSetChanged();
    }

    public void onInvalidated()
    {
        notifyDataSetInvalidated();
    }

    ()
    {
        this$0 = AdapterWrapper.this;
        super();
    }
}
