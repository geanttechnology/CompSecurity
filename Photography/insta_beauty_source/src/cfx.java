// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public final class cfx
    implements android.os.Parcelable.Creator
{

    public cfx()
    {
    }

    public viewpagerindicator.TitlePageIndicator.SavedState a(Parcel parcel)
    {
        return new viewpagerindicator.TitlePageIndicator.SavedState(parcel, null);
    }

    public viewpagerindicator.TitlePageIndicator.SavedState[] a(int i)
    {
        return new viewpagerindicator.TitlePageIndicator.SavedState[i];
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
