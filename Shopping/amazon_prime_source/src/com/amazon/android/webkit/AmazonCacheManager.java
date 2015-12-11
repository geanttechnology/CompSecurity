// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;

import android.content.Context;

public abstract class AmazonCacheManager
{
    public static final class AppCacheStatus extends Enum
    {

        private static final AppCacheStatus $VALUES[];
        public static final AppCacheStatus CACHED;
        public static final AppCacheStatus NO_UPDATE;
        public static final AppCacheStatus UNKNOWN;
        public static final AppCacheStatus UPDATED;

        public static AppCacheStatus valueOf(String s)
        {
            return (AppCacheStatus)Enum.valueOf(com/amazon/android/webkit/AmazonCacheManager$AppCacheStatus, s);
        }

        public static AppCacheStatus[] values()
        {
            return (AppCacheStatus[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new AppCacheStatus("UNKNOWN", 0);
            NO_UPDATE = new AppCacheStatus("NO_UPDATE", 1);
            CACHED = new AppCacheStatus("CACHED", 2);
            UPDATED = new AppCacheStatus("UPDATED", 3);
            $VALUES = (new AppCacheStatus[] {
                UNKNOWN, NO_UPDATE, CACHED, UPDATED
            });
        }

        private AppCacheStatus(String s, int i)
        {
            super(s, i);
        }
    }

    public static interface UpdateAppCacheCallback
    {

        public abstract void onCompleted(AppCacheStatus appcachestatus, String as[], long l);

        public abstract void onError(String s);

        public abstract void onProgress(String s, int i, int j);
    }


    public AmazonCacheManager()
    {
    }

    public abstract void clearCache(Context context, boolean flag);

    public abstract void setCacheMaxSize(long l);

    public abstract void setCacheThreshold(long l);

    public abstract void setWebCoreCache(int i);

    public abstract void updateAppCache(String s, String s1, UpdateAppCacheCallback updateappcachecallback);
}
