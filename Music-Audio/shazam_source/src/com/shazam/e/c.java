// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.e;


// Referenced classes of package com.shazam.e:
//            a, b

public final class c
    implements a
{

    private final b a;

    public c(b b1)
    {
        a = b1;
    }

    public final Object a(Object obj)
    {
        boolean flag = false;
        obj = (byte[])obj;
        int i = obj.length;
        int k = (i / 8 + 1) * 8;
        byte abyte0[] = new byte[k];
        byte abyte1[] = new byte[k];
        System.arraycopy(obj, 0, abyte0, 0, i);
        int j;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= k)
            {
                break;
            }
            abyte0[i] = 0;
            i++;
        } while (true);
        for (; j < k; j += 8)
        {
            b.a(abyte0, j, abyte1, j);
        }

        return abyte1;
    }
}
