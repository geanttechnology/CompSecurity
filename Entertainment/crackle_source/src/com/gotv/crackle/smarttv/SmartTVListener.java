// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import java.util.List;

public interface SmartTVListener
{

    public static final int APPLICATION_NOT_RUNNING = 404;
    public static final int FORBIDDEN = 403;
    public static final int MAXIMUM_CONNECTIONS = 503;
    public static final int OK = 200;
    public static final int UNAUTHORIZED = 401;

    public abstract void onSmartTVConnect(int i);

    public abstract void onSmartTVDataSent(int i);

    public abstract void onSmartTVDeviceListUpdate(List list);

    public abstract void onSmartTVDisconnect(int i);

    public abstract void onSmartTVLauncher(int i);

    public abstract void onSmartTVRequestInfo(int i);
}
