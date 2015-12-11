// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.database.DataSetObserver;
import android.widget.Adapter;

// Referenced classes of package com.mopub.nativeads:
//            MoPubAdAdapter, MoPubStreamAdPlacer

class t> extends DataSetObserver
{

    final MoPubAdAdapter this$0;

    public void onChanged()
    {
        MoPubAdAdapter.access$200(MoPubAdAdapter.this).setItemCount(MoPubAdAdapter.access$100(MoPubAdAdapter.this).getCount());
        notifyDataSetChanged();
    }

    public void onInvalidated()
    {
        notifyDataSetInvalidated();
    }

    er()
    {
        this$0 = MoPubAdAdapter.this;
        super();
    }
}
