// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.os.Parcel;
import android.os.Parcelable;
import java.text.SimpleDateFormat;
import java.util.Date;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultDomainModelFacade

public class RapiSearchResultFragmentDomainModel
    implements Parcelable, RapiSearchResultDomainModelFacade
{

    private static final String ANY_TIME_LOG = "Any time";
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public RapiSearchResultFragmentDomainModel createFromParcel(Parcel parcel)
        {
            return new RapiSearchResultFragmentDomainModel(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RapiSearchResultFragmentDomainModel[] newArray(int i)
        {
            return new RapiSearchResultFragmentDomainModel[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final int DEFAULT_PARTY_SIZE = 2;
    private boolean isMakeAReservationToggled;
    private boolean isReservationHeaderVisible;
    private int partySize;
    private Date reservationDate;
    private Date reservationTime;
    private String serviceType;

    public RapiSearchResultFragmentDomainModel()
    {
        isReservationHeaderVisible = false;
        isMakeAReservationToggled = false;
        partySize = 2;
        serviceType = "all";
        reservationDate = new Date();
        reservationTime = null;
    }

    protected RapiSearchResultFragmentDomainModel(Parcel parcel)
    {
        boolean flag1 = true;
        super();
        isReservationHeaderVisible = false;
        isMakeAReservationToggled = false;
        partySize = 2;
        serviceType = "all";
        reservationDate = new Date();
        reservationTime = null;
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isReservationHeaderVisible = flag;
        if (parcel.readByte() != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        isMakeAReservationToggled = flag;
        partySize = parcel.readInt();
        reservationDate = (Date)parcel.readSerializable();
        reservationTime = (Date)parcel.readSerializable();
        serviceType = parcel.readString();
    }

    public int describeContents()
    {
        return 0;
    }

    public int getPartySize()
    {
        return partySize;
    }

    public Date getReservationDate()
    {
        return reservationDate;
    }

    public String getReservationDateFormatted()
    {
        return (new SimpleDateFormat("yyyy-MM-dd")).format(getReservationDate());
    }

    public Date getReservationTime()
    {
        return reservationTime;
    }

    public String getReservationTimeFormatted()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("HH:mm");
        Date date = getReservationTime();
        if (date != null)
        {
            return simpledateformat.format(date);
        } else
        {
            return "Any time";
        }
    }

    public String getServiceType()
    {
        return serviceType;
    }

    public boolean isMakeAReservationToggled()
    {
        return isMakeAReservationToggled;
    }

    public boolean isReservationHeaderVisible()
    {
        return isReservationHeaderVisible;
    }

    public void resetValues()
    {
        partySize = 2;
        serviceType = "all";
        reservationDate = new Date();
        reservationTime = null;
    }

    public void setMakeAReservationToggle(boolean flag)
    {
        isMakeAReservationToggled = flag;
    }

    public void setPartySize(int i)
    {
        partySize = i;
    }

    public void setReservationDate(Date date)
    {
        reservationDate = date;
    }

    public void setReservationHeaderVisibility(boolean flag)
    {
        isReservationHeaderVisible = flag;
    }

    public void setReservationTime(Date date)
    {
        reservationTime = date;
    }

    public void setServiceType(String s)
    {
        serviceType = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        if (isReservationHeaderVisible)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        if (isMakeAReservationToggled)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
        parcel.writeInt(partySize);
        parcel.writeSerializable(reservationDate);
        parcel.writeSerializable(reservationTime);
        parcel.writeString(serviceType);
    }

}
