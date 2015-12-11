// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;


// Referenced classes of package com.google.android.gms.appdatasearch:
//            UsageInfo, DocumentId, DocumentContents

public final class zzRa
{

    private String zzLe;
    private DocumentId zzQU;
    private long zzQV;
    private int zzQW;
    private DocumentContents zzQX;
    private boolean zzQY;
    private int zzQZ;
    private int zzRa;

    public final zzRa zzO(boolean flag)
    {
        zzQY = flag;
        return this;
    }

    public final ts zza(DocumentContents documentcontents)
    {
        zzQX = documentcontents;
        return this;
    }

    public final zzQX zza(DocumentId documentid)
    {
        zzQU = documentid;
        return this;
    }

    public final zzQU zzan(int i)
    {
        zzQW = i;
        return this;
    }

    public final zzQW zzao(int i)
    {
        zzRa = i;
        return this;
    }

    public final UsageInfo zzlv()
    {
        return new UsageInfo(zzQU, zzQV, zzQW, zzLe, zzQX, zzQY, zzQZ, zzRa, null);
    }

    public final ts zzw(long l)
    {
        zzQV = l;
        return this;
    }

    public ts()
    {
        zzQV = -1L;
        zzQW = -1;
        zzQZ = -1;
        zzQY = false;
        zzRa = 0;
    }
}
