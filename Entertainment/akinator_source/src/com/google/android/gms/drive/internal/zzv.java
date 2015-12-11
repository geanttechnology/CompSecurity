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
import com.google.android.gms.internal.zzmt;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzu, OpenContentsRequest, zzbl, zzam, 
//            CloseContentsAndUpdateMetadataRequest, zzbt, zzz, CloseContentsRequest

public class zzv
    implements DriveContents
{

    private boolean mClosed;
    private final Contents zzakR;
    private boolean zzakS;
    private boolean zzakT;

    public zzv(Contents contents)
    {
        mClosed = false;
        zzakS = false;
        zzakT = false;
        zzakR = (Contents)zzx.zzw(contents);
    }

    static Contents zza(zzv zzv1)
    {
        return zzv1.zzakR;
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
        if (zzakR.getMode() == 0x10000000)
        {
            throw new IllegalStateException("Cannot commit contents opened with MODE_READ_ONLY");
        }
        if (ExecutionOptions.zzck(executionoptions1.zzqU()) && !zzakR.zzqM())
        {
            throw new IllegalStateException("DriveContents must be valid for conflict detection.");
        }
        ExecutionOptions.zza(googleapiclient, executionoptions1);
        if (zzqQ())
        {
            throw new IllegalStateException("DriveContents already closed.");
        }
        if (getDriveId() == null)
        {
            throw new IllegalStateException("Only DriveContents obtained through DriveFile.open can be committed.");
        }
        if (metadatachangeset == null)
        {
            metadatachangeset = MetadataChangeSet.zzajc;
        }
        zzqP();
        return googleapiclient.zzb(new zzt.zza(googleapiclient, metadatachangeset, executionoptions1) {

            final zzv zzakU;
            final MetadataChangeSet zzakV;
            final ExecutionOptions zzakW;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zzu)zzb);
            }

            protected void zza(zzu zzu1)
                throws RemoteException
            {
                zzakV.zzqW().setContext(zzu1.getContext());
                zzu1.zzrm().zza(new CloseContentsAndUpdateMetadataRequest(zzv.zza(zzakU).getDriveId(), zzakV.zzqW(), zzv.zza(zzakU).getRequestId(), zzv.zza(zzakU).zzqM(), zzakW), new zzbt(this));
            }

            
            {
                zzakU = zzv.this;
                zzakV = metadatachangeset;
                zzakW = executionoptions;
                super(googleapiclient);
            }
        });
    }

    public void discard(GoogleApiClient googleapiclient)
    {
        if (zzqQ())
        {
            throw new IllegalStateException("DriveContents already closed.");
        } else
        {
            zzqP();
            ((_cls4)googleapiclient.zzb(new zzt.zza(googleapiclient) {

                final zzv zzakU;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zzu)zzb);
                }

                protected void zza(zzu zzu1)
                    throws RemoteException
                {
                    zzu1.zzrm().zza(new CloseContentsRequest(zzv.zza(zzakU).getRequestId(), false), new zzbt(this));
                }

            
            {
                zzakU = zzv.this;
                super(googleapiclient);
            }
            })).setResultCallback(new ResultCallback() {

                final zzv zzakU;

                public void onResult(Result result)
                {
                    zzo((Status)result);
                }

                public void zzo(Status status)
                {
                    if (!status.isSuccess())
                    {
                        zzz.zzz("DriveContentsImpl", "Error discarding contents");
                        return;
                    } else
                    {
                        com.google.android.gms.drive.internal.zzz.zzx("DriveContentsImpl", "Contents discarded");
                        return;
                    }
                }

            
            {
                zzakU = zzv.this;
                super();
            }
            });
            return;
        }
    }

    public DriveId getDriveId()
    {
        return zzakR.getDriveId();
    }

    public InputStream getInputStream()
    {
        if (zzqQ())
        {
            throw new IllegalStateException("Contents have been closed, cannot access the input stream.");
        }
        if (zzakR.getMode() != 0x10000000)
        {
            throw new IllegalStateException("getInputStream() can only be used with contents opened with MODE_READ_ONLY.");
        }
        if (zzakS)
        {
            throw new IllegalStateException("getInputStream() can only be called once per Contents instance.");
        } else
        {
            zzakS = true;
            return zzakR.getInputStream();
        }
    }

    public int getMode()
    {
        return zzakR.getMode();
    }

    public OutputStream getOutputStream()
    {
        if (zzqQ())
        {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        }
        if (zzakR.getMode() != 0x20000000)
        {
            throw new IllegalStateException("getOutputStream() can only be used with contents opened with MODE_WRITE_ONLY.");
        }
        if (zzakT)
        {
            throw new IllegalStateException("getOutputStream() can only be called once per Contents instance.");
        } else
        {
            zzakT = true;
            return zzakR.getOutputStream();
        }
    }

    public ParcelFileDescriptor getParcelFileDescriptor()
    {
        if (zzqQ())
        {
            throw new IllegalStateException("Contents have been closed, cannot access the output stream.");
        } else
        {
            return zzakR.getParcelFileDescriptor();
        }
    }

    public PendingResult reopenForWrite(GoogleApiClient googleapiclient)
    {
        if (zzqQ())
        {
            throw new IllegalStateException("DriveContents already closed.");
        }
        if (zzakR.getMode() != 0x10000000)
        {
            throw new IllegalStateException("reopenForWrite can only be used with DriveContents opened with MODE_READ_ONLY.");
        } else
        {
            zzqP();
            return googleapiclient.zza(new zzs.zzb(googleapiclient) {

                final zzv zzakU;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                    throws RemoteException
                {
                    zza((zzu)zzb);
                }

                protected void zza(zzu zzu1)
                    throws RemoteException
                {
                    zzu1.zzrm().zza(new OpenContentsRequest(zzakU.getDriveId(), 0x20000000, zzv.zza(zzakU).getRequestId()), new zzbl(this, null));
                }

            
            {
                zzakU = zzv.this;
                super(googleapiclient);
            }
            });
        }
    }

    public Contents zzqO()
    {
        return zzakR;
    }

    public void zzqP()
    {
        zzmt.zza(zzakR.getParcelFileDescriptor());
        mClosed = true;
    }

    public boolean zzqQ()
    {
        return mClosed;
    }
}
