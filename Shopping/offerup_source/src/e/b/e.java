// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.b;

import java.io.PrintWriter;

// Referenced classes of package e.b:
//            c

final class e extends c
{

    private final PrintWriter a;

    e(PrintWriter printwriter)
    {
        super((byte)0);
        a = printwriter;
    }

    final Object a()
    {
        return a;
    }

    final void a(Object obj)
    {
        a.println(obj);
    }
}
