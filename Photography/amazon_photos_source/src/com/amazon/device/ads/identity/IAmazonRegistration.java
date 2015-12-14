// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads.identity;

import android.content.Context;

// Referenced classes of package com.amazon.device.ads.identity:
//            AppInfo, DeviceInfo, RegistrationInfo

interface IAmazonRegistration
{

    public abstract void contextReceived(Context context);

    public abstract AppInfo getAppInfo();

    public abstract Context getApplicationContext();

    public abstract DeviceInfo getDeviceInfo();

    public abstract RegistrationInfo getRegistrationInfo();
}
