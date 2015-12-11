// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

// Referenced classes of package com.flurry.sdk:
//            gx, ib, ia

public class cl
    implements gx
{

    protected Class a;
    private final ia b;

    public cl(Class class1)
    {
        this(class1, false);
    }

    public cl(Class class1, boolean flag)
    {
        a = class1;
        class1 = new ib();
        if (flag)
        {
            class1.a();
        }
        b = class1.b();
    }

    public void a(OutputStream outputstream, Object obj)
    {
        if (outputstream == null || obj == null)
        {
            return;
        } else
        {
            outputstream = new OutputStreamWriter(outputstream);
            b.a(obj, outputstream);
            outputstream.flush();
            return;
        }
    }

    public Object b(InputStream inputstream)
    {
        if (inputstream == null)
        {
            return null;
        } else
        {
            return b.a(new InputStreamReader(inputstream), a);
        }
    }
}
