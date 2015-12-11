// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.k.a;

import com.google.a.a.e;
import com.target.mothership.common.params.RegistrySearchParam;
import com.target.mothership.common.registries.d;
import com.target.mothership.common.registries.f;
import com.target.mothership.common.registries.h;
import com.target.mothership.services.f.a.b;
import com.target.mothership.services.f.a.c;
import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class a extends b
{

    private static final String ALTERNATIVE_LIST_ID = "alt_list_id";
    private static final com.target.mothership.services.f.a.b.a CHANNEL = new com.target.mothership.services.f.a.b.a("channel");
    private static final String CLOSE_BRACKET = ")";
    private static final String EMAIL_ID = "email_id";
    private static final String END_DATE = "end_date";
    private static final String EVENT_CITY = "event_city";
    private static final String EVENT_STATE = "event_state";
    private static final com.target.mothership.services.f.a.b.a EVENT_TYPE = new com.target.mothership.services.f.a.b.a("event_type");
    private static final String FIRST_NAME = "first_name";
    private static final String LAST_NAME = "last_name";
    private static final String LIMIT = "limit";
    private static final String OFFSET = "offset";
    private static final String OPEN_BRACKET = "(";
    private static final String ORGANIZATION = "organization";
    private static final String PHONE_NUMBER = "phone_number";
    private static final String PROFILE_ID = "profile_id";
    private static c REGISTRY_DETAIL;
    private static final com.target.mothership.services.f.a.b.a REGISTRY_ID = new com.target.mothership.services.f.a.b.a("registry_id");
    private static c REGISTRY_SEARCH;
    private static final String ROLE = "role";
    private static final com.target.mothership.services.f.a.b.a SEARCH_QUERY = new com.target.mothership.services.f.a.b.a("q");
    private static final String SEPARATOR = "+";
    private static final String SORT = "sort";
    private static final String START_DATE = "start_date";
    private static final com.target.mothership.services.f.a.b.a STORE_ID = new com.target.mothership.services.f.a.b.a("store_id");
    private static final com.target.mothership.services.f.a.b.a SUB_CHANNEL = new com.target.mothership.services.f.a.b.a("sub_channel");

    public a(com.target.mothership.services.f.b.a a1)
    {
        super(a1);
    }

    private String a(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(s);
        stringbuilder.append("=");
        stringbuilder.append(s1);
        return stringbuilder.toString();
    }

    private void a(List list, RegistrySearchParam registrysearchparam)
    {
        list.add(a("first_name", registrysearchparam.a().toString()));
        list.add(a("last_name", registrysearchparam.b().toString()));
    }

    private String b(RegistrySearchParam registrysearchparam)
    {
        return o.a(c(registrysearchparam), "+");
    }

    private void b(List list, RegistrySearchParam registrysearchparam)
    {
        if (registrysearchparam.o().b())
        {
            list.add(a("limit", ((Integer)registrysearchparam.o().c()).toString()));
        }
        if (registrysearchparam.p().b())
        {
            list.add(a("offset", ((Integer)registrysearchparam.p().c()).toString()));
        }
    }

    private List c(RegistrySearchParam registrysearchparam)
    {
        ArrayList arraylist = new ArrayList();
        a(arraylist, registrysearchparam);
        b(arraylist, registrysearchparam);
        c(((List) (arraylist)), registrysearchparam);
        d(arraylist, registrysearchparam);
        e(arraylist, registrysearchparam);
        f(arraylist, registrysearchparam);
        g(arraylist, registrysearchparam);
        h(arraylist, registrysearchparam);
        i(arraylist, registrysearchparam);
        j(arraylist, registrysearchparam);
        k(arraylist, registrysearchparam);
        l(arraylist, registrysearchparam);
        return arraylist;
    }

    private void c(List list, RegistrySearchParam registrysearchparam)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(a("sort", registrysearchparam.h().toString()));
        stringbuilder.append("(");
        stringbuilder.append(registrysearchparam.i().toString());
        stringbuilder.append(")");
        list.add(stringbuilder.toString());
    }

    private void d(List list, RegistrySearchParam registrysearchparam)
    {
        if (!registrysearchparam.f().equals(d.UNKNOWN))
        {
            list.add(a("role", registrysearchparam.f().toString()));
        }
    }

    private void e(List list, RegistrySearchParam registrysearchparam)
    {
        if (registrysearchparam.q().b() && registrysearchparam.r().b())
        {
            list.add(a("start_date", ((Date)registrysearchparam.q().c()).toString()));
            list.add(a("end_date", ((Date)registrysearchparam.r().c()).toString()));
        }
    }

    private void f(List list, RegistrySearchParam registrysearchparam)
    {
        if (registrysearchparam.j().b())
        {
            list.add(a("email_id", ((String)registrysearchparam.j().c()).toString()));
        }
    }

    private void g(List list, RegistrySearchParam registrysearchparam)
    {
        if (registrysearchparam.k().b())
        {
            list.add(a("event_state", ((String)registrysearchparam.k().c()).toString()));
        }
    }

    private void h(List list, RegistrySearchParam registrysearchparam)
    {
        if (registrysearchparam.l().b())
        {
            list.add(a("event_city", ((String)registrysearchparam.l().c()).toString()));
        }
    }

    private void i(List list, RegistrySearchParam registrysearchparam)
    {
        if (registrysearchparam.m().b())
        {
            list.add(a("organization", registrysearchparam.m().toString()));
        }
    }

    private void j(List list, RegistrySearchParam registrysearchparam)
    {
        if (registrysearchparam.n().b())
        {
            list.add(a("phone_number", ((String)registrysearchparam.n().c()).toString()));
        }
    }

    private void k(List list, RegistrySearchParam registrysearchparam)
    {
        if (registrysearchparam.s().b())
        {
            list.add(a("profile_id", ((String)registrysearchparam.s().c()).toString()));
        }
    }

    private void l(List list, RegistrySearchParam registrysearchparam)
    {
        if (registrysearchparam.t().b())
        {
            list.add(a("alt_list_id", ((String)registrysearchparam.t().c()).toString()));
        }
    }

    public com.target.mothership.services.f.a.b.b a(RegistrySearchParam registrysearchparam)
    {
        c c1 = REGISTRY_SEARCH;
        android.support.v4.f.a a2 = new android.support.v4.f.a();
        a2.put(STORE_ID.a(), registrysearchparam.c());
        a2.put(CHANNEL.a(), registrysearchparam.d().toString());
        a2.put(SUB_CHANNEL.a(), registrysearchparam.e().toString());
        a2.put(EVENT_TYPE.a(), registrysearchparam.g().toString());
        android.support.v4.f.a a1 = new android.support.v4.f.a();
        a1.put(SEARCH_QUERY.a(), b(registrysearchparam));
        registrysearchparam = a(c1, null, null, ((Map) (a2)), null);
        registrysearchparam.a(a1);
        return registrysearchparam;
    }

    static 
    {
        REGISTRY_SEARCH = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.ApigeePciSecure, "/registries/v1/search");
        REGISTRY_DETAIL = new c(com.target.mothership.services.f.a.d.a.GET, com.target.mothership.services.f.b.a.TGTAppData, "/v1/registry/view/{registry_id}");
    }
}
