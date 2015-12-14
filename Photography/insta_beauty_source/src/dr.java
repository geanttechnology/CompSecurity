// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public final class dr
    implements android.os.Parcelable.Creator
{

    public dr()
    {
    }

    public android.support.v7.internal.widget.SpinnerCompat.SavedState a(Parcel parcel)
    {
        return new android.support.v7.internal.widget.SpinnerCompat.SavedState(parcel, null);
    }

    public android.support.v7.internal.widget.SpinnerCompat.SavedState[] a(int i)
    {
        return new android.support.v7.internal.widget.SpinnerCompat.SavedState[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }
}
