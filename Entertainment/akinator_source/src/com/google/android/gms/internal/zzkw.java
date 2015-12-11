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
//            zzla, zzkx

public class zzkw
    implements CastRemoteDisplayApi
{
    private abstract class zza extends zzky.zza
    {

        final zzkw zzZP;

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

        public void zznn()
            throws RemoteException
        {
            throw new UnsupportedOperationException();
        }

        private zza()
        {
            zzZP = zzkw.this;
            super();
        }

    }

    private abstract class zzb extends zzlb.zza
    {

        final zzkw zzZP;

        protected Result zzb(Status status)
        {
            return zzs(status);
        }

        protected com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult zzs(Status status)
        {
            return new zzc(status);
        }

        public zzb(GoogleApiClient googleapiclient)
        {
            zzZP = zzkw.this;
            super(zzkw.zzc(zzkw.this), googleapiclient);
        }
    }

    protected final class zzb.zza extends zza
    {

        private final zzkx zzZR;
        final zzb zzZS;

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
            zzZS.zzb(new zzc(Status.zzabd));
        }

        public void zza(int i, int j, Surface surface)
        {
            zzkw.zznm().zzb("onConnected", new Object[0]);
            DisplayManager displaymanager = (DisplayManager)zzZR.getContext().getSystemService("display");
            if (displaymanager == null)
            {
                zzkw.zznm().zzc("Unable to get the display manager", new Object[0]);
                zzZS.zzb(new zzc(Status.zzabd));
                return;
            }
            zzkw.zza(zzZS.zzZP);
            int k = zzi(i, j);
            zzkw.zza(zzZS.zzZP, displaymanager.createVirtualDisplay("private_display", i, j, k, surface, 2));
            if (zzkw.zzd(zzZS.zzZP) == null)
            {
                zzkw.zznm().zzc("Unable to create virtual display", new Object[0]);
                zzZS.zzb(new zzc(Status.zzabd));
                return;
            }
            if (zzkw.zzd(zzZS.zzZP).getDisplay() == null)
            {
                zzkw.zznm().zzc("Virtual display does not have a display", new Object[0]);
                zzZS.zzb(new zzc(Status.zzabd));
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
            zzZS.zzb(new zzc(Status.zzabd));
        }

        public void zznn()
        {
            zzkw.zznm().zzb("onConnectedWithDisplay", new Object[0]);
            Display display = zzkw.zzd(zzZS.zzZP).getDisplay();
            if (display != null)
            {
                zzZS.zzb(new zzc(display));
                return;
            } else
            {
                zzkw.zznm().zzc("Virtual display no longer has a display", new Object[0]);
                zzZS.zzb(new zzc(Status.zzabd));
                return;
            }
        }

        public zzb.zza(zzb zzb1, zzkx zzkx1)
        {
            zzZS = zzb1;
            zzb1.zzZP. super();
            zzZR = zzkx1;
        }
    }

    protected final class zzb.zzb extends zza
    {

        final zzb zzZS;

        public void onDisconnected()
            throws RemoteException
        {
            zzkw.zznm().zzb("onDisconnected", new Object[0]);
            zzkw.zza(zzZS.zzZP);
            zzZS.zzb(new zzc(Status.zzabb));
        }

        public void onError(int i)
            throws RemoteException
        {
            zzkw.zznm().zzb("onError: %d", new Object[] {
                Integer.valueOf(i)
            });
            zzkw.zza(zzZS.zzZP);
            zzZS.zzb(new zzc(Status.zzabd));
        }

        protected zzb.zzb(zzb zzb1)
        {
            zzZS = zzb1;
            zzb1.zzZP. super();
        }
    }

    private static final class zzc
        implements com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionResult
    {

        private final Status zzSC;
        private final Display zzVA;

        public Display getPresentationDisplay()
        {
            return zzVA;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        public zzc(Display display)
        {
            zzSC = Status.zzabb;
            zzVA = display;
        }

        public zzc(Status status)
        {
            zzSC = status;
            zzVA = null;
        }
    }


    private static final zzl zzVo = new zzl("CastRemoteDisplayApiImpl");
    private com.google.android.gms.common.api.Api.zzc zzZM;
    private VirtualDisplay zzZN;
    private final zzla zzZO = new zzla.zza() {

        final zzkw zzZP;

        public void zzbg(int i)
        {
            zzkw.zznm().zzb("onRemoteDisplayEnded", new Object[0]);
            zzkw.zza(zzZP);
        }

            
            {
                zzZP = zzkw.this;
                super();
            }
    };

    public zzkw(com.google.android.gms.common.api.Api.zzc zzc1)
    {
        zzZM = zzc1;
    }

    static VirtualDisplay zza(zzkw zzkw1, VirtualDisplay virtualdisplay)
    {
        zzkw1.zzZN = virtualdisplay;
        return virtualdisplay;
    }

    static void zza(zzkw zzkw1)
    {
        zzkw1.zznl();
    }

    static zzla zzb(zzkw zzkw1)
    {
        return zzkw1.zzZO;
    }

    static com.google.android.gms.common.api.Api.zzc zzc(zzkw zzkw1)
    {
        return zzkw1.zzZM;
    }

    static VirtualDisplay zzd(zzkw zzkw1)
    {
        return zzkw1.zzZN;
    }

    private void zznl()
    {
        if (zzZN != null)
        {
            if (zzZN.getDisplay() != null)
            {
                zzVo.zzb((new StringBuilder()).append("releasing virtual display: ").append(zzZN.getDisplay().getDisplayId()).toString(), new Object[0]);
            }
            zzZN.release();
            zzZN = null;
        }
    }

    static zzl zznm()
    {
        return zzVo;
    }

    public PendingResult startRemoteDisplay(GoogleApiClient googleapiclient, String s)
    {
        zzVo.zzb("startRemoteDisplay", new Object[0]);
        return googleapiclient.zzb(new zzb(googleapiclient, s) {

            final zzkw zzZP;
            final String zzZQ;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzkx)zzb1);
            }

            protected void zza(zzkx zzkx1)
                throws RemoteException
            {
                zzkx1.zza(new zzb.zza(this, zzkx1), zzkw.zzb(zzZP), zzZQ);
            }

            
            {
                zzZP = zzkw.this;
                zzZQ = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult stopRemoteDisplay(GoogleApiClient googleapiclient)
    {
        zzVo.zzb("stopRemoteDisplay", new Object[0]);
        return googleapiclient.zzb(new zzb(googleapiclient) {

            final zzkw zzZP;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzkx)zzb1);
            }

            protected void zza(zzkx zzkx1)
                throws RemoteException
            {
                zzkx1.zza(new zzb.zzb(this));
            }

            
            {
                zzZP = zzkw.this;
                super(googleapiclient);
            }
        });
    }

}
