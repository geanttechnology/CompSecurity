// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.zzam;
import com.google.android.gms.drive.internal.zzu;
import com.google.android.gms.drive.query.Filter;
import com.google.android.gms.drive.query.internal.FilterHolder;
import com.google.android.gms.drive.query.internal.zzg;

// Referenced classes of package com.google.android.gms.drive:
//            Drive, DriveId

public class OpenFileActivityBuilder
{

    public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
    private String zzajf;
    private String zzajg[];
    private Filter zzajh;
    private DriveId zzaji;

    public OpenFileActivityBuilder()
    {
    }

    public IntentSender build(GoogleApiClient googleapiclient)
    {
        zzx.zza(googleapiclient.isConnected(), "Client must be connected");
        if (zzajg == null)
        {
            zzajg = new String[0];
        }
        if (zzajg.length > 0 && zzajh != null)
        {
            throw new IllegalStateException("Cannot use a selection filter and set mimetypes simultaneously");
        }
        FilterHolder filterholder;
        if (zzajh == null)
        {
            filterholder = null;
        } else
        {
            filterholder = new FilterHolder(zzajh);
        }
        try
        {
            googleapiclient = ((zzu)googleapiclient.zza(Drive.zzRk)).zzrm().zza(new OpenFileIntentSenderRequest(zzajf, zzajg, zzaji, filterholder));
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
        zzaji = (DriveId)zzx.zzw(driveid);
        return this;
    }

    public OpenFileActivityBuilder setActivityTitle(String s)
    {
        zzajf = (String)zzx.zzw(s);
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
        zzajg = as;
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
        zzajh = filter;
        return this;
    }
}
