// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.mybby;


public class Token
{

    private String accessToken;
    private String errorCode;
    private String expriesIn;
    private boolean hasError;

    public Token()
    {
    }

    public String getAccessToken()
    {
        return accessToken;
    }

    public String getErrorCode()
    {
        return errorCode;
    }

    public String getExpriesIn()
    {
        return expriesIn;
    }

    public boolean isHasError()
    {
        return hasError;
    }

    public void setAccessToken(String s)
    {
        accessToken = s;
    }

    public void setErrorCode(String s)
    {
        errorCode = s;
    }

    public void setExpriesIn(String s)
    {
        expriesIn = s;
    }

    public void setHasError(boolean flag)
    {
        hasError = flag;
    }
}
