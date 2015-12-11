// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class cxk
    implements bhv
{

    private final bhv a;

    public cxk(bhv bhv1)
    {
        a = (bhv)b.a(bhv1);
    }

    public final void a(Object obj, Exception exception)
    {
        obj = (String)obj;
        a.a(obj, exception);
    }

    public final void a(Object obj, Object obj1)
    {
        obj = (String)obj;
        obj1 = (List)obj1;
        ArrayList arraylist = new ArrayList();
        int j = ((List) (obj1)).size();
        for (int i = 0; i < j; i++)
        {
            cxu cxu1 = (cxu)((List) (obj1)).get(i);
            arraylist.add(cxu.a(cxu1.a, cxu1.b, cxu1.c, ((String) (obj)), cxu1.e, cxu1.g));
        }

        a.a(obj, arraylist);
    }
}
