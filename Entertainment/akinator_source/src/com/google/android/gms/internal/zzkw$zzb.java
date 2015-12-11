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
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzkw, zzkx

private abstract class  extends 
{
    protected final class zza extends zzkw.zza
    {

        private final zzkx zzZR;
        final zzkw.zzb zzZS;

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
            zzkw.zza(zzZS.zzZP);
            zzZS.zzb(new zzkw.zzc(Status.zzabd));
        }

        public void zza(int i, int j, Surface surface)
        {
            zzkw.zznm().zzb("onConnected", new Object[0]);
            DisplayManager displaymanager = (DisplayManager)zzZR.getContext().getSystemService("display");
            if (displaymanager == null)
            {
                zzkw.zznm().zzc("Unable to get the display manager", new Object[0]);
                zzZS.zzb(new zzkw.zzc(Status.zzabd));
                return;
            }
            zzkw.zza(zzZS.zzZP);
            int k = zzi(i, j);
            zzkw.zza(zzZS.zzZP, displaymanager.createVirtualDisplay("private_display", i, j, k, surface, 2));
            if (zzkw.zzd(zzZS.zzZP) == null)
            {
                zzkw.zznm().zzc("Unable to create virtual display", new Object[0]);
                zzZS.zzb(new zzkw.zzc(Status.zzabd));
                return;
            }
            if (zzkw.zzd(zzZS.zzZP).getDisplay() == null)
            {
                zzkw.zznm().zzc("Virtual display does not have a display", new Object[0]);
                zzZS.zzb(new zzkw.zzc(Status.zzabd));
                return;
            }
            try
            {
                zzZR.zza(this, zzkw.zzd(zzZS.zzZP).getDisplay().getDisplayId());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Surface surface) { }
            // Misplaced declaration of an exception variable
            catch (Surface surface) { }
            zzkw.zznm().zzc("Unable to provision the route's new virtual Display", new Object[0]);
            zzZS.zzb(new zzkw.zzc(Status.zzabd));
        }

        public void zznn()
        {
            zzkw.zznm().zzb("onConnectedWithDisplay", new Object[0]);
            Display display = zzkw.zzd(zzZS.zzZP).getDisplay();
            if (display != null)
            {
                zzZS.zzb(new zzkw.zzc(display));
                return;
            } else
            {
                zzkw.zznm().zzc("Virtual display no longer has a display", new Object[0]);
                zzZS.zzb(new zzkw.zzc(Status.zzabd));
                return;
            }
        }

        public zza(zzkx zzkx1)
        {
            zzZS = zzkw.zzb.this;
            super(zzZP, null);
            zzZR = zzkx1;
        }
    }

    protected final class zzb extends zzkw.zza
    {

        final zzkw.zzb zzZS;

        public void onDisconnected()
            throws RemoteException
        {
            zzkw.zznm().zzb("onDisconnected", new Object[0]);
            zzkw.zza(zzZS.zzZP);
            zzZS.zzb(new zzkw.zzc(Status.zzabb));
        }

        public void onError(int i)
            throws RemoteException
        {
            zzkw.zznm().zzb("onError: %d", new Object[] {
                Integer.valueOf(i)
            });
            zzkw.zza(zzZS.zzZP);
            zzZS.zzb(new zzkw.zzc(Status.zzabd));
        }

        protected zzb()
        {
            zzZS = zzkw.zzb.this;
            super(zzZP, null);
        }
    }


    final zzkw zzZP;

    protected Result zzb(Status status)
    {
        return zzs(status);
    }

    protected com.google.android.gms.cast.eDisplay.CastRemoteDisplaySessionResult zzs(Status status)
    {
        return new <init>(status);
    }

    public piClient(zzkw zzkw1, GoogleApiClient googleapiclient)
    {
        zzZP = zzkw1;
        super(zzkw.zzc(zzkw1), googleapiclient);
    }
}
