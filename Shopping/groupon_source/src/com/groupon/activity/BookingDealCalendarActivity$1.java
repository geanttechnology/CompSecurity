// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.events.DealUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.loader.DealLoader;

// Referenced classes of package com.groupon.activity:
//            BookingDealCalendarActivity

class this._cls0
    implements android.app.tivity._cls1
{

    final BookingDealCalendarActivity this$0;

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new DealLoader(com/groupon/db/models/Deal, com/groupon/db/events/DealUpdateEvent, BookingDealCalendarActivity.this, dealId);
    }

    public void onLoadFinished(Loader loader, Deal deal)
    {
        BookingDealCalendarActivity.this.deal = deal;
        BookingDealCalendarActivity.access$000(BookingDealCalendarActivity.this);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Deal)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }

    ()
    {
        this$0 = BookingDealCalendarActivity.this;
        super();
    }
}
