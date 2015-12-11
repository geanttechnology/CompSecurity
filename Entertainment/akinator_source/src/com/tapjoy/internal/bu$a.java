// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

// Referenced classes of package com.tapjoy.internal:
//            bu, bv, ct, dd

public static abstract class eam
{

    private static name a;

    public static eam a()
    {
        eam eam1 = a;
        eam eam = eam1;
        if (eam1 == null)
        {
            eam = bv.a;
            a = eam;
        }
        return eam;
    }

    public final bu a(InputStream inputstream)
    {
        return a(((Reader) (new InputStreamReader(inputstream, ct.c))));
    }

    public bu a(Reader reader)
    {
        return a(dd.a(reader));
    }

    public bu a(String s)
    {
        return a(((InputStream) (new ByteArrayInputStream(s.getBytes(ct.c.name())))));
    }

    public eam()
    {
    }
}
