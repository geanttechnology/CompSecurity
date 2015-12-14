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
import com.google.android.gms.drive.internal.zzao;
import com.google.android.gms.drive.internal.zzy;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.zzlr;
import com.google.android.gms.internal.zzmb;
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
    final String zzQE;
    final DriveId zzags;
    final ParcelFileDescriptor zzahs;
    final ParcelFileDescriptor zzaht;
    final MetadataBundle zzahu;
    final List zzahv;
    final IBinder zzahw;
    private boolean zzahx;
    private boolean zzahy;
    private boolean zzahz;
    final int zzxJ;

    CompletionEvent(int i, DriveId driveid, String s, ParcelFileDescriptor parcelfiledescriptor, ParcelFileDescriptor parcelfiledescriptor1, MetadataBundle metadatabundle, List list, 
            int j, IBinder ibinder)
    {
        zzahx = false;
        zzahy = false;
        zzahz = false;
        mVersionCode = i;
        zzags = driveid;
        zzQE = s;
        zzahs = parcelfiledescriptor;
        zzaht = parcelfiledescriptor1;
        zzahu = metadatabundle;
        zzahv = list;
        zzxJ = j;
        zzahw = ibinder;
    }

    private void zzqx()
    {
        if (zzahz)
        {
            throw new IllegalStateException("Event has already been dismissed or snoozed.");
        } else
        {
            return;
        }
    }

    private void zzt(boolean flag)
    {
        zzqx();
        zzahz = true;
        zzlr.zza(zzahs);
        zzlr.zza(zzaht);
        if (zzahu != null && zzahu.zzc(zzmb.zzakT))
        {
            ((BitmapTeleporter)zzahu.zza(zzmb.zzakT)).release();
        }
        if (zzahw == null)
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
            zzy.zzx("CompletionEvent", stringbuilder.append(s).toString());
            return;
        }
        try
        {
            com.google.android.gms.drive.internal.zzao.zza.zzaV(zzahw).zzt(flag);
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
            zzy.zzx("CompletionEvent", stringbuilder1.append(s1).append(": ").append(remoteexception).toString());
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
        zzqx();
        return zzQE;
    }

    public InputStream getBaseContentsInputStream()
    {
        zzqx();
        if (zzahs == null)
        {
            return null;
        }
        if (zzahx)
        {
            throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
        } else
        {
            zzahx = true;
            return new FileInputStream(zzahs.getFileDescriptor());
        }
    }

    public DriveId getDriveId()
    {
        zzqx();
        return zzags;
    }

    public InputStream getModifiedContentsInputStream()
    {
        zzqx();
        if (zzaht == null)
        {
            return null;
        }
        if (zzahy)
        {
            throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
        } else
        {
            zzahy = true;
            return new FileInputStream(zzaht.getFileDescriptor());
        }
    }

    public MetadataChangeSet getModifiedMetadataChangeSet()
    {
        zzqx();
        if (zzahu != null)
        {
            return new MetadataChangeSet(zzahu);
        } else
        {
            return null;
        }
    }

    public int getStatus()
    {
        zzqx();
        return zzxJ;
    }

    public List getTrackingTags()
    {
        zzqx();
        return new ArrayList(zzahv);
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
        if (zzahv == null)
        {
            s = "<null>";
        } else
        {
            s = (new StringBuilder()).append("'").append(TextUtils.join("','", zzahv)).append("'").toString();
        }
        return String.format(Locale.US, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", new Object[] {
            zzags, Integer.valueOf(zzxJ), s
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zze.zza(this, parcel, i | 1);
    }

}
