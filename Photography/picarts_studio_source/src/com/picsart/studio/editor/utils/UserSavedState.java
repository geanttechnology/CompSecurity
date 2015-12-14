// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.editor.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class UserSavedState
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public final Object createFromParcel(Parcel parcel)
        {
            if (parcel.readParcelable(null) != null)
            {
                throw new IllegalStateException("superState must be null");
            } else
            {
                return UserSavedState.a();
            }
        }

        public final volatile Object[] newArray(int i)
        {
            return new UserSavedState[i];
        }

    };
    private static final UserSavedState b = new UserSavedState();
    public final Parcelable a;

    private UserSavedState()
    {
        a = null;
    }

    public UserSavedState(Parcel parcel)
    {
        parcel = parcel.readParcelable(getClass().getClassLoader());
        if (parcel == null)
        {
            parcel = b;
        }
        a = parcel;
    }

    public UserSavedState(Parcelable parcelable)
    {
        if (parcelable == null)
        {
            throw new IllegalArgumentException("superState must not be null");
        }
        if (parcelable == b)
        {
            parcelable = null;
        }
        a = parcelable;
    }

    static UserSavedState a()
    {
        return b;
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeParcelable(a, i);
    }

}
