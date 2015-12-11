// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import b.a.a;
import com.b.a.a.j;
import com.offerup.android.dto.response.ItemActions;
import java.util.TimeZone;
import org.apache.commons.lang3.StringUtils;

// Referenced classes of package com.offerup.android.dto:
//            Category, Person, Photo

public class Item
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private Category category;
    private int condition;
    private String description;
    private String discussionCount;
    private String getFullUrl;
    private long getImgMediumHeight;
    private long getImgMediumWidth;
    private Uri getImgPermalinkLarge;
    private Uri getImgPermalinkMedium;
    private Uri getImgPermalinkSmall;
    private long getImgSmallHeight;
    private long getImgSmallWidth;
    private long id;
    private String imageMobDetHd;
    private String imageMobListHd;
    private ItemActions itemActions;
    private String latitude;
    private int listingType;
    private String locationName;
    private String longitude;
    private int offerCount;
    private long orderId;
    private Person owner;
    private boolean paid;
    private boolean payable;
    private Photo photos[];
    private a postDate;
    private String postDateAgo;
    private String postFromStoreAddress;
    private String price;
    private int priority;
    private String sortLabel;
    private int state;
    private String title;
    private boolean watched;

    public Item()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public Category getCategory()
    {
        return category;
    }

    public int getCondition()
    {
        return condition;
    }

    public String getDescription()
    {
        return description;
    }

    public String getDiscussionCount()
    {
        return discussionCount;
    }

    public String getGetFullUrl()
    {
        return getFullUrl;
    }

    public long getGetImgMediumHeight()
    {
        return getImgMediumHeight;
    }

    public long getGetImgMediumWidth()
    {
        return getImgMediumWidth;
    }

    public Uri getGetImgPermalinkLarge()
    {
        return getImgPermalinkLarge;
    }

    public Uri getGetImgPermalinkMedium()
    {
        return getImgPermalinkMedium;
    }

    public Uri getGetImgPermalinkSmall()
    {
        return getImgPermalinkSmall;
    }

    public long getGetImgSmallHeight()
    {
        return getImgSmallHeight;
    }

    public long getGetImgSmallWidth()
    {
        return getImgSmallWidth;
    }

    public long getId()
    {
        return id;
    }

    public String getImageMobDetHd()
    {
        return imageMobDetHd;
    }

    public String getImageMobListHd()
    {
        return imageMobListHd;
    }

    public ItemActions getItemActions()
    {
        return itemActions;
    }

    public Uri getLargestImageAvailable()
    {
        if (getImgPermalinkLarge != null)
        {
            return getImgPermalinkLarge;
        }
        if (getImgPermalinkMedium != null)
        {
            return getImgPermalinkMedium;
        } else
        {
            return getImgPermalinkSmall;
        }
    }

    public String getLatitude()
    {
        return latitude;
    }

    public int getListingType()
    {
        return listingType;
    }

    public String getLocationName()
    {
        return locationName;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public int getOfferCount()
    {
        return offerCount;
    }

    public long getOrderId()
    {
        return orderId;
    }

    public Person getOwner()
    {
        return owner;
    }

    public Photo[] getPhotos()
    {
        return photos;
    }

    public a getPostDate()
    {
        return postDate;
    }

    public String getPostDateAgo()
    {
        return postDateAgo;
    }

    public String getPostFromStoreAddress()
    {
        return postFromStoreAddress;
    }

    public String getPrice()
    {
        if (StringUtils.isNotEmpty(price) && price.contains(".00"))
        {
            return price.substring(0, price.lastIndexOf(".00"));
        } else
        {
            return price;
        }
    }

    public int getPriority()
    {
        return priority;
    }

    public String getSortLabel()
    {
        return sortLabel;
    }

    public int getState()
    {
        return state;
    }

    public String getTitle()
    {
        return title;
    }

    public boolean isPaid()
    {
        return paid;
    }

    public boolean isPayable()
    {
        if (!j.a().b())
        {
            return false;
        } else
        {
            return payable;
        }
    }

    public boolean isWatched()
    {
        return watched;
    }

    public void setCategory(Category category1)
    {
        category = category1;
    }

    public void setCondition(int i)
    {
        condition = i;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setDiscussionCount(String s)
    {
        discussionCount = s;
    }

    public void setGetFullUrl(String s)
    {
        getFullUrl = s;
    }

    public void setGetImgMediumHeight(long l)
    {
        getImgMediumHeight = l;
    }

    public void setGetImgMediumWidth(long l)
    {
        getImgMediumWidth = l;
    }

    public void setGetImgPermalinkLarge(Uri uri)
    {
        getImgPermalinkLarge = uri;
    }

    public void setGetImgPermalinkSmall(Uri uri)
    {
        getImgPermalinkSmall = uri;
    }

    public void setGetImgSmallHeight(long l)
    {
        getImgSmallHeight = l;
    }

    public void setGetImgSmallWidth(long l)
    {
        getImgSmallWidth = l;
    }

    public void setGet_imgPermalinkMedium(Uri uri)
    {
        getImgPermalinkMedium = uri;
    }

    public void setId(int i)
    {
        id = i;
    }

    public void setImageMobDetHd(String s)
    {
        imageMobDetHd = s;
    }

    public void setImageMobListHd(String s)
    {
        imageMobListHd = s;
    }

    public void setLatitude(String s)
    {
        latitude = s;
    }

    public void setListingType(int i)
    {
        listingType = i;
    }

    public void setLocationName(String s)
    {
        locationName = s;
    }

    public void setLongitude(String s)
    {
        longitude = s;
    }

    public void setOfferCount(int i)
    {
        offerCount = i;
    }

    public void setOwner(Person person)
    {
        owner = person;
    }

    public void setPostDate(a a1)
    {
        postDate = a1;
    }

    public void setPostDateAgo(String s)
    {
        postDateAgo = s;
    }

    public void setPostFromStoreAddress(String s)
    {
        postFromStoreAddress = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setPriority(int i)
    {
        priority = i;
    }

    public void setSortLabel(String s)
    {
        sortLabel = s;
    }

    public void setState(int i)
    {
        state = i;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setWatched(boolean flag)
    {
        watched = flag;
    }

    public String toString()
    {
        return (new StringBuilder("Item [title=")).append(title).append("]").toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeInt(offerCount);
        parcel.writeLong(postDate.a(TimeZone.getTimeZone("UTC")));
        parcel.writeLong(getImgMediumWidth);
        parcel.writeLong(getImgSmallWidth);
        parcel.writeParcelable(owner, i);
        parcel.writeLong(id);
        parcel.writeParcelable(itemActions, i);
        parcel.writeParcelable(category, i);
        parcel.writeString(locationName);
        parcel.writeLong(getImgSmallHeight);
        parcel.writeLong(getImgMediumHeight);
        parcel.writeString(title);
        parcel.writeString(postDateAgo);
        parcel.writeString(getFullUrl);
        parcel.writeInt(priority);
        parcel.writeInt(state);
        parcel.writeString(latitude);
        parcel.writeParcelable(getImgPermalinkMedium, i);
        parcel.writeString(sortLabel);
        parcel.writeString(description);
        parcel.writeString(price);
        parcel.writeParcelable(getImgPermalinkSmall, i);
        parcel.writeString(discussionCount);
        parcel.writeString(imageMobDetHd);
        parcel.writeInt(listingType);
        parcel.writeInt(condition);
        parcel.writeString(postFromStoreAddress);
        parcel.writeString(longitude);
        parcel.writeString(imageMobListHd);
        parcel.writeParcelable(getImgPermalinkLarge, i);
        int k;
        if (watched)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        if (payable)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        parcel.writeLong(orderId);
        if (paid)
        {
            k = ((flag) ? 1 : 0);
        } else
        {
            k = 0;
        }
        parcel.writeInt(k);
        if (photos == null)
        {
            k = -1;
        } else
        {
            k = photos.length;
        }
        parcel.writeInt(k);
        if (k > 0)
        {
            parcel.writeTypedArray(photos, i);
        }
    }



/*
    static int access$002(Item item, int i)
    {
        item.offerCount = i;
        return i;
    }

*/


/*
    static long access$1002(Item item, long l)
    {
        item.getImgMediumHeight = l;
        return l;
    }

*/


/*
    static a access$102(Item item, a a1)
    {
        item.postDate = a1;
        return a1;
    }

*/


/*
    static String access$1102(Item item, String s)
    {
        item.title = s;
        return s;
    }

*/


/*
    static String access$1202(Item item, String s)
    {
        item.postDateAgo = s;
        return s;
    }

*/


/*
    static String access$1302(Item item, String s)
    {
        item.getFullUrl = s;
        return s;
    }

*/


/*
    static int access$1402(Item item, int i)
    {
        item.priority = i;
        return i;
    }

*/


/*
    static int access$1502(Item item, int i)
    {
        item.state = i;
        return i;
    }

*/


/*
    static String access$1602(Item item, String s)
    {
        item.latitude = s;
        return s;
    }

*/


/*
    static Uri access$1702(Item item, Uri uri)
    {
        item.getImgPermalinkMedium = uri;
        return uri;
    }

*/


/*
    static String access$1802(Item item, String s)
    {
        item.sortLabel = s;
        return s;
    }

*/


/*
    static String access$1902(Item item, String s)
    {
        item.description = s;
        return s;
    }

*/


/*
    static String access$2002(Item item, String s)
    {
        item.price = s;
        return s;
    }

*/


/*
    static long access$202(Item item, long l)
    {
        item.getImgMediumWidth = l;
        return l;
    }

*/


/*
    static Uri access$2102(Item item, Uri uri)
    {
        item.getImgPermalinkSmall = uri;
        return uri;
    }

*/


/*
    static String access$2202(Item item, String s)
    {
        item.discussionCount = s;
        return s;
    }

*/


/*
    static String access$2302(Item item, String s)
    {
        item.imageMobDetHd = s;
        return s;
    }

*/


/*
    static int access$2402(Item item, int i)
    {
        item.listingType = i;
        return i;
    }

*/


/*
    static int access$2502(Item item, int i)
    {
        item.condition = i;
        return i;
    }

*/


/*
    static String access$2602(Item item, String s)
    {
        item.postFromStoreAddress = s;
        return s;
    }

*/


/*
    static String access$2702(Item item, String s)
    {
        item.longitude = s;
        return s;
    }

*/


/*
    static String access$2802(Item item, String s)
    {
        item.imageMobListHd = s;
        return s;
    }

*/


/*
    static Uri access$2902(Item item, Uri uri)
    {
        item.getImgPermalinkLarge = uri;
        return uri;
    }

*/


/*
    static boolean access$3002(Item item, boolean flag)
    {
        item.watched = flag;
        return flag;
    }

*/


/*
    static long access$302(Item item, long l)
    {
        item.getImgSmallWidth = l;
        return l;
    }

*/


/*
    static boolean access$3102(Item item, boolean flag)
    {
        item.payable = flag;
        return flag;
    }

*/


/*
    static long access$3202(Item item, long l)
    {
        item.orderId = l;
        return l;
    }

*/


/*
    static boolean access$3302(Item item, boolean flag)
    {
        item.paid = flag;
        return flag;
    }

*/



/*
    static Photo[] access$3402(Item item, Photo aphoto[])
    {
        item.photos = aphoto;
        return aphoto;
    }

*/


/*
    static Person access$402(Item item, Person person)
    {
        item.owner = person;
        return person;
    }

*/


/*
    static long access$502(Item item, long l)
    {
        item.id = l;
        return l;
    }

*/


/*
    static ItemActions access$602(Item item, ItemActions itemactions)
    {
        item.itemActions = itemactions;
        return itemactions;
    }

*/


/*
    static Category access$702(Item item, Category category1)
    {
        item.category = category1;
        return category1;
    }

*/


/*
    static String access$802(Item item, String s)
    {
        item.locationName = s;
        return s;
    }

*/


/*
    static long access$902(Item item, long l)
    {
        item.getImgSmallHeight = l;
        return l;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final Item createFromParcel(Parcel parcel)
        {
            Item item = new Item();
            item.offerCount = parcel.readInt();
            item.postDate = a.a(parcel.readLong(), TimeZone.getTimeZone("UTC"));
            item.getImgMediumWidth = parcel.readLong();
            item.getImgSmallWidth = parcel.readLong();
            item.owner = (Person)parcel.readParcelable(com/offerup/android/dto/Person.getClassLoader());
            item.id = parcel.readLong();
            item.itemActions = (ItemActions)parcel.readParcelable(com/offerup/android/dto/response/ItemActions.getClassLoader());
            item.category = (Category)parcel.readParcelable(com/offerup/android/dto/Category.getClassLoader());
            item.locationName = parcel.readString();
            item.getImgSmallHeight = parcel.readLong();
            item.getImgMediumHeight = parcel.readLong();
            item.title = parcel.readString();
            item.postDateAgo = parcel.readString();
            item.getFullUrl = parcel.readString();
            item.priority = parcel.readInt();
            item.state = parcel.readInt();
            item.latitude = parcel.readString();
            item.getImgPermalinkMedium = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
            item.sortLabel = parcel.readString();
            item.description = parcel.readString();
            item.price = parcel.readString();
            item.getImgPermalinkSmall = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
            item.discussionCount = parcel.readString();
            item.imageMobDetHd = parcel.readString();
            item.listingType = parcel.readInt();
            item.condition = parcel.readInt();
            item.postFromStoreAddress = parcel.readString();
            item.longitude = parcel.readString();
            item.imageMobListHd = parcel.readString();
            item.getImgPermalinkLarge = (Uri)parcel.readParcelable(android/net/Uri.getClassLoader());
            item.watched = (new OfferUpBoolean(parcel.readInt())).value;
            item.payable = (new OfferUpBoolean(parcel.readInt())).value;
            item.orderId = parcel.readLong();
            item.paid = (new OfferUpBoolean(parcel.readInt())).value;
            int i = parcel.readInt();
            if (i > 0)
            {
                item.photos = new Photo[i];
                parcel.readTypedArray(item.photos, Photo.CREATOR);
            }
            return item;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Item[] newArray(int i)
        {
            return new Item[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
