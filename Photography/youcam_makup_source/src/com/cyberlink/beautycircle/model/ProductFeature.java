// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model;

import com.perfectcorp.model.Model;
import java.util.Date;

public class ProductFeature extends Model
{

    public Long id;
    public String imgOriginal;
    public String imgUrl;
    public Date lastModified;
    public String locale;
    public Metadata metadata;
    public String productDescription;
    public String productTitle;
    public String productType;

    public ProductFeature()
    {
    }

    public Long b_()
    {
        return id;
    }
}
