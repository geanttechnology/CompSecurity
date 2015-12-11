// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store:
//            DetailedHours

public class StoreDetails
    implements gu, Serializable
{

    private String address;
    private String city;
    private String country;
    private DetailedHours detailedHours[];
    private String fri_close;
    private String fri_open;
    private boolean hasLimitedShipToStore;
    private boolean hasPickupAndShipToStore;
    private String latitude;
    private String locationSubType;
    private String locationType;
    private String longitude;
    private String mon_close;
    private String mon_open;
    private String name;
    private String phone;
    private String sat_close;
    private String sat_open;
    private String state;
    private String status;
    private String sun_close;
    private String sun_open;
    private String thu_close;
    private String thu_open;
    private String tue_close;
    private String tue_open;
    private String wed_close;
    private String wed_open;
    private String zipCode;
    private String zipPlusFour;

    public StoreDetails()
    {
    }

    public String getAddress()
    {
        return address;
    }

    public String getCity()
    {
        return city;
    }

    public String getCountry()
    {
        return country;
    }

    public DetailedHours[] getDetailedHours()
    {
        return detailedHours;
    }

    public String getFri_close()
    {
        return fri_close;
    }

    public String getFri_open()
    {
        return fri_open;
    }

    public String getLatitude()
    {
        return latitude;
    }

    public String getLocationSubType()
    {
        return locationSubType;
    }

    public String getLocationType()
    {
        return locationType;
    }

    public String getLongitude()
    {
        return longitude;
    }

    public String getMon_close()
    {
        return mon_close;
    }

    public String getMon_open()
    {
        return mon_open;
    }

    public String getName()
    {
        return name;
    }

    public String getPhone()
    {
        return phone;
    }

    public String getSat_close()
    {
        return sat_close;
    }

    public String getSat_open()
    {
        return sat_open;
    }

    public String getState()
    {
        return state;
    }

    public String getStatus()
    {
        return status;
    }

    public String getSun_close()
    {
        return sun_close;
    }

    public String getSun_open()
    {
        return sun_open;
    }

    public String getThu_close()
    {
        return thu_close;
    }

    public String getThu_open()
    {
        return thu_open;
    }

    public String getTue_close()
    {
        return tue_close;
    }

    public String getTue_open()
    {
        return tue_open;
    }

    public String getWed_close()
    {
        return wed_close;
    }

    public String getWed_open()
    {
        return wed_open;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public String getZipPlusFour()
    {
        return zipPlusFour;
    }

    public boolean isHasLimitedShipToStore()
    {
        return hasLimitedShipToStore;
    }

    public boolean isHasPickupAndShipToStore()
    {
        return hasPickupAndShipToStore;
    }

    public void setAddress(String s)
    {
        address = s;
    }

    public void setCity(String s)
    {
        city = s;
    }

    public void setCountry(String s)
    {
        country = s;
    }

    public void setDetailedHours(DetailedHours adetailedhours[])
    {
        detailedHours = adetailedhours;
    }

    public void setFri_close(String s)
    {
        fri_close = s;
    }

    public void setFri_open(String s)
    {
        fri_open = s;
    }

    public void setHasLimitedShipToStore(boolean flag)
    {
        hasLimitedShipToStore = flag;
    }

    public void setHasPickupAndShipToStore(boolean flag)
    {
        hasPickupAndShipToStore = flag;
    }

    public void setLatitude(String s)
    {
        latitude = s;
    }

    public void setLocationSubType(String s)
    {
        locationSubType = s;
    }

    public void setLocationType(String s)
    {
        locationType = s;
    }

    public void setLongitude(String s)
    {
        longitude = s;
    }

    public void setMon_close(String s)
    {
        mon_close = s;
    }

    public void setMon_open(String s)
    {
        mon_open = s;
    }

    public void setName(String s)
    {
        name = s;
    }

    public void setPhone(String s)
    {
        phone = s;
    }

    public void setSat_close(String s)
    {
        sat_close = s;
    }

    public void setSat_open(String s)
    {
        sat_open = s;
    }

    public void setState(String s)
    {
        state = s;
    }

    public void setStatus(String s)
    {
        status = s;
    }

    public void setSun_close(String s)
    {
        sun_close = s;
    }

    public void setSun_open(String s)
    {
        sun_open = s;
    }

    public void setThu_close(String s)
    {
        thu_close = s;
    }

    public void setThu_open(String s)
    {
        thu_open = s;
    }

    public void setTue_close(String s)
    {
        tue_close = s;
    }

    public void setTue_open(String s)
    {
        tue_open = s;
    }

    public void setWed_close(String s)
    {
        wed_close = s;
    }

    public void setWed_open(String s)
    {
        wed_open = s;
    }

    public void setZipCode(String s)
    {
        zipCode = s;
    }

    public void setZipPlusFour(String s)
    {
        zipPlusFour = s;
    }
}
