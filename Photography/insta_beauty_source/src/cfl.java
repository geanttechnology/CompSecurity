// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public final class cfl
    implements android.os.Parcelable.Creator
{

    public cfl()
    {
    }

    public viewpagerindicator.CirclePageIndicator.SavedState a(Parcel parcel)
    {
        return new viewpagerindicator.CirclePageIndicator.SavedState(parcel, null);
    }

    public viewpagerindicator.CirclePageIndicator.SavedState[] a(int i)
    {
        return new viewpagerindicator.CirclePageIndicator.SavedState[i];
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
