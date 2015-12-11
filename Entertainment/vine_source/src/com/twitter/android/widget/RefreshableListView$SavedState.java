// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twitter.android.widget;

import android.os.Parcel;
import android.os.Parcelable;

// Referenced classes of package com.twitter.android.widget:
//            RefreshableListView

static class mode extends android.view.ew.SavedState
{

    public static final android.os.View.SavedState.mode CREATOR = new android.os.Parcelable.Creator() {

        public RefreshableListView.SavedState createFromParcel(Parcel parcel)
        {
            return new RefreshableListView.SavedState(parcel);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public RefreshableListView.SavedState[] newArray(int i)
        {
            return new RefreshableListView.SavedState[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public int mode;
    public boolean refreshable;

    public void writeToParcel(Parcel parcel, int i)
    {
        super.el(parcel, i);
        if (refreshable)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeInt(mode);
    }


    public _cls1(Parcel parcel)
    {
        boolean flag = true;
        super(parcel);
        if (parcel.readInt() != 1)
        {
            flag = false;
        }
        refreshable = flag;
        mode = parcel.readInt();
    }

    public mode(Parcelable parcelable)
    {
        super(parcelable);
    }
}
