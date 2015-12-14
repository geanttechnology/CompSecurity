// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appdatasearch;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

// Referenced classes of package com.google.android.gms.appdatasearch:
//            RegisterSectionInfo, Feature

public static final class zzPJ
{

    private final String mName;
    private String zzPH;
    private boolean zzPI;
    private int zzPJ;
    private boolean zzPK;
    private String zzPL;
    private final List zzPM = new ArrayList();
    private BitSet zzPN;
    private String zzPO;

    public zzPJ zzM(boolean flag)
    {
        zzPI = flag;
        return this;
    }

    public zzPI zzN(boolean flag)
    {
        zzPK = flag;
        return this;
    }

    public zzPK zzak(int i)
    {
        if (zzPN == null)
        {
            zzPN = new BitSet();
        }
        zzPN.set(i);
        return this;
    }

    public zzPN zzby(String s)
    {
        zzPH = s;
        return this;
    }

    public zzPH zzbz(String s)
    {
        zzPO = s;
        return this;
    }

    public RegisterSectionInfo zzld()
    {
        int i = 0;
        int ai[] = null;
        if (zzPN != null)
        {
            int ai1[] = new int[zzPN.cardinality()];
            int j = zzPN.nextSetBit(0);
            do
            {
                ai = ai1;
                if (j < 0)
                {
                    break;
                }
                ai1[i] = j;
                j = zzPN.nextSetBit(j + 1);
                i++;
            } while (true);
        }
        return new RegisterSectionInfo(mName, zzPH, zzPI, zzPJ, zzPK, zzPL, (Feature[])zzPM.toArray(new Feature[zzPM.size()]), ai, zzPO);
    }

    public (String s)
    {
        mName = s;
        zzPJ = 1;
    }
}
