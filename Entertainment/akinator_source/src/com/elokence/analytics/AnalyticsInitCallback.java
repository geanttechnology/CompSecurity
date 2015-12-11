// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.elokence.analytics;


public interface AnalyticsInitCallback
{

    public abstract void onAnalyticsInitError();

    public abstract void onAnalyticsInitResponse();
}
