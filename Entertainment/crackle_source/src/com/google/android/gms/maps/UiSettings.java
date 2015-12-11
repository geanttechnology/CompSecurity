// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings
{

    private final IUiSettingsDelegate Ch;

    UiSettings(IUiSettingsDelegate iuisettingsdelegate)
    {
        Ch = iuisettingsdelegate;
    }

    public boolean isCompassEnabled()
    {
        boolean flag;
        try
        {
            flag = Ch.isCompassEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isMyLocationButtonEnabled()
    {
        boolean flag;
        try
        {
            flag = Ch.isMyLocationButtonEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isRotateGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = Ch.isRotateGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isScrollGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = Ch.isScrollGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isTiltGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = Ch.isTiltGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isZoomControlsEnabled()
    {
        boolean flag;
        try
        {
            flag = Ch.isZoomControlsEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public boolean isZoomGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = Ch.isZoomGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public void setAllGesturesEnabled(boolean flag)
    {
        try
        {
            Ch.setAllGesturesEnabled(flag);
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
            Ch.setCompassEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setMyLocationButtonEnabled(boolean flag)
    {
        try
        {
            Ch.setMyLocationButtonEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setRotateGesturesEnabled(boolean flag)
    {
        try
        {
            Ch.setRotateGesturesEnabled(flag);
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
            Ch.setScrollGesturesEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public void setTiltGesturesEnabled(boolean flag)
    {
        try
        {
            Ch.setTiltGesturesEnabled(flag);
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
            Ch.setZoomControlsEnabled(flag);
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
            Ch.setZoomGesturesEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }
}
