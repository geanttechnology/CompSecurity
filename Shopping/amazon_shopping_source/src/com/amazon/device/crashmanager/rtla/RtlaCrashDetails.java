// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.crashmanager.rtla;

import java.util.List;

public interface RtlaCrashDetails
{

    public abstract List getActiveWebLabs();

    public abstract String getPageType();

    public abstract String getSessionId();

    public abstract String getSubPageType();

    public abstract String getUserAgent();
}
