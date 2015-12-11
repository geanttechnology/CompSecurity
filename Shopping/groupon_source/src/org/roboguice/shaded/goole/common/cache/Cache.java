// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.cache;


public interface Cache
{

    public abstract void cleanUp();

    public abstract Object getIfPresent(Object obj);

    public abstract void put(Object obj, Object obj1);
}
