// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit;


public final class PrerenderStatus extends Enum
{

    private static final PrerenderStatus $VALUES[];
    public static final PrerenderStatus FINAL_STATUS_APP_TERMINATING;
    public static final PrerenderStatus FINAL_STATUS_AUTH_NEEDED;
    public static final PrerenderStatus FINAL_STATUS_CACHE_OR_HISTORY_CLEARED;
    public static final PrerenderStatus FINAL_STATUS_CANCELLED;
    public static final PrerenderStatus FINAL_STATUS_CONTROL_GROUP;
    public static final PrerenderStatus FINAL_STATUS_CREATE_NEW_WINDOW;
    public static final PrerenderStatus FINAL_STATUS_CROSS_SITE_NAVIGATION_PENDING;
    public static final PrerenderStatus FINAL_STATUS_DEVTOOLS_ATTACHED;
    public static final PrerenderStatus FINAL_STATUS_DOWNLOAD;
    public static final PrerenderStatus FINAL_STATUS_EVICTED;
    public static final PrerenderStatus FINAL_STATUS_FRAGMENT_MISMATCH;
    public static final PrerenderStatus FINAL_STATUS_HTML5_MEDIA;
    public static final PrerenderStatus FINAL_STATUS_HTTPS;
    public static final PrerenderStatus FINAL_STATUS_INVALID_HTTP_METHOD;
    public static final PrerenderStatus FINAL_STATUS_JAVASCRIPT_ALERT;
    public static final PrerenderStatus FINAL_STATUS_JS_OUT_OF_MEMORY;
    public static final PrerenderStatus FINAL_STATUS_MANAGER_SHUTDOWN;
    public static final PrerenderStatus FINAL_STATUS_MEMORY_LIMIT_EXCEEDED;
    public static final PrerenderStatus FINAL_STATUS_OPEN_URL;
    public static final PrerenderStatus FINAL_STATUS_PAGE_ID_CONFLICT;
    public static final PrerenderStatus FINAL_STATUS_PROFILE_DESTROYED;
    public static final PrerenderStatus FINAL_STATUS_RATE_LIMIT_EXCEEDED;
    public static final PrerenderStatus FINAL_STATUS_RECENTLY_VISITED;
    public static final PrerenderStatus FINAL_STATUS_RENDERER_CRASHED;
    public static final PrerenderStatus FINAL_STATUS_SAFE_BROWSING;
    public static final PrerenderStatus FINAL_STATUS_SOURCE_RENDER_VIEW_CLOSED;
    public static final PrerenderStatus FINAL_STATUS_SSL_CLIENT_CERTIFICATE_REQUESTED;
    public static final PrerenderStatus FINAL_STATUS_SSL_ERROR;
    public static final PrerenderStatus FINAL_STATUS_TIMED_OUT;
    public static final PrerenderStatus FINAL_STATUS_TOO_MANY_PROCESSES;
    public static final PrerenderStatus FINAL_STATUS_UNKNOWN;
    public static final PrerenderStatus FINAL_STATUS_UNSUPPORTED_SCHEME;
    public static final PrerenderStatus FINAL_STATUS_USED;
    public static final PrerenderStatus FINAL_STATUS_WINDOW_OPENER;
    public static final PrerenderStatus FINAL_STATUS_WINDOW_PRINT;
    private final int status;

    private PrerenderStatus(String s, int i, int j)
    {
        super(s, i);
        status = j;
    }

    public static PrerenderStatus fromStatusCode(int i)
    {
        PrerenderStatus aprerenderstatus[] = values();
        int k = aprerenderstatus.length;
        for (int j = 0; j < k; j++)
        {
            PrerenderStatus prerenderstatus = aprerenderstatus[j];
            if (prerenderstatus.getStatusCode() == i)
            {
                return prerenderstatus;
            }
        }

        return FINAL_STATUS_UNKNOWN;
    }

    public static PrerenderStatus valueOf(String s)
    {
        return (PrerenderStatus)Enum.valueOf(com/amazon/android/webkit/PrerenderStatus, s);
    }

    public static PrerenderStatus[] values()
    {
        return (PrerenderStatus[])$VALUES.clone();
    }

    public int getStatusCode()
    {
        return status;
    }

    static 
    {
        FINAL_STATUS_UNKNOWN = new PrerenderStatus("FINAL_STATUS_UNKNOWN", 0, -1);
        FINAL_STATUS_USED = new PrerenderStatus("FINAL_STATUS_USED", 1, 0);
        FINAL_STATUS_TIMED_OUT = new PrerenderStatus("FINAL_STATUS_TIMED_OUT", 2, 1);
        FINAL_STATUS_EVICTED = new PrerenderStatus("FINAL_STATUS_EVICTED", 3, 2);
        FINAL_STATUS_MANAGER_SHUTDOWN = new PrerenderStatus("FINAL_STATUS_MANAGER_SHUTDOWN", 4, 3);
        FINAL_STATUS_CREATE_NEW_WINDOW = new PrerenderStatus("FINAL_STATUS_CREATE_NEW_WINDOW", 5, 5);
        FINAL_STATUS_PROFILE_DESTROYED = new PrerenderStatus("FINAL_STATUS_PROFILE_DESTROYED", 6, 6);
        FINAL_STATUS_APP_TERMINATING = new PrerenderStatus("FINAL_STATUS_APP_TERMINATING", 7, 7);
        FINAL_STATUS_JAVASCRIPT_ALERT = new PrerenderStatus("FINAL_STATUS_JAVASCRIPT_ALERT", 8, 8);
        FINAL_STATUS_AUTH_NEEDED = new PrerenderStatus("FINAL_STATUS_AUTH_NEEDED", 9, 9);
        FINAL_STATUS_HTTPS = new PrerenderStatus("FINAL_STATUS_HTTPS", 10, 10);
        FINAL_STATUS_DOWNLOAD = new PrerenderStatus("FINAL_STATUS_DOWNLOAD", 11, 11);
        FINAL_STATUS_MEMORY_LIMIT_EXCEEDED = new PrerenderStatus("FINAL_STATUS_MEMORY_LIMIT_EXCEEDED", 12, 12);
        FINAL_STATUS_JS_OUT_OF_MEMORY = new PrerenderStatus("FINAL_STATUS_JS_OUT_OF_MEMORY", 13, 13);
        FINAL_STATUS_TOO_MANY_PROCESSES = new PrerenderStatus("FINAL_STATUS_TOO_MANY_PROCESSES", 14, 15);
        FINAL_STATUS_RATE_LIMIT_EXCEEDED = new PrerenderStatus("FINAL_STATUS_RATE_LIMIT_EXCEEDED", 15, 16);
        FINAL_STATUS_CONTROL_GROUP = new PrerenderStatus("FINAL_STATUS_CONTROL_GROUP", 16, 18);
        FINAL_STATUS_HTML5_MEDIA = new PrerenderStatus("FINAL_STATUS_HTML5_MEDIA", 17, 19);
        FINAL_STATUS_SOURCE_RENDER_VIEW_CLOSED = new PrerenderStatus("FINAL_STATUS_SOURCE_RENDER_VIEW_CLOSED", 18, 20);
        FINAL_STATUS_RENDERER_CRASHED = new PrerenderStatus("FINAL_STATUS_RENDERER_CRASHED", 19, 21);
        FINAL_STATUS_UNSUPPORTED_SCHEME = new PrerenderStatus("FINAL_STATUS_UNSUPPORTED_SCHEME", 20, 22);
        FINAL_STATUS_INVALID_HTTP_METHOD = new PrerenderStatus("FINAL_STATUS_INVALID_HTTP_METHOD", 21, 23);
        FINAL_STATUS_WINDOW_PRINT = new PrerenderStatus("FINAL_STATUS_WINDOW_PRINT", 22, 24);
        FINAL_STATUS_RECENTLY_VISITED = new PrerenderStatus("FINAL_STATUS_RECENTLY_VISITED", 23, 25);
        FINAL_STATUS_WINDOW_OPENER = new PrerenderStatus("FINAL_STATUS_WINDOW_OPENER", 24, 26);
        FINAL_STATUS_PAGE_ID_CONFLICT = new PrerenderStatus("FINAL_STATUS_PAGE_ID_CONFLICT", 25, 27);
        FINAL_STATUS_SAFE_BROWSING = new PrerenderStatus("FINAL_STATUS_SAFE_BROWSING", 26, 28);
        FINAL_STATUS_FRAGMENT_MISMATCH = new PrerenderStatus("FINAL_STATUS_FRAGMENT_MISMATCH", 27, 29);
        FINAL_STATUS_SSL_CLIENT_CERTIFICATE_REQUESTED = new PrerenderStatus("FINAL_STATUS_SSL_CLIENT_CERTIFICATE_REQUESTED", 28, 30);
        FINAL_STATUS_CACHE_OR_HISTORY_CLEARED = new PrerenderStatus("FINAL_STATUS_CACHE_OR_HISTORY_CLEARED", 29, 31);
        FINAL_STATUS_CANCELLED = new PrerenderStatus("FINAL_STATUS_CANCELLED", 30, 32);
        FINAL_STATUS_SSL_ERROR = new PrerenderStatus("FINAL_STATUS_SSL_ERROR", 31, 33);
        FINAL_STATUS_CROSS_SITE_NAVIGATION_PENDING = new PrerenderStatus("FINAL_STATUS_CROSS_SITE_NAVIGATION_PENDING", 32, 34);
        FINAL_STATUS_DEVTOOLS_ATTACHED = new PrerenderStatus("FINAL_STATUS_DEVTOOLS_ATTACHED", 33, 35);
        FINAL_STATUS_OPEN_URL = new PrerenderStatus("FINAL_STATUS_OPEN_URL", 34, 40);
        $VALUES = (new PrerenderStatus[] {
            FINAL_STATUS_UNKNOWN, FINAL_STATUS_USED, FINAL_STATUS_TIMED_OUT, FINAL_STATUS_EVICTED, FINAL_STATUS_MANAGER_SHUTDOWN, FINAL_STATUS_CREATE_NEW_WINDOW, FINAL_STATUS_PROFILE_DESTROYED, FINAL_STATUS_APP_TERMINATING, FINAL_STATUS_JAVASCRIPT_ALERT, FINAL_STATUS_AUTH_NEEDED, 
            FINAL_STATUS_HTTPS, FINAL_STATUS_DOWNLOAD, FINAL_STATUS_MEMORY_LIMIT_EXCEEDED, FINAL_STATUS_JS_OUT_OF_MEMORY, FINAL_STATUS_TOO_MANY_PROCESSES, FINAL_STATUS_RATE_LIMIT_EXCEEDED, FINAL_STATUS_CONTROL_GROUP, FINAL_STATUS_HTML5_MEDIA, FINAL_STATUS_SOURCE_RENDER_VIEW_CLOSED, FINAL_STATUS_RENDERER_CRASHED, 
            FINAL_STATUS_UNSUPPORTED_SCHEME, FINAL_STATUS_INVALID_HTTP_METHOD, FINAL_STATUS_WINDOW_PRINT, FINAL_STATUS_RECENTLY_VISITED, FINAL_STATUS_WINDOW_OPENER, FINAL_STATUS_PAGE_ID_CONFLICT, FINAL_STATUS_SAFE_BROWSING, FINAL_STATUS_FRAGMENT_MISMATCH, FINAL_STATUS_SSL_CLIENT_CERTIFICATE_REQUESTED, FINAL_STATUS_CACHE_OR_HISTORY_CLEARED, 
            FINAL_STATUS_CANCELLED, FINAL_STATUS_SSL_ERROR, FINAL_STATUS_CROSS_SITE_NAVIGATION_PENDING, FINAL_STATUS_DEVTOOLS_ATTACHED, FINAL_STATUS_OPEN_URL
        });
    }
}
