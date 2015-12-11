// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.List;

final class aae extends bmr
{

    private aaa a;

    aae(aaa aaa1)
    {
        a = aaa1;
        super();
    }

    public final Object a()
    {
        bgg bgg1 = new bgg(((bdc)a.C.b_()).a);
        ArrayList arraylist = new ArrayList();
        arraylist.add(a.A());
        arraylist.add(bgg1);
        return new bxm(arraylist);
    }
}
