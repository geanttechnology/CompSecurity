// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.protocol;


public final class HTTP
{

    private HTTP()
    {
    }

    public static boolean isWhitespace(char c)
    {
        return c == ' ' || c == '\t' || c == '\r' || c == '\n';
    }
}
