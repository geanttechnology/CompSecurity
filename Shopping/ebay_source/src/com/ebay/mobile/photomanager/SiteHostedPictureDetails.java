// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.photomanager;

import android.os.Parcel;
import android.os.Parcelable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public final class SiteHostedPictureDetails
    implements Parcelable
{
    public static final class Member
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public Member createFromParcel(Parcel parcel)
            {
                Member member = new Member();
                member.url = SiteHostedPictureDetails.readUrl(parcel);
                member.height = parcel.readInt();
                member.width = parcel.readInt();
                return member;
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public Member[] newArray(int i)
            {
                return new Member[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        public int height;
        public URL url;
        public int width;

        public int describeContents()
        {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i)
        {
            SiteHostedPictureDetails.write(parcel, url);
            parcel.writeInt(height);
            parcel.writeInt(width);
        }


        public Member()
        {
            url = null;
            height = 0;
            width = 0;
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public SiteHostedPictureDetails createFromParcel(Parcel parcel)
        {
            SiteHostedPictureDetails sitehostedpicturedetails = new SiteHostedPictureDetails();
            sitehostedpicturedetails.baseUrl = SiteHostedPictureDetails.readUrl(parcel);
            sitehostedpicturedetails.fullUrl = SiteHostedPictureDetails.readUrl(parcel);
            sitehostedpicturedetails.pictureFormat = parcel.readString();
            sitehostedpicturedetails.pictureSet = parcel.readString();
            sitehostedpicturedetails.useBy = SiteHostedPictureDetails.readDate(parcel);
            int j = parcel.readInt();
            sitehostedpicturedetails.members.ensureCapacity(j);
            for (int i = 0; i < j; i++)
            {
                sitehostedpicturedetails.members.add(Member.CREATOR.createFromParcel(parcel));
            }

            return sitehostedpicturedetails;
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public SiteHostedPictureDetails[] newArray(int i)
        {
            return new SiteHostedPictureDetails[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public URL baseUrl;
    public URL fullUrl;
    public ArrayList members;
    public String pictureFormat;
    public String pictureSet;
    public Date useBy;

    public SiteHostedPictureDetails()
    {
        baseUrl = null;
        fullUrl = null;
        pictureFormat = null;
        pictureSet = null;
        members = new ArrayList();
        useBy = null;
    }

    static final Date readDate(Parcel parcel)
    {
        long l = parcel.readLong();
        if (l != -1L)
        {
            return new Date(l);
        } else
        {
            return null;
        }
    }

    static final URL readUrl(Parcel parcel)
    {
        parcel = parcel.readString();
        if (parcel == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        parcel = new URL(parcel);
        return parcel;
        parcel;
        parcel.printStackTrace();
        return null;
    }

    static final void write(Parcel parcel, URL url)
    {
        if (url != null)
        {
            url = url.toString();
        } else
        {
            url = null;
        }
        parcel.writeString(url);
    }

    static final void write(Parcel parcel, Date date)
    {
        long l;
        if (date != null)
        {
            l = date.getTime();
        } else
        {
            l = -1L;
        }
        parcel.writeLong(l);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        write(parcel, baseUrl);
        write(parcel, fullUrl);
        parcel.writeString(pictureFormat);
        parcel.writeString(pictureSet);
        write(parcel, useBy);
        parcel.writeInt(members.size());
        for (Iterator iterator = members.iterator(); iterator.hasNext(); ((Member)iterator.next()).writeToParcel(parcel, i)) { }
    }

}
