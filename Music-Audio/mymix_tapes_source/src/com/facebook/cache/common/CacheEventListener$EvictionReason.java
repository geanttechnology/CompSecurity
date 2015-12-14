// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.common;


// Referenced classes of package com.facebook.cache.common:
//            CacheEventListener

public static final class A extends Enum
{

    private static final CACHE_MANAGER_TRIMMED $VALUES[];
    public static final CACHE_MANAGER_TRIMMED CACHE_FULL;
    public static final CACHE_MANAGER_TRIMMED CACHE_MANAGER_TRIMMED;
    public static final CACHE_MANAGER_TRIMMED CONTENT_STALE;
    public static final CACHE_MANAGER_TRIMMED USER_FORCED;

    public static A valueOf(String s)
    {
        return (A)Enum.valueOf(com/facebook/cache/common/CacheEventListener$EvictionReason, s);
    }

    public static A[] values()
    {
        return (A[])$VALUES.clone();
    }

    static 
    {
        CACHE_FULL = new <init>("CACHE_FULL", 0);
        CONTENT_STALE = new <init>("CONTENT_STALE", 1);
        USER_FORCED = new <init>("USER_FORCED", 2);
        CACHE_MANAGER_TRIMMED = new <init>("CACHE_MANAGER_TRIMMED", 3);
        $VALUES = (new .VALUES[] {
            CACHE_FULL, CONTENT_STALE, USER_FORCED, CACHE_MANAGER_TRIMMED
        });
    }

    private A(String s, int i)
    {
        super(s, i);
    }
}
