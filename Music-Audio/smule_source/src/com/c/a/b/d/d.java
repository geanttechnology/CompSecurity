// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.d;

import java.io.InputStream;

// Referenced classes of package com.c.a.b.d:
//            b, c

public class d
    implements b
{

    private final b a;

    public d(b b1)
    {
        a = b1;
    }

    public InputStream a(String s, Object obj)
    {
        class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[c.values().length];
                try
                {
                    a[c.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[c.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.a[c.a(s).ordinal()])
        {
        default:
            return a.a(s, obj);

        case 1: // '\001'
        case 2: // '\002'
            throw new IllegalStateException();
        }
    }
}
