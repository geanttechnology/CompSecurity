// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.dto;


public class Store
{

    private String email;
    private int id;

    public Store()
    {
    }

    public String getEmail()
    {
        return email;
    }

    public int getId()
    {
        return id;
    }

    public void setEmail(String s)
    {
        email = s;
    }

    public void setId(int i)
    {
        id = i;
    }

    public String toString()
    {
        return (new StringBuilder("Store [email=")).append(email).append(", id=").append(id).append("]").toString();
    }
}
