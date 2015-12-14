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
import com.google.android.gms.internal.zzrx;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.zip.CRC32;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzj, DocumentSection, DocumentId, DocumentContents

public class UsageInfo
    implements SafeParcelable
{
    public static final class zza
    {

        private String zzJZ;
        private DocumentId zzPP;
        private long zzPQ;
        private int zzPR;
        private DocumentContents zzPS;
        private boolean zzPT;
        private int zzPU;
        private int zzPV;

        public zza zzO(boolean flag)
        {
            zzPT = flag;
            return this;
        }

        public zza zza(DocumentContents documentcontents)
        {
            zzPS = documentcontents;
            return this;
        }

        public zza zza(DocumentId documentid)
        {
            zzPP = documentid;
            return this;
        }

        public zza zzam(int i)
        {
            zzPR = i;
            return this;
        }

        public zza zzan(int i)
        {
            zzPV = i;
            return this;
        }

        public UsageInfo zzlf()
        {
            return new UsageInfo(zzPP, zzPQ, zzPR, zzJZ, zzPS, zzPT, zzPU, zzPV);
        }

        public zza zzw(long l)
        {
            zzPQ = l;
            return this;
        }

        public zza()
        {
            zzPQ = -1L;
            zzPR = -1;
            zzPU = -1;
            zzPT = false;
            zzPV = 0;
        }
    }


    public static final zzj CREATOR = new zzj();
    final int mVersionCode;
    final DocumentId zzPP;
    final long zzPQ;
    int zzPR;
    final DocumentContents zzPS;
    final boolean zzPT;
    int zzPU;
    int zzPV;
    public final String zztM;

    UsageInfo(int i, DocumentId documentid, long l, int j, String s, DocumentContents documentcontents, 
            boolean flag, int k, int i1)
    {
        mVersionCode = i;
        zzPP = documentid;
        zzPQ = l;
        zzPR = j;
        zztM = s;
        zzPS = documentcontents;
        zzPT = flag;
        zzPU = k;
        zzPV = i1;
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
        this(1, zza(s, intent), System.currentTimeMillis(), 0, ((String) (null)), zza(intent, s1, uri, s2, list).zzkY(), false, -1, i);
    }

    public static DocumentContents.zza zza(Intent intent, String s, Uri uri, String s1, List list)
    {
        DocumentContents.zza zza1 = new DocumentContents.zza();
        zza1.zza(zzbA(s));
        if (uri != null)
        {
            zza1.zza(zzi(uri));
        }
        if (list != null)
        {
            zza1.zza(zzh(list));
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
        return zza1.zzbv(s1).zzK(true);
    }

    public static DocumentId zza(String s, Intent intent)
    {
        return zzp(s, zzg(intent));
    }

    private static DocumentSection zzbA(String s)
    {
        return new DocumentSection(s, (new RegisterSectionInfo.zza("title")).zzak(1).zzN(true).zzbz("name").zzld(), "text1");
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

    private static DocumentSection zzh(List list)
    {
        com.google.android.gms.internal.zznw.zza zza1 = new com.google.android.gms.internal.zznw.zza();
        com.google.android.gms.internal.zznw.zza.zza azza[] = new com.google.android.gms.internal.zznw.zza.zza[list.size()];
        for (int i = 0; i < azza.length; i++)
        {
            azza[i] = new com.google.android.gms.internal.zznw.zza.zza();
            com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink appindexinglink = (com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink)list.get(i);
            azza[i].zzaAo = appindexinglink.appIndexingUrl.toString();
            azza[i].viewId = appindexinglink.viewId;
            if (appindexinglink.webUrl != null)
            {
                azza[i].zzaAp = appindexinglink.webUrl.toString();
            }
        }

        zza1.zzaAm = azza;
        return new DocumentSection(zzrx.zzf(zza1), (new RegisterSectionInfo.zza("outlinks")).zzM(true).zzbz(".private:outLinks").zzby("blob").zzld());
    }

    private static DocumentSection zzi(Uri uri)
    {
        return new DocumentSection(uri.toString(), (new RegisterSectionInfo.zza("web_url")).zzak(4).zzM(true).zzbz("url").zzld());
    }

    private static DocumentId zzp(String s, String s1)
    {
        return new DocumentId(s, "", s1);
    }

    private static DocumentSection zzq(String s, String s1)
    {
        return new DocumentSection(s1, (new RegisterSectionInfo.zza(s)).zzM(true).zzld(), s);
    }

    public int describeContents()
    {
        zzj zzj1 = CREATOR;
        return 0;
    }

    public String toString()
    {
        return String.format("UsageInfo[documentId=%s, timestamp=%d, usageType=%d, status=%d]", new Object[] {
            zzPP, Long.valueOf(zzPQ), Integer.valueOf(zzPR), Integer.valueOf(zzPV)
        });
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzj zzj1 = CREATOR;
        zzj.zza(this, parcel, i);
    }

    public DocumentContents zzle()
    {
        return zzPS;
    }

}
