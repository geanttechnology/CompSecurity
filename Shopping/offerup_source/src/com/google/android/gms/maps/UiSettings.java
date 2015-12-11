// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps;

import android.os.RemoteException;
import com.google.android.gms.maps.internal.IUiSettingsDelegate;
import com.google.android.gms.maps.model.RuntimeRemoteException;

public final class UiSettings
{

    private final IUiSettingsDelegate zzaJE;

    UiSettings(IUiSettingsDelegate iuisettingsdelegate)
    {
        zzaJE = iuisettingsdelegate;
    }

    public final boolean isCompassEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJE.isCompassEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isIndoorLevelPickerEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJE.isIndoorLevelPickerEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isMapToolbarEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJE.isMapToolbarEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isMyLocationButtonEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJE.isMyLocationButtonEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isRotateGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJE.isRotateGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isScrollGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJE.isScrollGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isTiltGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJE.isTiltGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isZoomControlsEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJE.isZoomControlsEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final boolean isZoomGesturesEnabled()
    {
        boolean flag;
        try
        {
            flag = zzaJE.isZoomGesturesEnabled();
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
        return flag;
    }

    public final void setAllGesturesEnabled(boolean flag)
    {
        try
        {
            zzaJE.setAllGesturesEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setCompassEnabled(boolean flag)
    {
        try
        {
            zzaJE.setCompassEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setIndoorLevelPickerEnabled(boolean flag)
    {
        try
        {
            zzaJE.setIndoorLevelPickerEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setMapToolbarEnabled(boolean flag)
    {
        try
        {
            zzaJE.setMapToolbarEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setMyLocationButtonEnabled(boolean flag)
    {
        try
        {
            zzaJE.setMyLocationButtonEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setRotateGesturesEnabled(boolean flag)
    {
        try
        {
            zzaJE.setRotateGesturesEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setScrollGesturesEnabled(boolean flag)
    {
        try
        {
            zzaJE.setScrollGesturesEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setTiltGesturesEnabled(boolean flag)
    {
        try
        {
            zzaJE.setTiltGesturesEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setZoomControlsEnabled(boolean flag)
    {
        try
        {
            zzaJE.setZoomControlsEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }

    public final void setZoomGesturesEnabled(boolean flag)
    {
        try
        {
            zzaJE.setZoomGesturesEnabled(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            throw new RuntimeRemoteException(remoteexception);
        }
    }
}
