// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.os.Parcel;
import android.os.Parcelable;
import com.groupon.models.Place;
import com.groupon.models.category.Category;
import com.groupon.models.search.domain.FacetFilter;
import com.groupon.models.search.domain.Filter;
import com.groupon.models.search.domain.SortMethod;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            ShowPropertyParam

public class RapiRequestProperties
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RapiRequestProperties createFromParcel(Parcel parcel)
        {
            return new RapiRequestProperties(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RapiRequestProperties[] newArray(int i)
        {
            return new RapiRequestProperties[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String availableFacetGroupFiltersFromDeepLink;
    public String bookable;
    public String currentCategoryId;
    public Place currentLocation;
    public String deckId;
    public String deepLinkWithApiParameters;
    public Place expressedLocation;
    public List facetFilters;
    public List filters;
    public String finderCardFilter;
    public int limit;
    public int offset;
    public String pageType;
    public int radiusKm;
    public String searchChannelFilter;
    public String searchQuery;
    public int segmentLimit;
    public java.util.Map.Entry selectedCategory;
    public List showParams;
    public ArrayList smuggledDeals;
    public SortMethod sortMethod;

    public RapiRequestProperties()
    {
        facetFilters = new ArrayList();
        filters = new ArrayList();
        smuggledDeals = new ArrayList();
        showParams = new ArrayList();
    }

    protected RapiRequestProperties(Parcel parcel)
    {
        facetFilters = new ArrayList();
        filters = new ArrayList();
        smuggledDeals = new ArrayList();
        showParams = new ArrayList();
        searchQuery = parcel.readString();
        expressedLocation = (Place)parcel.readValue(com/groupon/models/Place.getClassLoader());
        currentLocation = (Place)parcel.readValue(com/groupon/models/Place.getClassLoader());
        selectedCategory = readMapEntry(parcel);
        currentCategoryId = parcel.readString();
        availableFacetGroupFiltersFromDeepLink = parcel.readString();
        deepLinkWithApiParameters = parcel.readString();
        radiusKm = parcel.readInt();
        searchChannelFilter = parcel.readString();
        pageType = parcel.readString();
        parcel.readList(facetFilters, com/groupon/models/search/domain/FacetFilter.getClassLoader());
        parcel.readList(filters, com/groupon/models/search/domain/FacetFilter.getClassLoader());
        parcel.readList(smuggledDeals, java/lang/String.getClassLoader());
        limit = parcel.readInt();
        offset = parcel.readInt();
        sortMethod = (SortMethod)parcel.readParcelable(com/groupon/models/search/domain/SortMethod.getClassLoader());
        parcel.readList(showParams, com/groupon/util/ShowPropertyParam.getClassLoader());
        finderCardFilter = parcel.readString();
        segmentLimit = parcel.readInt();
        deckId = parcel.readString();
        bookable = parcel.readString();
    }

    private java.util.Map.Entry readMapEntry(Parcel parcel)
    {
        Category category = (Category)parcel.readValue(com/groupon/models/category/Category.getClassLoader());
        if (category != null)
        {
            return new java.util.AbstractMap.SimpleEntry(category, Integer.valueOf(parcel.readInt()));
        } else
        {
            return null;
        }
    }

    private void writeMapEntry(java.util.Map.Entry entry, Parcel parcel, int i)
    {
        if (entry != null)
        {
            parcel.writeValue(entry.getKey());
            parcel.writeInt(((Integer)entry.getValue()).intValue());
            return;
        } else
        {
            parcel.writeValue(null);
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Filter findFilter(String s)
    {
        for (Iterator iterator = filters.iterator(); iterator.hasNext();)
        {
            Filter filter = (Filter)iterator.next();
            if (filter.filterId.equals(s))
            {
                return filter;
            }
        }

        return null;
    }

    public ShowPropertyParam findShowParam(String s)
    {
        for (Iterator iterator = showParams.iterator(); iterator.hasNext();)
        {
            ShowPropertyParam showpropertyparam = (ShowPropertyParam)iterator.next();
            if (Strings.equals(showpropertyparam.getProperty(), s))
            {
                return showpropertyparam;
            }
        }

        return null;
    }

    public int hashCode()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(searchQuery);
        stringbuilder.append(String.format("%s,%s", new Object[] {
            Double.valueOf(expressedLocation.lat), Double.valueOf(expressedLocation.lng)
        }));
        stringbuilder.append(pageType);
        Object obj = new ArrayList();
        for (Iterator iterator1 = facetFilters.iterator(); iterator1.hasNext(); ((List) (obj)).add(((FacetFilter)iterator1.next()).asUrlParam())) { }
        Collections.sort(((List) (obj)));
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); stringbuilder.append((String)((Iterator) (obj)).next())) { }
        for (Iterator iterator = filters.iterator(); iterator.hasNext(); stringbuilder.append(((Filter)iterator.next()).asUrlParam())) { }
        if (sortMethod != null)
        {
            stringbuilder.append(sortMethod.id);
        }
        return stringbuilder.toString().hashCode();
    }

    public void removeFacetFilter(String s)
    {
        Object obj = null;
        Iterator iterator = facetFilters.iterator();
        FacetFilter facetfilter;
        do
        {
            facetfilter = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            facetfilter = (FacetFilter)iterator.next();
        } while (!Strings.equals(s, facetfilter.facetId));
        facetFilters.remove(facetfilter);
    }

    public void removeFilter(String s)
    {
        Object obj = null;
        Iterator iterator = filters.iterator();
        Filter filter;
        do
        {
            filter = obj;
            if (!iterator.hasNext())
            {
                break;
            }
            filter = (Filter)iterator.next();
        } while (!Strings.equals(s, filter.filterId));
        filters.remove(filter);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(searchQuery);
        parcel.writeValue(expressedLocation);
        parcel.writeValue(currentLocation);
        writeMapEntry(selectedCategory, parcel, i);
        parcel.writeString(currentCategoryId);
        parcel.writeString(availableFacetGroupFiltersFromDeepLink);
        parcel.writeString(deepLinkWithApiParameters);
        parcel.writeInt(radiusKm);
        parcel.writeString(searchChannelFilter);
        parcel.writeString(pageType);
        parcel.writeList(facetFilters);
        parcel.writeList(filters);
        parcel.writeList(smuggledDeals);
        parcel.writeInt(limit);
        parcel.writeInt(offset);
        parcel.writeParcelable(sortMethod, i);
        parcel.writeList(showParams);
        parcel.writeString(finderCardFilter);
        parcel.writeInt(segmentLimit);
        parcel.writeString(deckId);
        parcel.writeString(bookable);
    }

}
