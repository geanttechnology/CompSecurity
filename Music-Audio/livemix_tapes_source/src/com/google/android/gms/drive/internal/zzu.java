// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzlr;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzt, OpenContentsRequest, zzbj, zzal, 
//            CloseContentsAndUpdateMetadataRequest, zzbr, zzy, CloseContentsRequest

public class zzu
    implements DriveContents
{

    private boolean mClosed;
    private final Contents zzaiD;
    private boolean zzaiE;
    private boolean zzaiF;

    public zzu(Contents contents)
    {
        mClosed = false;
        zzaiE = false;
        zzaiF = false;
        zzaiD = (Contents)zzx.zzv(contents);
    }

    static Contents zza(zzu zzu1)
    {
        return zzu1.zzaiD;
    }

    public PendingResult commit(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset)
    {
        return commit(googleapiclient, metadatachangeset, null);
    }

    public PendingResult commit(GoogleApiClient googleapiclient, MetadataChangeSet metadatachangeset, ExecutionOptions executionoptions)
    {
        ExecutionOptions executionoptions1 = executionoptions;
        if (executionoptions == null)
        {
            executionoptions1 = (new com.google.android.gms.drive.ExecutionOptions.Builder()).build();
        }
        if (zzaiD.getMode() == 0x10000000)
        {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        }
        if (ExecutionOptions.zzcf(executionoptions1.zzqn()) && !zzaiD.zzqf())
        {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
        ExecutionOptions.zza(googleapiclient, executionoptions1);
        if (zzqj())
        {
            throw new IllegalStateException("DriveContents already closed.");
        }
        if (getDriveId() == null)
        {
            throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
        }
        if (metadatachangeset == null)
        {
            metadatachangeset = MetadataChangeSet.zzagR;
        }
        zzqi();
        return googleapiclient.zzb(new zzs.zza(googleapiclient, metadatachangeset, executionoptions1) {

            final zzu zzaiG;
            final MetadataChangeSet zzaiH;
            final ExecutionOptions zzaiI;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzt)zzb);
            }

            protected void zza(zzt zzt1)
                throws RemoteException
            {
                zzaiH.zzqp().setContext(zzt1.getContext());
                zzt1.zzqF().zza(new CloseContentsAndUpdateMetadataRequest(zzu.zza(zzaiG).getDriveId(), zzaiH.zzqp(), zzu.zza(zzaiG).getRequestId(), zzu.zza(zzaiG).zzqf(), zzaiI), new zzbr(this));
            }

            
            {
                zzaiG = zzu.this;
                zzaiH = metadatachangeset;
                zzaiI = executionoptions;
                super(googleapiclient);
            }
        });
    }

    public void discard(GoogleApiClient googleapiclient)
    {
        if (zzqj())
        {
            throw new IllegalStateException("DriveContents already closed.");
        } else
        {
            zzqi();
            ((_cls4)googleapiclient.zzb(new zzs.zza(googleapiclient) {

                final zzu zzaiG;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zzt)zzb);
                }

                protected void zza(zzt zzt1)
                    throws RemoteException
                {
                    zzt1.zzqF().zza(new CloseContentsRequest(zzu.zza(zzaiG).getRequestId(), false), new zzbr(this));
                }

            
            {
                zzaiG = zzu.this;
                super(googleapiclient);
            }
            })).setResultCallback(new ResultCallback() {

                final zzu zzaiG;

                public void onResult(Result result)
                {
                    zzr((Status)result);
                }

                public void zzr(Status status)
                {
                    if (!status.isSuccess())
                    {
                        com.google.android.gms.drive.internal.zzy.zzx("DriveContentsImpl", "Error discarding contents");
                        return;
                    } else
                    {
                        zzy.zzv("DriveContentsImpl", "Contents discarded");
                        return;
                    }
                }

            
            {
                zzaiG = zzu.this;
                super();
            }
            });
            return;
        }
    }

    public DriveId getDriveId()
    {
        return zzaiD.getDriveId();
    }

    public InputStream getInputStream()
    {
        if (zzqj())
        {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        }
        if (zzaiD.getMode() != 0x10000000)
        {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        }
        if (zzaiE)
        {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else
        {
            zzaiE = true;
            return zzaiD.getInputStream();
        }
    }

    public int getMode()
    {
        return zzaiD.getMode();
    }

    public OutputStream getOutputStream()
    {
        if (zzqj())
        {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        if (zzaiD.getMode() != 0x20000000)
        {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        }
        if (zzaiF)
        {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else
        {
            zzaiF = true;
            return zzaiD.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor()
    {
        if (zzqj())
        {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else
        {
            return zzaiD.getParcelFileDescriptor();
        }
    }

    public PendingResult reopenForWrite(GoogleApiClient googleapiclient)
    {
        if (zzqj())
        {
            throw new IllegalStateException("DriveContents already closed.");
        }
        if (zzaiD.getMode() != 0x10000000)
        {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else
        {
            zzqi();
            return googleapiclient.zza(new zzr.zzb(googleapiclient) {

                final zzu zzaiG;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zzt)zzb);
                }

                protected void zza(zzt zzt1)
                    throws RemoteException
                {
                    zzt1.zzqF().zza(new OpenContentsRequest(zzaiG.getDriveId(), 0x20000000, zzu.zza(zzaiG).getRequestId()), new zzbj(this, null));
                }

            
            {
                zzaiG = zzu.this;
                super(googleapiclient);
            }
            });
        }
    }

    public Contents zzqh()
    {
        return zzaiD;
    }

    public void zzqi()
    {
        zzlr.zza(zzaiD.getParcelFileDescriptor());
        mClosed = true;
    }

    public boolean zzqj()
    {
        return mClosed;
    }
}
