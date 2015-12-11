// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl, FusedLocationProviderResult, LocationRequestInternal

public class zzd
    implements FusedLocationProviderApi
{
    private static abstract class zza extends com.google.android.gms.location.LocationServices.zza
    {

        public Result zzb(Status status)
        {
            return zzd(status);
        }

        public Status zzd(Status status)
        {
            return status;
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }


    public zzd()
    {
    }

    public Location getLastLocation(GoogleApiClient googleapiclient)
    {
        googleapiclient = LocationServices.zzd(googleapiclient);
        try
        {
            googleapiclient = googleapiclient.getLastLocation();
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            return null;
        }
        return googleapiclient;
    }

    public LocationAvailability getLocationAvailability(GoogleApiClient googleapiclient)
    {
        googleapiclient = LocationServices.zzd(googleapiclient);
        try
        {
            googleapiclient = googleapiclient.zzwD();
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            return null;
        }
        return googleapiclient;
    }

    public PendingResult removeLocationUpdates(GoogleApiClient googleapiclient, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, pendingintent) {

            final PendingIntent zzaEY;
            final zzd zzaFf;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzg.zza zza1 = new zzg.zza(this) {

                    final _cls9 zzaFq;

                    public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                    {
                        zzaFq.zzb(fusedlocationproviderresult.getStatus());
                    }

            
            {
                zzaFq = _pcls9;
                super();
            }
                };
                zzl1.zza(zzaEY, zza1);
            }

            
            {
                zzaFf = zzd.this;
                zzaEY = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult removeLocationUpdates(GoogleApiClient googleapiclient, LocationCallback locationcallback)
    {
        return googleapiclient.zzb(new zza(googleapiclient, locationcallback) {

            final zzd zzaFf;
            final LocationCallback zzaFh;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzg.zza zza1 = new zzg.zza(this) {

                    final _cls2 zzaFi;

                    public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                    {
                        zzaFi.zzb(fusedlocationproviderresult.getStatus());
                    }

            
            {
                zzaFi = _pcls2;
                super();
            }
                };
                zzl1.zza(zzaFh, zza1);
            }

            
            {
                zzaFf = zzd.this;
                zzaFh = locationcallback;
                super(googleapiclient);
            }
        });
    }

    public PendingResult removeLocationUpdates(GoogleApiClient googleapiclient, LocationListener locationlistener)
    {
        return googleapiclient.zzb(new zza(googleapiclient, locationlistener) {

            final LocationListener zzaFe;
            final zzd zzaFf;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzg.zza zza1 = new zzg.zza(this) {

                    final _cls8 zzaFp;

                    public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                    {
                        zzaFp.zzb(fusedlocationproviderresult.getStatus());
                    }

            
            {
                zzaFp = _pcls8;
                super();
            }
                };
                zzl1.zza(zzaFe, zza1);
            }

            
            {
                zzaFf = zzd.this;
                zzaFe = locationlistener;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new zza(googleapiclient, locationrequest, pendingintent) {

            final PendingIntent zzaEY;
            final LocationRequest zzaFd;
            final zzd zzaFf;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzg.zza zza1 = new zzg.zza(this) {

                    final _cls7 zzaFo;

                    public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                    {
                        zzaFo.zzb(fusedlocationproviderresult.getStatus());
                    }

            
            {
                zzaFo = _pcls7;
                super();
            }
                };
                zzl1.zza(zzaFd, zzaEY, zza1);
            }

            
            {
                zzaFf = zzd.this;
                zzaFd = locationrequest;
                zzaEY = pendingintent;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationCallback locationcallback, Looper looper)
    {
        return googleapiclient.zzb(new zza(googleapiclient, locationrequest, locationcallback, looper) {

            final LocationRequest zzaFd;
            final zzd zzaFf;
            final LocationCallback zzaFh;
            final Looper zzaFl;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzg.zza zza1 = new zzg.zza(this) {

                    final _cls6 zzaFn;

                    public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                    {
                        zzaFn.zzb(fusedlocationproviderresult.getStatus());
                    }

            
            {
                zzaFn = _pcls6;
                super();
            }
                };
                zzl1.zza(LocationRequestInternal.zzb(zzaFd), zzaFh, zzaFl, zza1);
            }

            
            {
                zzaFf = zzd.this;
                zzaFd = locationrequest;
                zzaFh = locationcallback;
                zzaFl = looper;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener)
    {
        return googleapiclient.zzb(new zza(googleapiclient, locationrequest, locationlistener) {

            final LocationRequest zzaFd;
            final LocationListener zzaFe;
            final zzd zzaFf;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzg.zza zza1 = new zzg.zza(this) {

                    final _cls1 zzaFg;

                    public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                    {
                        zzaFg.zzb(fusedlocationproviderresult.getStatus());
                    }

            
            {
                zzaFg = _pcls1;
                super();
            }
                };
                zzl1.zza(zzaFd, zzaFe, null, zza1);
            }

            
            {
                zzaFf = zzd.this;
                zzaFd = locationrequest;
                zzaFe = locationlistener;
                super(googleapiclient);
            }
        });
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
    {
        return googleapiclient.zzb(new zza(googleapiclient, locationrequest, locationlistener, looper) {

            final LocationRequest zzaFd;
            final LocationListener zzaFe;
            final zzd zzaFf;
            final Looper zzaFl;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzg.zza zza1 = new zzg.zza(this) {

                    final _cls5 zzaFm;

                    public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                    {
                        zzaFm.zzb(fusedlocationproviderresult.getStatus());
                    }

            
            {
                zzaFm = _pcls5;
                super();
            }
                };
                zzl1.zza(zzaFd, zzaFe, zzaFl, zza1);
            }

            
            {
                zzaFf = zzd.this;
                zzaFd = locationrequest;
                zzaFe = locationlistener;
                zzaFl = looper;
                super(googleapiclient);
            }
        });
    }

    public PendingResult setMockLocation(GoogleApiClient googleapiclient, Location location)
    {
        return googleapiclient.zzb(new zza(googleapiclient, location) {

            final zzd zzaFf;
            final Location zzaFk;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzl1.zzc(zzaFk);
                zzb(Status.zzabb);
            }

            
            {
                zzaFf = zzd.this;
                zzaFk = location;
                super(googleapiclient);
            }
        });
    }

    public PendingResult setMockMode(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zzb(new zza(googleapiclient, flag) {

            final zzd zzaFf;
            final boolean zzaFj;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzl)zzb);
            }

            protected void zza(zzl zzl1)
                throws RemoteException
            {
                zzl1.zzah(zzaFj);
                zzb(Status.zzabb);
            }

            
            {
                zzaFf = zzd.this;
                zzaFj = flag;
                super(googleapiclient);
            }
        });
    }
}
