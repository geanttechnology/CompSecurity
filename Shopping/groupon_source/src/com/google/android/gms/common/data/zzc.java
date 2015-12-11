// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.common.internal.zzu;

// Referenced classes of package com.google.android.gms.common.data:
//            DataHolder

public abstract class zzc
{

    protected final DataHolder zzWu;
    protected int zzYs;
    private int zzYt;

    public zzc(DataHolder dataholder, int i)
    {
        zzWu = (DataHolder)zzu.zzu(dataholder);
        zzbf(i);
    }

    public boolean equals(Object obj)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (obj instanceof zzc)
        {
            obj = (zzc)obj;
            flag = flag1;
            if (zzt.equal(Integer.valueOf(((zzc) (obj)).zzYs), Integer.valueOf(zzYs)))
            {
                flag = flag1;
                if (zzt.equal(Integer.valueOf(((zzc) (obj)).zzYt), Integer.valueOf(zzYt)))
                {
                    flag = flag1;
                    if (((zzc) (obj)).zzWu == zzWu)
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    protected String getString(String s)
    {
        return zzWu.zzd(s, zzYs, zzYt);
    }

    public int hashCode()
    {
        return zzt.hashCode(new Object[] {
            Integer.valueOf(zzYs), Integer.valueOf(zzYt), zzWu
        });
    }

    protected void zzbf(int i)
    {
        boolean flag;
        if (i >= 0 && i < zzWu.getCount())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzu.zzU(flag);
        zzYs = i;
        zzYt = zzWu.zzbh(zzYs);
    }
}
