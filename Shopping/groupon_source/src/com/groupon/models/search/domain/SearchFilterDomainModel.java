// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.search.domain;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.Channel;
import com.groupon.events.FilterDataChangedLocallyEvent;
import com.groupon.events.SearchFilterSelectedFacetUpdatedEvent;
import com.groupon.models.search.data.Facet;
import com.groupon.models.search.data.FacetValue;
import com.groupon.util.OnSearchFilterUpdatedListener;
import com.squareup.otto.Bus;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.groupon.models.search.domain:
//            SortMethod, SortMethodWrapper, SearchFilterDomainModelListener, FacetFilter

public class SearchFilterDomainModel
    implements Parcelable, OnSearchFilterUpdatedListener
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SearchFilterDomainModel createFromParcel(Parcel parcel)
        {
            return new SearchFilterDomainModel(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SearchFilterDomainModel[] newArray(int i)
        {
            return new SearchFilterDomainModel[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    private Bus bus;
    private Channel channel;
    private int dealCount;
    private HashMap facetToSelectedFacetValueMap;
    private List facets;
    public boolean includeBrandFacet;
    public boolean includeCategoryAttributeFacet;
    private List searchFilterDomainModelListeners;
    private SortMethod sortMethod;
    public final List sortMethods;

    public SearchFilterDomainModel(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        facets = new ArrayList();
        sortMethod = SortMethod.Methods.RELEVANCE;
        facetToSelectedFacetValueMap = new HashMap();
        sortMethods = new ArrayList();
        searchFilterDomainModelListeners = new ArrayList();
        parcel.readList(facets, com/groupon/models/search/data/Facet.getClassLoader());
        sortMethod = (SortMethod)parcel.readParcelable(com/groupon/models/search/domain/SortMethod.getClassLoader());
        facetToSelectedFacetValueMap = readFacetToSelectedFacetValueMap(parcel);
        dealCount = parcel.readInt();
        parcel.readList(sortMethods, com/groupon/models/search/domain/SortMethodWrapper.getClassLoader());
        boolean flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        includeBrandFacet = flag;
        if (parcel.readByte() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        includeCategoryAttributeFacet = flag;
    }

    public SearchFilterDomainModel(Channel channel1)
    {
        facets = new ArrayList();
        sortMethod = SortMethod.Methods.RELEVANCE;
        facetToSelectedFacetValueMap = new HashMap();
        sortMethods = new ArrayList();
        searchFilterDomainModelListeners = new ArrayList();
        channel = channel1;
        sortMethods.clear();
        Iterator iterator = SortMethod.Methods.values.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            SortMethod sortmethod = (SortMethod)iterator.next();
            if (sortmethod != SortMethod.Methods.DISTANCE || channel1 != Channel.GOODS && channel1 != Channel.SHOPPING)
            {
                sortMethods.add(new SortMethodWrapper(sortmethod));
            }
        } while (true);
        selectDefaultSortMethod();
    }

    private void addSelectedFacetValue(Facet facet, FacetValue facetvalue)
    {
        if (!facet.isMultiSelect())
        {
            for (Iterator iterator = facet.getValues().iterator(); iterator.hasNext();)
            {
                ((FacetValue)iterator.next()).isSelected = false;
            }

            ((List)facetToSelectedFacetValueMap.get(facet)).clear();
        }
        ((List)facetToSelectedFacetValueMap.get(facet)).add(facetvalue);
        facetvalue.isSelected = true;
        if (bus != null)
        {
            bus.post(new FilterDataChangedLocallyEvent());
        }
    }

    private List createExplicitFacetList()
    {
        LinkedList linkedlist = new LinkedList(Arrays.asList(new String[] {
            "price", "distance", "topcategory|category|subcategory|subcategory2"
        }));
        if (includeBrandFacet)
        {
            linkedlist.add("brand_uuid");
        }
        if (includeCategoryAttributeFacet)
        {
            linkedlist.add("category_attributes");
        }
        return linkedlist;
    }

    private SortMethod getDefaultSortMethod()
    {
        if (channel == Channel.GETAWAYS)
        {
            return SortMethod.Methods.DISTANCE;
        } else
        {
            return SortMethod.Methods.RELEVANCE;
        }
    }

    private SortMethodWrapper getSortMethodWrapper(SortMethod sortmethod)
    {
        for (Iterator iterator = sortMethods.iterator(); iterator.hasNext();)
        {
            SortMethodWrapper sortmethodwrapper = (SortMethodWrapper)iterator.next();
            if (sortmethodwrapper.sortMethod.equals(sortmethod))
            {
                return sortmethodwrapper;
            }
        }

        return null;
    }

    private HashMap readFacetToSelectedFacetValueMap(Parcel parcel)
    {
        HashMap hashmap = new HashMap();
        int j = parcel.readInt();
        for (int i = 0; i < j; i++)
        {
            Facet facet = (Facet)parcel.readParcelable(com/groupon/models/search/data/Facet.getClassLoader());
            ArrayList arraylist = new ArrayList();
            parcel.readList(arraylist, com/groupon/models/search/data/FacetValue.getClassLoader());
            hashmap.put(facet, arraylist);
        }

        return hashmap;
    }

    private void removeSelectedFacetValue(Facet facet, FacetValue facetvalue)
    {
        boolean flag = facetvalue.hasSelectedChildren();
        Iterator iterator = ((List)facetToSelectedFacetValueMap.get(facet)).iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            FacetValue facetvalue1 = (FacetValue)iterator.next();
            if (!facetvalue1.id.equals(facetvalue.id))
            {
                continue;
            }
            ((List)facetToSelectedFacetValueMap.get(facet)).remove(facetvalue1);
            if (facetvalue.children.size() > 0)
            {
                unselectChildrenRecursively(facet, facetvalue);
            }
            break;
        } while (true);
        facetvalue.isSelected = flag;
        if (flag)
        {
            ((List)facetToSelectedFacetValueMap.get(facet)).add(facetvalue);
        }
        if (bus != null)
        {
            bus.post(new FilterDataChangedLocallyEvent());
        }
    }

    private void selectDefaultSortMethod()
    {
        Iterator iterator = sortMethods.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            SortMethodWrapper sortmethodwrapper = (SortMethodWrapper)iterator.next();
            sortmethodwrapper.isSelected = false;
            if (sortmethodwrapper.sortMethod.equals(getDefaultSortMethod()))
            {
                sortmethodwrapper.isSelected = true;
            }
        } while (true);
        sortMethod = getDefaultSortMethod();
    }

    private void unselectChildrenRecursively(Facet facet, FacetValue facetvalue)
    {
        ((List)facetToSelectedFacetValueMap.get(facet)).remove(facetvalue);
        facetvalue.isSelected = false;
        for (facetvalue = facetvalue.children.iterator(); facetvalue.hasNext(); unselectChildrenRecursively(facet, (FacetValue)facetvalue.next())) { }
    }

    private void writeFacetToSelectedFacetValueMap(Parcel parcel, int i)
    {
        parcel.writeInt(facetToSelectedFacetValueMap.size());
        Facet facet;
        for (Iterator iterator = facetToSelectedFacetValueMap.keySet().iterator(); iterator.hasNext(); parcel.writeList((List)facetToSelectedFacetValueMap.get(facet)))
        {
            facet = (Facet)iterator.next();
            parcel.writeParcelable(facet, i);
        }

    }

    public void addSearchFilterDomainModelListener(SearchFilterDomainModelListener searchfilterdomainmodellistener)
    {
        if (!searchFilterDomainModelListeners.contains(searchfilterdomainmodellistener))
        {
            searchFilterDomainModelListeners.add(searchfilterdomainmodellistener);
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void facetValueSelectionChanged(Facet facet, FacetValue facetvalue, boolean flag)
    {
        if (flag)
        {
            addSelectedFacetValue(facet, facetvalue);
        } else
        {
            removeSelectedFacetValue(facet, facetvalue);
        }
        for (facet = searchFilterDomainModelListeners.iterator(); facet.hasNext(); ((SearchFilterDomainModelListener)facet.next()).onSearchFilterDomainModelSyncRequested()) { }
        if (bus != null)
        {
            bus.post(new SearchFilterSelectedFacetUpdatedEvent(getFilteredFacetCount()));
        }
    }

    public List generateFilters()
    {
        Object obj = createExplicitFacetList();
        ArrayList arraylist = new ArrayList();
        Iterator iterator = facets.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj2 = (Facet)iterator.next();
            Object obj1 = getSelectedFacetValues(((Facet) (obj2)));
            if (((List) (obj1)).size() > 0)
            {
                ((List) (obj)).remove(((Facet) (obj2)).id);
                obj2 = ((Facet) (obj2)).createEmptyFacetFilter(((Facet) (obj2)).id);
                for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((FacetFilter) (obj2)).addSelectedFacetValue((FacetValue)((Iterator) (obj1)).next())) { }
                arraylist.add(obj2);
            }
        } while (true);
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(new FacetFilter((String)((Iterator) (obj)).next()))) { }
        return arraylist;
    }

    public int getDealCount()
    {
        return dealCount;
    }

    public List getFacets()
    {
        return facets;
    }

    public int getFilteredFacetCount()
    {
        int i = 0;
        Iterator iterator = facets.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (getSelectedFacetValues((Facet)iterator.next()).size() > 0)
            {
                i++;
            }
        } while (true);
        int j = i;
        if (!getDefaultSortMethod().equals(sortMethod))
        {
            j = i + 1;
        }
        return j;
    }

    public List getSelectedFacetValues(Facet facet)
    {
        return (List)facetToSelectedFacetValueMap.get(facet);
    }

    public SortMethod getSelectedSortMethod()
    {
        return sortMethod;
    }

    public SearchFilterSelectedFacetUpdatedEvent provideFilteredFacetCount()
    {
        return new SearchFilterSelectedFacetUpdatedEvent(getFilteredFacetCount());
    }

    public void registerBus(Bus bus1)
    {
        unRegisterBus();
        bus = bus1;
        bus.register(this);
    }

    public void removeSearchFilterDomainModelListener(SearchFilterDomainModelListener searchfilterdomainmodellistener)
    {
        searchFilterDomainModelListeners.remove(searchfilterdomainmodellistener);
    }

    public void reset()
    {
        facetToSelectedFacetValueMap = new HashMap();
        setFacets(facets);
        selectDefaultSortMethod();
        for (Iterator iterator = searchFilterDomainModelListeners.iterator(); iterator.hasNext(); ((SearchFilterDomainModelListener)iterator.next()).onSearchFilterDomainModelSyncRequested()) { }
        if (bus != null)
        {
            bus.post(new SearchFilterSelectedFacetUpdatedEvent(getFilteredFacetCount()));
        }
    }

    public void setDealCount(int i)
    {
        dealCount = i;
        for (Iterator iterator = searchFilterDomainModelListeners.iterator(); iterator.hasNext(); ((SearchFilterDomainModelListener)iterator.next()).onDealCountUpdated(dealCount)) { }
    }

    public void setFacets(List list)
    {
        facets = list;
        for (list = list.iterator(); list.hasNext();)
        {
            Facet facet = (Facet)list.next();
            if (facetToSelectedFacetValueMap.get(facet) == null)
            {
                facetToSelectedFacetValueMap.put(facet, new ArrayList());
            }
            Iterator iterator = facet.getValues().iterator();
            while (iterator.hasNext()) 
            {
                ((FacetValue)iterator.next()).derivedParentFacetId = facet.id;
            }
        }

        SearchFilterDomainModelListener searchfilterdomainmodellistener;
        for (list = searchFilterDomainModelListeners.iterator(); list.hasNext(); searchfilterdomainmodellistener.onSearchFilterDomainModelSyncCompleted())
        {
            searchfilterdomainmodellistener = (SearchFilterDomainModelListener)list.next();
            searchfilterdomainmodellistener.onFacetsUpdated();
        }

    }

    public void sortValueSelected(SortMethodWrapper sortmethodwrapper)
    {
        for (Iterator iterator = sortMethods.iterator(); iterator.hasNext();)
        {
            SortMethodWrapper sortmethodwrapper1 = (SortMethodWrapper)iterator.next();
            if (sortmethodwrapper.sortMethod.id.equals(sortmethodwrapper1.sortMethod.id))
            {
                sortmethodwrapper1.isSelected = true;
            } else
            {
                sortmethodwrapper1.isSelected = false;
            }
        }

        sortMethod = sortmethodwrapper.sortMethod;
        for (sortmethodwrapper = searchFilterDomainModelListeners.iterator(); sortmethodwrapper.hasNext(); ((SearchFilterDomainModelListener)sortmethodwrapper.next()).onSearchFilterDomainModelSyncRequested()) { }
        if (bus != null)
        {
            bus.post(new FilterDataChangedLocallyEvent());
        }
    }

    public void unRegisterBus()
    {
        if (bus == null)
        {
            return;
        } else
        {
            bus.unregister(this);
            bus = null;
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeList(facets);
        parcel.writeParcelable(sortMethod, i);
        writeFacetToSelectedFacetValueMap(parcel, i);
        parcel.writeInt(dealCount);
        parcel.writeList(sortMethods);
        if (includeBrandFacet)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (includeCategoryAttributeFacet)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }

}
