// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;


public class PostResult
{

    public String captchaUrl;
    public boolean shouldRefreshSessionKey;
    public boolean success;

    public PostResult(boolean flag)
    {
        success = flag;
    }

    public PostResult(boolean flag, boolean flag1, String s)
    {
        success = flag;
        captchaUrl = s;
        shouldRefreshSessionKey = flag1;
    }
}
