// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.design.widget;

import android.os.Parcel;

final class w
    implements android.os.Parcelable.Creator
{

    w()
    {
    }

    public final Object createFromParcel(Parcel parcel)
    {
        return new CoordinatorLayout.SavedState(parcel);
    }

    public final volatile Object[] newArray(int i)
    {
        return new CoordinatorLayout.SavedState[i];
    }
}
