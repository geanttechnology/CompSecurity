// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.a.g;

import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

// Referenced classes of package com.google.api.a.g:
//            y, r, p

public final class s
    implements y
{

    private final y a;
    private final int b;
    private final Level c;
    private final Logger d;

    public s(y y1, Logger logger, Level level, int i)
    {
        a = y1;
        d = logger;
        c = level;
        b = i;
    }

    public final void a(OutputStream outputstream)
    {
        r r1 = new r(outputstream, d, c, b);
        a.a(r1);
        r1.a.close();
        outputstream.flush();
        return;
        outputstream;
        r1.a.close();
        throw outputstream;
    }
}
