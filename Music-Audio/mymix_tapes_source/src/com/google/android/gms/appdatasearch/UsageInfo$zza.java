// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;


// Referenced classes of package com.google.android.gms.appdatasearch:
//            UsageInfo, DocumentId, DocumentContents

public static final class zzPV
{

    private String zzJZ;
    private DocumentId zzPP;
    private long zzPQ;
    private int zzPR;
    private DocumentContents zzPS;
    private boolean zzPT;
    private int zzPU;
    private int zzPV;

    public zzPV zzO(boolean flag)
    {
        zzPT = flag;
        return this;
    }

    public ts zza(DocumentContents documentcontents)
    {
        zzPS = documentcontents;
        return this;
    }

    public zzPS zza(DocumentId documentid)
    {
        zzPP = documentid;
        return this;
    }

    public zzPP zzam(int i)
    {
        zzPR = i;
        return this;
    }

    public zzPR zzan(int i)
    {
        zzPV = i;
        return this;
    }

    public UsageInfo zzlf()
    {
        return new UsageInfo(zzPP, zzPQ, zzPR, zzJZ, zzPS, zzPT, zzPU, zzPV, null);
    }

    public ts zzw(long l)
    {
        zzPQ = l;
        return this;
    }

    public ts()
    {
        zzPQ = -1L;
        zzPR = -1;
        zzPU = -1;
        zzPT = false;
        zzPV = 0;
    }
}
