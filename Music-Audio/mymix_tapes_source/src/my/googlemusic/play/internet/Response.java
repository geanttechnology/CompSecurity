// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package my.googlemusic.play.internet;


public class Response
{

    public static final int STATUS_FAILURE_BAD_URL = 3;
    public static final int STATUS_FAILURE_FILE_NOT_FOUND = 5;
    public static final int STATUS_FAILURE_IO_EXCEPTION = 4;
    public static final int STATUS_FAILURE_NOT_FOUND = 2;
    public static final int STATUS_FAILURE_NO_INTERNET_CONNECTION = 6;
    public static final int STATUS_FAILURE_SERVER_BAD_RESPONSE = 8;
    public static final int STATUS_FAILURE_SERVER_OFFLINE = 9;
    public static final int STATUS_FAILURE_SERVER_RESPONSE = 7;
    public static final int STATUS_SERVER_REQUESTING = 10;
    public static final int STATUS_SUCCESS = 1;
    private String content;
    private int status;

    public Response(int i, String s)
    {
        status = i;
        content = s;
    }

    public String getContent()
    {
        return content;
    }

    public int getStatus()
    {
        return status;
    }

    public boolean isSuccessful()
    {
        return status == 1;
    }
}
