// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.widget;

import android.os.Parcel;

final class h
    implements android.os.Parcelable.Creator
{

    h()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new DrawerLayout.SavedState(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new DrawerLayout.SavedState[i];
    }
}
