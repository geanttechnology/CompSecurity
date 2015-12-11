// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Trend extends BaseApiResponse
    implements Parcelable
{
    public static class Image
    {

        public String url;

        public Image()
        {
        }
    }

    public static class ListingSummary
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public ListingSummary createFromParcel(Parcel parcel)
            {
                return new ListingSummary(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public ListingSummary[] newArray(int i)
            {
                return new ListingSummary[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public TextSpanValueProperty displayPrice;
        public Image image;
        public String listingId;
        public String title;
        public String url;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeString(listingId);
            parcel.writeString(title);
            parcel.writeString(image.url);
            parcel.writeDouble(((BaseCommonType.Amount)displayPrice.value).value);
            parcel.writeString(((BaseCommonType.Amount)displayPrice.value).currency);
            parcel.writeInt(displayPrice.textSpans.size());
            for (Iterator iterator = displayPrice.textSpans.iterator(); iterator.hasNext(); parcel.writeString(((TextSpan)iterator.next()).text)) { }
            parcel.writeString(url);
        }


        public ListingSummary(Parcel parcel)
        {
            listingId = parcel.readString();
            title = parcel.readString();
            image = new Image();
            image.url = parcel.readString();
            displayPrice = new TextSpanValueProperty();
            displayPrice.value = new BaseCommonType.Amount();
            ((BaseCommonType.Amount)displayPrice.value).value = parcel.readDouble();
            ((BaseCommonType.Amount)displayPrice.value).currency = parcel.readString();
            int i = parcel.readInt();
            displayPrice.textSpans = new ArrayList(i);
            for (; i > 0; i--)
            {
                TextSpan textspan = new TextSpan();
                textspan.text = parcel.readString();
                displayPrice.textSpans.add(textspan);
            }

            url = parcel.readString();
        }
    }

    public static class RankDelta
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public RankDelta createFromParcel(Parcel parcel)
            {
                return new RankDelta(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public RankDelta[] newArray(int i)
            {
                return new RankDelta[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public String change;
        public TextSpanValueProperty delta;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeInt(((Integer)delta.value).intValue());
            parcel.writeInt(delta.textSpans.size());
            for (Iterator iterator = delta.textSpans.iterator(); iterator.hasNext(); parcel.writeString(((TextSpan)iterator.next()).text)) { }
            parcel.writeString(change);
        }


        public RankDelta(Parcel parcel)
        {
            delta = new TextSpanValueProperty();
            delta.value = Integer.valueOf(parcel.readInt());
            int i = parcel.readInt();
            delta.textSpans = new ArrayList(i);
            for (; i > 0; i--)
            {
                TextSpan textspan = new TextSpan();
                textspan.text = parcel.readString();
                delta.textSpans.add(textspan);
            }

            change = parcel.readString();
        }
    }

    public static class SearchHistogramEntry
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SearchHistogramEntry createFromParcel(Parcel parcel)
            {
                return new SearchHistogramEntry(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SearchHistogramEntry[] newArray(int i)
            {
                return new SearchHistogramEntry[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public TextSpanValueProperty date;
        public int searchCount;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeLong(((Long)date.value).longValue());
            parcel.writeInt(date.textSpans.size());
            for (Iterator iterator = date.textSpans.iterator(); iterator.hasNext(); parcel.writeString(((TextSpan)iterator.next()).text)) { }
            parcel.writeInt(searchCount);
        }


        public SearchHistogramEntry(Parcel parcel)
        {
            date = new TextSpanValueProperty();
            date.value = Long.valueOf(parcel.readLong());
            int i = parcel.readInt();
            date.textSpans = new ArrayList(i);
            for (; i > 0; i--)
            {
                TextSpan textspan = new TextSpan();
                textspan.text = parcel.readString();
                date.textSpans.add(textspan);
            }

            searchCount = parcel.readInt();
        }
    }

    public static class SearchStats
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SearchStats createFromParcel(Parcel parcel)
            {
                return new SearchStats(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SearchStats[] newArray(int i)
            {
                return new SearchStats[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public List searchHistogramEntries;
        public TextSpanValueProperty total;
        public TextSpanValueProperty totalClicks;

        private TextSpanValueProperty ConstructTextSpan(Parcel parcel)
        {
            TextSpanValueProperty textspanvalueproperty = new TextSpanValueProperty();
            textspanvalueproperty.value = Long.valueOf(parcel.readLong());
            int i = parcel.readInt();
            textspanvalueproperty.textSpans = new ArrayList(i);
            for (; i > 0; i--)
            {
                TextSpan textspan = new TextSpan();
                textspan.text = parcel.readString();
                textspanvalueproperty.textSpans.add(textspan);
            }

            return textspanvalueproperty;
        }

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeTypedList(searchHistogramEntries);
            parcel.writeLong(((Long)total.value).longValue());
            parcel.writeInt(total.textSpans.size());
            for (Iterator iterator = total.textSpans.iterator(); iterator.hasNext(); parcel.writeString(((TextSpan)iterator.next()).text)) { }
            parcel.writeLong(((Long)totalClicks.value).longValue());
            parcel.writeInt(totalClicks.textSpans.size());
            for (Iterator iterator1 = totalClicks.textSpans.iterator(); iterator1.hasNext(); parcel.writeString(((TextSpan)iterator1.next()).text)) { }
        }


        public SearchStats(Parcel parcel)
        {
            searchHistogramEntries = new ArrayList();
            parcel.readTypedList(searchHistogramEntries, SearchHistogramEntry.CREATOR);
            total = ConstructTextSpan(parcel);
            totalClicks = ConstructTextSpan(parcel);
        }
    }

    public static class TextSpan
    {

        public String text;

        public TextSpan()
        {
        }
    }

    public static class TextSpanValueProperty
    {

        public List textSpans;
        public Object value;

        public TextSpanValueProperty()
        {
        }
    }

    public static class TrendingListingSummary
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public TrendingListingSummary createFromParcel(Parcel parcel)
            {
                return new TrendingListingSummary(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public TrendingListingSummary[] newArray(int i)
            {
                return new TrendingListingSummary[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public ListingSummary listingSummary;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            parcel.writeParcelable(listingSummary, i);
        }


        public TrendingListingSummary(Parcel parcel)
        {
            listingSummary = (ListingSummary)parcel.readParcelable(com/ebay/nautilus/domain/data/Trend$ListingSummary.getClassLoader());
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Trend createFromParcel(Parcel parcel)
        {
            return new Trend(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Trend[] newArray(int i)
        {
            return new Trend[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Image bannerImage;
    public String categoryId;
    public List collectionIds;
    public String description;
    public String label;
    public RankDelta rankDelta;
    public SearchStats searchStats;
    public Image squareImage;
    public String title;
    public String topicId;
    public List trendingListingSummaries;
    public String url;

    public Trend(Parcel parcel)
    {
        trendingListingSummaries = new ArrayList();
        collectionIds = new ArrayList();
        topicId = parcel.readString();
        title = parcel.readString();
        label = parcel.readString();
        description = parcel.readString();
        bannerImage = new Image();
        bannerImage.url = parcel.readString();
        squareImage = new Image();
        squareImage.url = parcel.readString();
        categoryId = parcel.readString();
        rankDelta = (RankDelta)parcel.readParcelable(com/ebay/nautilus/domain/data/Trend$RankDelta.getClassLoader());
        searchStats = (SearchStats)parcel.readParcelable(com/ebay/nautilus/domain/data/Trend$SearchStats.getClassLoader());
        parcel.readTypedList(trendingListingSummaries, TrendingListingSummary.CREATOR);
        parcel.readStringList(collectionIds);
        url = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(topicId);
        parcel.writeString(title);
        parcel.writeString(label);
        parcel.writeString(description);
        parcel.writeString(bannerImage.url);
        parcel.writeString(squareImage.url);
        parcel.writeString(categoryId);
        parcel.writeParcelable(rankDelta, i);
        parcel.writeParcelable(searchStats, i);
        parcel.writeTypedList(trendingListingSummaries);
        parcel.writeStringList(collectionIds);
        parcel.writeString(url);
    }

}
