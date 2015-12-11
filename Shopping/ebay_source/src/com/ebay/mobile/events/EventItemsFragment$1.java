// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;


// Referenced classes of package com.ebay.mobile.events:
//            EventItemsFragment, EventItemsAdapter

class SpanSizeLookup extends android.support.v7.widget.nSizeLookup
{

    final EventItemsFragment this$0;

    public int getSpanSize(int i)
    {
        switch (EventItemsFragment.access$000(EventItemsFragment.this).getItemViewType(i))
        {
        default:
            return 1;

        case 1: // '\001'
            return EventItemsFragment.access$100(EventItemsFragment.this);
        }
    }

    SpanSizeLookup()
    {
        this$0 = EventItemsFragment.this;
        super();
    }
}
