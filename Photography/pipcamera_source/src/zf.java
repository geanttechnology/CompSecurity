// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.List;

public class zf
{

    zo a;

    public zf()
    {
        a = new zo();
    }

    public String a(String s, List list, List list1, zj zj1)
    {
        list.addAll(zj1.c());
        list = (new zn()).a(s, "POST", zj1.d(), zj1.f(), list);
        return a.a(s, list, list1);
    }

    public String a(String s, List list, zj zj1)
    {
        list.addAll(zj1.c());
        list = (new zn()).a(s, "GET", zj1.d(), zj1.f(), list);
        return a.a(s, list);
    }

    public String b(String s, List list, List list1, zj zj1)
    {
        list.addAll(zj1.c());
        list = (new zn()).a(s, "POST", zj1.d(), zj1.f(), list);
        return a.b(s, list, list1);
    }
}
