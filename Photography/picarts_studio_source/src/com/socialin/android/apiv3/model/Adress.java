// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.socialin.android.c;
import com.socialin.gson.Gson;
import org.json.JSONObject;

public class Adress
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Adress createFromParcel(Parcel parcel)
        {
            return new Adress(parcel);
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final Adress[] newArray(int i)
        {
            return new Adress[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public String city;
    public float coordinates[];
    public String country;
    public String place;
    public String state;
    public String street;
    public String venueId;
    public String zip;

    public Adress()
    {
        street = "";
        city = "";
        state = "";
        country = "";
        zip = "";
        place = "";
    }

    public Adress(Parcel parcel)
    {
        street = "";
        city = "";
        state = "";
        country = "";
        zip = "";
        place = "";
        readFromParcel(parcel);
    }

    private void readFromParcel(Parcel parcel)
    {
        try
        {
            street = parcel.readString();
            city = parcel.readString();
            state = parcel.readString();
            country = parcel.readString();
            zip = parcel.readString();
            place = parcel.readString();
            coordinates = new float[2];
            parcel.readFloatArray(coordinates);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            parcel.printStackTrace();
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public float getLatitude()
    {
        if (coordinates != null && coordinates.length > 0)
        {
            return coordinates[0];
        } else
        {
            return -1F;
        }
    }

    public String getLatitudeString()
    {
        return String.valueOf(getLatitude());
    }

    public float getLongitude()
    {
        if (coordinates != null && coordinates.length > 1)
        {
            return coordinates[1];
        } else
        {
            return -1F;
        }
    }

    public String getLongitudeString()
    {
        return String.valueOf(getLongitude());
    }

    public void setLatitude(float f)
    {
        if (coordinates == null || coordinates.length < 2)
        {
            coordinates = new float[2];
        }
        coordinates[0] = f;
    }

    public void setLongitude(float f)
    {
        if (coordinates == null || coordinates.length < 2)
        {
            coordinates = new float[2];
        }
        coordinates[1] = f;
    }

    public JSONObject toJson()
    {
        return new JSONObject(c.a().toJson(this));
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        String s;
        if (street == null)
        {
            s = "";
        } else
        {
            s = street;
        }
        parcel.writeString(s);
        if (city == null)
        {
            s = "";
        } else
        {
            s = city;
        }
        parcel.writeString(s);
        if (state == null)
        {
            s = "";
        } else
        {
            s = state;
        }
        parcel.writeString(s);
        if (country == null)
        {
            s = "";
        } else
        {
            s = country;
        }
        parcel.writeString(s);
        if (zip == null)
        {
            s = "";
        } else
        {
            s = zip;
        }
        parcel.writeString(s);
        if (place == null)
        {
            s = "";
        } else
        {
            s = place;
        }
        parcel.writeString(s);
        parcel.writeFloatArray(coordinates);
    }

}
