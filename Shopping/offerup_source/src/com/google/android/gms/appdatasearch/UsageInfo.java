// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.zzse;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzj, DocumentSection, DocumentId, DocumentContents

public class UsageInfo
    implements SafeParcelable
{

    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final DocumentId zzQU;
    final long zzQV;
    int zzQW;
    final DocumentContents zzQX;
    final boolean zzQY;
    int zzQZ;
    int zzRa;
    public final String zzub;

    UsageInfo(int i, DocumentId documentid, long l, int j, String s, DocumentContents documentcontents, 
            boolean flag, int k, int i1)
    {
        mVersionCode = i;
        zzQU = documentid;
        zzQV = l;
        zzQW = j;
        zzub = s;
        zzQX = documentcontents;
        zzQY = flag;
        zzQZ = k;
        zzRa = i1;
    }

    private UsageInfo(DocumentId documentid, long l, int i, String s, DocumentContents documentcontents, boolean flag, 
            int j, int k)
    {
        this(1, documentid, l, i, s, documentcontents, flag, j, k);
    }

    UsageInfo(DocumentId documentid, long l, int i, String s, DocumentContents documentcontents, boolean flag, 
            int j, int k, _cls1 _pcls1)
    {
        this(documentid, l, i, s, documentcontents, flag, j, k);
    }

    public UsageInfo(String s, Intent intent, String s1, Uri uri, String s2, List list, int i)
    {
        this(1, zza(s, intent), System.currentTimeMillis(), 0, ((String) (null)), zza(intent, s1, uri, s2, list).zzlo(), false, -1, i);
    }

    public static DocumentContents.zza zza(Intent intent, String s, Uri uri, String s1, List list)
    {
        DocumentContents.zza zza1 = new DocumentContents.zza();
        zza1.zza(zzbC(s));
        if (uri != null)
        {
            zza1.zza(zzi(uri));
        }
        if (list != null)
        {
            zza1.zza(zzo(list));
        }
        s = intent.getAction();
        if (s != null)
        {
            zza1.zza(zzq("intent_action", s));
        }
        s = intent.getDataString();
        if (s != null)
        {
            zza1.zza(zzq("intent_data", s));
        }
        s = intent.getComponent();
        if (s != null)
        {
            zza1.zza(zzq("intent_activity", s.getClassName()));
        }
        intent = intent.getExtras();
        if (intent != null)
        {
            intent = intent.getString("intent_extra_data_key");
            if (intent != null)
            {
                zza1.zza(zzq("intent_extra_data", intent));
            }
        }
        return zza1.zzbx(s1).zzK(true);
    }

    public static DocumentId zza(String s, Intent intent)
    {
        return zzp(s, zzg(intent));
    }

    private static DocumentSection zzbC(String s)
    {
        return new DocumentSection(s, (new RegisterSectionInfo.zza("title")).zzal(1).zzN(true).zzbB("name").zzlt(), "text1");
    }

    private static String zzg(Intent intent)
    {
        intent = intent.toUri(1);
        CRC32 crc32 = new CRC32();
        try
        {
            crc32.update(intent.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            throw new IllegalStateException(intent);
        }
        return Long.toHexString(crc32.getValue());
    }

    private static DocumentSection zzi(Uri uri)
    {
        return new DocumentSection(uri.toString(), (new RegisterSectionInfo.zza("web_url")).zzal(4).zzM(true).zzbB("url").zzlt());
    }

    private static DocumentSection zzo(List list)
    {
        com.google.android.gms.internal.zzox.zza zza1 = new com.google.android.gms.internal.zzox.zza();
        com.google.android.gms.internal.zzox.zza.zza azza[] = new com.google.android.gms.internal.zzox.zza.zza[list.size()];
        for (int i = 0; i < azza.length; i++)
        {
            azza[i] = new com.google.android.gms.internal.zzox.zza.zza();
            com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink appindexinglink = (com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink)list.get(i);
            azza[i].zzaCW = appindexinglink.appIndexingUrl.toString();
            azza[i].viewId = appindexinglink.viewId;
            if (appindexinglink.webUrl != null)
            {
                azza[i].zzaCX = appindexinglink.webUrl.toString();
            }
        }

        zza1.zzaCU = azza;
        return new DocumentSection(zzse.zzf(zza1), (new RegisterSectionInfo.zza("outlinks")).zzM(true).zzbB(".private:outLinks").zzbA("blob").zzlt());
    }

    private static DocumentId zzp(String s, String s1)
    {
        return new DocumentId(s, "", s1);
    }

    private static DocumentSection zzq(String s, String s1)
    {
        return new DocumentSection(s1, (new RegisterSectionInfo.zza(s)).zzM(true).zzlt(), s);
    }

    public int describeContents()
    {
        return 0;
    }

    public String toString()
    {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[] {
            zzQU, Long.valueOf(zzQV), Integer.valueOf(zzQW), Integer.valueOf(zzRa)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj.zza(this, parcel, i);
    }

    public DocumentContents zzlu()
    {
        return zzQX;
    }

}
