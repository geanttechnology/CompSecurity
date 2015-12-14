// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.DrivePreferencesApi;
import com.google.android.gms.drive.FileUploadPreferences;

// Referenced classes of package com.google.android.gms.drive.internal:
//            FileUploadPreferencesImpl, zzd, OnDeviceUsagePreferenceResponse, zzt, 
//            zzal, zzs, SetFileUploadPreferencesRequest, zzbr

public class zzz
    implements DrivePreferencesApi
{
    private class zza extends zzd
    {

        private final com.google.android.gms.common.api.zzc.zzb zzQz;
        final zzz zzaiX;

        public void zza(OnDeviceUsagePreferenceResponse ondeviceusagepreferenceresponse)
            throws RemoteException
        {
            zzQz.zzn(zzaiX. new zzb(Status.zzaaD, ondeviceusagepreferenceresponse.zzqP()));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzQz.zzn(zzaiX. new zzb(status, null));
        }

        private zza(com.google.android.gms.common.api.zzc.zzb zzb1)
        {
            zzaiX = zzz.this;
            super();
            zzQz = zzb1;
        }

    }

    private class zzb
        implements com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult
    {

        private final Status zzQA;
        final zzz zzaiX;
        private final FileUploadPreferences zzaiZ;

        public FileUploadPreferences getFileUploadPreferences()
        {
            return zzaiZ;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        private zzb(Status status, FileUploadPreferences fileuploadpreferences)
        {
            zzaiX = zzz.this;
            super();
            zzQA = status;
            zzaiZ = fileuploadpreferences;
        }

    }

    private abstract class zzc extends zzs
    {

        final zzz zzaiX;

        protected com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult zzF(Status status)
        {
            return zzaiX. new zzb(status, null);
        }

        protected Result zzb(Status status)
        {
            return zzF(status);
        }

        public zzc(GoogleApiClient googleapiclient)
        {
            zzaiX = zzz.this;
            super(googleapiclient);
        }
    }


    public zzz()
    {
    }

    public PendingResult getFileUploadPreferences(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzc(googleapiclient) {

            final zzz zzaiX;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzt)zzb1);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzt1.zzqF().zzd(zzaiX. new zza(this));
            }

            
            {
                zzaiX = zzz.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult setFileUploadPreferences(GoogleApiClient googleapiclient, FileUploadPreferences fileuploadpreferences)
    {
        if (!(fileuploadpreferences instanceof FileUploadPreferencesImpl))
        {
            throw new IllegalArgumentException("Invalid preference value");
        } else
        {
            return googleapiclient.zzb(new zzs.zza(googleapiclient, (FileUploadPreferencesImpl)fileuploadpreferences) {

                final zzz zzaiX;
                final FileUploadPreferencesImpl zzaiY;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzt)zzb1);
                }

                protected void zza(zzt zzt1)
                    throws RemoteException
                {
                    zzt1.zzqF().zza(new SetFileUploadPreferencesRequest(zzaiY), new zzbr(this));
                }

            
            {
                zzaiX = zzz.this;
                zzaiY = fileuploadpreferencesimpl;
                super(googleapiclient);
            }
            });
        }
    }
}
