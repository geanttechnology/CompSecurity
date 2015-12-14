// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.messaging;


public class AutoSavePowerSettingChangedEvent
{

    private boolean syncNow;

    public AutoSavePowerSettingChangedEvent(boolean flag)
    {
        syncNow = flag;
    }

    public boolean shouldSyncNow()
    {
        return syncNow;
    }
}
