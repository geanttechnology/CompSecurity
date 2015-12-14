// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk;


public interface AdListener
{

    public static final int REASON_APP_STOPPED = 5;
    public static final int REASON_COMPLETED = 1;
    public static final int REASON_MORE_INFO = 4;
    public static final int REASON_SYSTEM_INTERRUPTED = 3;
    public static final int REASON_USER_CANCELLED = 2;
    public static final int STATUS_DOWNLOAD_FAILED = -2;
    public static final int STATUS_NO_AD_AVAILABLE = -3;
    public static final int STATUS_UNKNOWN_ERROR = -1;

    public abstract void onAdAvailable();

    public abstract void onAdRefreshing();

    public abstract void onError(int i, Exception exception);

    public abstract void onPlaybackStarting();

    public abstract void onPlaybackStopped(int i);
}
