// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.content.Context;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.v3.view.list_view.LocationBarHeader;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            LocationBarMapping

class val.wrapper
    implements android.view.ationBarMapping._cls1
{

    final LocationBarMapping this$0;
    final LocationBarHeader val$wrapper;

    public void onClick(View view)
    {
        LocationBarMapping.access$100(LocationBarMapping.this).logClick("", "click_country_selector", LocationBarMapping.access$000(LocationBarMapping.this).toString(), val$wrapper.location);
        view.getContext().startActivity(LocationBarMapping.access$200(LocationBarMapping.this).newCountryOrDivisionSelector());
    }

    _cls9()
    {
        this$0 = final_locationbarmapping;
        val$wrapper = LocationBarHeader.this;
        super();
    }
}
