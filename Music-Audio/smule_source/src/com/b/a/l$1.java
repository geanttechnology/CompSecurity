// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.a;

import android.content.Context;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import junit.framework.Assert;

// Referenced classes of package com.b.a:
//            m, l, i

final class nit> extends m
{

    final String a;
    final Context b;
    final String c;
    final int d;
    final int e;

    public void a(i j, InputStream inputstream, String s)
    {
        boolean flag;
        if (inputstream == null || s == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Assert.assertTrue(flag);
        if (inputstream != null || s != null) goto _L2; else goto _L1
_L1:
        if (j != null && !j.a())
        {
            (new File(a)).delete();
        }
_L3:
        return;
_L2:
        String s1 = a;
        if (inputstream == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        s = new FileOutputStream(a);
        l.a(inputstream, s);
        s.close();
        s = s1;
        f = l.a(b, c, s, d, e);
        if (j != null && !j.a())
        {
            (new File(a)).delete();
            return;
        }
          goto _L3
        inputstream;
        (new File(a)).delete();
        if (j == null || j.a()) goto _L3; else goto _L4
_L4:
        (new File(a)).delete();
        return;
        inputstream;
        if (j != null && !j.a())
        {
            (new File(a)).delete();
        }
        throw inputstream;
    }

    ring(String s, Context context, String s1, int j, int k)
    {
        a = s;
        b = context;
        c = s1;
        d = j;
        e = k;
        super(null);
    }
}
