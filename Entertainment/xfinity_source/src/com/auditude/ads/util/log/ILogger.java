// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.auditude.ads.util.log;

import com.auditude.ads.util.event.IEventDispatcher;

public interface ILogger
    extends IEventDispatcher
{

    public abstract String getCategory();

    public abstract void info(Object obj);
}
