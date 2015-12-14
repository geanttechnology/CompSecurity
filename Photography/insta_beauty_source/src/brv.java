// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

public class brv
{

    bsf a;

    public brv()
    {
        a = new bsf();
    }

    public String a(String s, List list, brz brz1)
    {
        list.addAll(brz1.c());
        list = (new bse()).a(s, "GET", brz1.d(), brz1.f(), list);
        return a.a(s, list);
    }

    public String a(String s, List list, List list1, brz brz1)
    {
        list.addAll(brz1.c());
        list = (new bse()).a(s, "POST", brz1.d(), brz1.f(), list);
        return a.a(s, list, list1);
    }

    public String b(String s, List list, List list1, brz brz1)
    {
        list.addAll(brz1.c());
        list = (new bse()).a(s, "POST", brz1.d(), brz1.f(), list);
        return a.b(s, list, list1);
    }
}
