// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.net.URL;

// Referenced classes of package a.a:
//            ed, ay, ee, dq, 
//            dp, dx, v, dr

final class ec extends ed
{

    private ay a;
    private ay b;
    private v c;
    private URL d;
    private dr e;
    private dq f;

    ec(ay ay1, ay ay2, v v, URL url, dr dr, dq dq1)
    {
        b = ay1;
        a = ay2;
        c = v;
        d = url;
        e = dr;
        f = dq1;
    }

    public final void a()
    {
        a.a(b);
        (new ee(f.a(c).a(b), new dx(d), true, e)).run();
    }
}
