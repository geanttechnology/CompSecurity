// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.streaming.rdio;


public class RdioTrialStartStatus
{

    public static final RdioTrialStartStatus EMPTY = new RdioTrialStartStatus(null, false);
    public final String message;
    public final boolean success;

    private RdioTrialStartStatus(String s, boolean flag)
    {
        message = s;
        success = flag;
    }

}
