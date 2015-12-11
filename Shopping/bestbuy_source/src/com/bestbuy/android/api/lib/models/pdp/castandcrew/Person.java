// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.castandcrew;

import gu;
import java.io.Serializable;

public class Person
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String displayName;
    private String role;

    public Person()
    {
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public String getRole()
    {
        return role;
    }

    public void setDisplayName(String s)
    {
        displayName = s;
    }

    public void setRole(String s)
    {
        role = s;
    }
}
