// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.w;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            i, ad, o, r, 
//            g, ak, c

private final class b
{

    int a;
    ByteArrayOutputStream b;
    final i c;

    public final boolean a(c c1)
    {
        w.a(c1);
        if (a + 1 > ad.g())
        {
            return false;
        }
        String s = c.a(c1, false);
        if (s == null)
        {
            ((o) (c)).i.a().a(c1, "Error formatting hit");
            return true;
        }
        byte abyte0[] = s.getBytes();
        int k = abyte0.length;
        if (k > ad.c())
        {
            ((o) (c)).i.a().a(c1, "Hit size exceeds the maximum size limit");
            return true;
        }
        int j = k;
        if (b.size() > 0)
        {
            j = k + 1;
        }
        if (b.size() + j > ((Integer)ak.A.a()).intValue())
        {
            return false;
        }
        try
        {
            if (b.size() > 0)
            {
                b.write(i.c());
            }
            b.write(abyte0);
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            c.e("Failed to write payload when batching hits", c1);
            return true;
        }
        a = a + 1;
        return true;
    }

    public (i j)
    {
        c = j;
        super();
        b = new ByteArrayOutputStream();
    }
}
