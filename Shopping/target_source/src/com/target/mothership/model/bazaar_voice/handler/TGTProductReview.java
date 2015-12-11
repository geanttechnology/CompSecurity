// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.bazaar_voice.handler;

import android.os.Parcel;
import com.target.mothership.model.bazaar_voice.interfaces.ProductReview;
import java.util.Date;

// Referenced classes of package com.target.mothership.model.bazaar_voice.handler:
//            TGTReview

public class TGTProductReview extends TGTReview
    implements ProductReview
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTProductReview a(Parcel parcel)
        {
            return new TGTProductReview(parcel);
        }

        public TGTProductReview[] a(int i)
        {
            return new TGTProductReview[i];
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
    private Date mLastModifiedDateAndTime;
    private Date mModeratedDateAndTime;
    private int mRating;
    private int mRatingRange;
    private String mReview;
    private Date mSubmissionDateAndTime;
    private String mTitle;
    private String mUserLocation;
    private String mUserNickName;

    TGTProductReview()
    {
    }

    private TGTProductReview(Parcel parcel)
    {
        Object obj = null;
        super();
        mTitle = parcel.readString();
        mReview = parcel.readString();
        mUserNickName = parcel.readString();
        mUserLocation = parcel.readString();
        mRating = parcel.readInt();
        mRatingRange = parcel.readInt();
        long l = parcel.readLong();
        Date date;
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mModeratedDateAndTime = date;
        l = parcel.readLong();
        if (l == -1L)
        {
            date = null;
        } else
        {
            date = new Date(l);
        }
        mSubmissionDateAndTime = date;
        l = parcel.readLong();
        if (l == -1L)
        {
            parcel = obj;
        } else
        {
            parcel = new Date(l);
        }
        mLastModifiedDateAndTime = parcel;
    }


    public String a()
    {
        return mTitle;
    }

    public void a(int i)
    {
        mRating = i;
    }

    public void a(String s)
    {
        mTitle = s;
    }

    public void a(Date date)
    {
        mModeratedDateAndTime = date;
    }

    public String b()
    {
        return mReview;
    }

    public void b(int i)
    {
        mRatingRange = i;
    }

    public void b(String s)
    {
        mReview = s;
    }

    public void b(Date date)
    {
        mSubmissionDateAndTime = date;
    }

    public String c()
    {
        return mUserNickName;
    }

    public void c(String s)
    {
        mUserNickName = s;
    }

    public void c(Date date)
    {
        mLastModifiedDateAndTime = date;
    }

    public int d()
    {
        return mRating;
    }

    public void d(String s)
    {
        mUserLocation = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public Date e()
    {
        return mSubmissionDateAndTime;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        long l1 = -1L;
        parcel.writeString(mTitle);
        parcel.writeString(mReview);
        parcel.writeString(mUserNickName);
        parcel.writeString(mUserLocation);
        parcel.writeInt(mRating);
        parcel.writeInt(mRatingRange);
        long l;
        if (mModeratedDateAndTime != null)
        {
            l = mModeratedDateAndTime.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        if (mSubmissionDateAndTime != null)
        {
            l = mSubmissionDateAndTime.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
        l = l1;
        if (mLastModifiedDateAndTime != null)
        {
            l = mLastModifiedDateAndTime.getTime();
        }
        parcel.writeLong(l);
    }

}
