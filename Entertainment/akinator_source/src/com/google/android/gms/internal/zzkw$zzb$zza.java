// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.hardware.display.VirtualDisplay;
import android.os.RemoteException;
import android.view.Display;
import android.view.Surface;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzkw, zzkx

protected final class zzZR extends zzZR
{

    private final zzkx zzZR;
    final d zzZS;

    private int zzi(int i, int j)
    {
        if (i >= j)
        {
            i = j;
        }
        return (i * 320) / 1080;
    }

    public void onError(int i)
        throws RemoteException
    {
        zzkw.zznm().zzb("onError: %d", new Object[] {
            Integer.valueOf(i)
        });
        zzkw.zza(zzZS.);
        zzZS.zzZS(new t>(Status.zzabd));
    }

    public void zza(int i, int j, Surface surface)
    {
        zzkw.zznm().zzb("onConnected", new Object[0]);
        DisplayManager displaymanager = (DisplayManager)zzZR.getContext().getSystemService("display");
        if (displaymanager == null)
        {
            zzkw.zznm().zzc("Unable to get the display manager", new Object[0]);
            zzZS.zzZS(new t>(Status.zzabd));
            return;
        }
        zzkw.zza(zzZS.);
        int k = zzi(i, j);
        zzkw.zza(zzZS., displaymanager.createVirtualDisplay("private_display", i, j, k, surface, 2));
        if (zzkw.zzd(zzZS.) == null)
        {
            zzkw.zznm().zzc("Unable to create virtual display", new Object[0]);
            zzZS.zzZS(new t>(Status.zzabd));
            return;
        }
        if (zzkw.zzd(zzZS.).getDisplay() == null)
        {
            zzkw.zznm().zzc("Virtual display does not have a display", new Object[0]);
            zzZS.zzZS(new t>(Status.zzabd));
            return;
        }
        try
        {
            zzZR.zza(this, zzkw.zzd(zzZS.).getDisplay().getDisplayId());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Surface surface) { }
        // Misplaced declaration of an exception variable
        catch (Surface surface) { }
        zzkw.zznm().zzc("Unable to provision the route's new virtual Display", new Object[0]);
        zzZS.zzZS(new t>(Status.zzabd));
    }

    public void zznn()
    {
        zzkw.zznm().zzb("onConnectedWithDisplay", new Object[0]);
        Display display = zzkw.zzd(zzZS.).getDisplay();
        if (display != null)
        {
            zzZS.zzZS(new t>(display));
            return;
        } else
        {
            zzkw.zznm().zzc("Virtual display no longer has a display", new Object[0]);
            zzZS.zzZS(new t>(Status.zzabd));
            return;
        }
    }

    public ( , zzkx zzkx1)
    {
        zzZS = ;
        super(., null);
        zzZR = zzkx1;
    }
}
