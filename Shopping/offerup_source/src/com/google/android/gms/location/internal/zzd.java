// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.location.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.location.FusedLocationProviderApi;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;

// Referenced classes of package com.google.android.gms.location.internal:
//            zzl

public class zzd
    implements FusedLocationProviderApi
{

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
        return googleapiclient.zzb(new _cls9(googleapiclient, pendingintent));
    }

    public PendingResult removeLocationUpdates(GoogleApiClient googleapiclient, LocationCallback locationcallback)
    {
        return googleapiclient.zzb(new _cls2(googleapiclient, locationcallback));
    }

    public PendingResult removeLocationUpdates(GoogleApiClient googleapiclient, LocationListener locationlistener)
    {
        return googleapiclient.zzb(new _cls8(googleapiclient, locationlistener));
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, PendingIntent pendingintent)
    {
        return googleapiclient.zzb(new _cls7(googleapiclient, locationrequest, pendingintent));
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationCallback locationcallback, Looper looper)
    {
        return googleapiclient.zzb(new _cls6(googleapiclient, locationrequest, locationcallback, looper));
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener)
    {
        return googleapiclient.zzb(new _cls1(googleapiclient, locationrequest, locationlistener));
    }

    public PendingResult requestLocationUpdates(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
    {
        return googleapiclient.zzb(new _cls5(googleapiclient, locationrequest, locationlistener, looper));
    }

    public PendingResult setMockLocation(GoogleApiClient googleapiclient, Location location)
    {
        return googleapiclient.zzb(new _cls4(googleapiclient, location));
    }

    public PendingResult setMockMode(GoogleApiClient googleapiclient, boolean flag)
    {
        return googleapiclient.zzb(new _cls3(googleapiclient, flag));
    }

    private class _cls9 extends zza
    {
        private class zza extends com.google.android.gms.location.LocationServices.zza
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


        final PendingIntent zzaEY;
        final zzd zzaFf;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            class _cls1 extends zzg.zza
            {

                final _cls9 zzaFq;

                public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                {
                    zzaFq.zzb(fusedlocationproviderresult.getStatus());
                }

                _cls1()
                {
                    zzaFq = _cls9.this;
                    super();
                }
            }

            _cls1 _lcls1 = new _cls1();
            zzl1.zza(zzaEY, _lcls1);
        }

        _cls9(GoogleApiClient googleapiclient, PendingIntent pendingintent)
        {
            zzaFf = zzd.this;
            zzaEY = pendingintent;
            super(googleapiclient);
        }
    }


    private class _cls2 extends zza
    {

        final zzd zzaFf;
        final LocationCallback zzaFh;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            class _cls1 extends zzg.zza
            {

                final _cls2 zzaFi;

                public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                {
                    zzaFi.zzb(fusedlocationproviderresult.getStatus());
                }

                _cls1()
                {
                    zzaFi = _cls2.this;
                    super();
                }
            }

            _cls1 _lcls1 = new _cls1();
            zzl1.zza(zzaFh, _lcls1);
        }

        _cls2(GoogleApiClient googleapiclient, LocationCallback locationcallback)
        {
            zzaFf = zzd.this;
            zzaFh = locationcallback;
            super(googleapiclient);
        }
    }


    private class _cls8 extends zza
    {

        final LocationListener zzaFe;
        final zzd zzaFf;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            class _cls1 extends zzg.zza
            {

                final _cls8 zzaFp;

                public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                {
                    zzaFp.zzb(fusedlocationproviderresult.getStatus());
                }

                _cls1()
                {
                    zzaFp = _cls8.this;
                    super();
                }
            }

            _cls1 _lcls1 = new _cls1();
            zzl1.zza(zzaFe, _lcls1);
        }

        _cls8(GoogleApiClient googleapiclient, LocationListener locationlistener)
        {
            zzaFf = zzd.this;
            zzaFe = locationlistener;
            super(googleapiclient);
        }
    }


    private class _cls7 extends zza
    {

        final PendingIntent zzaEY;
        final LocationRequest zzaFd;
        final zzd zzaFf;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            class _cls1 extends zzg.zza
            {

                final _cls7 zzaFo;

                public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                {
                    zzaFo.zzb(fusedlocationproviderresult.getStatus());
                }

                _cls1()
                {
                    zzaFo = _cls7.this;
                    super();
                }
            }

            _cls1 _lcls1 = new _cls1();
            zzl1.zza(zzaFd, zzaEY, _lcls1);
        }

        _cls7(GoogleApiClient googleapiclient, LocationRequest locationrequest, PendingIntent pendingintent)
        {
            zzaFf = zzd.this;
            zzaFd = locationrequest;
            zzaEY = pendingintent;
            super(googleapiclient);
        }
    }


    private class _cls6 extends zza
    {

        final LocationRequest zzaFd;
        final zzd zzaFf;
        final LocationCallback zzaFh;
        final Looper zzaFl;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            class _cls1 extends zzg.zza
            {

                final _cls6 zzaFn;

                public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                {
                    zzaFn.zzb(fusedlocationproviderresult.getStatus());
                }

                _cls1()
                {
                    zzaFn = _cls6.this;
                    super();
                }
            }

            _cls1 _lcls1 = new _cls1();
            zzl1.zza(LocationRequestInternal.zzb(zzaFd), zzaFh, zzaFl, _lcls1);
        }

        _cls6(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationCallback locationcallback, Looper looper)
        {
            zzaFf = zzd.this;
            zzaFd = locationrequest;
            zzaFh = locationcallback;
            zzaFl = looper;
            super(googleapiclient);
        }
    }


    private class _cls1 extends zza
    {

        final LocationRequest zzaFd;
        final LocationListener zzaFe;
        final zzd zzaFf;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            class _cls1 extends zzg.zza
            {

                final _cls1 zzaFg;

                public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                {
                    zzaFg.zzb(fusedlocationproviderresult.getStatus());
                }

                _cls1()
                {
                    zzaFg = _cls1.this;
                    super();
                }
            }

            _cls1 _lcls1 = new _cls1();
            zzl1.zza(zzaFd, zzaFe, null, _lcls1);
        }

        _cls1(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener)
        {
            zzaFf = zzd.this;
            zzaFd = locationrequest;
            zzaFe = locationlistener;
            super(googleapiclient);
        }
    }


    private class _cls5 extends zza
    {

        final LocationRequest zzaFd;
        final LocationListener zzaFe;
        final zzd zzaFf;
        final Looper zzaFl;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            class _cls1 extends zzg.zza
            {

                final _cls5 zzaFm;

                public void zza(FusedLocationProviderResult fusedlocationproviderresult)
                {
                    zzaFm.zzb(fusedlocationproviderresult.getStatus());
                }

                _cls1()
                {
                    zzaFm = _cls5.this;
                    super();
                }
            }

            _cls1 _lcls1 = new _cls1();
            zzl1.zza(zzaFd, zzaFe, zzaFl, _lcls1);
        }

        _cls5(GoogleApiClient googleapiclient, LocationRequest locationrequest, LocationListener locationlistener, Looper looper)
        {
            zzaFf = zzd.this;
            zzaFd = locationrequest;
            zzaFe = locationlistener;
            zzaFl = looper;
            super(googleapiclient);
        }
    }


    private class _cls4 extends zza
    {

        final zzd zzaFf;
        final Location zzaFk;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            zzl1.zzc(zzaFk);
            zzb(Status.zzabb);
        }

        _cls4(GoogleApiClient googleapiclient, Location location)
        {
            zzaFf = zzd.this;
            zzaFk = location;
            super(googleapiclient);
        }
    }


    private class _cls3 extends zza
    {

        final zzd zzaFf;
        final boolean zzaFj;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
        {
            zza((zzl)zzb);
        }

        protected void zza(zzl zzl1)
        {
            zzl1.zzah(zzaFj);
            zzb(Status.zzabb);
        }

        _cls3(GoogleApiClient googleapiclient, boolean flag)
        {
            zzaFf = zzd.this;
            zzaFj = flag;
            super(googleapiclient);
        }
    }

}
