// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.guest;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.Guest;
import java.util.Date;

// Referenced classes of package com.target.mothership.cache.guest:
//            CacheAccountDetails

public class CacheGuest
    implements Parcelable, Guest
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public CacheGuest createFromParcel(Parcel parcel)
        {
            return new CacheGuest(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public CacheGuest[] newArray(int i)
        {
            return new CacheGuest[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String GUEST_TABLE = "guest";
    private String mAccessToken;
    private CacheAccountDetails mAccountDetails;
    private Date mExpirationDate;
    private String mGuestId;
    private boolean mIsAnonymous;
    private int mKey;
    private String mRefreshToken;

    public CacheGuest()
    {
    }

    private CacheGuest(Parcel parcel)
    {
        mKey = parcel.readInt();
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
            mAccountDetails = (CacheAccountDetails)parcel.readParcelable(com/target/mothership/cache/guest/CacheAccountDetails.getClassLoader());
        }
    }


    public CacheGuest(Guest guest)
    {
        mAccessToken = guest.getAccessToken();
        mExpirationDate = guest.getExpirationDate();
        mRefreshToken = guest.getRefreshToken();
        mGuestId = guest.getGuestId();
        mIsAnonymous = guest.isAnonymous();
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
        if (mAccountDetails == null)
        {
            return e.e();
        } else
        {
            return e.b(mAccountDetails);
        }
    }

    public CacheAccountDetails getCacheAccountDetails()
    {
        return mAccountDetails;
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

    public void setAccountDetails(CacheAccountDetails cacheaccountdetails)
    {
        mAccountDetails = cacheaccountdetails;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = false;
        parcel.writeInt(mKey);
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
        if (mAccountDetails == null)
        {
            byte0 = flag;
        } else
        {
            byte0 = 1;
        }
        parcel.writeByte(byte0);
        if (mAccountDetails != null)
        {
            parcel.writeParcelable(mAccountDetails, i);
        }
    }

}
