// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.remix;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.remix:
//            StoreHours

public class Store
    implements Parcelable
{

    public static String ADDRESS = "address";
    public static String CITY = "city";
    public static String COUNTRY = "country ";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Store createFromParcel(Parcel parcel)
        {
            return new Store(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Store[] newArray(int i)
        {
            return new Store[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static String DETAILED_HOURS = "detailedHours";
    public static String DISTANCE = "distance";
    public static String HOURS = "hoursAmPm";
    public static String LAT = "lat";
    public static String LNG = "lng";
    public static String LONG_NAME = "longName";
    public static String NAME = "name";
    public static String PHONE = "phone";
    public static String POSTAL_CODE = "postalCode";
    public static String REGION = "region";
    public static String SERVICES = "services";
    public static String STORE_ID = "storeId";
    public static String STORE_IMAGE = "storeimage";
    public static String STORE_TYPE = "storeType";
    private String address;
    private String availabilityMessage;
    private String city;
    private String distance;
    private String hours;
    private double lat;
    private double lng;
    private String longName;
    private String name;
    private String phone;
    private String postalCode;
    private String region;
    private String services;
    private boolean shipToStore;
    private ArrayList storeHours;
    private String storeId;
    private String storeImage;
    private String storeLink;
    private String storeType;

    public Store(Parcel parcel)
    {
        storeHours = null;
        storeId = parcel.readString();
        storeType = parcel.readString();
        name = parcel.readString();
        address = parcel.readString();
        longName = parcel.readString();
        city = parcel.readString();
        region = parcel.readString();
        postalCode = parcel.readString();
        lat = parcel.readDouble();
        lng = parcel.readDouble();
        phone = parcel.readString();
        hours = parcel.readString();
        distance = parcel.readString();
        availabilityMessage = parcel.readString();
        storeLink = parcel.readString();
        storeImage = parcel.readString();
        services = parcel.readString();
    }

    public Store(JSONObject jsonobject)
    {
        storeHours = null;
        storeId = jsonobject.optString(STORE_ID);
        storeType = jsonobject.optString(STORE_TYPE);
        name = jsonobject.optString(NAME);
        longName = jsonobject.optString(LONG_NAME);
        address = jsonobject.optString(ADDRESS);
        city = jsonobject.optString(CITY);
        region = jsonobject.optString(REGION);
        postalCode = jsonobject.optString(POSTAL_CODE);
        phone = jsonobject.optString(PHONE);
        lat = jsonobject.getDouble(LAT);
        lng = jsonobject.getDouble(LNG);
        hours = jsonobject.optString(HOURS);
        distance = jsonobject.optString(DISTANCE);
        storeImage = jsonobject.optString(STORE_IMAGE);
        services = loadServices(jsonobject.getJSONArray(SERVICES));
        storeHours = loadStoreTiming(jsonobject.optJSONArray(DETAILED_HOURS));
    }

    private String loadServices(JSONArray jsonarray)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < jsonarray.length(); i++)
        {
            JSONObject jsonobject = jsonarray.getJSONObject(i);
            stringbuilder.append((new StringBuilder()).append(jsonobject.optString("service")).append(",").toString());
        }

        return stringbuilder.toString();
    }

    private ArrayList loadStoreTiming(JSONArray jsonarray)
    {
        ArrayList arraylist = new ArrayList();
        if (jsonarray != null)
        {
            for (int i = 0; i < jsonarray.length(); i++)
            {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                StoreHours storehours = new StoreHours();
                storehours.setClose(jsonobject.optString("close", ""));
                storehours.setOpen(jsonobject.optString("open", ""));
                storehours.setDate(jsonobject.optString("date", ""));
                storehours.setDay(jsonobject.optString("day", ""));
                arraylist.add(storehours);
            }

        }
        return arraylist;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAddress()
    {
        return address;
    }

    public String getAvailabilityMessage()
    {
        return availabilityMessage;
    }

    public String getCity()
    {
        return city;
    }

    public String getDistance()
    {
        return distance;
    }

    public String getHours()
    {
        return hours;
    }

    public double getLat()
    {
        return lat;
    }

    public double getLng()
    {
        return lng;
    }

    public String getLongName()
    {
        return longName;
    }

    public String getName()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getPostalCode()
    {
        return postalCode;
    }

    public String getRegion()
    {
        return region;
    }

    public String getServices()
    {
        return services;
    }

    public ArrayList getStoreHours()
    {
        return storeHours;
    }

    public String getStoreId()
    {
        return storeId;
    }

    public String getStoreImage()
    {
        return storeImage;
    }

    public String getStoreLink()
    {
        return storeLink;
    }

    public String getStoreType()
    {
        return storeType;
    }

    public boolean isShipToStore()
    {
        return shipToStore;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(storeId);
        parcel.writeString(storeType);
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeString(longName);
        parcel.writeString(longName);
        parcel.writeString(region);
        parcel.writeString(postalCode);
        parcel.writeDouble(lat);
        parcel.writeDouble(lng);
        parcel.writeString(phone);
        parcel.writeString(hours);
        parcel.writeString(distance);
        parcel.writeString(availabilityMessage);
        parcel.writeString(storeLink);
        parcel.writeString(storeImage);
        parcel.writeString(services);
    }

}
