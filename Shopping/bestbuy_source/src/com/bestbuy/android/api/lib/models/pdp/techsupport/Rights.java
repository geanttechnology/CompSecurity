// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.techsupport;

import gu;
import java.io.Serializable;
import java.util.List;

public class Rights
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private List purchase;

    public Rights()
    {
    }

    public List getPurchase()
    {
        return purchase;
    }

    public void setPurchase(List list)
    {
        purchase = list;
    }
}
