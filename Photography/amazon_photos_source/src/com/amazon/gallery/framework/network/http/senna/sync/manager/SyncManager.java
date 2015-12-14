// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.senna.sync.manager;

import com.amazon.gallery.framework.data.account.AccountChangeListener;

public interface SyncManager
    extends AccountChangeListener
{

    public abstract boolean isColdBootCompleted();

    public abstract void scheduleBackgroundSync();

    public abstract void scheduleForegroundSync();
}
