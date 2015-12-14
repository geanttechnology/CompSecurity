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
//            zzkl, zzkm

protected final class zzYb extends zzYb
{

    private final zzkm zzYb;
    final F zzYc;

    private int zzj(int i, int j)
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
        zzkl.zzmQ().zzb("onError: %d", new Object[] {
            Integer.valueOf(i)
        });
        zzkl.zza(zzYc.);
        zzYc.zzYc(new t>(Status.zzaaF));
    }

    public void zza(int i, int j, Surface surface)
    {
        zzkl.zzmQ().zzb("onConnected", new Object[0]);
        DisplayManager displaymanager = (DisplayManager)zzYb.getContext().getSystemService("display");
        if (displaymanager == null)
        {
            zzkl.zzmQ().zzc("Unable to get the display manager", new Object[0]);
            zzYc.zzYc(new t>(Status.zzaaF));
            return;
        }
        zzkl.zza(zzYc.);
        int k = zzj(i, j);
        zzkl.zza(zzYc., displaymanager.createVirtualDisplay("private_display", i, j, k, surface, 2));
        if (zzkl.zzd(zzYc.) == null)
        {
            zzkl.zzmQ().zzc("Unable to create virtual display", new Object[0]);
            zzYc.zzYc(new t>(Status.zzaaF));
            return;
        }
        if (zzkl.zzd(zzYc.).getDisplay() == null)
        {
            zzkl.zzmQ().zzc("Virtual display does not have a display", new Object[0]);
            zzYc.zzYc(new t>(Status.zzaaF));
            return;
        }
        try
        {
            zzYb.zza(this, zzkl.zzd(zzYc.).getDisplay().getDisplayId());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Surface surface) { }
        // Misplaced declaration of an exception variable
        catch (Surface surface) { }
        zzkl.zzmQ().zzc("Unable to provision the route's new virtual Display", new Object[0]);
        zzYc.zzYc(new t>(Status.zzaaF));
    }

    public void zzmR()
    {
        zzkl.zzmQ().zzb("onConnectedWithDisplay", new Object[0]);
        Display display = zzkl.zzd(zzYc.).getDisplay();
        if (display != null)
        {
            zzYc.zzYc(new t>(display));
            return;
        } else
        {
            zzkl.zzmQ().zzc("Virtual display no longer has a display", new Object[0]);
            zzYc.zzYc(new t>(Status.zzaaF));
            return;
        }
    }

    public ( , zzkm zzkm1)
    {
        zzYc = ;
        super(., null);
        zzYb = zzkm1;
    }
}
