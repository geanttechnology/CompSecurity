// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.page_item.handler;

import android.os.Parcel;
import com.google.a.a.e;
import com.target.mothership.model.page_item.interfaces.PageItem;
import com.target.mothership.model.page_item.interfaces.PageItemCollection;
import com.target.mothership.util.k;
import java.util.ArrayList;
import java.util.List;

class TGTPageItemCollection
    implements PageItemCollection
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public TGTPageItemCollection a(Parcel parcel)
        {
            return new TGTPageItemCollection(parcel);
        }

        public TGTPageItemCollection[] a(int i)
        {
            return new TGTPageItemCollection[i];
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
    private List mPageItems;
    private String mTitle;

    public TGTPageItemCollection()
    {
    }

    private TGTPageItemCollection(Parcel parcel)
    {
        mPageItems = new ArrayList();
        parcel.readList(mPageItems, com/target/mothership/model/page_item/interfaces/PageItem.getClassLoader());
        mTitle = parcel.readString();
    }


    public List a()
    {
        return k.a(mPageItems);
    }

    public void a(String s)
    {
        mTitle = s;
    }

    public void a(List list)
    {
        mPageItems = list;
    }

    public e b()
    {
        return e.c(mTitle);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeList(mPageItems);
        parcel.writeString(mTitle);
    }

}
