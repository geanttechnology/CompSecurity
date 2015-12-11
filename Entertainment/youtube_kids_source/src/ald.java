// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Map;
import java.util.Set;

class ald
    implements cfv
{

    private final Set a;
    private akx b;

    public ald(akx akx1, Set set)
    {
        b = akx1;
        super();
        a = set;
    }

    public void a(cgw cgw1)
    {
        als als1;
        Object obj;
        als1 = new als(cgw1);
        if (b.e.i() == amj.b && als1.equals(b.e.n()) && cgw1.a() && cgw1.a.c == 2)
        {
            chq chq = b.l;
            cgw1 = String.valueOf(cgw1);
            (new StringBuilder(String.valueOf(cgw1).length() + 54)).append("The app status for ").append(cgw1).append(" is STOPPED. Will remove the route!");
            b.a(als1);
            a.remove(als1);
            return;
        }
        b.h.put(cgw1.g, Integer.valueOf(0));
        obj = akx.a(b, cgw1.g);
        if (obj == null) goto _L2; else goto _L1
_L1:
        Object obj1 = ((als) (obj)).a;
        if (!cgw1.a()) goto _L4; else goto _L3
_L3:
        if (!((cgw) (obj1)).a()) goto _L6; else goto _L5
_L5:
        obj = cgw1.a;
        obj1 = ((cgw) (obj1)).a;
        if (obj == obj1) goto _L8; else goto _L7
_L7:
        if (obj1 != null) goto _L10; else goto _L9
_L9:
        boolean flag = false;
_L12:
        if (flag) goto _L4; else goto _L6
_L6:
        if ((b.e.i() == amj.b || b.e.i() == amj.a) && b.e.n().h() && cgw1.g.equals(b.e.n().f().a.g)) goto _L4; else goto _L2
_L2:
        akx.a(b, als1);
_L4:
        a.remove(als1);
        return;
_L10:
        if (obj.getClass() != obj1.getClass())
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        obj1 = (cfy)obj1;
        if (((cfy) (obj)).b == null)
        {
            if (((cfy) (obj1)).b != null)
            {
                flag = false;
                continue; /* Loop/switch isn't completed */
            }
        } else
        if (!((cfy) (obj)).b.equals(((cfy) (obj1)).b))
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
        if (((cfy) (obj)).e != ((cfy) (obj1)).e)
        {
            flag = false;
            continue; /* Loop/switch isn't completed */
        }
_L8:
        flag = true;
        if (true) goto _L12; else goto _L11
_L11:
    }
}
