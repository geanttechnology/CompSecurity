// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Intent;
import android.os.IBinder;

interface ProxyService
{

    public abstract IBinder onBind(Intent intent);

    public abstract void onCreate();

    public abstract void onDestroy();

    public abstract int onStartCommand(Intent intent, int i, int j);
}
