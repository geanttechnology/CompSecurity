// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.tags.http;

import com.comcast.cim.cmasl.http.request.DefaultCacheableRequestProvider;
import com.comcast.cim.cmasl.http.request.RequestProvider;

public class TagsRequestProvider extends DefaultCacheableRequestProvider
{

    public TagsRequestProvider(RequestProvider requestprovider, String s)
    {
        super(requestprovider, s);
        addHeader("Accept", "application/json");
    }
}
