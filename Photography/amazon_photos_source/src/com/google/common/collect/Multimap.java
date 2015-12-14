// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.collect;

import java.util.Collection;
import java.util.Map;

public interface Multimap
{

    public abstract Map asMap();

    public abstract boolean containsKey(Object obj);

    public abstract Collection get(Object obj);

    public abstract boolean put(Object obj, Object obj1);
}
