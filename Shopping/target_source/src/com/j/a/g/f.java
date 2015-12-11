// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;


// Referenced classes of package com.j.a.g:
//            l, w, h

class f
    implements l
{

    final h a;

    f(h h)
    {
        a = h;
        super();
    }

    public void a(Exception exception)
    {
        if (exception != null)
        {
            w.b("Writing JSON to Disk: ", exception);
        }
    }
}
