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
//            FileUploadPreferencesImpl, zzd, OnDeviceUsagePreferenceResponse, zzu, 
//            zzam, zzt, SetFileUploadPreferencesRequest, zzbt

public class zzaa
    implements DrivePreferencesApi
{
    private class zza extends zzd
    {

        private final com.google.android.gms.internal.zzlb.zzb zzagy;
        final zzaa zzall;

        public void zza(OnDeviceUsagePreferenceResponse ondeviceusagepreferenceresponse)
            throws RemoteException
        {
            zzagy.zzp(zzall. new zzb(Status.zzabb, ondeviceusagepreferenceresponse.zzrx()));
        }

        public void zzy(Status status)
            throws RemoteException
        {
            zzagy.zzp(zzall. new zzb(status, null));
        }

        private zza(com.google.android.gms.internal.zzlb.zzb zzb1)
        {
            zzall = zzaa.this;
            super();
            zzagy = zzb1;
        }

    }

    private class zzb
        implements com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult
    {

        private final Status zzSC;
        final zzaa zzall;
        private final FileUploadPreferences zzaln;

        public FileUploadPreferences getFileUploadPreferences()
        {
            return zzaln;
        }

        public Status getStatus()
        {
            return zzSC;
        }

        private zzb(Status status, FileUploadPreferences fileuploadpreferences)
        {
            zzall = zzaa.this;
            super();
            zzSC = status;
            zzaln = fileuploadpreferences;
        }

    }

    private abstract class zzc extends zzt
    {

        final zzaa zzall;

        protected com.google.android.gms.drive.DrivePreferencesApi.FileUploadPreferencesResult zzF(Status status)
        {
            return zzall. new zzb(status, null);
        }

        protected Result zzb(Status status)
        {
            return zzF(status);
        }

        public zzc(GoogleApiClient googleapiclient)
        {
            zzall = zzaa.this;
            super(googleapiclient);
        }
    }


    public zzaa()
    {
    }

    public PendingResult getFileUploadPreferences(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zzc(googleapiclient) {

            final zzaa zzall;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzu)zzb1);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzu1.zzrm().zzd(zzall. new zza(this));
            }

            
            {
                zzall = zzaa.this;
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
            return googleapiclient.zzb(new zzt.zza(googleapiclient, (FileUploadPreferencesImpl)fileuploadpreferences) {

                final zzaa zzall;
                final FileUploadPreferencesImpl zzalm;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzu)zzb1);
                }

                protected void zza(zzu zzu1)
                    throws RemoteException
                {
                    zzu1.zzrm().zza(new SetFileUploadPreferencesRequest(zzalm), new zzbt(this));
                }

            
            {
                zzall = zzaa.this;
                zzalm = fileuploadpreferencesimpl;
                super(googleapiclient);
            }
            });
        }
    }
}
