// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search;

import com.ebay.nautilus.domain.net.CosVersionType;
import com.ebay.nautilus.domain.net.EbayCosRequest;

public abstract class SearchServiceRequest extends EbayCosRequest
{

    public static final String OPERATION_NAME = "search";

    SearchServiceRequest(String s, String s1)
    {
        super(s, s1);
    }

    SearchServiceRequest(String s, String s1, CosVersionType cosversiontype)
    {
        super(s, s1, cosversiontype);
    }

    public abstract int getPageNumber();
}
