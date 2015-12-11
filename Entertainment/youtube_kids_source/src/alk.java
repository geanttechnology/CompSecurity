// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

final class alk extends alm
{

    private bhv a;
    private ali b;

    alk(ali ali, Void void1, bhv bhv1, bhv bhv2)
    {
        b = ali;
        a = bhv2;
        super(ali, null, bhv1);
    }

    public final void a(Object obj, Object obj1)
    {
        obj1 = (List)obj1;
        if (a != null)
        {
            obj = a;
            Object obj2 = b;
            obj2 = new ArrayList();
            for (obj1 = ((List) (obj1)).iterator(); ((Iterator) (obj1)).hasNext(); ((List) (obj2)).add(new alq((cgc)((Iterator) (obj1)).next()))) { }
            ((bhv) (obj)).a(null, obj2);
        }
    }
}
