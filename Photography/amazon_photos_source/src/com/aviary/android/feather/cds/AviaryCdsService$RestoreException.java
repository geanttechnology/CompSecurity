// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.cds;


// Referenced classes of package com.aviary.android.feather.cds:
//            AviaryCdsService

public static class code extends Exception
{

    static final int CODE_DOWNLOAD_REQUEST_ERROR = 8;
    static final int CODE_ERROR_CURSOR_EMPTY = 2;
    static final int CODE_ERROR_IAB_EXCEPTION = 1;
    static final int CODE_HTTP_EXCEPTION = 4;
    static final int CODE_ICON_ERROR = 7;
    static final int CODE_JSON_EXCEPTION = 3;
    static final int CODE_RESTORE_OWNED_ERROR = 6;
    static final int CODE_UNKNOWN_ERROR = 5;
    private static final long serialVersionUID = 1L;
    private int code;

    public int getCode()
    {
        return code;
    }

    public String getLocalizedMessage()
    {
        String s;
        if (getCause() != null)
        {
            s = getCause().getLocalizedMessage();
        } else
        {
            s = super.getLocalizedMessage();
        }
        return (new StringBuilder()).append(s).append(" (ErrorCode: ").append(code).append(")").toString();
    }

    public (int i, String s)
    {
        super(s);
        code = i;
    }

    code(int i, Throwable throwable)
    {
        super(throwable);
        code = i;
    }
}
