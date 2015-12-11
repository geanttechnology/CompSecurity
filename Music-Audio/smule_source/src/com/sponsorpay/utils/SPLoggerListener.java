// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;


public interface SPLoggerListener
{

    public abstract void log(SponsorPayLogger.Level level, String s, String s1, Exception exception);
}
