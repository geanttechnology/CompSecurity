// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.internal;

import java.util.HashMap;
import java.util.Map;

public abstract class ErrorStatus
{

    public static final int ADAPTER_NOT_FOUND = 1;
    public static final int DISPLAY_FAILED = 4;
    public static final int INIT_FAILED = 3;
    public static final int LOAD_FAILED = 5;
    public static final int LOAD_TIMED_OUT = 6;
    public static final int NO_NETWORK = 2;
    public static final int UNKNOWN = 7;
    protected static Map errorCodes;
    private Throwable cause;
    private String description;
    private int errorCode;

    protected ErrorStatus(int i)
    {
        this(i, null);
    }

    protected ErrorStatus(int i, String s)
    {
        this(i, s, null);
    }

    protected ErrorStatus(int i, String s, Throwable throwable)
    {
        errorCode = i;
        description = s;
        cause = throwable;
    }

    public String getDescription()
    {
        return description;
    }

    public int getErrorCode()
    {
        return errorCode;
    }

    public String toString()
    {
        StringBuilder stringbuilder = (new StringBuilder()).append("[").append(errorCode).append("]: [").append((String)errorCodes.get(Integer.valueOf(errorCode))).append("] ");
        String s;
        if (description != null)
        {
            s = description;
        } else
        {
            s = "No additional details available.";
        }
        stringbuilder = stringbuilder.append(s);
        if (cause != null)
        {
            s = (new StringBuilder()).append(" caused by ").append(cause.getMessage()).toString();
        } else
        {
            s = "";
        }
        return stringbuilder.append(s).toString();
    }

    static 
    {
        errorCodes = new HashMap();
        errorCodes.put(Integer.valueOf(1), "ADAPTER_NOT_FOUND");
        errorCodes.put(Integer.valueOf(2), "NO_NETWORK");
        errorCodes.put(Integer.valueOf(3), "INIT_FAILED");
        errorCodes.put(Integer.valueOf(4), "DISPLAY_FAILED");
        errorCodes.put(Integer.valueOf(5), "LOAD_FAILED");
        errorCodes.put(Integer.valueOf(6), "LOAD_TIMED_OUT");
        errorCodes.put(Integer.valueOf(7), "UNKNOWN");
    }
}
