// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.io.File;

public final class pm
{

    public final bmi a;
    public final cpz b;
    public final bje c;
    public final bkn d;
    public final bmh e;
    public final asa f;
    public final asa g;
    public final cna h;
    public final clv i;
    public final bjp j;
    public final long k;
    public final czk l;
    private final cnf m;

    public pm(bje bje1, cpz cpz1, bmi bmi1, bkn bkn1, bmh bmh1, cnf cnf1, asa asa1, 
            asa asa2, cna cna1, clv clv1, bjp bjp1, long l1, czk czk1)
    {
        c = (bje)b.a(bje1);
        b = (cpz)b.a(cpz1);
        a = (bmi)b.a(bmi1);
        d = (bkn)b.a(bkn1);
        e = (bmh)b.a(bmh1);
        m = (cnf)b.a(cnf1);
        f = (asa)b.a(asa1);
        g = (asa)b.a(asa2);
        h = (cna)b.a(cna1);
        i = (clv)b.a(clv1);
        j = (bjp)b.a(bjp1);
        k = l1;
        l = (czk)b.a(czk1);
    }

    public final ph a(btv btv1, String s, String s1, boolean flag, String s2)
    {
        File file = (File)j.b_();
        bje bje1 = c;
        bmi bmi1 = a;
        cpz cpz1 = b;
        bkn bkn1 = d;
        bmh bmh1 = e;
        asa asa1 = f;
        asa asa2 = g;
        cna cna1 = h;
        clv clv1 = i;
        long l1;
        long l2;
        if (file == null)
        {
            l1 = -1L;
        } else
        {
            l1 = file.getFreeSpace();
        }
        if (file == null)
        {
            l2 = -1L;
        } else
        {
            l2 = file.getTotalSpace();
        }
        btv1 = new ph(bje1, bmi1, cpz1, bkn1, bmh1, asa1, asa2, cna1, clv1, l1, l2, k, l, ph.a(Uri.parse(((btv)b.a(btv1)).b), b.a(s), b.a(s1), flag, s2, m), -1L, false, (byte)0);
        ph.a(btv1, -1);
        ph.b(btv1, -1);
        btv1.d();
        return btv1;
    }
}
