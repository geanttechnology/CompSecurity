// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.tagmanager;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

abstract class FunctionCallImplementation
{

    private static final String FUNCTION_KEY = "function";
    private final String mFunctionId;
    private final Set mRequiredKeys;

    public transient FunctionCallImplementation(String s, String as[])
    {
        mFunctionId = s;
        mRequiredKeys = new HashSet(as.length);
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            s = as[i];
            mRequiredKeys.add(s);
        }

    }

    public static String getFunctionKey()
    {
        return "function";
    }

    public abstract com.google.analytics.midtier.proto.containertag.TypeSystem.Value evaluate(Map map);

    public String getInstanceFunctionId()
    {
        return mFunctionId;
    }

    public Set getRequiredKeys()
    {
        return mRequiredKeys;
    }

    boolean hasRequiredKeys(Set set)
    {
        return set.containsAll(mRequiredKeys);
    }

    public abstract boolean isCacheable();
}
