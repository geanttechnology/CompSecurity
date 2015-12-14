// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public final class cfq
    implements android.os.Parcelable.Creator
{

    public cfq()
    {
    }

    public viewpagerindicator.LinePageIndicator.SavedState a(Parcel parcel)
    {
        return new viewpagerindicator.LinePageIndicator.SavedState(parcel, null);
    }

    public viewpagerindicator.LinePageIndicator.SavedState[] a(int i)
    {
        return new viewpagerindicator.LinePageIndicator.SavedState[i];
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
