// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.concurrent.Executor;

public final class va
    implements cwv
{

    final cpz a;
    final cxc b;
    public final bsv c;
    public final Uri d;
    public final int e;
    public final String f;
    public final int g;
    public volatile boolean h;
    private final Executor i;

    va(cpz cpz1, Executor executor, cxc cxc1, bsv bsv1, Uri uri, int j, String s, 
            int k)
    {
        a = (cpz)b.a(cpz1);
        i = (Executor)b.a(executor);
        b = (cxc)b.a(cxc1);
        d = (Uri)b.a(uri);
        c = (bsv)b.a(bsv1);
        e = j;
        f = s;
        g = k;
    }

    public va(cpz cpz1, Executor executor, cxc cxc1, vc vc1)
    {
        this(cpz1, executor, cxc1, vc1.a, vc1.b, vc1.c, vc1.d, vc1.e);
        h = vc1.f;
    }

    public void a()
    {
        i.execute(new vb(this));
    }

    public final void b()
    {
    }
}
