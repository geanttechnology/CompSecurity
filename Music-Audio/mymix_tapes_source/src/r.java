// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import com.nuance.nmdp.speechkit.util.pdx.PdxValue;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class r
{

    private final int a;
    private final int b;
    private final String c;
    private final byte d[];
    private final Map e;
    private final List f;

    public r(PdxValue pdxvalue)
    {
        a = pdxvalue.getType();
        a;
        JVM INSTR tableswitch 0 4: default 52
    //                   0 298
    //                   1 330
    //                   2 78
    //                   3 176
    //                   4 266;
           goto _L1 _L2 _L3 _L4 _L5 _L6
_L2:
        break MISSING_BLOCK_LABEL_298;
_L3:
        break MISSING_BLOCK_LABEL_330;
_L1:
        b = 0;
        c = null;
        d = null;
        f = null;
        e = null;
_L7:
        return;
_L4:
        b = 0;
        c = null;
        d = null;
        f = null;
        e = new HashMap();
        pdxvalue = ((com.nuance.nmdp.speechkit.util.pdx.PdxValue.Dictionary)pdxvalue).getEntries().iterator();
        while (pdxvalue.hasNext()) 
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)pdxvalue.next();
            e.put(entry.getKey(), new r((PdxValue)entry.getValue()));
        }
        if (true)
        {
            continue; /* Loop/switch isn't completed */
        }
_L5:
        pdxvalue = (com.nuance.nmdp.speechkit.util.pdx.PdxValue.Sequence)pdxvalue;
        b = 0;
        c = null;
        d = null;
        f = new ArrayList(pdxvalue.size());
        e = null;
        pdxvalue = pdxvalue.getValues().iterator();
        while (pdxvalue.hasNext()) 
        {
            PdxValue pdxvalue1 = (PdxValue)pdxvalue.next();
            f.add(new r(pdxvalue1));
        }
        if (true) goto _L7; else goto _L6
_L6:
        b = 0;
        c = null;
        d = ((com.nuance.nmdp.speechkit.util.pdx.PdxValue.Bytes)pdxvalue).get();
        f = null;
        e = null;
        return;
        b = 0;
        c = ((com.nuance.nmdp.speechkit.util.pdx.PdxValue.String)pdxvalue).get();
        d = null;
        f = null;
        e = null;
        return;
        b = ((com.nuance.nmdp.speechkit.util.pdx.PdxValue.Integer)pdxvalue).get();
        c = null;
        d = null;
        f = null;
        e = null;
        return;
    }

    public final Map a()
    {
        return e;
    }

    public final List b()
    {
        return f;
    }

    public final String c()
    {
        return c;
    }

    public final int d()
    {
        return b;
    }

    public final byte[] e()
    {
        return d;
    }

    public final int f()
    {
        return a;
    }
}
