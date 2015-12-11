// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.Channel;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

class this._cls0
    implements android.view.ment._cls11
{

    final HotelCardListFragment this$0;

    public void onClick(View view)
    {
        if (HotelCardListFragment.access$600(HotelCardListFragment.this))
        {
            return;
        }
        LoggingUtils loggingutils = loggingUtils;
        if (pagerChannel != null)
        {
            view = pagerChannel.toString();
        } else
        {
            view = "";
        }
        loggingutils.logClickWithMetadata("", "show_full_map_floating_button_click", view, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
        setHotelPagerMode(true, true);
    }

    ()
    {
        this$0 = HotelCardListFragment.this;
        super();
    }
}
