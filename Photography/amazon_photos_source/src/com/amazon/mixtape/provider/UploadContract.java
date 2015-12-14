// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.provider;

import android.net.Uri;

public class UploadContract
{
    public static class LogEntry
    {

        public static String ERROR = "error";
        public static String EVENT = "event";
        public static String MESSAGE = "message";
        public static String TIME = "time";
        public static String UPLOAD_REQUEST = "upload_request";

        public static Uri getContentUri(String s, String s1)
        {
            return Uri.parse((new StringBuilder()).append("content://").append(s).append("/").append(s1).append("/").append("upload_log").toString());
        }

    }

    public static class Request
    {

        public static Uri getContentUri(String s, String s1)
        {
            return Uri.parse((new StringBuilder()).append("content://").append(s).append("/").append(s1).append("/").append("upload_requests").toString());
        }
    }

    public static class RequestBlocker
    {

        public static Uri getContentUri(String s, String s1)
        {
            return Uri.parse((new StringBuilder()).append("content://").append(s).append("/").append(s1).append("/").append("upload_request_blockers").toString());
        }
    }

}
