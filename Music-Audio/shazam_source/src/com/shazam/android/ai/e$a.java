// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ai;

import com.moodstocks.android.Result;
import com.shazam.android.visual.v;
import com.shazam.model.visual.VisualShazamProvider;

// Referenced classes of package com.shazam.android.ai:
//            e

private final class <init>
    implements <init>
{

    final e a;

    public final void a(Result result)
    {
        result.getType();
        JVM INSTR tableswitch -2147483648 -2147483648: default 24
    //                   -2147483648 77;
           goto _L1 _L2
_L1:
        com.shazam.android.visual.t> t> = null;
_L4:
        if (t> != null)
        {
            com.shazam.android.visual.t> t>1 = new com.shazam.android.visual.<init>();
            t>1.c = VisualShazamProvider.MOODSTOCKS;
            t>1.b = t>;
            t>1.a = result.getValue();
            result = t>1.a();
            a.a.a(result);
        }
        return;
_L2:
        t> = com.shazam.android.visual.b;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private ult(e e1)
    {
        a = e1;
        super();
    }

    a(e e1, byte byte0)
    {
        this(e1);
    }
}
