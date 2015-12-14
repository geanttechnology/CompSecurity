// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;


public final class UploadErrorCode extends Enum
{

    private static final UploadErrorCode $VALUES[];
    public static final UploadErrorCode CLOUD_DRIVE_EXCEPTION;
    public static final UploadErrorCode CONFLICT_EXCEPTION;
    public static final UploadErrorCode FILE_NOT_FOUND_EXCEPTION;
    public static final UploadErrorCode FORBIDDEN;
    public static final UploadErrorCode FORBIDDEN_INSUFFICIENT_STORAGE;
    public static final UploadErrorCode FORBIDDEN_NO_ACTIVE_SUBSCRIPTION_FOUND;
    public static final UploadErrorCode INVALID_PARAMETER;
    public static final UploadErrorCode REBUILD_EXCEPTION;
    public static final UploadErrorCode UNKNOWN_EXCEPTION;
    private final int mCode;

    private UploadErrorCode(String s, int i, int j)
    {
        super(s, i);
        mCode = j;
    }

    public static UploadErrorCode valueOf(String s)
    {
        return (UploadErrorCode)Enum.valueOf(com/amazon/mixtape/upload/UploadErrorCode, s);
    }

    public static UploadErrorCode[] values()
    {
        return (UploadErrorCode[])$VALUES.clone();
    }

    public int toInt()
    {
        return mCode;
    }

    static 
    {
        FILE_NOT_FOUND_EXCEPTION = new UploadErrorCode("FILE_NOT_FOUND_EXCEPTION", 0, 1);
        CONFLICT_EXCEPTION = new UploadErrorCode("CONFLICT_EXCEPTION", 1, 2);
        REBUILD_EXCEPTION = new UploadErrorCode("REBUILD_EXCEPTION", 2, 3);
        CLOUD_DRIVE_EXCEPTION = new UploadErrorCode("CLOUD_DRIVE_EXCEPTION", 3, 4);
        FORBIDDEN = new UploadErrorCode("FORBIDDEN", 4, 5);
        FORBIDDEN_INSUFFICIENT_STORAGE = new UploadErrorCode("FORBIDDEN_INSUFFICIENT_STORAGE", 5, 6);
        UNKNOWN_EXCEPTION = new UploadErrorCode("UNKNOWN_EXCEPTION", 6, 7);
        INVALID_PARAMETER = new UploadErrorCode("INVALID_PARAMETER", 7, 8);
        FORBIDDEN_NO_ACTIVE_SUBSCRIPTION_FOUND = new UploadErrorCode("FORBIDDEN_NO_ACTIVE_SUBSCRIPTION_FOUND", 8, 9);
        $VALUES = (new UploadErrorCode[] {
            FILE_NOT_FOUND_EXCEPTION, CONFLICT_EXCEPTION, REBUILD_EXCEPTION, CLOUD_DRIVE_EXCEPTION, FORBIDDEN, FORBIDDEN_INSUFFICIENT_STORAGE, UNKNOWN_EXCEPTION, INVALID_PARAMETER, FORBIDDEN_NO_ACTIVE_SUBSCRIPTION_FOUND
        });
    }
}
