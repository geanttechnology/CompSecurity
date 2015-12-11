// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.zzap;
import com.google.android.gms.drive.internal.zzz;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zznd;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.google.android.gms.drive.events:
//            ResourceEvent, zze

public final class CompletionEvent
    implements SafeParcelable, ResourceEvent
{

    public static final android.os.Parcelable.Creator CREATOR = new zze();
    public static final int STATUS_CANCELED = 3;
    public static final int STATUS_CONFLICT = 2;
    public static final int STATUS_FAILURE = 1;
    public static final int STATUS_SUCCESS = 0;
    final int mVersionCode;
    final String zzRs;
    final DriveId zzaiA;
    final ParcelFileDescriptor zzajC;
    final ParcelFileDescriptor zzajD;
    final MetadataBundle zzajE;
    final List zzajF;
    final IBinder zzajG;
    private boolean zzajH;
    private boolean zzajI;
    private boolean zzajJ;
    final int zzys;

    CompletionEvent(int i, DriveId driveid, String s, ParcelFileDescriptor parcelfiledescriptor, ParcelFileDescriptor parcelfiledescriptor1, MetadataBundle metadatabundle, List list, 
            int j, IBinder ibinder)
    {
        zzajH = false;
        zzajI = false;
        zzajJ = false;
        mVersionCode = i;
        zzaiA = driveid;
        zzRs = s;
        zzajC = parcelfiledescriptor;
        zzajD = parcelfiledescriptor1;
        zzajE = metadatabundle;
        zzajF = list;
        zzys = j;
        zzajG = ibinder;
    }

    private void zzre()
    {
        if (zzajJ)
        {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        } else
        {
            return;
        }
    }

    private void zzt(boolean flag)
    {
        zzre();
        zzajJ = true;
        zzmt.zza(zzajC);
        zzmt.zza(zzajD);
        if (zzajE != null && zzajE.zzc(zznd.zzano))
        {
            ((BitmapTeleporter)zzajE.zza(zznd.zzano)).release();
        }
        if (zzajG == null)
        {
            StringBuilder stringbuilder = (new StringBuilder()).append("No callback on ");
            String s;
            if (flag)
            {
                s = "snooze";
            } else
            {
                s = "dismiss";
            }
            zzz.zzz("CompletionEvent", stringbuilder.append(s).toString());
            return;
        }
        try
        {
            com.google.android.gms.drive.internal.zzap.zza.zzaV(zzajG).zzt(flag);
            return;
        }
        catch (RemoteException remoteexception)
        {
            StringBuilder stringbuilder1 = (new StringBuilder()).append("RemoteException on ");
            String s1;
            if (flag)
            {
                s1 = "snooze";
            } else
            {
                s1 = "dismiss";
            }
            zzz.zzz("CompletionEvent", stringbuilder1.append(s1).append(": ").append(remoteexception).toString());
            return;
        }
    }

    public int describeContents()
    {
        return 0;
    }

    public void dismiss()
    {
        zzt(false);
    }

    public String getAccountName()
    {
        zzre();
        return zzRs;
    }

    public InputStream getBaseContentsInputStream()
    {
        zzre();
        if (zzajC == null)
        {
            return null;
        }
        if (zzajH)
        {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        } else
        {
            zzajH = true;
            return new FileInputStream(zzajC.getFileDescriptor());
        }
    }

    public DriveId getDriveId()
    {
        zzre();
        return zzaiA;
    }

    public InputStream getModifiedContentsInputStream()
    {
        zzre();
        if (zzajD == null)
        {
            return null;
        }
        if (zzajI)
        {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        } else
        {
            zzajI = true;
            return new FileInputStream(zzajD.getFileDescriptor());
        }
    }

    public MetadataChangeSet getModifiedMetadataChangeSet()
    {
        zzre();
        if (zzajE != null)
        {
            return new MetadataChangeSet(zzajE);
        } else
        {
            return null;
        }
    }

    public int getStatus()
    {
        zzre();
        return zzys;
    }

    public List getTrackingTags()
    {
        zzre();
        return new ArrayList(zzajF);
    }

    public int getType()
    {
        return 2;
    }

    public void snooze()
    {
        zzt(true);
    }

    public String toString()
    {
        String s;
        if (zzajF == null)
        {
            s = "<null>";
        } else
        {
            s = (new StringBuilder()).append("'").append(TextUtils.join("','", zzajF)).append("'").toString();
        }
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[] {
            zzaiA, Integer.valueOf(zzys), s
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i | 1);
    }

}
