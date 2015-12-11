// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.h;

import com.shazam.h.b.a;
import com.shazam.h.e.a.b;

// Referenced classes of package com.shazam.h:
//            h, x, w, e, 
//            s, q

public static final class nit>
{

    public e a;
    public s b;
    public b c;
    public x d;
    public q e;

    public final h a()
    {
        if (!a.a)
        {
            throw new IllegalStateException("Http client gson configuration was not called. Please call HttpClientGsonConfiguration.configure() before using the library");
        } else
        {
            return new h(this, (byte)0);
        }
    }

    public b()
    {
        d = com.shazam.h.x.a;
        e = new w();
    }
}
