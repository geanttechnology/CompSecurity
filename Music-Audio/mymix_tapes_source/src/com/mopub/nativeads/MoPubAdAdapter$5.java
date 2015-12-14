// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.nativeads;

import android.view.View;
import android.widget.AdapterView;

// Referenced classes of package com.mopub.nativeads:
//            MoPubAdAdapter, MoPubStreamAdPlacer

class ClickListener
    implements android.widget.mLongClickListener
{

    final MoPubAdAdapter this$0;
    final android.widget.mLongClickListener val$listener;

    public boolean onItemLongClick(AdapterView adapterview, View view, int i, long l)
    {
        return isAd(i) || val$listener.onItemLongClick(adapterview, view, MoPubAdAdapter.access$200(MoPubAdAdapter.this).getOriginalPosition(i), l);
    }

    ClickListener()
    {
        this$0 = final_mopubadadapter;
        val$listener = android.widget.mLongClickListener.this;
        super();
    }
}
