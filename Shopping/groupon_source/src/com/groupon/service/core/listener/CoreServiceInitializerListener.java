// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service.core.listener;

import com.groupon.service.core.CoreService;
import java.util.Collection;

public interface CoreServiceInitializerListener
{

    public abstract void onAllServicesRefreshCompletedSuccessfully();

    public abstract void onAllServicesRefreshCompletedWithError(Collection collection);

    public abstract void onServiceRefreshStarted(CoreService coreservice);
}
