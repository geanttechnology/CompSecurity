// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.content.ListContent;
import com.ebay.nautilus.domain.data.Event;
import com.ebay.nautilus.domain.net.api.events.EventItemsRequest;
import com.ebay.nautilus.domain.net.api.events.EventItemsResponse;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.Request;
import com.ebay.nautilus.kernel.net.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            UserContextObservingDataManager, UserContextDataManager, PagedListManager

public final class EventItemsDataManager extends UserContextObservingDataManager
{
    private final class EventItemsPageLoader extends PagedListManager
    {

        private final EbayCountry country;
        final EventItemsDataManager this$0;

        protected ResultStatus getPage(int i, ArrayList arraylist)
            throws InterruptedException
        {
            Object obj = EventItemsDataManager.getRequestParams(i, EventItemsDataManager.eventId, country, currentCategoryFilters, currentSortOrder, currentMinPrice, currentMaxPrice);
            obj = new EventItemsRequest(country, ((com.ebay.nautilus.domain.net.api.events.EventItemsRequest.EventRequestParams) (obj)));
            EventItemsResponse eventitemsresponse = (EventItemsResponse)sendRequest(((Request) (obj)));
            obj = eventitemsresponse.getResultStatus();
            if (!((ResultStatus) (obj)).hasError())
            {
                currentEventData = eventitemsresponse.event;
                if (currentEventData != null)
                {
                    com.ebay.nautilus.domain.data.Event.PaginationResponse paginationresponse = currentEventData.paginationResponse;
                    totalNumberOfItems = (int)currentEventData.matchCount;
                    highestPageIndex = paginationresponse.totalPages;
                    if (currentEventData.searchRecord != null)
                    {
                        for (Iterator iterator = currentEventData.searchRecord.iterator(); iterator.hasNext(); arraylist.add((com.ebay.nautilus.domain.data.Event.SearchRecord)iterator.next())) { }
                    }
                }
            }
            return ((ResultStatus) (obj));
        }

        protected void handleLoadListResult(ListContent listcontent)
        {
            ((Observer)searchRecord).onEventListContentChanged(EventItemsDataManager.this, listcontent);
        }

        protected void onLoadStarted()
        {
        }

        public EventItemsPageLoader(EbayCountry ebaycountry)
        {
            this$0 = EventItemsDataManager.this;
            super(EventItemsDataManager.MAX_ENTRIES_PER_PAGE);
            country = ebaycountry;
            totalNumberOfItems = 0x7ffffffe;
            highestPageIndex = 0x7ffffffe;
        }
    }

    public static final class KeyParams extends UserContextObservingDataManager.KeyBase
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public KeyParams createFromParcel(Parcel parcel)
            {
                return new KeyParams(parcel.readString());
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public KeyParams[] newArray(int i)
            {
                return new KeyParams[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public final String eventId;

        protected EventItemsDataManager create(EbayContext ebaycontext)
        {
            return new EventItemsDataManager(ebaycontext, this);
        }

        protected volatile UserContextObservingDataManager create(EbayContext ebaycontext)
        {
            return create(ebaycontext);
        }

        public boolean equals(Object obj)
        {
            return (obj instanceof KeyParams) && ((KeyParams)obj).eventId.equals(eventId);
        }

        public int hashCode()
        {
            return super.hashCode() * 31 + eventId.hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append("eventId:").append(eventId).toString();
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(eventId);
        }


        public KeyParams(String s)
        {
            eventId = s;
            if (s == null)
            {
                throw new IllegalStateException("eventId must be non-null.");
            } else
            {
                return;
            }
        }
    }

    public static interface Observer
    {

        public abstract void onEventListContentChanged(EventItemsDataManager eventitemsdatamanager, ListContent listcontent);
    }


    private static final String CURRENT_SITE = "CurrentSite";
    public static int MAX_ENTRIES_PER_PAGE = 0;
    public static final int MIN_ENTRIES = 1;
    private static String eventId;
    static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("EventItems", 3, "EventItemsDataManager");
    private EbayCountry country;
    private final List currentCategoryFilters = new ArrayList();
    private Event currentEventData;
    private double currentMaxPrice;
    private double currentMinPrice;
    private com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder currentSortOrder;
    private EventItemsPageLoader eventItemsPageLoader;
    private boolean isCountryInitialized;

    EventItemsDataManager(EbayContext ebaycontext, KeyParams keyparams)
    {
        super(ebaycontext, com/ebay/nautilus/domain/content/dm/EventItemsDataManager$Observer, keyparams);
        currentMinPrice = -1D;
        currentMaxPrice = -1D;
        eventId = keyparams.eventId;
        currentSortOrder = null;
    }

    private static ArrayList getCurrencyAttributeNameValues(EbayCountry ebaycountry)
    {
        ArrayList arraylist = new ArrayList();
        com.ebay.nautilus.domain.net.api.events.EventItemsRequest.AttributeNameValue attributenamevalue = new com.ebay.nautilus.domain.net.api.events.EventItemsRequest.AttributeNameValue();
        attributenamevalue.name = "currency";
        attributenamevalue.value = ebaycountry.getCurrency().getCurrencyCode();
        arraylist.add(attributenamevalue);
        return arraylist;
    }

    private static com.ebay.nautilus.domain.net.api.events.EventItemsRequest.GlobalAspectConstraint getGlobalAspectConstraint(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.ConstraintType constrainttype, String s, List list)
    {
        com.ebay.nautilus.domain.net.api.events.EventItemsRequest.GlobalAspectConstraint globalaspectconstraint = new com.ebay.nautilus.domain.net.api.events.EventItemsRequest.GlobalAspectConstraint();
        globalaspectconstraint.constraintType = constrainttype;
        constrainttype = new ArrayList();
        ArrayList arraylist = new ArrayList();
        arraylist.add(s);
        for (s = arraylist.iterator(); s.hasNext(); constrainttype.add((String)s.next())) { }
        globalaspectconstraint.value = constrainttype;
        if (list != null && list.size() > 0)
        {
            globalaspectconstraint.paramNameValue = list;
        }
        return globalaspectconstraint;
    }

    static com.ebay.nautilus.domain.net.api.events.EventItemsRequest.EventRequestParams getRequestParams(int i, String s, EbayCountry ebaycountry, List list, com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder sortorder, double d, double d1)
    {
        com.ebay.nautilus.domain.net.api.events.EventItemsRequest.PaginationInput paginationinput = new com.ebay.nautilus.domain.net.api.events.EventItemsRequest.PaginationInput(MAX_ENTRIES_PER_PAGE, i, 1);
        com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SearchConstraints searchconstraints = new com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SearchConstraints();
        searchconstraints.globalAspect = new ArrayList();
        searchconstraints.globalAspect.add(getGlobalAspectConstraint(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.ConstraintType.PreferredLocation, "CurrentSite", null));
        ArrayList arraylist = getCurrencyAttributeNameValues(ebaycountry);
        i = 0;
        if (d1 >= 0.0D)
        {
            i = 1;
            searchconstraints.globalAspect.add(getGlobalAspectConstraint(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.ConstraintType.MaxPrice, Double.toString(d1), arraylist));
        }
        if (d >= 0.0D && (i == 0 || d <= d1))
        {
            searchconstraints.globalAspect.add(getGlobalAspectConstraint(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.ConstraintType.MinPrice, Double.toString(d), arraylist));
        }
        if (list != null)
        {
            int j = list.size();
            if (j > 0)
            {
                searchconstraints.scopedAspect = new ArrayList();
            }
            for (i = 0; i < j; i++)
            {
                com.ebay.nautilus.domain.net.api.events.EventItemsRequest.ScopedAspectConstraint scopedaspectconstraint = new com.ebay.nautilus.domain.net.api.events.EventItemsRequest.ScopedAspectConstraint();
                com.ebay.nautilus.domain.net.api.events.EventItemsRequest.AspectScope aspectscope = new com.ebay.nautilus.domain.net.api.events.EventItemsRequest.AspectScope();
                String s1 = ((com.ebay.nautilus.domain.data.Event.Category)list.get(i)).name;
                aspectscope.type = "CUSTOM_CATEGORY_NAME";
                aspectscope.value = s1;
                scopedaspectconstraint.scope = aspectscope;
                searchconstraints.scopedAspect.add(scopedaspectconstraint);
            }

        }
        list = new com.ebay.nautilus.domain.net.api.events.EventItemsRequest.OutputSelectors();
        list.OUTPUT_SELECTOR = new ArrayList();
        ((com.ebay.nautilus.domain.net.api.events.EventItemsRequest.OutputSelectors) (list)).OUTPUT_SELECTOR.add(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.OutputSelector.itemWithShippingInfo);
        list.HISTOGRAMS = new ArrayList();
        ((com.ebay.nautilus.domain.net.api.events.EventItemsRequest.OutputSelectors) (list)).HISTOGRAMS.add(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.HistogramSelector.CATEGORY_HISTOGRAM);
        ((com.ebay.nautilus.domain.net.api.events.EventItemsRequest.OutputSelectors) (list)).HISTOGRAMS.add(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.HistogramSelector.ASPECT_HISTOGRAM);
        return new com.ebay.nautilus.domain.net.api.events.EventItemsRequest.EventRequestParams(s, ebaycountry.getSiteId(), paginationinput, searchconstraints, list, sortorder);
    }

    public boolean addCategoryFilter(com.ebay.nautilus.domain.data.Event.Category category)
    {
        if (category != null && !currentCategoryFilters.contains(category))
        {
            currentCategoryFilters.clear();
            currentCategoryFilters.add(category);
            return true;
        } else
        {
            return false;
        }
    }

    public void forceReloadData()
    {
        NautilusKernel.verifyMain();
        if (eventItemsPageLoader != null)
        {
            eventItemsPageLoader.markDirty();
            eventItemsPageLoader = null;
        }
        loadPage(1, null);
    }

    public List getCategories()
    {
        ArrayList arraylist1 = new ArrayList();
        ArrayList arraylist;
        if (currentEventData != null && currentEventData.searchRefinement != null && currentEventData.searchRefinement.categoryHistogram != null)
        {
            Iterator iterator = currentEventData.searchRefinement.categoryHistogram.iterator();
            do
            {
                arraylist = arraylist1;
                if (!iterator.hasNext())
                {
                    break;
                }
                arraylist1.add(((com.ebay.nautilus.domain.data.Event.CategoryHistogram)iterator.next()).category);
            } while (true);
        } else
        {
            arraylist = null;
        }
        return arraylist;
    }

    public List getSortOptions()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder.None);
        arraylist.add(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder.CurrentPriceLowest);
        arraylist.add(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder.CurrentPriceHighest);
        return arraylist;
    }

    public void loadData(Observer observer)
    {
    }

    public volatile void loadData(Object obj)
    {
        loadData((Observer)obj);
    }

    public void loadPage(int i, Observer observer)
    {
        NautilusKernel.verifyMain();
        if (i < 1)
        {
            throw new IllegalArgumentException("pageNumber must be larger than zero (0).");
        }
        if (country == null)
        {
            throw new IllegalStateException("this.country is null");
        }
        if (eventItemsPageLoader == null)
        {
            eventItemsPageLoader = new EventItemsPageLoader(country);
        }
        ListContent listcontent = eventItemsPageLoader.getData();
        if (observer != null && listcontent != null && listcontent.getPagesLoaded() >= i)
        {
            observer.onEventListContentChanged(this, listcontent);
            return;
        } else
        {
            eventItemsPageLoader.load(i);
            return;
        }
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        if (log.isLoggable)
        {
            log.log((new StringBuilder()).append(".onCurrentCountryChanged country=").append(ebaycountry.toString()).toString());
        }
        country = ebaycountry;
        ebaycountry.getCurrency();
        if (!isCountryInitialized)
        {
            isCountryInitialized = true;
            return;
        } else
        {
            forceReloadData();
            return;
        }
    }

    protected void onLastObserverUnregistered()
    {
        if (log.isLoggable)
        {
            log.log(".onLastObserverUnregistered");
        }
        if (eventItemsPageLoader != null)
        {
            eventItemsPageLoader.markDirty();
        }
        eventItemsPageLoader = null;
    }

    public void resetAllSortAndFilter()
    {
        currentCategoryFilters.clear();
        currentSortOrder = null;
        currentMaxPrice = -1D;
        currentMinPrice = -1D;
    }

    public void setMaxPrice(double d)
    {
        currentMaxPrice = d;
    }

    public void setMinPrice(double d)
    {
        currentMinPrice = d;
    }

    public void setSortOrder(com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder sortorder)
    {
        currentSortOrder = sortorder;
        if (sortorder == com.ebay.nautilus.domain.net.api.events.EventItemsRequest.SortOrder.None)
        {
            currentSortOrder = null;
        }
    }

    static 
    {
        MAX_ENTRIES_PER_PAGE = 25;
    }









/*
    static Event access$602(EventItemsDataManager eventitemsdatamanager, Event event)
    {
        eventitemsdatamanager.currentEventData = event;
        return event;
    }

*/

}
