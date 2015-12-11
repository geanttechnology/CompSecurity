// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            EbayCosDateTime

public class CollectionDetail extends BaseDataMapped
    implements Parcelable
{
    public static class Collection
    {

        public String collectionId;
        public EbayCosDateTime creationDate;
        public Creator creator;
        public String description;
        public List entries;
        public int entryCount;
        public int followersCount;
        public String headline;
        public String href;
        public EbayCosDateTime lastActivityDate;
        public int maxAllowedItems;
        public MediaAttributes mediaAttributes;
        public String name;
        public String subtitle;
        public int topLeafCategoryId;
        public ViewerToCollectionRelationship viewerToCollectionRelationship;
        public Visibility visibility;

        public Collection()
        {
        }
    }

    public static class CollectionEntry
    {

        public EbayCosDateTime addedDate;
        public String entryId;
        public EntryType entryType;
        public ListingSummaryBase listingSummaryBase;
        public String note;
        public ViewerToCollectedEntryRelationship viewerToCollectedEntryRelationship;

        public CollectionEntry()
        {
        }
    }

    public static class Creator
    {

        public String profileImageURL;
        public UserIdentifier userIdentifier;

        public Creator()
        {
        }
    }

    public static final class EntryType extends Enum
    {

        private static final EntryType $VALUES[];
        public static final EntryType ITEM_VARIATION;
        public static final EntryType LISTING;

        public static EntryType valueOf(String s)
        {
            return (EntryType)Enum.valueOf(com/ebay/nautilus/domain/data/CollectionDetail$EntryType, s);
        }

        public static EntryType[] values()
        {
            return (EntryType[])$VALUES.clone();
        }

        static 
        {
            LISTING = new EntryType("LISTING", 0);
            ITEM_VARIATION = new EntryType("ITEM_VARIATION", 1);
            $VALUES = (new EntryType[] {
                LISTING, ITEM_VARIATION
            });
        }

        private EntryType(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ListingSummaryBase
    {

        public BaseCommonType.Amount currentBidPrice;
        public BaseListingType.ListingFormatEnum format;
        public String imageURL;
        public String listingId;
        public BaseCommonType.Amount lowestFixedPrice;
        public EbayCosDateTime scheduledEndDate;
        public UserIdentifier sellerIdentifier;
        public BaseListingType.ListingStatusEnum status;
        public Title title;
        public String type;
        public String variationId;

        public ListingSummaryBase()
        {
        }
    }

    public static class MediaAttributes
    {

        public String design;
        public Photo photo;
        public Video video;

        public MediaAttributes()
        {
        }
    }

    public static class Photo
    {

        public String imageURL;

        public Photo()
        {
        }
    }

    public static class Title
    {

        public String content;

        public Title()
        {
        }
    }

    public static class UserIdentifier
    {

        public String userId;
        public String username;

        public UserIdentifier()
        {
        }
    }

    public static class Video
    {

        public String type;
        public String videoSource;
        public String videoURL;

        public Video()
        {
        }
    }

    public static class ViewerToCollectedEntryRelationship
    {

        public boolean showInMarketplace;

        public ViewerToCollectedEntryRelationship()
        {
        }
    }

    public static class ViewerToCollectionRelationship
    {

        public boolean followStatus;
        public boolean showInMarketplace;

        public ViewerToCollectionRelationship()
        {
        }
    }

    public static final class Visibility extends Enum
    {

        private static final Visibility $VALUES[];
        public static final Visibility PRIVATE;
        public static final Visibility PUBLIC;

        public static Visibility valueOf(String s)
        {
            return (Visibility)Enum.valueOf(com/ebay/nautilus/domain/data/CollectionDetail$Visibility, s);
        }

        public static Visibility[] values()
        {
            return (Visibility[])$VALUES.clone();
        }

        static 
        {
            PUBLIC = new Visibility("PUBLIC", 0);
            PRIVATE = new Visibility("PRIVATE", 1);
            $VALUES = (new Visibility[] {
                PUBLIC, PRIVATE
            });
        }

        private Visibility(String s, int i)
        {
            super(s, i);
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CollectionDetail createFromParcel(Parcel parcel)
        {
            return (CollectionDetail)DataMapperFactory.readParcelJson(parcel, com/ebay/nautilus/domain/data/CollectionDetail);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CollectionDetail[] newArray(int i)
        {
            return new CollectionDetail[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public Collection collection;
    public String next;
    public String prev;
    public int total;

    public CollectionDetail()
    {
    }

}
