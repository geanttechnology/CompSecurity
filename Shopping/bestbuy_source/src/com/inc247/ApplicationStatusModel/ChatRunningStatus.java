// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.inc247.ApplicationStatusModel;


public class ChatRunningStatus
{

    static boolean isChatRunning;

    public ChatRunningStatus()
    {
    }

    public static boolean getChatRunning()
    {
        return isChatRunning;
    }

    public static void setChatRunning(boolean flag)
    {
        isChatRunning = flag;
    }
}
