// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.multiqueueuploader;


class UploadResult
{
    static final class Status extends Enum
    {

        private static final Status $VALUES[];
        public static final Status FAILED;
        public static final Status SUCCESSFUL;

        public static Status valueOf(String s)
        {
            return (Status)Enum.valueOf(com/amazon/gallery/framework/network/multiqueueuploader/UploadResult$Status, s);
        }

        public static Status[] values()
        {
            return (Status[])$VALUES.clone();
        }

        static 
        {
            SUCCESSFUL = new Status("SUCCESSFUL", 0);
            FAILED = new Status("FAILED", 1);
            $VALUES = (new Status[] {
                SUCCESSFUL, FAILED
            });
        }

        private Status(String s, int i)
        {
            super(s, i);
        }
    }


    final Exception reason;
    final Status status;

    UploadResult(Status status1, Exception exception)
    {
        status = status1;
        reason = exception;
    }
}
