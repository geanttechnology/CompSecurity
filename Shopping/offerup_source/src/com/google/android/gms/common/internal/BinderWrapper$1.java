// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.internal;

import android.os.Parcel;

// Referenced classes of package com.google.android.gms.common.internal:
//            BinderWrapper

final class 
    implements android.os.or
{

    public final Object createFromParcel(Parcel parcel)
    {
        return zzaj(parcel);
    }

    public final Object[] newArray(int i)
    {
        return zzbC(i);
    }

    public final BinderWrapper zzaj(Parcel parcel)
    {
        return new BinderWrapper(parcel, null);
    }

    public final BinderWrapper[] zzbC(int i)
    {
        return new BinderWrapper[i];
    }

    ()
    {
    }
}
