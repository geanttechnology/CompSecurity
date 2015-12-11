// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.e;

import com.google.api.a.f.a.a.a.a.c;
import com.google.api.a.g.u;
import com.google.api.a.g.w;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.google.api.a.e:
//            c, f, i

public final class e
    implements u
{
    public static final class a
    {

        final com.google.api.a.e.c a;
        public Collection b;

        public final e a()
        {
            return new e(this);
        }

        public a(com.google.api.a.e.c c1)
        {
            b = new HashSet();
            a = (com.google.api.a.e.c)c.a(c1);
        }
    }


    public final com.google.api.a.e.c a;
    public final Set b;

    public e(com.google.api.a.e.c c1)
    {
        this(new a(c1));
    }

    protected e(a a1)
    {
        a = a1.a;
        b = new HashSet(a1.b);
    }

    public final Object a(InputStream inputstream, Charset charset, Class class1)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        inputstream = a.a(inputstream, charset);
        if (b.isEmpty())
        {
            break MISSING_BLOCK_LABEL_75;
        }
        flag = flag1;
        if (inputstream.a(b) == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        flag = flag1;
        if (inputstream.c() != i.d)
        {
            flag = true;
        }
        w.a(flag, "wrapper key(s) not found: %s", new Object[] {
            b
        });
        return inputstream.a(class1, true);
        charset;
        inputstream.a();
        throw charset;
    }
}
