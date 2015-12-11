// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.data.model;

import java.io.File;
import java.util.Collection;

public class Product
{

    public static final String COLUMN_NAME_COMPOSER = "composer";
    public static final String COLUMN_NAME_DISPLAY_NAME = "display_name";
    public static final String COLUMN_NAME_ETAG = "etag";
    public static final String COLUMN_NAME_GENRE = "genre";
    public static final String COLUMN_NAME_ID = "_id";
    public static final String COLUMN_NAME_UID = "uid";
    public static final String PRODUCT_PAGE_URL = "product_page_url";
    public int _id;
    public String composer;
    public String displayName;
    public String eTag;
    public String genre;
    public String mNewEtag;
    public File midiFile;
    public Collection parentPack;
    public String product_page_url;
    public Collection resources;
    public String uid;

    public Product()
    {
    }

    public void copyLocal(Product product)
    {
        eTag = product.eTag;
        _id = product._id;
    }

    public volatile void copyLocal(Object obj)
    {
        copyLocal((Product)obj);
    }

    public String equatableId()
    {
        return uid;
    }

    public boolean hasProgress()
    {
        return false;
    }

    public boolean needsResourceUpdate()
    {
        if (mNewEtag != null)
        {
            if (eTag == null)
            {
                return true;
            }
            if (mNewEtag.compareTo(eTag) != 0)
            {
                return true;
            }
        }
        return false;
    }

    public boolean shouldBeDeleted()
    {
        return true;
    }

    public void update(Product product)
    {
        composer = product.composer;
        displayName = product.displayName;
        genre = product.genre;
        uid = product.uid;
        product_page_url = product.product_page_url;
        resources = product.resources;
    }
}
