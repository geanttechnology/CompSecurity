// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.b;

import java.util.zip.Inflater;

// Referenced classes of package com.a.a.a.b:
//            l, m

final class o extends Inflater
{

    final m a;

    o(m m)
    {
        a = m;
        super();
    }

    public final int inflate(byte abyte0[], int i, int j)
    {
        int i1 = super.inflate(abyte0, i, j);
        int k = i1;
        if (i1 == 0)
        {
            k = i1;
            if (needsDictionary())
            {
                setDictionary(l.a);
                k = super.inflate(abyte0, i, j);
            }
        }
        return k;
    }
}
