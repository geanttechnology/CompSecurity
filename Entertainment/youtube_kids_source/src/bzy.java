// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Iterator;
import java.util.Set;
import org.xml.sax.Attributes;

public final class bzy extends bnt
{

    public bzy()
    {
    }

    public final void a(bmz bmz1, Attributes attributes)
    {
        bmz1.offer(new cds());
    }

    public final void a(bmz bmz1, Attributes attributes, String s)
    {
        boolean flag;
        attributes = ((cds)bmz1.b(cds)).a();
        bmz1 = (cpw)bmz1.a(cpw);
        if (((cdr) (attributes)).a == cdt.a && ((cdr) (attributes)).c.g == 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        s = ((cdr) (attributes)).c.a.iterator();
_L6:
        if (!s.hasNext()) goto _L4; else goto _L3
_L3:
        if (((cdw)s.next()).a == 93)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L6; else goto _L5
_L5:
        flag = true;
_L9:
        if (!flag) goto _L7; else goto _L2
_L2:
        bmz1.a(attributes);
_L7:
        return;
_L4:
        flag = false;
        if (true) goto _L9; else goto _L8
_L8:
    }
}
