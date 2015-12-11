// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.util;


public class VineProgressEvent
{

    public static final int CANCELED_EVENT_CODE = 8;
    public static final int COMPLETED_EVENT_CODE = 2;
    public static final int FAILED_EVENT_CODE = 4;
    public static final int PART_COMPLETED_EVENT_CODE = 2048;
    public static final int PART_FAILED_EVENT_CODE = 4096;
    public static final int PART_STARTED_EVENT_CODE = 1024;
    public static final int STARTED_EVENT_CODE = 1;
    private int bytesTransfered;
    private int eventCode;

    public VineProgressEvent(int i)
    {
        bytesTransfered = i;
    }

    public int getBytesTransfered()
    {
        return bytesTransfered;
    }

    public int getEventCode()
    {
        return eventCode;
    }

    public void setBytesTransfered(int i)
    {
        bytesTransfered = i;
    }

    public void setEventCode(int i)
    {
        eventCode = i;
    }
}
