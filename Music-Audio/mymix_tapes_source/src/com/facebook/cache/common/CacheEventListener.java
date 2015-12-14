// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.cache.common;


public interface CacheEventListener
{
    public static final class EvictionReason extends Enum
    {

        private static final EvictionReason $VALUES[];
        public static final EvictionReason CACHE_FULL;
        public static final EvictionReason CACHE_MANAGER_TRIMMED;
        public static final EvictionReason CONTENT_STALE;
        public static final EvictionReason USER_FORCED;

        public static EvictionReason valueOf(String s)
        {
            return (EvictionReason)Enum.valueOf(com/facebook/cache/common/CacheEventListener$EvictionReason, s);
        }

        public static EvictionReason[] values()
        {
            return (EvictionReason[])$VALUES.clone();
        }

        static 
        {
            CACHE_FULL = new EvictionReason("CACHE_FULL", 0);
            CONTENT_STALE = new EvictionReason("CONTENT_STALE", 1);
            USER_FORCED = new EvictionReason("USER_FORCED", 2);
            CACHE_MANAGER_TRIMMED = new EvictionReason("CACHE_MANAGER_TRIMMED", 3);
            $VALUES = (new EvictionReason[] {
                CACHE_FULL, CONTENT_STALE, USER_FORCED, CACHE_MANAGER_TRIMMED
            });
        }

        private EvictionReason(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void onEviction(EvictionReason evictionreason, int i, long l);

    public abstract void onHit();

    public abstract void onMiss();

    public abstract void onReadException();

    public abstract void onWriteAttempt();

    public abstract void onWriteException();
}
