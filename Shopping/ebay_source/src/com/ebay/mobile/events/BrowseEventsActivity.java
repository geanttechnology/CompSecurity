// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.events;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.BrowseDepartmentActivity;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.data.UnifiedStream.KeyValue;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.events:
//            EventsAdapter, EventViewModel, EventTimeLeftHelper, EventItemsActivity

public class BrowseEventsActivity extends BrowseDepartmentActivity
    implements com.ebay.mobile.common.view.ViewModel.OnClickListener
{

    public BrowseEventsActivity()
    {
    }

    public RecyclerContentAdapter getChannelContentAdapter(Boolean boolean1)
    {
        return new EventsAdapter(this);
    }

    public ContentSourceEnum getContentSourceEnum(String s)
    {
        return ContentSourceEnum.RPP_EVENT;
    }

    public List getContextValues()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new KeyValue(ContentSourceEnum.RPP_EVENT.name(), "ShowAllEvents", "true"));
        return arraylist;
    }

    public String getTrackingEventName()
    {
        return "SalesEventsBrowse";
    }

    public void onClick(View view, ViewModel viewmodel)
    {
        viewmodel = (EventViewModel)viewmodel;
        view = null;
        Resources resources = getResources();
        if (((EventViewModel) (viewmodel)).showTimer)
        {
            view = EventTimeLeftHelper.getEndsInTimeMaxUnitString(resources, EventTimeLeftHelper.getRemainingDuration(((EventViewModel) (viewmodel)).endDate), true);
            view = String.format(resources.getString(0x7f0701f4), new Object[] {
                view
            });
        }
        EventItemsActivity.startActivity(this, viewmodel, departmentId, view, new SourceIdentification("SalesEventsBrowse", "salesevents", TrackingData.sanitize(departmentId)));
    }

    public void sendTracking(String s, Contents contents)
    {
        contents = new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
        contents.addKeyValuePair("chnl", s, true);
        if (TextUtils.equals(s, departmentId))
        {
            s = "0";
        } else
        {
            s = "1";
        }
        contents.addKeyValuePair("filter", s);
        contents.addSourceIdentification(getIntent());
        contents.send(this);
    }
}
