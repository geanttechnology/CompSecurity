// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IInterface;
import android.os.RemoteException;

public interface zzfe
    extends IInterface
{

    public abstract String getProductId()
        throws RemoteException;

    public abstract void recordPlayBillingResolution(int i)
        throws RemoteException;
}
