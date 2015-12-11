// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.concurrent.Executor;

public final class ve
{

    public final cpz a;
    public final Executor b;
    public final cxc c;

    public ve(cpz cpz1, Executor executor, cxc cxc1)
    {
        a = (cpz)b.a(cpz1);
        b = (Executor)b.a(executor);
        c = (cxc)b.a(cxc1);
    }

    public final va a(bsv bsv, btv btv1, String s, int i)
    {
        if (bsv == null || btv1 == null)
        {
            return null;
        } else
        {
            cpz cpz1 = a;
            Uri uri = Uri.parse(btv1.b);
            int j = btv1.a(5);
            btv1 = b.a(s);
            b.a(bsv);
            b.a(uri);
            return new va(cpz1, b, c, bsv, uri, j, btv1, i);
        }
    }
}
