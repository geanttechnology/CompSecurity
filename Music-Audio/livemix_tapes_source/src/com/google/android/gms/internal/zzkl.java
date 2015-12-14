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
import com.google.android.gms.cast.CastRemoteDisplayApi;
import com.google.android.gms.cast.internal.zzl;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzkp, zzkm

public class zzkl
    implements CastRemoteDisplayApi
{
    private abstract class zza extends zzkn.zza
    {

        final zzkl zzXZ;

        public void onDisconnected()
            throws RemoteException
        {
            throw new UnsupportedOperationException();
        }

        public void onError(int i)
            throws RemoteException
        {
            throw new UnsupportedOperationException();
        }

        public void zza(int i, int j, Surface surface)
            throws RemoteException
        {
            throw new UnsupportedOperationException();
        }

        public void zzmR()
            throws RemoteException
        {
            throw new UnsupportedOperationException();
        }

        private zza()
        {
            zzXZ = zzkl.this;
            super();
        }

    }

    private abstract class zzb extends com.google.android.gms.common.api.zzc.zza
    {

        final zzkl zzXZ;

        protected Result zzb(Status status)
        {
            return zzv(status);
        }

        protected com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult zzv(Status status)
        {
            return new zzc(status);
        }

        public zzb(GoogleApiClient googleapiclient)
        {
            zzXZ = zzkl.this;
            super(zzkl.zzc(zzkl.this), googleapiclient);
        }
    }

    protected final class zzb.zza extends zza
    {

        private final zzkm zzYb;
        final zzb zzYc;

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
            zzkl.zza(zzYc.zzXZ);
            zzYc.zza(new zzc(Status.zzaaF));
        }

        public void zza(int i, int j, Surface surface)
        {
            zzkl.zzmQ().zzb("onConnected", new Object[0]);
            DisplayManager displaymanager = (DisplayManager)zzYb.getContext().getSystemService("display");
            if (displaymanager == null)
            {
                zzkl.zzmQ().zzc("Unable to get the display manager", new Object[0]);
                zzYc.zza(new zzc(Status.zzaaF));
                return;
            }
            zzkl.zza(zzYc.zzXZ);
            int k = zzj(i, j);
            zzkl.zza(zzYc.zzXZ, displaymanager.createVirtualDisplay("private_display", i, j, k, surface, 2));
            if (zzkl.zzd(zzYc.zzXZ) == null)
            {
                zzkl.zzmQ().zzc("Unable to create virtual display", new Object[0]);
                zzYc.zza(new zzc(Status.zzaaF));
                return;
            }
            if (zzkl.zzd(zzYc.zzXZ).getDisplay() == null)
            {
                zzkl.zzmQ().zzc("Virtual display does not have a display", new Object[0]);
                zzYc.zza(new zzc(Status.zzaaF));
                return;
            }
            try
            {
                zzYb.zza(this, zzkl.zzd(zzYc.zzXZ).getDisplay().getDisplayId());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Surface surface) { }
            // Misplaced declaration of an exception variable
            catch (Surface surface) { }
            zzkl.zzmQ().zzc("Unable to provision the route's new virtual Display", new Object[0]);
            zzYc.zza(new zzc(Status.zzaaF));
        }

        public void zzmR()
        {
            zzkl.zzmQ().zzb("onConnectedWithDisplay", new Object[0]);
            Display display = zzkl.zzd(zzYc.zzXZ).getDisplay();
            if (display != null)
            {
                zzYc.zza(new zzc(display));
                return;
            } else
            {
                zzkl.zzmQ().zzc("Virtual display no longer has a display", new Object[0]);
                zzYc.zza(new zzc(Status.zzaaF));
                return;
            }
        }

        public zzb.zza(zzb zzb1, zzkm zzkm1)
        {
            zzYc = zzb1;
            zzb1.zzXZ. super();
            zzYb = zzkm1;
        }
    }

    protected final class zzb.zzb extends zza
    {

        final zzb zzYc;

        public void onDisconnected()
            throws RemoteException
        {
            zzkl.zzmQ().zzb("onDisconnected", new Object[0]);
            zzkl.zza(zzYc.zzXZ);
            zzYc.zza(new zzc(Status.zzaaD));
        }

        public void onError(int i)
            throws RemoteException
        {
            zzkl.zzmQ().zzb("onError: %d", new Object[] {
                Integer.valueOf(i)
            });
            zzkl.zza(zzYc.zzXZ);
            zzYc.zza(new zzc(Status.zzaaF));
        }

        protected zzb.zzb(zzb zzb1)
        {
            zzYc = zzb1;
            zzb1.zzXZ. super();
        }
    }

    private static final class zzc
        implements com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult
    {

        private final Status zzQA;
        private final Display zzTK;

        public Display getPresentationDisplay()
        {
            return zzTK;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public zzc(Display display)
        {
            zzQA = Status.zzaaD;
            zzTK = display;
        }

        public zzc(Status status)
        {
            zzQA = status;
            zzTK = null;
        }
    }


    private static final zzl zzTy = new zzl("CastRemoteDisplayApiImpl");
    private com.google.android.gms.common.api.Api.zzc zzXW;
    private VirtualDisplay zzXX;
    private final zzkp zzXY = new zzkp.zza() {

        final zzkl zzXZ;

        public void zzaZ(int i)
        {
            zzkl.zzmQ().zzb("onRemoteDisplayEnded", new Object[0]);
            zzkl.zza(zzXZ);
        }

            
            {
                zzXZ = zzkl.this;
                super();
            }
    };

    public zzkl(com.google.android.gms.common.api.Api.zzc zzc1)
    {
        zzXW = zzc1;
    }

    static VirtualDisplay zza(zzkl zzkl1, VirtualDisplay virtualdisplay)
    {
        zzkl1.zzXX = virtualdisplay;
        return virtualdisplay;
    }

    static void zza(zzkl zzkl1)
    {
        zzkl1.zzmP();
    }

    static zzkp zzb(zzkl zzkl1)
    {
        return zzkl1.zzXY;
    }

    static com.google.android.gms.common.api.Api.zzc zzc(zzkl zzkl1)
    {
        return zzkl1.zzXW;
    }

    static VirtualDisplay zzd(zzkl zzkl1)
    {
        return zzkl1.zzXX;
    }

    private void zzmP()
    {
        if (zzXX != null)
        {
            if (zzXX.getDisplay() != null)
            {
                zzTy.zzb((new StringBuilder()).append("releasing virtual display: ").append(zzXX.getDisplay().getDisplayId()).toString(), new Object[0]);
            }
            zzXX.release();
            zzXX = null;
        }
    }

    static zzl zzmQ()
    {
        return zzTy;
    }

    public PendingResult startRemoteDisplay(GoogleApiClient googleapiclient, String s)
    {
        zzTy.zzb("startRemoteDisplay", new Object[0]);
        return googleapiclient.zzb(new zzb(googleapiclient, s) {

            final zzkl zzXZ;
            final String zzYa;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzkm)zzb1);
            }

            protected void zza(zzkm zzkm1)
                throws RemoteException
            {
                zzkm1.zza(new zzb.zza(this, zzkm1), zzkl.zzb(zzXZ), zzYa);
            }

            
            {
                zzXZ = zzkl.this;
                zzYa = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult stopRemoteDisplay(GoogleApiClient googleapiclient)
    {
        zzTy.zzb("stopRemoteDisplay", new Object[0]);
        return googleapiclient.zzb(new zzb(googleapiclient) {

            final zzkl zzXZ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzkm)zzb1);
            }

            protected void zza(zzkm zzkm1)
                throws RemoteException
            {
                zzkm1.zza(new zzb.zzb(this));
            }

            
            {
                zzXZ = zzkl.this;
                super(googleapiclient);
            }
        });
    }

}
