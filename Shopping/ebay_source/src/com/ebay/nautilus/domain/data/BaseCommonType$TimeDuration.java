// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.content.res.Resources;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            BaseCommonType

public static final class unit
{

    public nitEnum unit;
    public long value;

    public String toIso8601()
    {
        String s;
        String s1;
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder();
        s1 = null;
        s = null;
        com.ebay.nautilus.domain.data.BaseCommonType.TimeDurationUnitEnum[unit.ordinal()];
        JVM INSTR tableswitch 1 8: default 68
    //                   1 109
    //                   2 115
    //                   3 121
    //                   4 121
    //                   5 127
    //                   6 136
    //                   7 145
    //                   8 154;
           goto _L1 _L2 _L3 _L4 _L4 _L5 _L6 _L7 _L8
_L1:
        stringbuilder.append('P');
        if (s1 != null)
        {
            stringbuilder.append(s1);
        }
        stringbuilder.append(value);
        if (s != null)
        {
            stringbuilder.append(s);
        }
        return stringbuilder.toString();
_L2:
        s = "Y";
        continue; /* Loop/switch isn't completed */
_L3:
        s = "M";
        continue; /* Loop/switch isn't completed */
_L4:
        s = "D";
        continue; /* Loop/switch isn't completed */
_L5:
        s1 = "T";
        s = "H";
        continue; /* Loop/switch isn't completed */
_L6:
        s1 = "T";
        s = "M";
        continue; /* Loop/switch isn't completed */
_L7:
        s1 = "T";
        s = "S";
        continue; /* Loop/switch isn't completed */
_L8:
        s1 = "T";
        s = "S";
        value = value / 1000L;
        if (true) goto _L1; else goto _L9
_L9:
    }

    public String toString(Resources resources)
    {
        Object obj;
        long l;
        l = value;
        obj = null;
        com.ebay.nautilus.domain.data.BaseCommonType.TimeDurationUnitEnum[unit.ordinal()];
        JVM INSTR tableswitch 1 7: default 60
    //                   1 115
    //                   2 123
    //                   3 131
    //                   4 139
    //                   5 147
    //                   6 155
    //                   7 163;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        int i;
        i = com.ebay.nautilus.domain.nds;
        l /= 1000L;
_L10:
        String s = obj;
        if (resources != null)
        {
            s = obj;
            if (l <= 0x7fffffffL)
            {
                s = resources.getQuantityString(i, (int)l, new Object[] {
                    Integer.valueOf((int)l)
                });
            }
        }
        return s;
_L2:
        i = com.ebay.nautilus.domain.s;
        continue; /* Loop/switch isn't completed */
_L3:
        i = com.ebay.nautilus.domain.hs;
        continue; /* Loop/switch isn't completed */
_L4:
        i = com.ebay.nautilus.domain.ndar_days;
        continue; /* Loop/switch isn't completed */
_L5:
        i = com.ebay.nautilus.domain.ness_days;
        continue; /* Loop/switch isn't completed */
_L6:
        i = com.ebay.nautilus.domain.s;
        continue; /* Loop/switch isn't completed */
_L7:
        i = com.ebay.nautilus.domain.tes;
        continue; /* Loop/switch isn't completed */
_L8:
        i = com.ebay.nautilus.domain.nds;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public nitEnum()
    {
    }

    public nitEnum(nitEnum nitenum, long l)
    {
        value = l;
        unit = nitenum;
    }
}
