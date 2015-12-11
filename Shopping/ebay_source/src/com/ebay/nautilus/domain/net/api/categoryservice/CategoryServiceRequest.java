// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.categoryservice;

import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbaySoaRequest;
import java.net.URL;

public abstract class CategoryServiceRequest extends EbaySoaRequest
{

    public static final String SERVICE_NAME = "CategoryService";

    protected CategoryServiceRequest(String s, String s1, EbaySite ebaysite)
    {
        super("CategoryService", true, s);
        if (ebaysite == null)
        {
            throw new IllegalArgumentException("EbaySite must be non-null");
        } else
        {
            useSoaLocaleList = true;
            dataFormat = "JSON";
            responseDataFormat = "JSON";
            soaContentType = "application/json";
            iafToken = s1;
            soaGlobalId = ebaysite.idString;
            return;
        }
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.categoryService);
    }
}
