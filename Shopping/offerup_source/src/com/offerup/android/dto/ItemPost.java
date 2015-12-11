// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.b.a.a.g;
import com.offerup.android.c.a;
import java.util.ArrayList;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

// Referenced classes of package com.offerup.android.dto:
//            Item, ItemPostPhoto, Category

public class ItemPost
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private Category category;
    private Integer condition;
    private String description;
    private Long id;
    private ArrayList itemPostPhotos;
    private Double latitude;
    private Integer listingState;
    private Integer listingType;
    private String locationName;
    private Double longitude;
    private Double price;
    private Integer shareToFacebook;
    private String title;
    private String zipcode;

    public ItemPost()
    {
    }

    public ItemPost(Item item)
    {
        if (item != null)
        {
            itemPostPhotos = new ArrayList(a.a());
            Photo aphoto[] = item.getPhotos();
            if (aphoto != null)
            {
                for (int i = 0; i < aphoto.length; i++)
                {
                    if (aphoto[i] != null)
                    {
                        itemPostPhotos.add(new ItemPostPhoto(aphoto[i]));
                    }
                }

            }
            setTitle(item.getTitle());
            id = Long.valueOf(item.getId());
            setCategory(item.getCategory());
            setDescription(item.getDescription());
            setPrice(item.getPrice());
            setListingType(Integer.valueOf(item.getListingType()));
            setCondition(Integer.valueOf(item.getCondition()));
            if (NumberUtils.isNumber(item.getLatitude()))
            {
                setLatitude(Double.valueOf(Double.parseDouble(item.getLatitude())));
            }
            if (NumberUtils.isNumber(item.getLongitude()))
            {
                setLongitude(Double.valueOf(Double.parseDouble(item.getLongitude())));
            }
            setShareToFacebook(Integer.valueOf(0));
            setLocationName(item.getLocationName());
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public Category getCategory()
    {
        return category;
    }

    public Integer getCondition()
    {
        return condition;
    }

    public String getDescription()
    {
        return description;
    }

    public Long getId()
    {
        return id;
    }

    public ArrayList getItemPostPhotos()
    {
        return itemPostPhotos;
    }

    public Double getLatitude()
    {
        return latitude;
    }

    public Integer getListingState()
    {
        return listingState;
    }

    public Integer getListingType()
    {
        return listingType;
    }

    public String getLocationName()
    {
        return locationName;
    }

    public Double getLongitude()
    {
        return longitude;
    }

    public Double getPrice()
    {
        return price;
    }

    public Integer getShareToFacebook()
    {
        int i;
        if (shareToFacebook == null)
        {
            i = 0;
        } else
        {
            i = shareToFacebook.intValue();
        }
        return Integer.valueOf(i);
    }

    public String getTitle()
    {
        return title;
    }

    public String getUploadedImageUuids()
    {
        Object obj = new StringBuilder();
        for (int i = 0; i < itemPostPhotos.size(); i++)
        {
            ItemPostPhoto itempostphoto = (ItemPostPhoto)itemPostPhotos.get(i);
            if (itempostphoto == null || !StringUtils.isNotEmpty(itempostphoto.getUuid()))
            {
                continue;
            }
            if (((StringBuilder) (obj)).length() > 0)
            {
                ((StringBuilder) (obj)).append(",");
            }
            ((StringBuilder) (obj)).append(itempostphoto.getUuid());
        }

        obj = ((StringBuilder) (obj)).toString();
        if (StringUtils.isNotEmpty(((CharSequence) (obj))))
        {
            return ((String) (obj));
        } else
        {
            return null;
        }
    }

    public String getZipcode()
    {
        return zipcode;
    }

    public void setCategory(Category category1)
    {
        category = category1;
    }

    public void setCondition(Integer integer)
    {
        condition = integer;
    }

    public void setDescription(String s)
    {
        description = s;
    }

    public void setId(Long long1)
    {
        id = long1;
    }

    public void setItemPostPhotos(ArrayList arraylist)
    {
        itemPostPhotos = arraylist;
    }

    public void setLatitude(Double double1)
    {
        latitude = double1;
    }

    public void setListingState(Integer integer)
    {
        listingState = integer;
    }

    public void setListingType(Integer integer)
    {
        listingType = integer;
    }

    public void setLocationName(String s)
    {
        locationName = s;
    }

    public void setLongitude(Double double1)
    {
        longitude = double1;
    }

    public void setPrice(String s)
    {
        if (s != null)
        {
            try
            {
                price = Double.valueOf(Double.parseDouble(s.replace("$", "")));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                g.a(this, s);
            }
            break MISSING_BLOCK_LABEL_37;
        }
        price = null;
        return;
    }

    public void setShareToFacebook(Integer integer)
    {
        shareToFacebook = integer;
    }

    public void setTitle(String s)
    {
        title = s;
    }

    public void setZipcode(String s)
    {
        zipcode = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeValue(title);
        parcel.writeValue(condition);
        parcel.writeValue(category);
        parcel.writeValue(description);
        parcel.writeValue(price);
        parcel.writeValue(listingType);
        parcel.writeValue(listingState);
        parcel.writeValue(zipcode);
        parcel.writeValue(longitude);
        parcel.writeValue(latitude);
        parcel.writeValue(shareToFacebook);
        parcel.writeValue(locationName);
        parcel.writeValue(id);
        parcel.writeTypedList(itemPostPhotos);
    }



/*
    static String access$002(ItemPost itempost, String s)
    {
        itempost.title = s;
        return s;
    }

*/


/*
    static Integer access$1002(ItemPost itempost, Integer integer)
    {
        itempost.shareToFacebook = integer;
        return integer;
    }

*/


/*
    static Integer access$102(ItemPost itempost, Integer integer)
    {
        itempost.condition = integer;
        return integer;
    }

*/


/*
    static String access$1102(ItemPost itempost, String s)
    {
        itempost.locationName = s;
        return s;
    }

*/


/*
    static Long access$1202(ItemPost itempost, Long long1)
    {
        itempost.id = long1;
        return long1;
    }

*/


/*
    static ArrayList access$1302(ItemPost itempost, ArrayList arraylist)
    {
        itempost.itemPostPhotos = arraylist;
        return arraylist;
    }

*/


/*
    static Category access$202(ItemPost itempost, Category category1)
    {
        itempost.category = category1;
        return category1;
    }

*/


/*
    static String access$302(ItemPost itempost, String s)
    {
        itempost.description = s;
        return s;
    }

*/


/*
    static Double access$402(ItemPost itempost, Double double1)
    {
        itempost.price = double1;
        return double1;
    }

*/


/*
    static Integer access$502(ItemPost itempost, Integer integer)
    {
        itempost.listingType = integer;
        return integer;
    }

*/


/*
    static Integer access$602(ItemPost itempost, Integer integer)
    {
        itempost.listingState = integer;
        return integer;
    }

*/


/*
    static String access$702(ItemPost itempost, String s)
    {
        itempost.zipcode = s;
        return s;
    }

*/


/*
    static Double access$802(ItemPost itempost, Double double1)
    {
        itempost.longitude = double1;
        return double1;
    }

*/


/*
    static Double access$902(ItemPost itempost, Double double1)
    {
        itempost.latitude = double1;
        return double1;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final ItemPost createFromParcel(Parcel parcel)
        {
            ItemPost itempost = new ItemPost();
            itempost.title = (String)parcel.readValue(java/lang/String.getClassLoader());
            itempost.condition = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
            itempost.category = (Category)parcel.readValue(com/offerup/android/dto/Category.getClassLoader());
            itempost.description = (String)parcel.readValue(java/lang/String.getClassLoader());
            itempost.price = (Double)parcel.readValue(java/lang/Double.getClassLoader());
            itempost.listingType = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
            itempost.listingState = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
            itempost.zipcode = (String)parcel.readValue(java/lang/String.getClassLoader());
            itempost.longitude = (Double)parcel.readValue(java/lang/Double.getClassLoader());
            itempost.latitude = (Double)parcel.readValue(java/lang/Double.getClassLoader());
            itempost.shareToFacebook = (Integer)parcel.readValue(java/lang/Integer.getClassLoader());
            itempost.locationName = (String)parcel.readValue(java/lang/String.getClassLoader());
            itempost.id = (Long)parcel.readValue(java/lang/Long.getClassLoader());
            ArrayList arraylist = new ArrayList(a.a());
            parcel.readTypedList(arraylist, ItemPostPhoto.CREATOR);
            itempost.itemPostPhotos = arraylist;
            return itempost;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ItemPost[] newArray(int i)
        {
            return new ItemPost[i];
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
