// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.RemoteException;
import android.support.v7.yv;
import com.google.android.gms.maps.model.e;

public final class g
{

    private final yv a;

    g(yv yv1)
    {
        a = yv1;
    }

    public void a(boolean flag)
    {
        try
        {
            a.a(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public void b(boolean flag)
    {
        try
        {
            a.c(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public void c(boolean flag)
    {
        try
        {
            a.h(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }

    public void d(boolean flag)
    {
        try
        {
            a.j(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new e(remoteexception);
        }
    }
}
