// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.common.data:
//            AbstractDataBuffer, DataHolder

public abstract class zzf extends AbstractDataBuffer
{

    private boolean zzadD;
    private ArrayList zzadE;

    protected zzf(DataHolder dataholder)
    {
        super(dataholder);
        zzadD = false;
    }

    private void zzoz()
    {
        this;
        JVM INSTR monitorenter ;
        if (zzadD) goto _L2; else goto _L1
_L1:
        int k;
        k = zzabq.getCount();
        zzadE = new ArrayList();
        if (k <= 0) goto _L4; else goto _L3
_L3:
        Object obj;
        String s1;
        zzadE.add(Integer.valueOf(0));
        s1 = zzoy();
        int i = zzabq.zzbt(0);
        obj = zzabq.zzd(s1, 0, i);
        int j = 1;
_L9:
        if (j >= k) goto _L4; else goto _L5
_L5:
        String s;
        int l;
        l = zzabq.zzbt(j);
        s = zzabq.zzd(s1, j, l);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_160;
        }
        throw new NullPointerException((new StringBuilder("Missing value for markerColumn: ")).append(s1).append(", at row: ").append(j).append(", for window: ").append(l).toString());
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
        if (s.equals(obj)) goto _L7; else goto _L6
_L6:
        zzadE.add(Integer.valueOf(j));
        obj = s;
          goto _L7
_L4:
        zzadD = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L7:
        j++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final Object get(int i)
    {
        zzoz();
        return zzj(zzbw(i), zzbx(i));
    }

    public int getCount()
    {
        zzoz();
        return zzadE.size();
    }

    int zzbw(int i)
    {
        if (i < 0 || i >= zzadE.size())
        {
            throw new IllegalArgumentException((new StringBuilder("Position ")).append(i).append(" is out of bounds for this buffer").toString());
        } else
        {
            return ((Integer)zzadE.get(i)).intValue();
        }
    }

    protected int zzbx(int i)
    {
        int k;
        if (i < 0 || i == zzadE.size())
        {
            k = 0;
        } else
        {
            int j;
            if (i == zzadE.size() - 1)
            {
                j = zzabq.getCount() - ((Integer)zzadE.get(i)).intValue();
            } else
            {
                j = ((Integer)zzadE.get(i + 1)).intValue() - ((Integer)zzadE.get(i)).intValue();
            }
            k = j;
            if (j == 1)
            {
                i = zzbw(i);
                int l = zzabq.zzbt(i);
                String s = zzoA();
                k = j;
                if (s != null)
                {
                    k = j;
                    if (zzabq.zzd(s, i, l) == null)
                    {
                        return 0;
                    }
                }
            }
        }
        return k;
    }

    protected abstract Object zzj(int i, int j);

    protected String zzoA()
    {
        return null;
    }

    protected abstract String zzoy();
}
