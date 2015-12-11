// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import android.os.IInterface;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

public interface zzd
    extends IInterface
{

    public abstract void zza(GoogleSignInAccount googlesigninaccount, Status status);

    public abstract void zza(Status status, Intent intent);

    public abstract void zzk(Status status);

    public abstract void zzl(Status status);

    public abstract void zzm(Status status);
}
