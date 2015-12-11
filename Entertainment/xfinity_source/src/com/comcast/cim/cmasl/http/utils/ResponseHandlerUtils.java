// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.http.utils;


public class ResponseHandlerUtils
{

    private ResponseHandlerUtils()
    {
    }

    public static boolean statusCodeIndicatesError(int i)
    {
        return i == 202 || i < 200 || i >= 300;
    }
}
