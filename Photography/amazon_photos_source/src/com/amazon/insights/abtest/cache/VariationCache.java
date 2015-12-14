// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.abtest.cache;

import com.amazon.insights.abtest.DefaultVariation;
import java.util.Map;
import java.util.Set;

public interface VariationCache
{

    public abstract Map get(Set set);

    public abstract Map getAll();

    public abstract boolean put(DefaultVariation defaultvariation);
}
