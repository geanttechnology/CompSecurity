// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto.response;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemActions
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new _cls1();
    private boolean allowRating;

    public ItemActions()
    {
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean isAllowRating()
    {
        return allowRating;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        if (allowRating)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
    }



/*
    static boolean access$002(ItemActions itemactions, boolean flag)
    {
        itemactions.allowRating = flag;
        return flag;
    }

*/

    private class _cls1
        implements android.os.Parcelable.Creator
    {

        public final ItemActions createFromParcel(Parcel parcel)
        {
            (new ItemActions()).allowRating = (new OfferUpBoolean(parcel.readInt())).value;
            return null;
        }

        public final volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public final ItemActions[] newArray(int i)
        {
            return new ItemActions[i];
        }

        public final volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

        _cls1()
        {
        }
    }

}
