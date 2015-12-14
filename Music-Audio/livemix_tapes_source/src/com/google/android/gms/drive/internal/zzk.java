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
//            zzt, CreateFileIntentSenderRequest, zzal

public class zzk
{

    private String zzagU;
    private DriveId zzagX;
    protected MetadataChangeSet zzahY;
    private Integer zzahZ;
    private final int zzaia;

    public zzk(int i)
    {
        zzaia = i;
    }

    public IntentSender build(GoogleApiClient googleapiclient)
    {
        zzx.zzb(zzahY, "Must provide initial metadata to CreateFileActivityBuilder.");
        zzx.zza(googleapiclient.isConnected(), "Client must be connected");
        googleapiclient = (zzt)googleapiclient.zza(Drive.zzQf);
        zzahY.zzqp().setContext(googleapiclient.getContext());
        int i;
        if (zzahZ == null)
        {
            i = 0;
        } else
        {
            i = zzahZ.intValue();
        }
        try
        {
            googleapiclient = googleapiclient.zzqF().zza(new CreateFileIntentSenderRequest(zzahY.zzqp(), i, zzagU, zzagX, zzaia));
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
        zzagX = (DriveId)zzx.zzv(driveid);
    }

    public void zza(MetadataChangeSet metadatachangeset)
    {
        zzahY = (MetadataChangeSet)zzx.zzv(metadatachangeset);
    }

    public void zzcC(int i)
    {
        zzahZ = Integer.valueOf(i);
    }

    public void zzcF(String s)
    {
        zzagU = (String)zzx.zzv(s);
    }
}
