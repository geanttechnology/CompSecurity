// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import org.json.JSONObject;

public class CvContentResponse
{

    public final int code;
    public final JSONObject content;
    public final Exception error;
    public final boolean isError;
    public final String message;

    public CvContentResponse(Exception exception, int i)
    {
        isError = true;
        message = (new StringBuilder()).append("Error while loading content: ").append(exception.getMessage()).toString();
        error = exception;
        content = null;
        code = i;
    }

    public CvContentResponse(String s, int i)
    {
        isError = true;
        message = s;
        error = null;
        content = null;
        code = i;
    }

    public CvContentResponse(String s, Exception exception, int i)
    {
        isError = true;
        message = s;
        error = exception;
        content = null;
        code = i;
    }

    public CvContentResponse(JSONObject jsonobject)
    {
        isError = false;
        message = "";
        error = null;
        content = jsonobject;
        code = 0;
    }
}
