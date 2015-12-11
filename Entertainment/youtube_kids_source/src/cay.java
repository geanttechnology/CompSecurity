// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

public final class cay
    implements crb
{

    private final crb a;

    public cay(crb crb1)
    {
        a = (crb)b.a(crb1);
    }

    public final void a(Object obj, bhv bhv1)
    {
        obj = (List)obj;
        ArrayList arraylist = new ArrayList();
        a(((List) (obj)), ((List) (arraylist)), ((bhv) (new caz(this, ((List) (obj)), arraylist, bhv1))), bhv1);
    }

    void a(List list, List list1, bhv bhv1, bhv bhv2)
    {
        int i = list1.size();
        int j = Math.min(i + 50, list.size());
        if (i < j)
        {
            list = new ArrayList(list.subList(i, j));
            a.a(list, bhv1);
            return;
        } else
        {
            bhv2.a(list, list1);
            return;
        }
    }
}
