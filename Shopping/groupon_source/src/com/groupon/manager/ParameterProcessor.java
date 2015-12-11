// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.util.HttpUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public abstract class ParameterProcessor
{

    private List nameValues;
    private String partialUrl;

    public ParameterProcessor(String s, List list)
    {
        partialUrl = s;
        nameValues = list;
    }

    protected abstract Set getExcludedClientParameters();

    protected abstract Set getExcludedServerParameters();

    public List process()
    {
        HashMap hashmap = HttpUtil.extractParams(partialUrl);
        HttpUtil.filter(hashmap, new com.groupon.util.HttpUtil.ParamFilter[] {
            new com.groupon.util.HttpUtil.ExcludeParamFilter(getExcludedServerParameters()), new com.groupon.util.HttpUtil.PrefixParamFilter("x_client_consumed")
        });
        HashMap hashmap1 = HttpUtil.arrayToHash(nameValues);
        HttpUtil.filter(hashmap1, new com.groupon.util.HttpUtil.ParamFilter[] {
            new com.groupon.util.HttpUtil.ExcludeParamFilter(getExcludedClientParameters())
        });
        hashmap1.putAll(hashmap);
        return HttpUtil.hashToArray(hashmap1);
    }
}
