// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.aeu;
import android.support.v7.aev;
import android.support.v7.aqo;
import android.text.TextUtils;

// Referenced classes of package com.abtnprojects.ambatana.models:
//            LetgoAddress, LatitudeLongitude

public class CurrentUserLocation
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CurrentUserLocation createFromParcel(Parcel parcel)
        {
            return new CurrentUserLocation(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CurrentUserLocation[] newArray(int i)
        {
            return new CurrentUserLocation[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String IP_PROVIDER = "UserLocationByIp";
    public static final String MANUAL_PROVIDER = "UserManual";
    private static CurrentUserLocation currentUserLocation;
    private long lastUpdated;
    private double latitude;
    private double longitude;
    private String provider;

    private CurrentUserLocation()
    {
        latitude = 4.9406564584124654E-324D;
        longitude = 4.9406564584124654E-324D;
        lastUpdated = 0L;
    }

    private CurrentUserLocation(Parcel parcel)
    {
        latitude = 4.9406564584124654E-324D;
        longitude = 4.9406564584124654E-324D;
        lastUpdated = 0L;
        latitude = parcel.readDouble();
        longitude = parcel.readDouble();
        lastUpdated = parcel.readLong();
        provider = parcel.readString();
    }


    public static CurrentUserLocation fromJSON(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        aeu aeu1 = (new aev()).a();
        try
        {
            s = (CurrentUserLocation)aeu1.a(s, com/abtnprojects/ambatana/models/CurrentUserLocation);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            aqo.b(s, "DeviceLocation.fromJSON", new Object[0]);
            s = null;
        }
        return s;
    }

    public static CurrentUserLocation getInstance()
    {
        com/abtnprojects/ambatana/models/CurrentUserLocation;
        JVM INSTR monitorenter ;
        CurrentUserLocation currentuserlocation;
        if (currentUserLocation == null)
        {
            currentUserLocation = new CurrentUserLocation();
        }
        currentuserlocation = currentUserLocation;
        com/abtnprojects/ambatana/models/CurrentUserLocation;
        JVM INSTR monitorexit ;
        return currentuserlocation;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isPreciselyLocated(LetgoAddress letgoaddress)
    {
        if (letgoaddress == null)
        {
            letgoaddress = null;
        } else
        {
            letgoaddress = letgoaddress.getProvider();
        }
        return !"UserLocationByIp".equalsIgnoreCase(letgoaddress) && !"UserManual".equalsIgnoreCase(letgoaddress);
    }

    public int describeContents()
    {
        return 0;
    }

    public long getLastUpdated()
    {
        return lastUpdated;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public LatitudeLongitude getLatitudeLongitude()
    {
        return new LatitudeLongitude(latitude, longitude);
    }

    public double getLongitude()
    {
        return longitude;
    }

    public String getProvider()
    {
        return provider;
    }

    public String toJSON()
    {
        return (new aev()).a().a(this);
    }

    public String toString()
    {
        return (new StringBuilder()).append("CurrentUserLocation{latitude=").append(latitude).append(", longitude=").append(longitude).append(", lastUpdated=").append(lastUpdated).append(", provider='").append(provider).append('\'').append('}').toString();
    }

    public void updateLocationData(double d, double d1, String s)
    {
        latitude = d;
        longitude = d1;
        lastUpdated = System.currentTimeMillis();
        provider = s;
    }

    public void updateLocationData(CurrentUserLocation currentuserlocation)
    {
        if (currentuserlocation == null)
        {
            return;
        } else
        {
            latitude = currentuserlocation.getLatitude();
            longitude = currentuserlocation.getLongitude();
            lastUpdated = currentuserlocation.getLastUpdated();
            provider = currentuserlocation.getProvider();
            return;
        }
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeDouble(latitude);
        parcel.writeDouble(longitude);
        parcel.writeLong(lastUpdated);
        parcel.writeString(provider);
    }

}
