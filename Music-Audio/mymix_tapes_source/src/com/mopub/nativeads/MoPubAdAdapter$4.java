// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.mopub.nativeads:
//            MoPubAdAdapter, MoPubStreamAdPlacer

class kListener
    implements android.widget.mClickListener
{

    final MoPubAdAdapter this$0;
    final android.widget.mClickListener val$listener;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        if (!MoPubAdAdapter.access$200(MoPubAdAdapter.this).isAd(i))
        {
            val$listener.onItemClick(adapterview, view, MoPubAdAdapter.access$200(MoPubAdAdapter.this).getOriginalPosition(i), l);
        }
    }

    kListener()
    {
        this$0 = final_mopubadadapter;
        val$listener = android.widget.mClickListener.this;
        super();
    }
}
