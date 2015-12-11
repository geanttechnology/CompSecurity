// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models.product;

import android.os.Parcel;
import android.os.Parcelable;
import com.abtnprojects.ambatana.models.user.User;
import java.lang.annotation.Annotation;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.abtnprojects.ambatana.models.product:
//            Geo, RemoteImage, Thumb

public class Product
    implements Parcelable
{
    public static interface Status
        extends Annotation
    {
    }

    public static interface StatusString
        extends Annotation
    {
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Product createFromParcel(Parcel parcel)
        {
            return new Product(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Product[] newArray(int i)
        {
            return new Product[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int DELETED = 6;
    public static final int PENDING_VALIDATION = 0;
    public static final int REFUSED = 2;
    public static final String SELLING_STR = "selling";
    public static final int SOLD = 3;
    public static final int SOLD_OLD = 5;
    public static final String SOLD_STR = "sold";
    public static final int VALIDATED = 1;
    private final int categoryId;
    private final Date createdAt;
    private final String currency;
    private final String description;
    private final int distanceRange;
    private final String formattedPrice;
    private final Geo geo;
    private final String id;
    private final List images;
    private boolean isFavorite;
    private boolean isReported;
    private final String languageCode;
    private final String name;
    private final User owner;
    private final double price;
    private final int status;
    private final Thumb thumb;
    private final Date updatedAt;

    protected Product(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        id = parcel.readString();
        name = parcel.readString();
        categoryId = parcel.readInt();
        languageCode = parcel.readString();
        description = parcel.readString();
        formattedPrice = parcel.readString();
        currency = parcel.readString();
        status = parcel.readInt();
        geo = (Geo)parcel.readParcelable(com/abtnprojects/ambatana/models/product/Geo.getClassLoader());
        images = parcel.createTypedArrayList(RemoteImage.CREATOR);
        thumb = (Thumb)parcel.readParcelable(com/abtnprojects/ambatana/models/product/Thumb.getClassLoader());
        createdAt = (Date)parcel.readSerializable();
        updatedAt = (Date)parcel.readSerializable();
        boolean flag;
        if (parcel.readByte() == 1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isReported = flag;
        if (parcel.readByte() == 1)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isFavorite = flag;
        owner = (User)parcel.readParcelable(com/abtnprojects/ambatana/models/user/User.getClassLoader());
        price = parcel.readDouble();
        distanceRange = parcel.readInt();
    }

    public Product(String s, String s1, int i, String s2, String s3, String s4, String s5, 
            int j, Geo geo1, List list, Thumb thumb1, Date date, Date date1, boolean flag, 
            boolean flag1, User user, double d, int k)
    {
        id = s;
        name = s1;
        categoryId = i;
        languageCode = s2;
        description = s3;
        formattedPrice = s4;
        currency = s5;
        status = j;
        geo = geo1;
        images = list;
        thumb = thumb1;
        createdAt = date;
        updatedAt = date1;
        isReported = flag;
        isFavorite = flag1;
        owner = user;
        price = d;
        distanceRange = k;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Product)obj;
            if (id == null || !id.equals(((Product) (obj)).id))
            {
                return false;
            }
        }
        return true;
    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public String getCategoryIdAsString()
    {
        return Integer.toString(categoryId);
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public String getCurrency()
    {
        return currency;
    }

    public String getDescription()
    {
        return description;
    }

    public int getDistanceRange()
    {
        return distanceRange;
    }

    public String getFormattedPrice()
    {
        return formattedPrice;
    }

    public Geo getGeo()
    {
        return geo;
    }

    public String getId()
    {
        return id;
    }

    public List getImages()
    {
        return images;
    }

    public String getLanguageCode()
    {
        return languageCode;
    }

    public String getName()
    {
        return name;
    }

    public User getOwner()
    {
        return owner;
    }

    public double getPrice()
    {
        return price;
    }

    public String getProductLink()
    {
        if (id == null)
        {
            return null;
        } else
        {
            return (new StringBuilder()).append("http://www.letgo.com/product/").append(id).toString();
        }
    }

    public int getStatus()
    {
        return status;
    }

    public Thumb getThumb()
    {
        return thumb;
    }

    public String getTrimmedName()
    {
        if (name != null)
        {
            return name.trim();
        } else
        {
            return name;
        }
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }

    public boolean isDeleted()
    {
        return getStatus() == 6;
    }

    public boolean isFavorite()
    {
        return isFavorite;
    }

    public boolean isPendingValidation()
    {
        return getStatus() == 0;
    }

    public boolean isReported()
    {
        return isReported;
    }

    public boolean isSold()
    {
        return getStatus() == 3 || getStatus() == 5;
    }

    public void setIsFavorite(boolean flag)
    {
        isFavorite = flag;
    }

    public void setIsReported(boolean flag)
    {
        isReported = flag;
    }

    public String toString()
    {
        return (new StringBuilder()).append("Product{id='").append(id).append('\'').append(", name='").append(name).append('\'').append(", categoryId=").append(categoryId).append(", languageCode='").append(languageCode).append('\'').append(", description='").append(description).append('\'').append(", formattedPrice=").append(formattedPrice).append(", currency='").append(currency).append('\'').append(", status=").append(status).append(", geo=").append(geo).append(", images=").append(images).append(", thumb=").append(thumb).append(", createdAt='").append(createdAt).append('\'').append(", updatedAt='").append(updatedAt).append('\'').append(", isReported=").append(isReported).append(", isFavorite=").append(isFavorite).append(", owner=").append(owner).append('}').toString();
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(id);
        parcel.writeString(name);
        parcel.writeInt(categoryId);
        parcel.writeString(languageCode);
        parcel.writeString(description);
        parcel.writeString(formattedPrice);
        parcel.writeString(currency);
        parcel.writeInt(status);
        parcel.writeParcelable(geo, i);
        parcel.writeTypedList(images);
        parcel.writeParcelable(thumb, i);
        parcel.writeSerializable(createdAt);
        parcel.writeSerializable(updatedAt);
        int j;
        if (isReported)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        parcel.writeByte((byte)j);
        if (isFavorite)
        {
            j = ((flag) ? 1 : 0);
        } else
        {
            j = 0;
        }
        parcel.writeByte((byte)j);
        parcel.writeParcelable(owner, i);
        parcel.writeDouble(price);
        parcel.writeInt(distanceRange);
    }

}
