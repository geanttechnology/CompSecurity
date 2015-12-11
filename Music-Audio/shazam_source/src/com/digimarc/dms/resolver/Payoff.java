// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;

public class Payoff
    implements Parcelable
{

    protected String mCorrelationKey;
    protected String mSubtitle;
    protected boolean mSynthesizedContent;
    protected PointF mThumbnailFocalPt;
    protected String mThumbnailUrl;
    protected String mTitle;

    public Payoff()
    {
    }

    public Payoff(Parcel parcel)
    {
        mTitle = parcel.readString();
        mSubtitle = parcel.readString();
        mThumbnailUrl = parcel.readString();
        mThumbnailFocalPt = new PointF(parcel.readFloat(), parcel.readFloat());
        mCorrelationKey = parcel.readString();
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mSynthesizedContent = flag;
    }

    public Payoff(Payoff payoff)
    {
        mTitle = payoff.mTitle;
        mSubtitle = payoff.mSubtitle;
        mThumbnailUrl = payoff.mThumbnailUrl;
        mThumbnailFocalPt = payoff.mThumbnailFocalPt;
        mCorrelationKey = payoff.mCorrelationKey;
        mSynthesizedContent = payoff.mSynthesizedContent;
    }

    public Payoff(String s, String s1, String s2, PointF pointf)
    {
        mTitle = s;
        mSubtitle = s1;
        mThumbnailUrl = s2;
        mThumbnailFocalPt = pointf;
    }

    public int describeContents()
    {
        return 0;
    }

    public String getCorrelationKey()
    {
        return mCorrelationKey;
    }

    public String getSubtitle()
    {
        return mSubtitle;
    }

    public PointF getThumbnailFocalPt()
    {
        return mThumbnailFocalPt;
    }

    public String getThumbnailUrl()
    {
        return mThumbnailUrl;
    }

    public String getTitle()
    {
        return mTitle;
    }

    public boolean isContentSynthesized()
    {
        return mSynthesizedContent;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mTitle);
        parcel.writeString(mSubtitle);
        parcel.writeString(mThumbnailUrl);
        parcel.writeFloat(mThumbnailFocalPt.x);
        parcel.writeFloat(mThumbnailFocalPt.y);
        parcel.writeString(mCorrelationKey);
        if (mSynthesizedContent)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeByte((byte)i);
    }
}
