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
    public static final int zzQh = Integer.parseInt("-1");
    private static final RegisterSectionInfo zzQi = (new RegisterSectionInfo.zza("SsbContext")).zzM(true).zzbA("blob").zzlt();
    final int mVersionCode;
    public final String zzQj;
    final RegisterSectionInfo zzQk;
    public final int zzQl;
    public final byte zzQm[];

    DocumentSection(int i, String s, RegisterSectionInfo registersectioninfo, int j, byte abyte0[])
    {
        boolean flag;
        if (j == zzQh || com.google.android.gms.appdatasearch.zzh.zzak(j) != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzb(flag, (new StringBuilder("Invalid section type ")).append(j).toString());
        mVersionCode = i;
        zzQj = s;
        zzQk = registersectioninfo;
        zzQl = j;
        zzQm = abyte0;
        s = zzlq();
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
        this(1, s, registersectioninfo, zzQh, null);
    }

    public DocumentSection(String s, RegisterSectionInfo registersectioninfo, String s1)
    {
        this(1, s, registersectioninfo, com.google.android.gms.appdatasearch.zzh.zzbz(s1), null);
    }

    public DocumentSection(byte abyte0[], RegisterSectionInfo registersectioninfo)
    {
        this(1, null, registersectioninfo, zzQh, abyte0);
    }

    public static DocumentSection zzh(byte abyte0[])
    {
        return new DocumentSection(abyte0, zzQi);
    }

    public int describeContents()
    {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        zzd.zza(this, parcel, i);
    }

    public RegisterSectionInfo zzlp()
    {
        return zzQk;
    }

    public String zzlq()
    {
        if (zzQl != zzQh && com.google.android.gms.appdatasearch.zzh.zzak(zzQl) == null)
        {
            return (new StringBuilder("Invalid section type ")).append(zzQl).toString();
        }
        if (zzQj != null && zzQm != null)
        {
            return "Both content and blobContent set";
        } else
        {
            return null;
        }
    }

}
