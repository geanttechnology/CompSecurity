// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.model.list;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.util.ab;
import org.ocpsoft.prettytime.c;

public class ListCollectionItem
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ListCollectionItem a(Parcel parcel)
        {
            return new ListCollectionItem(parcel);
        }

        public ListCollectionItem[] a(int i)
        {
            return new ListCollectionItem[i];
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
    private static c sPrettyTime = new c();
    private boolean mActionEnabled;
    private String mDescription;
    private String mItemCount;
    private ListSummary mListSummary;
    private String mLocation;
    private String mOrganization;
    private String mTitle;
    private String mUpdated;

    private ListCollectionItem(Parcel parcel)
    {
        mTitle = parcel.readString();
        mDescription = parcel.readString();
        mLocation = parcel.readString();
        mOrganization = parcel.readString();
        mItemCount = parcel.readString();
        mUpdated = parcel.readString();
        mListSummary = (ListSummary)parcel.readParcelable(com/target/mothership/model/list/interfaces/ListSummary.getClassLoader());
        boolean flag;
        if (parcel.readByte() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        mActionEnabled = flag;
    }


    public ListCollectionItem(ListSummary listsummary, Context context)
    {
        mTitle = listsummary.getTitle();
        mDescription = listsummary.getDescription();
        mLocation = listsummary.getLocation();
        mOrganization = listsummary.getOrganization();
        mUpdated = (new StringBuilder()).append(context.getResources().getString(0x7f090520)).append(" ").append(sPrettyTime.b(listsummary.getLastModifiedDate())).toString();
        mItemCount = ab.a(listsummary.getItemCount(), 0x7f110003);
        mListSummary = listsummary;
    }

    public String a()
    {
        return mUpdated;
    }

    public void a(ListSummary listsummary)
    {
        mListSummary = listsummary;
    }

    public void a(String s)
    {
        mTitle = s;
    }

    public void a(boolean flag)
    {
        mActionEnabled = flag;
    }

    public String b()
    {
        return mTitle;
    }

    public void b(String s)
    {
        mDescription = s;
    }

    public String c()
    {
        return mItemCount;
    }

    public void c(String s)
    {
        mLocation = s;
    }

    public ListSummary d()
    {
        return mListSummary;
    }

    public void d(String s)
    {
        mOrganization = s;
    }

    public int describeContents()
    {
        return 0;
    }

    public void e(String s)
    {
        mUpdated = s;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeString(mTitle);
        parcel.writeString(mDescription);
        parcel.writeString(mLocation);
        parcel.writeString(mOrganization);
        parcel.writeString(mItemCount);
        parcel.writeString(mUpdated);
        parcel.writeParcelable(mListSummary, i);
        byte byte0;
        if (mActionEnabled)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        parcel.writeByte(byte0);
    }

}
