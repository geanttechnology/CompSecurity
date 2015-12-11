// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Pagination extends LinearLayout
{
    private static class SavedState extends android.view.View.BaseSavedState
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public SavedState createFromParcel(Parcel parcel)
            {
                return new SavedState(parcel);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public SavedState[] newArray(int i)
            {
                return new SavedState[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };
        int currentPage;
        int numberOfPages;

        public void writeToParcel(Parcel parcel, int i)
        {
            super.writeToParcel(parcel, i);
            parcel.writeInt(currentPage);
            parcel.writeInt(numberOfPages);
        }


        private SavedState(Parcel parcel)
        {
            super(parcel);
            currentPage = parcel.readInt();
            numberOfPages = parcel.readInt();
        }


        SavedState(Parcelable parcelable)
        {
            super(parcelable);
        }
    }


    private static int DEFAULT_MAX_PAGE_COUNT = 5;
    private int currentPage;
    private final int maximumPagesShown;
    private int numberOfPages;

    public Pagination(Context context)
    {
        super(context);
        numberOfPages = 0;
        currentPage = 0;
        maximumPagesShown = DEFAULT_MAX_PAGE_COUNT;
    }

    public Pagination(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        numberOfPages = 0;
        currentPage = 0;
        context = context.obtainStyledAttributes(attributeset, com.ebay.mobile.R.styleable.Pagination, 0, 0);
        maximumPagesShown = context.getInt(0, DEFAULT_MAX_PAGE_COUNT);
        context.recycle();
    }

    public int getCurrentPage()
    {
        return currentPage;
    }

    public int getPageCount()
    {
        return numberOfPages;
    }

    public void onRestoreInstanceState(Parcelable parcelable)
    {
        if (!(parcelable instanceof SavedState))
        {
            super.onRestoreInstanceState(parcelable);
            return;
        } else
        {
            parcelable = (SavedState)parcelable;
            super.onRestoreInstanceState(parcelable.getSuperState());
            setPageCount(((SavedState) (parcelable)).numberOfPages);
            setCurrentPage(((SavedState) (parcelable)).currentPage);
            return;
        }
    }

    public Parcelable onSaveInstanceState()
    {
        SavedState savedstate = new SavedState(super.onSaveInstanceState());
        savedstate.currentPage = currentPage;
        savedstate.numberOfPages = numberOfPages;
        return savedstate;
    }

    public void setCurrentPage(int i)
    {
        currentPage = i;
        if (numberOfPages > 1)
        {
            int j = currentPage % numberOfPages;
            if (j >= 0 && j < numberOfPages)
            {
                i = 0;
                while (i < getChildCount()) 
                {
                    ImageView imageview = (ImageView)getChildAt(i);
                    boolean flag;
                    if (i == j)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    imageview.setSelected(flag);
                    i++;
                }
            }
        }
    }

    public void setPageCount(int i)
    {
        LayoutInflater layoutinflater = LayoutInflater.from(getContext());
        numberOfPages = Math.min(maximumPagesShown, i);
        removeAllViews();
        if (numberOfPages > 1)
        {
            for (i = 0; i < numberOfPages; i++)
            {
                layoutinflater.inflate(0x7f030195, this, true);
            }

        }
    }

}
