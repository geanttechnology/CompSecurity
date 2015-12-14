// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            zzd, zzh, RegisterSectionInfo

public class DocumentSection
    implements SafeParcelable
{

    public static final zzd CREATOR = new zzd();
    public static final int zzPc = Integer.parseInt("-1");
    private static final RegisterSectionInfo zzPd = (new RegisterSectionInfo.zza("SsbContext")).zzM(true).zzby("blob").zzld();
    final int mVersionCode;
    public final String zzPe;
    final RegisterSectionInfo zzPf;
    public final int zzPg;
    public final byte zzPh[];

    DocumentSection(int i, String s, RegisterSectionInfo registersectioninfo, int j, byte abyte0[])
    {
        boolean flag;
        if (j == zzPc || com.google.android.gms.appdatasearch.zzh.zzaj(j) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, (new StringBuilder()).append("Invalid section type ").append(j).toString());
        mVersionCode = i;
        zzPe = s;
        zzPf = registersectioninfo;
        zzPg = j;
        zzPh = abyte0;
        s = zzla();
        if (s != null)
        {
            throw new IllegalArgumentException(s);
        } else
        {
            return;
        }
    }

    public DocumentSection(String s, RegisterSectionInfo registersectioninfo)
    {
        this(1, s, registersectioninfo, zzPc, null);
    }

    public DocumentSection(String s, RegisterSectionInfo registersectioninfo, String s1)
    {
        this(1, s, registersectioninfo, com.google.android.gms.appdatasearch.zzh.zzbx(s1), null);
    }

    public DocumentSection(byte abyte0[], RegisterSectionInfo registersectioninfo)
    {
        this(1, null, registersectioninfo, zzPc, abyte0);
    }

    public static DocumentSection zzh(byte abyte0[])
    {
        return new DocumentSection(abyte0, zzPd);
    }

    public int describeContents()
    {
        zzd zzd1 = CREATOR;
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd zzd1 = CREATOR;
        zzd.zza(this, parcel, i);
    }

    public RegisterSectionInfo zzkZ()
    {
        return zzPf;
    }

    public String zzla()
    {
        if (zzPg != zzPc && com.google.android.gms.appdatasearch.zzh.zzaj(zzPg) == null)
        {
            return (new StringBuilder()).append("Invalid section type ").append(zzPg).toString();
        }
        if (zzPe != null && zzPh != null)
        {
            return "Both content and blobContent set";
        } else
        {
            return null;
        }
    }

}
