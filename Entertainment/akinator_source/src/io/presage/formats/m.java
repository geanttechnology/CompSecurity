// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;


// Referenced classes of package io.presage.formats:
//            h

final class m
    implements Runnable
{

    final h.c a;

    m(h.c c)
    {
        a = c;
        super();
    }

    public final void run()
    {
        if (h.c.a(a).e)
        {
            h.c.a(a).a().b("cancel");
            return;
        } else
        {
            h.c.a(a).a().b("close");
            return;
        }
    }
}
