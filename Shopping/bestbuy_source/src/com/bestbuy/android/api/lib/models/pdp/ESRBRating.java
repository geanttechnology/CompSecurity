// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import gu;
import java.io.Serializable;

public class ESRBRating
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String descriptors;
    private String rating;

    public ESRBRating()
    {
    }

    public String getDescriptors()
    {
        return descriptors;
    }

    public String getRating()
    {
        return rating;
    }

    public void setDescriptors(String s)
    {
        descriptors = s;
    }

    public void setRating(String s)
    {
        rating = s;
    }
}
