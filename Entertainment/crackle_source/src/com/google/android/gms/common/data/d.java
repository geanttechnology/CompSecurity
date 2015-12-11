// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.data;

import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.common.data:
//            DataBuffer, DataHolder

public abstract class d extends DataBuffer
{

    private boolean nZ;
    private ArrayList oa;

    protected d(DataHolder dataholder)
    {
        super(dataholder);
        nZ = false;
    }

    private int E(int i)
    {
        if (i < 0 || i == oa.size())
        {
            return 0;
        }
        if (i == oa.size() - 1)
        {
            return nE.getCount() - ((Integer)oa.get(i)).intValue();
        } else
        {
            return ((Integer)oa.get(i + 1)).intValue() - ((Integer)oa.get(i)).intValue();
        }
    }

    private void by()
    {
        this;
        JVM INSTR monitorenter ;
        if (nZ) goto _L2; else goto _L1
_L1:
        int k;
        k = nE.getCount();
        oa = new ArrayList();
        if (k <= 0) goto _L4; else goto _L3
_L3:
        String s;
        String s2;
        oa.add(Integer.valueOf(0));
        s2 = getPrimaryDataMarkerColumn();
        int i = nE.C(0);
        s = nE.getString(s2, 0, i);
        int j = 1;
_L9:
        if (j >= k) goto _L4; else goto _L5
_L5:
        String s1;
        int l = nE.C(j);
        s1 = nE.getString(s2, j, l);
        if (s1.equals(s)) goto _L7; else goto _L6
_L6:
        oa.add(Integer.valueOf(j));
        s = s1;
          goto _L7
_L4:
        nZ = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
_L7:
        j++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    int D(int i)
    {
        if (i < 0 || i >= oa.size())
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Position ").append(i).append(" is out of bounds for this buffer").toString());
        } else
        {
            return ((Integer)oa.get(i)).intValue();
        }
    }

    protected abstract Object a(int i, int j);

    public final Object get(int i)
    {
        by();
        return a(D(i), E(i));
    }

    public int getCount()
    {
        by();
        return oa.size();
    }

    protected abstract String getPrimaryDataMarkerColumn();
}
