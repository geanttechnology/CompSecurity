// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Parcel;

public final class l
    implements android.os.Parcelable.Creator
{

    public l()
    {
    }

    public android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState.SavedState a(Parcel parcel)
    {
        return android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState.SavedState.a(parcel);
    }

    public android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState.SavedState[] a(int i)
    {
        return new android.support.v7.app.ActionBarActivityDelegateBase.PanelFeatureState.SavedState[i];
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
