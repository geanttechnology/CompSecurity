// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core.listener;

import com.groupon.service.core.CoreService;

public interface CoreServiceListener
{

    public abstract void onRefreshError(CoreService coreservice, Exception exception);

    public abstract void onRefreshStarted(CoreService coreservice);

    public abstract void onRefreshSuccess(CoreService coreservice);
}
