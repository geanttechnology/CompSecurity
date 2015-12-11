// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.k;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package com.target.mothership.model.guest.handler:
//            TGTAccountDetails

class TGTGuest
    implements Parcelable, Guest
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTGuest a(Parcel parcel)
        {
            return new TGTGuest(parcel);
        }

        public TGTGuest[] a(int i)
        {
            return new TGTGuest[i];
        }

        public Object createFromParcel(Parcel parcel)
        {
            return a(parcel);
        }

        public Object[] newArray(int i)
        {
            return a(i);
        }

    };
    private String mAccessToken;
    private AccountDetails mAccountDetails;
    private Date mExpirationDate;
    private String mGuestId;
    private boolean mIsAnonymous;
    private String mRefreshToken;

    public TGTGuest()
    {
    }

    private TGTGuest(Parcel parcel)
    {
        mAccessToken = parcel.readString();
        long l = parcel.readLong();
        Date date;
        boolean flag;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mExpirationDate = date;
        mRefreshToken = parcel.readString();
        mGuestId = parcel.readString();
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mIsAnonymous = flag;
        if (parcel.readByte() == 1)
        {
            mAccountDetails = (AccountDetails)parcel.readParcelable(com/target/mothership/model/guest/handler/TGTAccountDetails.getClassLoader());
            return;
        } else
        {
            mAccountDetails = null;
            return;
        }
    }


    public void a(long l)
    {
        mExpirationDate = new Date(1000L * l + Calendar.getInstance().getTimeInMillis());
    }

    public void a(AccountDetails accountdetails)
    {
        mAccountDetails = accountdetails;
    }

    public void a(String s)
    {
        mAccessToken = s;
    }

    public void a(boolean flag)
    {
        mIsAnonymous = flag;
    }

    public void b(String s)
    {
        mGuestId = s;
    }

    public void c(String s)
    {
        mRefreshToken = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getAccessToken()
    {
        return mAccessToken;
    }

    public e getAccountDetails()
    {
        return k.a(mAccountDetails);
    }

    public Date getExpirationDate()
    {
        return mExpirationDate;
    }

    public String getGuestId()
    {
        return mGuestId;
    }

    public String getRefreshToken()
    {
        return mRefreshToken;
    }

    public boolean isAnonymous()
    {
        return mIsAnonymous;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        parcel.writeString(mAccessToken);
        byte byte0;
        long l;
        if (mExpirationDate != null)
        {
            l = mExpirationDate.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        parcel.writeString(mRefreshToken);
        parcel.writeString(mGuestId);
        if (mIsAnonymous)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        byte0 = flag;
        if (mAccountDetails == null)
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
        if (mAccountDetails != null)
        {
            parcel.writeParcelable(mAccountDetails, 0);
        }
    }

}
