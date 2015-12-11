// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


public class Offer
{

    private String description;
    private String id;
    private String type;

    public Offer()
    {
    }

    public void copy(Offer offer)
    {
        id = offer.id;
        type = offer.type;
        description = offer.description;
    }

    public String getDescription()
    {
        return description;
    }

    public String getId()
    {
        return id;
    }

    public String getType()
    {
        return type;
    }
}
