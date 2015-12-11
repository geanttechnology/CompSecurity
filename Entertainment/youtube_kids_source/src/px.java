// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.LinkedList;
import java.util.List;

public final class px
{

    private final bmi a;
    private final bkn b;
    private final bje c;
    private final cnf d;
    private final bme e;
    private final cpz f;
    private final crh g;

    public px(cpz cpz, bmi bmi1, bkn bkn1, bje bje1, cnf cnf1, crh crh1, bme bme)
    {
        f = cpz;
        a = (bmi)b.a(bmi1);
        b = (bkn)b.a(bkn1);
        c = (bje)b.a(bje1);
        d = (cnf)b.a(cnf1);
        g = (crh)b.a(crh1);
        e = bme;
    }

    private pv a(Uri uri, Uri uri1, Uri uri2, String s, String s1, String s2, int i, 
            int j, boolean flag, boolean flag1, String s3, ctn ctn1, csg csg1, List list, 
            crh crh1)
    {
        uri = new pv(f, a, uri, uri1, uri2, s, String.valueOf(i), j, flag, flag1, s3, s1, s2, a.b(), ctn1, "-", csg1, b, c, d, list, e, crh1);
        uri.f();
        return uri;
    }

    public final pv a(btv btv1, btv btv2, btv btv3, String s, String s1, int i, String s2, 
            ctn ctn1, csg csg1)
    {
        return a(Uri.parse(btv1.b), Uri.parse(btv2.b), Uri.parse(btv3.b), b.a(s), b.a(s1), null, i, btv2.a(0), true, false, b.a(s2), (ctn)b.a(ctn1), (csg)b.a(csg1), ((List) (new LinkedList())), g);
    }

    public final pv a(btv btv1, btv btv2, btv btv3, String s, String s1, String s2, int i, 
            boolean flag, boolean flag1, ctn ctn1, csg csg1)
    {
        btv1 = Uri.parse(btv1.b);
        Uri uri = Uri.parse(btv2.b);
        btv3 = Uri.parse(btv3.b);
        s = b.a(s);
        s1 = b.a(s1);
        byte byte0;
        if (flag)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        return a(((Uri) (btv1)), uri, ((Uri) (btv3)), s, s1, s2, i, btv2.a(byte0), flag, flag1, null, (ctn)b.a(ctn1), (csg)b.a(csg1), ((List) (new LinkedList())), g);
    }

    public final pv a(csg csg1, py py1)
    {
        cpz cpz = f;
        bmi bmi1 = a;
        py py2 = (py)b.a(py1);
        csg1 = (csg)b.a(csg1);
        bkn bkn1 = b;
        bje bje1 = c;
        cnf cnf1 = d;
        py1 = py1.h;
        csg1 = new pv(cpz, bmi1, py2, csg1, bkn1, bje1, cnf1, new LinkedList(), e, g);
        csg1.f();
        return csg1;
    }
}
