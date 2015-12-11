// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.zzx;

public abstract class WriteAwareParcelable
    implements Parcelable
{

    private volatile transient boolean zzajv;

    public WriteAwareParcelable()
    {
        zzajv = false;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag;
        if (!zzrd())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        zzajv = true;
        zzJ(parcel, i);
    }

    protected abstract void zzJ(Parcel parcel, int i);

    public final boolean zzrd()
    {
        return zzajv;
    }
}
