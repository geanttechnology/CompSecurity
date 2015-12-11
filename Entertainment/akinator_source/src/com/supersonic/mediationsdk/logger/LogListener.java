// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.logger;


public interface LogListener
{

    public abstract void onLog(SupersonicLogger.SupersonicTag supersonictag, String s, int i);
}
