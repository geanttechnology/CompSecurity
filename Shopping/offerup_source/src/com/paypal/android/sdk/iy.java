// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.zip.Inflater;

// Referenced classes of package com.paypal.android.sdk:
//            jc

final class iy extends Inflater
{

    iy()
    {
    }

    public final int inflate(byte abyte0[], int i, int j)
    {
        int l = super.inflate(abyte0, i, j);
        int k = l;
        if (l == 0)
        {
            k = l;
            if (needsDictionary())
            {
                setDictionary(jc.a);
                k = super.inflate(abyte0, i, j);
            }
        }
        return k;
    }
}
