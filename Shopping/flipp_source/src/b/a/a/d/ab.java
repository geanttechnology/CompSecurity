// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.d;

import java.util.List;

// Referenced classes of package b.a.a.d:
//            ad, ah, aj, am, 
//            al, ac

public final class ab
{

    private static ac a;

    public static ac a()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        Object obj;
        ad ad1;
        obj = new ad();
        ((ad) (obj)).b();
        ah ah1 = new ah("P");
        ((ad) (obj)).a(ah1, ah1);
        ((ad) (obj)).a(0);
        obj = ((ad) (obj)).a("Y");
        ((ad) (obj)).a(1);
        obj = ((ad) (obj)).a("M");
        ((ad) (obj)).a(2);
        obj = ((ad) (obj)).a("W");
        ((ad) (obj)).a(3);
        ad1 = ((ad) (obj)).a("D");
        ad1.b();
        obj = ad1.a;
        if (((List) (obj)).size() != 0) goto _L4; else goto _L3
_L3:
        obj = new aj("T", "T", ah.a, ah.a);
        ad1.a(((am) (obj)), ((al) (obj)));
_L6:
        ad1.a(4);
        obj = ad1.a("H");
        ((ad) (obj)).a(5);
        obj = ((ad) (obj)).a("M");
        ((ad) (obj)).a(9);
        a = ((ad) (obj)).a("S").a();
_L2:
        return a;
_L4:
        aj aj1 = null;
        int i = ((List) (obj)).size();
label0:
        do
        {
label1:
            {
                i--;
                if (i >= 0)
                {
                    if (!(((List) (obj)).get(i) instanceof aj))
                    {
                        break label1;
                    }
                    aj1 = (aj)((List) (obj)).get(i);
                    obj = ((List) (obj)).subList(i + 1, ((List) (obj)).size());
                }
                if (aj1 != null && ((List) (obj)).size() == 0)
                {
                    throw new IllegalStateException("Cannot have two adjacent separators");
                }
                break label0;
            }
            i--;
        } while (true);
        Object aobj[] = ad.a(((List) (obj)));
        ((List) (obj)).clear();
        aobj = new aj("T", "T", (am)aobj[0], (al)aobj[1]);
        ((List) (obj)).add(((Object) (aobj)));
        ((List) (obj)).add(((Object) (aobj)));
        if (true) goto _L6; else goto _L5
_L5:
    }
}
