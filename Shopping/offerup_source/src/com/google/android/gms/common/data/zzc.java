// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder

public abstract class zzc
{

    protected final DataHolder zzabq;
    protected int zzadl;
    private int zzadm;

    public zzc(DataHolder dataholder, int i)
    {
        zzabq = (DataHolder)zzx.zzw(dataholder);
        zzbr(i);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof zzc)
        {
            obj = (zzc)obj;
            flag = flag1;
            if (zzw.equal(Integer.valueOf(((zzc) (obj)).zzadl), Integer.valueOf(zzadl)))
            {
                flag = flag1;
                if (zzw.equal(Integer.valueOf(((zzc) (obj)).zzadm), Integer.valueOf(zzadm)))
                {
                    flag = flag1;
                    if (((zzc) (obj)).zzabq == zzabq)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    protected boolean getBoolean(String s)
    {
        return zzabq.zze(s, zzadl, zzadm);
    }

    protected byte[] getByteArray(String s)
    {
        return zzabq.zzg(s, zzadl, zzadm);
    }

    protected float getFloat(String s)
    {
        return zzabq.zzf(s, zzadl, zzadm);
    }

    protected int getInteger(String s)
    {
        return zzabq.zzc(s, zzadl, zzadm);
    }

    protected long getLong(String s)
    {
        return zzabq.zzb(s, zzadl, zzadm);
    }

    protected String getString(String s)
    {
        return zzabq.zzd(s, zzadl, zzadm);
    }

    public int hashCode()
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(zzadl), Integer.valueOf(zzadm), zzabq
        });
    }

    public boolean isDataValid()
    {
        return !zzabq.isClosed();
    }

    protected void zza(String s, CharArrayBuffer chararraybuffer)
    {
        zzabq.zza(s, zzadl, zzadm, chararraybuffer);
    }

    protected void zzbr(int i)
    {
        boolean flag;
        if (i >= 0 && i < zzabq.getCount())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zzZ(flag);
        zzadl = i;
        zzadm = zzabq.zzbt(zzadl);
    }

    public boolean zzce(String s)
    {
        return zzabq.zzce(s);
    }

    protected Uri zzcf(String s)
    {
        return zzabq.zzh(s, zzadl, zzadm);
    }

    protected boolean zzcg(String s)
    {
        return zzabq.zzi(s, zzadl, zzadm);
    }

    protected int zzou()
    {
        return zzadl;
    }
}
