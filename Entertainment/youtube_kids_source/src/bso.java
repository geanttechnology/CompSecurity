// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashSet;
import java.util.Set;

public final class bso
    implements bnj
{

    public dfh a;
    public dfh b;
    public dfh c;
    public dfh d;
    public dfh e;
    public dfh f;
    public dfh g;
    public dfh h;
    private Set i;

    public bso(dfg dfg1)
    {
        dfh adfh[];
        int j;
        boolean flag;
        int k;
        flag = false;
        super();
        b.a(dfg1);
        i = new HashSet();
        adfh = dfg1.a;
        k = adfh.length;
        j = 0;
_L7:
        dfh dfh2;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        dfh2 = adfh[j];
        a(dfh2);
        dfh2.b;
        JVM INSTR tableswitch 1 4: default 88
    //                   1 97
    //                   2 113
    //                   3 105
    //                   4 121;
           goto _L1 _L2 _L3 _L4 _L5
_L5:
        break MISSING_BLOCK_LABEL_121;
_L1:
        break; /* Loop/switch isn't completed */
_L2:
        break; /* Loop/switch isn't completed */
_L8:
        j++;
        if (true) goto _L7; else goto _L6
_L6:
        a = dfh2;
          goto _L8
_L4:
        b = dfh2;
          goto _L8
_L3:
        c = dfh2;
          goto _L8
        d = dfh2;
          goto _L8
        dfg1 = dfg1.b;
        k = dfg1.length;
        j = ((flag) ? 1 : 0);
_L15:
        dfh dfh1;
        if (j >= k)
        {
            break MISSING_BLOCK_LABEL_233;
        }
        dfh1 = dfg1[j];
        a(dfh1);
        dfh1.b;
        JVM INSTR tableswitch 1 4: default 192
    //                   1 201
    //                   2 217
    //                   3 209
    //                   4 225;
           goto _L9 _L10 _L11 _L12 _L13
_L13:
        break MISSING_BLOCK_LABEL_225;
_L9:
        break; /* Loop/switch isn't completed */
_L10:
        break; /* Loop/switch isn't completed */
_L16:
        j++;
        if (true) goto _L15; else goto _L14
_L14:
        e = dfh1;
          goto _L16
_L12:
        f = dfh1;
          goto _L16
_L11:
        g = dfh1;
          goto _L16
        h = dfh1;
          goto _L16
    }

    private void a(dfh dfh1)
    {
        a(dfh1.c);
        a(dfh1.d);
        a(dfh1.e);
    }

    private void a(dre dre)
    {
        if (dre != null)
        {
            i.add(dre);
        }
    }

    public final void a(bnk bnk1)
    {
        bnk1.a();
    }

    public final boolean a()
    {
        return c != null;
    }

    public final boolean b()
    {
        return b != null;
    }
}
