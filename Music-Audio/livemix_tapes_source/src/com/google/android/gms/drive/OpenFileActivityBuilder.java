// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzal;
import com.google.android.gms.drive.internal.zzt;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzg;

// Referenced classes of package com.google.android.gms.drive:
//            Drive, DriveId

public class OpenFileActivityBuilder
{

    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String zzagU;
    private String zzagV[];
    private Filter zzagW;
    private DriveId zzagX;

    public OpenFileActivityBuilder()
    {
    }

    public IntentSender build(GoogleApiClient googleapiclient)
    {
        zzx.zza(googleapiclient.isConnected(), "Client must be connected");
        if (zzagV == null)
        {
            zzagV = new String[0];
        }
        if (zzagV.length > 0 && zzagW != null)
        {
            throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
        }
        FilterHolder filterholder;
        if (zzagW == null)
        {
            filterholder = null;
        } else
        {
            filterholder = new FilterHolder(zzagW);
        }
        try
        {
            googleapiclient = ((zzt)googleapiclient.zza(Drive.zzQf)).zzqF().zza(new OpenFileIntentSenderRequest(zzagU, zzagV, zzagX, filterholder));
        }
        // Misplaced declaration of an exception variable
        catch (GoogleApiClient googleapiclient)
        {
            throw new RuntimeException("Unable to connect Drive Play Service", googleapiclient);
        }
        return googleapiclient;
    }

    public OpenFileActivityBuilder setActivityStartFolder(DriveId driveid)
    {
        zzagX = (DriveId)zzx.zzv(driveid);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String s)
    {
        zzagU = (String)zzx.zzv(s);
        return this;
    }

    public OpenFileActivityBuilder setMimeType(String as[])
    {
        boolean flag;
        if (as != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "mimeTypes may not be null");
        zzagV = as;
        return this;
    }

    public OpenFileActivityBuilder setSelectionFilter(Filter filter)
    {
        boolean flag1 = true;
        boolean flag;
        if (filter != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "filter may not be null");
        if (!zzg.zza(filter))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, "FullTextSearchFilter cannot be used as a selection filter");
        zzagW = filter;
        return this;
    }
}
