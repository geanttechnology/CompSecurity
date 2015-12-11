// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon;

import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;

public interface IBeaconConsumer
{

    public abstract boolean bindService(Intent intent, ServiceConnection serviceconnection, int i);

    public abstract Context getApplicationContext();

    public abstract void onIBeaconServiceConnect();

    public abstract void unbindService(ServiceConnection serviceconnection);
}
