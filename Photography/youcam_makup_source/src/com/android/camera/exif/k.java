// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.camera.exif;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.android.camera.exif:
//            j, c

class k
{

    private static final int d[] = {
        0, 1, 2, 3, 4
    };
    private final int a;
    private final Map b = new HashMap();
    private int c;

    k(int i)
    {
        c = 0;
        a = i;
    }

    protected static int[] a()
    {
        return d;
    }

    protected j a(j j1)
    {
        j1.b(a);
        return (j)b.put(Short.valueOf(j1.b()), j1);
    }

    protected j a(short word0)
    {
        return (j)b.get(Short.valueOf(word0));
    }

    protected void a(int i)
    {
        c = i;
    }

    protected void b(short word0)
    {
        b.remove(Short.valueOf(word0));
    }

    protected j[] b()
    {
        return (j[])b.values().toArray(new j[b.size()]);
    }

    protected int c()
    {
        return a;
    }

    protected int d()
    {
        return b.size();
    }

    protected int e()
    {
        return c;
    }

    public boolean equals(Object obj)
    {
        int i;
        int l;
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (!(obj instanceof k))
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = (k)obj;
        if (((k) (obj)).c() != a || ((k) (obj)).d() != d())
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = ((k) (obj)).b();
        l = obj.length;
        i = 0;
_L3:
        j j1;
        if (i >= l)
        {
            break; /* Loop/switch isn't completed */
        }
        j1 = obj[i];
          goto _L1
_L5:
        i++;
        if (true) goto _L3; else goto _L2
_L1:
        if (com.android.camera.exif.c.a(j1.b()) || j1.equals((j)b.get(Short.valueOf(j1.b())))) goto _L5; else goto _L4
_L4:
        return false;
_L2:
        return true;
        return false;
    }

}
