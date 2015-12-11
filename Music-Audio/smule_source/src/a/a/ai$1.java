// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package a.a:
//            ed, ai, aj, aa, 
//            ay

final class nit> extends ed
{

    final List a;
    final aa b;

    public final void a()
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext();)
        {
            synchronized ((ai)iterator.next())
            {
                if (ai.a(ai1) == aj.b)
                {
                    b.n.b(ai1);
                }
            }
        }

    }

    .List(List list, aa aa1)
    {
        a = list;
        b = aa1;
        super();
    }
}
