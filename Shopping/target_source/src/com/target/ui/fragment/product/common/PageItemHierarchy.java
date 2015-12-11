// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.target.mothership.model.page_item.interfaces.PageItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PageItemHierarchy
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public PageItemHierarchy a(Parcel parcel)
        {
            return new PageItemHierarchy(parcel);
        }

        public PageItemHierarchy[] a(int i)
        {
            return new PageItemHierarchy[i];
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
    private static final int FLAG_PREVIOUS_CATEGORIES_ABSENT = 0;
    private static final int FLAG_PREVIOUS_CATEGORIES_PRESENT = 1;
    private final PageItem mPageItem;
    private final List mPreviousPageItems;

    public PageItemHierarchy(Parcel parcel)
    {
        mPageItem = (PageItem)parcel.readParcelable(com/target/mothership/model/page_item/interfaces/PageItem.getClassLoader());
        if (parcel.readInt() == 0)
        {
            mPreviousPageItems = Collections.emptyList();
            return;
        } else
        {
            mPreviousPageItems = new ArrayList();
            parcel.readList(mPreviousPageItems, com/target/mothership/model/page_item/interfaces/PageItem.getClassLoader());
            return;
        }
    }

    public PageItemHierarchy(PageItem pageitem, List list)
    {
        if (pageitem == null)
        {
            throw new IllegalArgumentException("currentPageItem cannot be null");
        }
        mPageItem = pageitem;
        pageitem = list;
        if (list == null)
        {
            pageitem = Collections.emptyList();
        }
        mPreviousPageItems = pageitem;
    }

    public PageItem a()
    {
        return mPageItem;
    }

    public List b()
    {
        return mPreviousPageItems;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(mPageItem, i);
        if (mPreviousPageItems.isEmpty())
        {
            parcel.writeInt(0);
            return;
        } else
        {
            parcel.writeInt(1);
            parcel.writeList(mPreviousPageItems);
            return;
        }
    }

}
