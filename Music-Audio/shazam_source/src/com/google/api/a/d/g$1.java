// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.d;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.google.api.a.d:
//            g

final class tream extends BufferedOutputStream
{

    final g a;

    public final void close()
    {
        try
        {
            flush();
            return;
        }
        catch (IOException ioexception)
        {
            return;
        }
    }

    tream(g g1, OutputStream outputstream)
    {
        a = g1;
        super(outputstream);
    }
}
