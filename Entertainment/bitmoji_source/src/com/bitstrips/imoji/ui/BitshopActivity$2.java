// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.ui;

import com.bitstrips.imoji.ui.adapters.PolyAdapter;

// Referenced classes of package com.bitstrips.imoji.ui:
//            BitshopActivity

class er.SpanSizeLookup extends android.support.v7.widget.SpanSizeLookup
{

    final BitshopActivity this$0;
    final PolyAdapter val$adapter;

    public int getSpanSize(int i)
    {
        return val$adapter.getSpanSizeForItem(i);
    }

    er()
    {
        this$0 = final_bitshopactivity;
        val$adapter = PolyAdapter.this;
        super();
    }
}
