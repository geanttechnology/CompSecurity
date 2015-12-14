// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.app;

import android.os.Parcel;

final class Y
    implements android.os.avedState._cls1
{

    public Y a(Parcel parcel)
    {
        return Y(parcel);
    }

    public Y[] a(int i)
    {
        return new Y[i];
    }

    public Object createFromParcel(Parcel parcel)
    {
        return a(parcel);
    }

    public Object[] newArray(int i)
    {
        return a(i);
    }

    Y()
    {
    }
}
