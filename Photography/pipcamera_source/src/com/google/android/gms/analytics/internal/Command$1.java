// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.os.Parcel;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            Command

final class _cls9
    implements android.os..Creator
{

    public Object createFromParcel(Parcel parcel)
    {
        return zzq(parcel);
    }

    public Object[] newArray(int i)
    {
        return zzaa(i);
    }

    public Command[] zzaa(int i)
    {
        return new Command[i];
    }

    public Command zzq(Parcel parcel)
    {
        return new Command(parcel);
    }

    _cls9()
    {
    }
}
