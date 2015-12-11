// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings
{

    private final IUiSettingsDelegate zzaCL;

    UiSettings(IUiSettingsDelegate iuisettingsdelegate)
    {
        zzaCL = iuisettingsdelegate;
    }

    public void setAllGesturesEnabled(boolean flag)
    {
        try
        {
            zzaCL.setAllGesturesEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setCompassEnabled(boolean flag)
    {
        try
        {
            zzaCL.setCompassEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setScrollGesturesEnabled(boolean flag)
    {
        try
        {
            zzaCL.setScrollGesturesEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setZoomControlsEnabled(boolean flag)
    {
        try
        {
            zzaCL.setZoomControlsEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setZoomGesturesEnabled(boolean flag)
    {
        try
        {
            zzaCL.setZoomGesturesEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }
}
