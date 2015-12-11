// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class qc
{

    private bmi a;
    private cou b;

    public qc(bmi bmi1, cou cou1)
    {
        a = (bmi)b.a(bmi1);
        b = (cou)b.a(cou1);
    }

    public final bfx a(bxb bxb1, long l)
    {
        b.b();
        b.a(bxb1);
        if (bxb1.k() == null)
        {
            return null;
        }
        Object obj;
        Object obj1;
        Object obj2;
        String s;
        ArrayList arraylist;
        Iterator iterator;
        bgc bgc1;
        Object obj3;
        buz buz1;
        bvd bvd1;
        long l1;
        long l2;
        try
        {
            obj = (bfx)b.a_(bxb1);
        }
        // Misplaced declaration of an exception variable
        catch (bxb bxb1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (bxb bxb1)
        {
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (bxb bxb1)
        {
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        obj1 = bxb.a(bxb1.a);
        obj2 = bxb1.a.n;
        s = bxb1.a.o;
        bxb1 = bxb1.c;
        l2 = a.a();
        arraylist = new ArrayList();
        iterator = ((bfx) (obj)).a.iterator();
_L10:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        obj3 = (bfz)iterator.next();
        bgc1 = ((bfz) (obj3)).a();
        bgc1.g = null;
        bgc1.f = ((String) (obj1));
        bgc1 = bgc1.a(bxb1);
        obj3 = ((bfz) (obj3)).e.iterator();
_L9:
        if (!((Iterator) (obj3)).hasNext()) goto _L4; else goto _L3
_L3:
        buz1 = (buz)((Iterator) (obj3)).next();
        bvd1 = buz1.a();
        bvd1.Z = l2;
        bvd1.d = ((String) (obj2));
        bvd1.e = s;
        bvd1.g = bxb1;
        if (buz1.N || buz1.J != 0L) goto _L6; else goto _L5
_L5:
        if (buz1.P == null || buz1.P.J <= 0L) goto _L8; else goto _L7
_L7:
        l1 = buz1.P.J;
_L17:
        bvd1.S = l1;
_L6:
        buz1 = bvd1.a();
        if (bgc1.g == null)
        {
            bgc1.g = new ArrayList();
        }
        bgc1.g.add(buz1);
          goto _L9
_L4:
        arraylist.add(bgc1.a());
          goto _L10
_L2:
        obj1 = Collections.unmodifiableList(arraylist);
        if (((bfx) (obj)).a.size() <= 0)
        {
            break MISSING_BLOCK_LABEL_488;
        }
        bxb1 = (bfz)((bfx) (obj)).a.get(0);
_L18:
        obj2 = new bfy();
        obj2.a = ((bfx) (obj)).a;
        if (((bfx) (obj)).a.size() <= 0) goto _L12; else goto _L11
_L11:
        obj = ((bfz)((bfx) (obj)).a.get(0)).j;
_L15:
        obj = ((bfy) (obj2)).a(((bfu) (obj)));
        if (bxb1 == null) goto _L14; else goto _L13
_L13:
        bxb1 = ((bfz) (bxb1)).k;
_L16:
        obj.b = bxb1;
        obj.a = ((List) (obj1));
        return ((bfy) (obj)).a();
_L12:
        obj = bfu.a;
          goto _L15
_L14:
        bxb1 = null;
          goto _L16
_L8:
        l1 = l2 + l;
          goto _L17
        bxb1 = null;
          goto _L18
    }
}
