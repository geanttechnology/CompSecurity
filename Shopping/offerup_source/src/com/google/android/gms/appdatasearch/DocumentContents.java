// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;
import java.util.BitSet;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzb, zzh, DocumentSection, RegisterSectionInfo

public class DocumentContents
    implements SafeParcelable
{

    public static final zzb CREATOR = new zzb();
    public final Account account;
    final int mVersionCode;
    final DocumentSection zzPX[];
    public final String zzPY;
    public final boolean zzPZ;

    DocumentContents(int i, DocumentSection adocumentsection[], String s, boolean flag, Account account1)
    {
        mVersionCode = i;
        zzPX = adocumentsection;
        zzPY = s;
        zzPZ = flag;
        account = account1;
    }

    transient DocumentContents(String s, boolean flag, Account account1, DocumentSection adocumentsection[])
    {
        this(1, adocumentsection, s, flag, account1);
        s = new BitSet(zzh.zzls());
        for (int i = 0; i < adocumentsection.length; i++)
        {
            int j = adocumentsection[i].zzQl;
            if (j == -1)
            {
                continue;
            }
            if (s.get(j))
            {
                throw new IllegalArgumentException((new StringBuilder("Duplicate global search section type ")).append(zzh.zzak(j)).toString());
            }
            s.set(j);
        }

    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzb.zza(this, parcel, i);
    }

    public DocumentSection zzbw(String s)
    {
        zzx.zzcr(s);
        if (zzPX != null)
        {
            DocumentSection adocumentsection[] = zzPX;
            int j = adocumentsection.length;
            int i = 0;
            while (i < j) 
            {
                DocumentSection documentsection = adocumentsection[i];
                if (s.equals(documentsection.zzlp().name))
                {
                    return documentsection;
                }
                i++;
            }
        }
        return null;
    }

    public String zzln()
    {
        DocumentSection documentsection = zzbw("web_url");
        if (documentsection != null)
        {
            return documentsection.zzQj;
        } else
        {
            return null;
        }
    }

}
