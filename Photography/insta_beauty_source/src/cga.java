// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public final class cga
    implements android.os.Parcelable.Creator
{

    public cga()
    {
    }

    public viewpagerindicator.UnderlinePageIndicator.SavedState a(Parcel parcel)
    {
        return new viewpagerindicator.UnderlinePageIndicator.SavedState(parcel, null);
    }

    public viewpagerindicator.UnderlinePageIndicator.SavedState[] a(int i)
    {
        return new viewpagerindicator.UnderlinePageIndicator.SavedState[i];
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
