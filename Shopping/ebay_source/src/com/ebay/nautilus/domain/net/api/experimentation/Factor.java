// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.experimentation;

import com.ebay.nautilus.domain.data.SerializablePair;

public class Factor extends SerializablePair
{

    public static final Factor EXPLICIT_DEFAULT = new Factor("IS_DEFAULT", "true");
    public String id;

    public Factor()
    {
    }

    public Factor(Factor factor)
    {
        this((String)factor.key, (String)factor.value, factor.id);
    }

    public Factor(String s, String s1)
    {
        this(s, s1, "");
    }

    public Factor(String s, String s1, String s2)
    {
        super(s, s1);
        id = s2;
    }

}
