// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

// Referenced classes of package com.google.android.gms.drive.internal:
//            zzu, CreateFileIntentSenderRequest, zzam

public class zzl
{

    private String zzajf;
    private DriveId zzaji;
    protected MetadataChangeSet zzakl;
    private Integer zzakm;
    private final int zzakn;

    public zzl(int i)
    {
        zzakn = i;
    }

    public IntentSender build(GoogleApiClient googleapiclient)
    {
        zzx.zzb(zzakl, "Must provide initial metadata to CreateFileActivityBuilder.");
        zzx.zza(googleapiclient.isConnected(), "Client must be connected");
        googleapiclient = (zzu)googleapiclient.zza(Drive.zzRk);
        zzakl.zzqW().setContext(googleapiclient.getContext());
        int i;
        if (zzakm == null)
        {
            i = 0;
        } else
        {
            i = zzakm.intValue();
        }
        try
        {
            googleapiclient = googleapiclient.zzrm().zza(new CreateFileIntentSenderRequest(zzakl.zzqW(), i, zzajf, zzaji, zzakn));
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            throw new RuntimeException("Unable to connect Drive Play Service", googleapiclient);
        }
        return googleapiclient;
    }

    public void zza(DriveId driveid)
    {
        zzaji = (DriveId)zzx.zzw(driveid);
    }

    public void zza(MetadataChangeSet metadatachangeset)
    {
        zzakl = (MetadataChangeSet)zzx.zzw(metadatachangeset);
    }

    public void zzcE(String s)
    {
        zzajf = (String)zzx.zzw(s);
    }

    public void zzcI(int i)
    {
        zzakm = Integer.valueOf(i);
    }
}
