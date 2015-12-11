// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.api.services.now.model;

import com.google.api.a.e.b;
import com.google.api.a.g.l;
import java.util.List;

public final class Address extends b
{

    private List addressLines;
    private String name;
    private String phoneNumber;

    public Address()
    {
    }

    public final volatile b clone()
    {
        return clone();
    }

    public final volatile l clone()
    {
        return clone();
    }

    public final Address clone()
    {
        return (Address)super.clone();
    }

    public final volatile Object clone()
    {
        return clone();
    }

    public final List getAddressLines()
    {
        return addressLines;
    }

    public final String getName()
    {
        return name;
    }

    public final String getPhoneNumber()
    {
        return phoneNumber;
    }

    public final volatile b set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final volatile l set(String s, Object obj)
    {
        return set(s, obj);
    }

    public final Address set(String s, Object obj)
    {
        return (Address)super.set(s, obj);
    }

    public final Address setAddressLines(List list)
    {
        addressLines = list;
        return this;
    }

    public final Address setName(String s)
    {
        name = s;
        return this;
    }

    public final Address setPhoneNumber(String s)
    {
        phoneNumber = s;
        return this;
    }
}
