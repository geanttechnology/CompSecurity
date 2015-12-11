// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import java.util.List;

// Referenced classes of package com.ebay.mobile.events:
//            EventsAdapter

class kup extends android.support.v7.widget.r.SpanSizeLookup
{

    final EventsAdapter this$0;

    public int getSpanSize(int i)
    {
        return ((Integer)EventsAdapter.access$000(EventsAdapter.this).get(i)).intValue();
    }

    ager.SpanSizeLookup()
    {
        this$0 = EventsAdapter.this;
        super();
    }
}
