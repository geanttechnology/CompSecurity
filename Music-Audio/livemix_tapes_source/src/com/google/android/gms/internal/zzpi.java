// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.Panorama;
import com.google.android.gms.panorama.PanoramaApi;

// Referenced classes of package com.google.android.gms.internal:
//            zzph, zzpg, zzpk, zzpj

public class zzpi
    implements PanoramaApi
{
    private static abstract class zza extends zzc
    {

        protected com.google.android.gms.panorama.PanoramaApi.PanoramaResult zzaW(Status status)
        {
            return new zzpk(status, null);
        }

        protected Result zzb(Status status)
        {
            return zzaW(status);
        }

        public zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }
    }

    private static final class zzb extends zzpg.zza
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;

        public void zza(int i, Bundle bundle, int j, Intent intent)
        {
            if (bundle != null)
            {
                bundle = (PendingIntent)bundle.getParcelable("pendingIntent");
            } else
            {
                bundle = null;
            }
            bundle = new Status(i, null, bundle);
            zzQz.zzn(new zzpk(bundle, intent));
        }

        public zzb(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzQz = zzb1;
        }
    }

    private static abstract class zzc extends com.google.android.gms.common.api.zzc.zza
    {

        protected abstract void zza(Context context, zzph zzph1)
            throws RemoteException;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzpj)zzb1);
        }

        protected final void zza(zzpj zzpj1)
            throws RemoteException
        {
            zza(zzpj1.getContext(), (zzph)zzpj1.zzoA());
        }

        protected zzc(GoogleApiClient googleapiclient)
        {
            super(Panorama.zzQf, googleapiclient);
        }
    }


    public zzpi()
    {
    }

    private static void zza(Context context, Uri uri)
    {
        context.revokeUriPermission(uri, 1);
    }

    private static void zza(Context context, zzph zzph1, zzpg zzpg, Uri uri, Bundle bundle)
        throws RemoteException
    {
        context.grantUriPermission("com.google.android.gms", uri, 1);
        zzpg = new zzpg.zza(context, uri, zzpg) {

            final zzpg zzaKA;
            final Uri zzaKy;
            final Context zzrn;

            public void zza(int i, Bundle bundle1, int j, Intent intent)
                throws RemoteException
            {
                zzpi.zzb(zzrn, zzaKy);
                zzaKA.zza(i, bundle1, j, intent);
            }

            
            {
                zzrn = context;
                zzaKy = uri;
                zzaKA = zzpg1;
                super();
            }
        };
        try
        {
            zzph1.zza(zzpg, uri, bundle, true);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (zzph zzph1)
        {
            zza(context, uri);
            throw zzph1;
        }
        // Misplaced declaration of an exception variable
        catch (zzph zzph1)
        {
            zza(context, uri);
        }
        throw zzph1;
    }

    static void zzb(Context context, Uri uri)
    {
        zza(context, uri);
    }

    static void zzb(Context context, zzph zzph1, zzpg zzpg, Uri uri, Bundle bundle)
        throws RemoteException
    {
        zza(context, zzph1, zzpg, uri, bundle);
    }

    public PendingResult loadPanoramaInfo(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.zza(new zza(googleapiclient, uri) {

            final Uri zzaKy;
            final zzpi zzaKz;

            protected void zza(Context context, zzph zzph1)
                throws RemoteException
            {
                zzph1.zza(new zzb(this), zzaKy, null, false);
            }

            
            {
                zzaKz = zzpi.this;
                zzaKy = uri;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadPanoramaInfoAndGrantAccess(GoogleApiClient googleapiclient, Uri uri)
    {
        return googleapiclient.zza(new zza(googleapiclient, uri) {

            final Uri zzaKy;
            final zzpi zzaKz;

            protected void zza(Context context, zzph zzph1)
                throws RemoteException
            {
                zzpi.zzb(context, zzph1, new zzb(this), zzaKy, null);
            }

            
            {
                zzaKz = zzpi.this;
                zzaKy = uri;
                super(googleapiclient);
            }
        });
    }
}
