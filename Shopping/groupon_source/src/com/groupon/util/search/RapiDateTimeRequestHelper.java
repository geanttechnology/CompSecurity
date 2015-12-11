// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util.search;

import com.groupon.fragment.RapiSearchResultDomainModelFacade;
import com.groupon.models.search.domain.DateTimeSearchFilter;
import com.groupon.models.search.domain.Filter;
import com.groupon.models.search.domain.FilterValue;
import com.groupon.util.DateTimeSearchHelper;
import com.groupon.util.RapiRequestProperties;
import com.groupon.util.ShowPropertyParam;
import java.util.List;

public class RapiDateTimeRequestHelper
{

    public static final int DEFAULT_SEGMENT_LIMIT = 3;

    public RapiDateTimeRequestHelper()
    {
    }

    private void addBookableSegmentOption(RapiRequestProperties rapirequestproperties)
    {
        ShowPropertyParam showpropertyparam1 = rapirequestproperties.findShowParam("deals");
        ShowPropertyParam showpropertyparam = showpropertyparam1;
        if (showpropertyparam1 == null)
        {
            showpropertyparam = new ShowPropertyParam("deals");
            rapirequestproperties.showParams.add(showpropertyparam);
        }
        showpropertyparam1 = showpropertyparam.findField("options");
        rapirequestproperties = showpropertyparam1;
        if (showpropertyparam1 == null)
        {
            rapirequestproperties = new ShowPropertyParam("options");
            showpropertyparam.addField(rapirequestproperties);
        }
        if (rapirequestproperties.findField("bookableSegments") == null)
        {
            rapirequestproperties.addField(new ShowPropertyParam("bookableSegments"));
        }
    }

    private void removeBookableSegmentOption(RapiRequestProperties rapirequestproperties)
    {
        rapirequestproperties = rapirequestproperties.findShowParam("deals");
        if (rapirequestproperties != null)
        {
            rapirequestproperties = rapirequestproperties.findField("options");
            if (rapirequestproperties != null)
            {
                rapirequestproperties.removeField("bookableSegments");
            }
        }
    }

    public void toggleReservation(RapiRequestProperties rapirequestproperties, boolean flag, RapiSearchResultDomainModelFacade rapisearchresultdomainmodelfacade, boolean flag1)
    {
        rapirequestproperties.removeFacetFilter("bookable");
        if (flag)
        {
            int i = rapisearchresultdomainmodelfacade.getPartySize();
            java.util.Date date = rapisearchresultdomainmodelfacade.getReservationDate();
            rapisearchresultdomainmodelfacade = rapisearchresultdomainmodelfacade.getReservationTime();
            DateTimeSearchFilter datetimesearchfilter = new DateTimeSearchFilter("bookable");
            datetimesearchfilter.addSelectedFacetValue(DateTimeSearchHelper.getBookableDayFilter(date));
            if (rapisearchresultdomainmodelfacade != null)
            {
                datetimesearchfilter.addSelectedFacetValue(DateTimeSearchHelper.getBookableTimeFilter(rapisearchresultdomainmodelfacade));
                datetimesearchfilter.addSelectedFacetValue(DateTimeSearchHelper.getBookableBufferFilter(0, 1, 0));
            }
            if (flag1)
            {
                datetimesearchfilter.addSelectedFacetValue(DateTimeSearchHelper.getPartySizeFilter(i));
            }
            rapirequestproperties.facetFilters.add(datetimesearchfilter);
            addBookableSegmentOption(rapirequestproperties);
            rapirequestproperties.segmentLimit = 3;
            return;
        } else
        {
            rapirequestproperties.facetFilters.add(new DateTimeSearchFilter("bookable"));
            removeBookableSegmentOption(rapirequestproperties);
            rapirequestproperties.segmentLimit = 0;
            return;
        }
    }

    public void updateReservationDetails(RapiRequestProperties rapirequestproperties, RapiSearchResultDomainModelFacade rapisearchresultdomainmodelfacade, com.groupon.db.models.Features.SearchIntentCategory searchintentcategory)
    {
        this;
        JVM INSTR monitorenter ;
        DateTimeSearchFilter datetimesearchfilter;
        rapirequestproperties.removeFacetFilter("bookable");
        datetimesearchfilter = new DateTimeSearchFilter("bookable");
        if (!rapisearchresultdomainmodelfacade.isMakeAReservationToggled()) goto _L2; else goto _L1
_L1:
        datetimesearchfilter.addSelectedFacetValue(DateTimeSearchHelper.getBookableDayFilter(rapisearchresultdomainmodelfacade.getReservationDate()));
        if (rapisearchresultdomainmodelfacade.getReservationTime() != null)
        {
            datetimesearchfilter.addSelectedFacetValue(DateTimeSearchHelper.getBookableTimeFilter(rapisearchresultdomainmodelfacade.getReservationTime()));
            datetimesearchfilter.addSelectedFacetValue(DateTimeSearchHelper.getBookableBufferFilter(0, 1, 0));
        }
        if (searchintentcategory != com.groupon.db.models.Features.SearchIntentCategory.FOOD_AND_DRINK) goto _L4; else goto _L3
_L3:
        datetimesearchfilter.addSelectedFacetValue(DateTimeSearchHelper.getPartySizeFilter(rapisearchresultdomainmodelfacade.getPartySize()));
_L2:
        rapirequestproperties.facetFilters.add(datetimesearchfilter);
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        if (searchintentcategory != com.groupon.db.models.Features.SearchIntentCategory.HEALTH_BEAUTY_WELLNESS) goto _L2; else goto _L5
_L5:
        rapirequestproperties.removeFilter("category");
        if (!rapisearchresultdomainmodelfacade.getServiceType().equals("all"))
        {
            searchintentcategory = new Filter("category");
            searchintentcategory.addFilterValue(new FilterValue("category", rapisearchresultdomainmodelfacade.getServiceType()));
            rapirequestproperties.filters.add(searchintentcategory);
        }
        rapirequestproperties.finderCardFilter = null;
          goto _L2
        rapirequestproperties;
        throw rapirequestproperties;
    }
}
