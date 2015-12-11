// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.service;

import java.util.concurrent.TimeUnit;

public interface n
{

    public static final long APP_CONFIG_UPDATE_FLEX_IN_SECONDS = 900L;
    public static final long APP_CONFIG_UPDATE_INTERVAL_SECONDS = 0x15180L;
    public static final String INVALIDATE_ADVERTISING_ID_CACHE = "INVALIDATE_ADVERTISING_ID_CACHE";
    public static final long INVALIDATE_ADVERTISING_ID_CACHE_UPDATE_FLEX_IN_SECONDS = TimeUnit.HOURS.toSeconds(4L);
    public static final long INVALIDATE_ADVERTISING_ID_CACHE_UPDATE_INTERVAL_SECONDS = TimeUnit.DAYS.toSeconds(1L);
    public static final String POPULATE_EMPTY_ADVERTISING_ID_CACHE = "POPULATE_EMPTY_ADVERTISING_ID_CACHE";
    public static final long POPULATE_EMPTY_ADVERTISING_ID_CACHE_MAX_DELAY = TimeUnit.MINUTES.toSeconds(5L);
    public static final String UPDATE_APP_CONFIG = "update_app_config";

}
