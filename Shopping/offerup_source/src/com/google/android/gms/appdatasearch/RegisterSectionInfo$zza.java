// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            RegisterSectionInfo, Feature

public final class zzQO
{

    private final String mName;
    private String zzQM;
    private boolean zzQN;
    private int zzQO;
    private boolean zzQP;
    private String zzQQ;
    private final List zzQR = new ArrayList();
    private BitSet zzQS;
    private String zzQT;

    public final zzQO zzM(boolean flag)
    {
        zzQN = flag;
        return this;
    }

    public final zzQN zzN(boolean flag)
    {
        zzQP = flag;
        return this;
    }

    public final zzQP zzal(int i)
    {
        if (zzQS == null)
        {
            zzQS = new BitSet();
        }
        zzQS.set(i);
        return this;
    }

    public final zzQS zzbA(String s)
    {
        zzQM = s;
        return this;
    }

    public final zzQM zzbB(String s)
    {
        zzQT = s;
        return this;
    }

    public final RegisterSectionInfo zzlt()
    {
        int i = 0;
        int ai[] = null;
        if (zzQS != null)
        {
            int ai1[] = new int[zzQS.cardinality()];
            int j = zzQS.nextSetBit(0);
            do
            {
                ai = ai1;
                if (j < 0)
                {
                    break;
                }
                ai1[i] = j;
                j = zzQS.nextSetBit(j + 1);
                i++;
            } while (true);
        }
        return new RegisterSectionInfo(mName, zzQM, zzQN, zzQO, zzQP, zzQQ, (Feature[])zzQR.toArray(new Feature[zzQR.size()]), ai, zzQT);
    }

    public (String s)
    {
        mName = s;
        zzQO = 1;
    }
}
