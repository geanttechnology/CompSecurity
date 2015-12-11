// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.a;

import java.util.ArrayList;
import java.util.Collections;

// Referenced classes of package com.appnexus.opensdk.a:
//            i, c, e, d, 
//            f, h, g

public final class a
{

    public static g a(i j, long l, h h)
    {
        if (j == i.b)
        {
            j = new ArrayList();
            Collections.addAll(j, i.values());
            j.remove(i.a);
            j.remove(i.b);
            Collections.shuffle(j);
            j = (i)j.get(0);
        }
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[i.values().length];
                try
                {
                    a[i.c.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[i.d.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[i.e.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[i.f.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[j.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new c(l);

        case 2: // '\002'
            return new e(l, h);

        case 3: // '\003'
            return new d(l, h);

        case 4: // '\004'
            return new f(l, h);
        }
    }
}
