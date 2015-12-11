// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.thin.downloadmanager;


// Referenced classes of package com.thin.downloadmanager:
//            DownloadRequest

public interface DownloadManager
{

    public static final int ERROR_DOWNLOAD_CANCELLED = 1008;
    public static final int ERROR_DOWNLOAD_SIZE_UNKNOWN = 1006;
    public static final int ERROR_FILE_ERROR = 1001;
    public static final int ERROR_HTTP_DATA_ERROR = 1004;
    public static final int ERROR_MALFORMED_URI = 1007;
    public static final int ERROR_TOO_MANY_REDIRECTS = 1005;
    public static final int ERROR_UNHANDLED_HTTP_CODE = 1002;
    public static final int STATUS_FAILED = 16;
    public static final int STATUS_NOT_FOUND = 32;
    public static final int STATUS_PENDING = 1;
    public static final int STATUS_RUNNING = 4;
    public static final int STATUS_STARTED = 2;
    public static final int STATUS_SUCCESSFUL = 8;

    public abstract int add(DownloadRequest downloadrequest);

    public abstract int cancel(int i);

    public abstract void cancelAll();

    public abstract int query(int i);

    public abstract void release();
}
