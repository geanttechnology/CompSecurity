// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.utility;

import com.pf.common.io.GZIPStreamCodec;

// Referenced classes of package com.pf.common.utility:
//            k, h

public class g extends k
    implements h
{

    public static final g a = new g();

    private g()
    {
        super(GZIPStreamCodec.a, g);
    }

    public String a()
    {
        return ".abmp.gz";
    }

}
