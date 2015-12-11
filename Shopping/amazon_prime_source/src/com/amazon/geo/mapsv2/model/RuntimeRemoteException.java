// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.model;

import android.os.RemoteException;

public final class RuntimeRemoteException extends RuntimeException
{

    private static final long serialVersionUID = 0x7c802e1fee2a5a00L;

    public RuntimeRemoteException(RemoteException remoteexception)
    {
        super(remoteexception);
    }
}
