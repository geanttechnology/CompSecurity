// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpmovies;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class MovieDetails
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList specifications;

    public MovieDetails()
    {
    }

    public ArrayList getSpecifications()
    {
        return specifications;
    }

    public void setSpecifications(ArrayList arraylist)
    {
        specifications = arraylist;
    }
}
