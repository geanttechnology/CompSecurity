// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.plus.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.plus.internal.model.people.PersonEntity;

public interface zzb
    extends IInterface
{

    public abstract void zza(int i, Bundle bundle, Bundle bundle1);

    public abstract void zza(int i, Bundle bundle, ParcelFileDescriptor parcelfiledescriptor);

    public abstract void zza(int i, Bundle bundle, SafeParcelResponse safeparcelresponse);

    public abstract void zza(int i, PersonEntity personentity);

    public abstract void zza(DataHolder dataholder, String s);

    public abstract void zza(DataHolder dataholder, String s, String s1);

    public abstract void zzaI(Status status);

    public abstract void zzdn(String s);

    public abstract void zzdo(String s);

    public abstract void zzj(int i, Bundle bundle);
}
