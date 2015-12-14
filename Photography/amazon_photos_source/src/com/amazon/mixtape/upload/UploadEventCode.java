// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.upload;


public final class UploadEventCode extends Enum
{

    private static final UploadEventCode $VALUES[];
    public static final UploadEventCode BACK_OFF;
    public static final UploadEventCode ERROR;
    public static final UploadEventCode INTERRUPTED;
    public static final UploadEventCode RESUME;
    public static final UploadEventCode SUCCESS;
    private final int mCode;

    private UploadEventCode(String s, int i, int j)
    {
        super(s, i);
        mCode = j;
    }

    public static UploadEventCode valueOf(String s)
    {
        return (UploadEventCode)Enum.valueOf(com/amazon/mixtape/upload/UploadEventCode, s);
    }

    public static UploadEventCode[] values()
    {
        return (UploadEventCode[])$VALUES.clone();
    }

    public int toInt()
    {
        return mCode;
    }

    static 
    {
        SUCCESS = new UploadEventCode("SUCCESS", 0, 1);
        RESUME = new UploadEventCode("RESUME", 1, 2);
        ERROR = new UploadEventCode("ERROR", 2, 3);
        INTERRUPTED = new UploadEventCode("INTERRUPTED", 3, 4);
        BACK_OFF = new UploadEventCode("BACK_OFF", 4, 5);
        $VALUES = (new UploadEventCode[] {
            SUCCESS, RESUME, ERROR, INTERRUPTED, BACK_OFF
        });
    }
}
