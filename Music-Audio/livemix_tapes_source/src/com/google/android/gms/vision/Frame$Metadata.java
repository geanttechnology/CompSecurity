// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision;


// Referenced classes of package com.google.android.gms.vision:
//            Frame

public static class getRotation
{

    private int mId;
    private long zzaxC;
    private int zznP;
    private int zznQ;
    private int zzzS;

    static int zza(getRotation getrotation, int i)
    {
        getrotation.zznP = i;
        return i;
    }

    static long zza(zznP zznp, long l)
    {
        zznp.zzaxC = l;
        return l;
    }

    static int zzb(zzaxC zzaxc, int i)
    {
        zzaxc.zznQ = i;
        return i;
    }

    static int zzc(zznQ zznq, int i)
    {
        zznq.mId = i;
        return i;
    }

    static int zzd(mId mid, int i)
    {
        mid.zzzS = i;
        return i;
    }

    public int getHeight()
    {
        return zznQ;
    }

    public int getId()
    {
        return mId;
    }

    public int getRotation()
    {
        return zzzS;
    }

    public long getTimestampMillis()
    {
        return zzaxC;
    }

    public int getWidth()
    {
        return zznP;
    }

    public void zzCd()
    {
        if (zzzS % 2 != 0)
        {
            int i = zznP;
            zznP = zznQ;
            zznQ = i;
        }
        zzzS = 0;
    }

    public ()
    {
    }

    public ( )
    {
        zznP = .getWidth();
        zznQ = .getHeight();
        mId = .getId();
        zzaxC = .getTimestampMillis();
        zzzS = .getRotation();
    }
}
