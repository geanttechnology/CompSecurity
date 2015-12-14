// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzb, zzh, DocumentSection, RegisterSectionInfo

public class DocumentContents
    implements SafeParcelable
{
    public static class zza
    {

        private List zzOV;
        private String zzOW;
        private boolean zzOX;
        private Account zzOY;

        public zza zzK(boolean flag)
        {
            zzOX = flag;
            return this;
        }

        public zza zza(Account account1)
        {
            zzOY = account1;
            return this;
        }

        public zza zza(DocumentSection documentsection)
        {
            if (zzOV == null)
            {
                zzOV = new ArrayList();
            }
            zzOV.add(documentsection);
            return this;
        }

        public zza zzbv(String s)
        {
            zzOW = s;
            return this;
        }

        public DocumentContents zzkY()
        {
            String s = zzOW;
            boolean flag = zzOX;
            Account account1 = zzOY;
            DocumentSection adocumentsection[];
            if (zzOV != null)
            {
                adocumentsection = (DocumentSection[])zzOV.toArray(new DocumentSection[zzOV.size()]);
            } else
            {
                adocumentsection = null;
            }
            return new DocumentContents(s, flag, account1, adocumentsection);
        }

        public zza()
        {
        }
    }


    public static final zzb CREATOR = new zzb();
    public final Account account;
    final int mVersionCode;
    final DocumentSection zzOS[];
    public final String zzOT;
    public final boolean zzOU;

    DocumentContents(int i, DocumentSection adocumentsection[], String s, boolean flag, Account account1)
    {
        mVersionCode = i;
        zzOS = adocumentsection;
        zzOT = s;
        zzOU = flag;
        account = account1;
    }

    transient DocumentContents(String s, boolean flag, Account account1, DocumentSection adocumentsection[])
    {
        this(1, adocumentsection, s, flag, account1);
        s = new BitSet(zzh.zzlc());
        for (int i = 0; i < adocumentsection.length; i++)
        {
            int j = adocumentsection[i].zzPg;
            if (j == -1)
            {
                continue;
            }
            if (s.get(j))
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Duplicate global search section type ").append(zzh.zzaj(j)).toString());
            }
            s.set(j);
        }

    }

    public int describeContents()
    {
        zzb zzb1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb zzb1 = CREATOR;
        zzb.zza(this, parcel, i);
    }

    public DocumentSection zzbu(String s)
    {
        zzx.zzcs(s);
        if (zzOS != null)
        {
            DocumentSection adocumentsection[] = zzOS;
            int j = adocumentsection.length;
            int i = 0;
            while (i < j) 
            {
                DocumentSection documentsection = adocumentsection[i];
                if (s.equals(documentsection.zzkZ().name))
                {
                    return documentsection;
                }
                i++;
            }
        }
        return null;
    }

    public String zzkX()
    {
        DocumentSection documentsection = zzbu("web_url");
        if (documentsection != null)
        {
            return documentsection.zzPe;
        } else
        {
            return null;
        }
    }

}
