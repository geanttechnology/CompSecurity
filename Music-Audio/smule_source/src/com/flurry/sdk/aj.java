// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            ai, hp

public class aj extends ai
{

    private final File a;
    private OutputStream b;

    public aj(File file)
    {
        a = file;
    }

    protected OutputStream f()
    {
        if (b != null)
        {
            return b;
        }
        if (a == null)
        {
            throw new IOException("No file specified");
        } else
        {
            b = new FileOutputStream(a);
            return b;
        }
    }

    protected void g()
    {
        hp.a(b);
        b = null;
    }

    protected void h()
    {
        if (a == null)
        {
            return;
        } else
        {
            a.delete();
            return;
        }
    }
}
