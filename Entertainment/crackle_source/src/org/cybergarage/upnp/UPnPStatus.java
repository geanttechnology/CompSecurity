// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import org.cybergarage.http.HTTPStatus;

public class UPnPStatus
{

    public static final int ACTION_FAILED = 501;
    public static final int INVALID_ACTION = 401;
    public static final int INVALID_ARGS = 402;
    public static final int INVALID_VAR = 404;
    public static final int OUT_OF_SYNC = 403;
    public static final int PRECONDITION_FAILED = 412;
    private int code;
    private String description;

    public UPnPStatus()
    {
        setCode(0);
        setDescription("");
    }

    public UPnPStatus(int i, String s)
    {
        setCode(i);
        setDescription(s);
    }

    public static final String code2String(int i)
    {
        switch (i)
        {
        default:
            return HTTPStatus.code2String(i);

        case 401: 
            return "Invalid Action";

        case 402: 
            return "Invalid Args";

        case 403: 
            return "Out of Sync";

        case 404: 
            return "Invalid Var";

        case 412: 
            return "Precondition Failed";

        case 501: 
            return "Action Failed";
        }
    }

    public int getCode()
    {
        return code;
    }

    public String getDescription()
    {
        return description;
    }

    public void setCode(int i)
    {
        code = i;
    }

    public void setDescription(String s)
    {
        description = s;
    }
}
