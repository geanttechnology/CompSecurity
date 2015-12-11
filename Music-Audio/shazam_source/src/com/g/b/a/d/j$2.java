// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.d;

import java.util.zip.Inflater;

// Referenced classes of package com.g.b.a.d:
//            j, n

final class flater extends Inflater
{

    final j a;

    public final int inflate(byte abyte0[], int i, int k)
    {
        int i1 = super.inflate(abyte0, i, k);
        int l = i1;
        if (i1 == 0)
        {
            l = i1;
            if (needsDictionary())
            {
                setDictionary(n.a);
                l = super.inflate(abyte0, i, k);
            }
        }
        return l;
    }

    flater(j j1)
    {
        a = j1;
        super();
    }
}
