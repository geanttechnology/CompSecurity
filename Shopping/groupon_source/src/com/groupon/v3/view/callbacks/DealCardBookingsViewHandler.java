// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.groupon.Channel;
import com.groupon.db.models.BookableSegments;
import com.groupon.db.models.DealSummary;
import com.groupon.fragment.CategoryIntentProperties;
import com.groupon.fragment.RapiSearchResultDomainModelFacade;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.nst.DTFGenericMetadata;
import com.groupon.models.nst.DealImpressionMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.view.param.DealCardClickInfo;
import com.groupon.v3.view.param.DealCardWithTimePillClickInfo;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.v3.view.callbacks:
//            DealCardViewHandler

public class DealCardBookingsViewHandler extends DealCardViewHandler
{

    public static final String RESERVATION_DETAILS = "reservation_details";
    public static final String RESERVATION_DETAILS_BUNDLE = "reservation_details_bundle";
    private CategoryIntentProperties categoryIntent;
    private RapiSearchResultDomainModelFacade domainModelFacade;
    private DateFormat dtfDateTime;
    LoggingUtils loggingUtils;
    private List selectedPillsStartAt;

    public DealCardBookingsViewHandler(Context context, String s, Channel channel, RapiSearchResultDomainModelFacade rapisearchresultdomainmodelfacade, CategoryIntentProperties categoryintentproperties)
    {
        super(context, s, channel);
        selectedPillsStartAt = new ArrayList();
        RoboGuice.getInjector(context).injectMembers(this);
        domainModelFacade = rapisearchresultdomainmodelfacade;
        categoryIntent = categoryintentproperties;
    }

    protected void fillMetadataWithExtraInfo(DealCardClickInfo dealcardclickinfo, JsonEncodedNSTField jsonencodednstfield)
    {
        super.fillMetadataWithExtraInfo(dealcardclickinfo, jsonencodednstfield);
        if (jsonencodednstfield instanceof DealImpressionMetadata)
        {
            dealcardclickinfo = (DealImpressionMetadata)jsonencodednstfield;
            dealcardclickinfo.type = categoryIntent.getCategoryIntent().toTrackingString();
            if (!selectedPillsStartAt.isEmpty())
            {
                dealcardclickinfo.DTFInfo = Strings.join(",", selectedPillsStartAt);
            }
        }
    }

    public Intent getDealCardClickIntent(DealCardClickInfo dealcardclickinfo, View view)
    {
        Intent intent = super.getDealCardClickIntent(dealcardclickinfo, view);
        DealSummary dealsummary = dealcardclickinfo.getDealSummary();
        view = null;
        if (dealcardclickinfo instanceof DealCardWithTimePillClickInfo)
        {
            view = ((DealCardWithTimePillClickInfo)dealcardclickinfo).getTimePill();
        }
        boolean flag;
        boolean flag1;
        if (view != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (dealsummary.bookableSegments != null && !dealsummary.bookableSegments.isEmpty())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag && !flag1)
        {
            return intent;
        }
        boolean flag2 = false;
        if (!flag)
        {
            view = (BookableSegments)dealsummary.bookableSegments.get(0);
            Object obj = getExactMatchBookableFragment(dealsummary);
            if (obj == null)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (obj != null)
            {
                dealcardclickinfo = ((BookableSegments) (obj)).startsAt;
            } else
            {
                dealcardclickinfo = ((BookableSegments) (view)).startsAt;
            }
            if (obj != null)
            {
                view = ((BookableSegments) (obj)).uuid;
            } else
            {
                view = ((BookableSegments) (view)).uuid;
            }
        } else
        {
            dealcardclickinfo = (String)view.getTag(0x7f10002c);
            Date date = (Date)view.getTag(0x7f10002a);
            view = dealcardclickinfo;
            dealcardclickinfo = date;
        }
        if (!categoryIntent.getCategoryIntent().equals(com.groupon.db.models.Features.SearchIntentCategory.UNKNOWN))
        {
            obj = new DateTimeFinderReservationDetails();
            obj.optionId = dealsummary.defaultOptionId;
            obj.partialIntent = flag2;
            obj.reservationDate = dealcardclickinfo;
            obj.segmentId = view;
            obj.searchIntentCategory = categoryIntent.getCategoryIntent();
            if (categoryIntent.isFoodAndDrinkIntent())
            {
                obj.partySize = domainModelFacade.getPartySize();
            }
            dealcardclickinfo = new Bundle(1);
            dealcardclickinfo.putParcelable("reservation_details", ((android.os.Parcelable) (obj)));
            intent.putExtra("reservation_details_bundle", dealcardclickinfo);
        }
        intent.putExtra("optionId", dealsummary.defaultOptionId);
        return intent;
    }

    protected BookableSegments getExactMatchBookableFragment(DealSummary dealsummary)
    {
        if (dealsummary.bookableSegments == null)
        {
            return null;
        }
        for (dealsummary = dealsummary.bookableSegments.iterator(); dealsummary.hasNext();)
        {
            BookableSegments bookablesegments = (BookableSegments)dealsummary.next();
            if (Boolean.TRUE.equals(bookablesegments.exactMatch))
            {
                return bookablesegments;
            }
        }

        return null;
    }

    protected EncodedNSTField getExtraInfo(DealCardClickInfo dealcardclickinfo)
    {
        DTFGenericMetadata dtfgenericmetadata = new DTFGenericMetadata();
        dtfgenericmetadata.type = categoryIntent.getCategoryIntent().toTrackingString();
        if (dealcardclickinfo instanceof DealCardWithTimePillClickInfo)
        {
            View view = ((DealCardWithTimePillClickInfo)dealcardclickinfo).getTimePill();
            if (view != null)
            {
                dtfgenericmetadata.tag = (Integer)view.getTag(0x7f10002b);
                dtfgenericmetadata.DTFValue = dtfDateTime.format(view.getTag(0x7f10002a));
            }
        }
        if (dtfgenericmetadata.DTFValue == null)
        {
            dealcardclickinfo = getExactMatchBookableFragment(dealcardclickinfo.getDealSummary());
            if (dealcardclickinfo != null)
            {
                dtfgenericmetadata.DTFValue = dtfDateTime.format(((BookableSegments) (dealcardclickinfo)).startsAt);
            }
        }
        return dtfgenericmetadata;
    }

    public void setSelectedPillsStartAt(List list)
    {
        selectedPillsStartAt = list;
    }
}
