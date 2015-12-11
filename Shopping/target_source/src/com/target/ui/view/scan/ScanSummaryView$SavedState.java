// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.scan;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.scan:
//            ScanSummaryView

public static class <init> extends android.view.SavedState
{

    public static final android.os.w.SavedState.savedItems CREATOR = new android.os.Parcelable.Creator() {

        public ScanSummaryView.SavedState a(Parcel parcel)
        {
            return new ScanSummaryView.SavedState(parcel, null);
        }

        public ScanSummaryView.SavedState[] a(int i)
        {
            return new ScanSummaryView.SavedState[i];
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
    private List savedItems;

    static List a(<init> <init>1)
    {
        return <init>1.savedItems;
    }

    static List a(savedItems saveditems, List list)
    {
        saveditems.savedItems = list;
        return list;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        super.Parcel(parcel, i);
        parcel.writeList(savedItems);
    }


    private _cls1(Parcel parcel)
    {
        super(parcel);
        savedItems = new ArrayList();
        parcel.readList(savedItems, getClass().getClassLoader());
    }

    savedItems(Parcel parcel, savedItems saveditems)
    {
        this(parcel);
    }

    <init>(Parcelable parcelable)
    {
        super(parcelable);
    }
}
