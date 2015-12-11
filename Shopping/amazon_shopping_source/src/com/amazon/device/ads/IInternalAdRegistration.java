// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import java.io.File;

// Referenced classes of package com.amazon.device.ads:
//            AppInfo, DeviceInfo, RegistrationInfo

interface IInternalAdRegistration
{

    public abstract void contextReceived(Context context);

    public abstract AppInfo getAppInfo();

    public abstract Context getApplicationContext();

    public abstract DeviceInfo getDeviceInfo();

    public abstract File getFilesDir();

    public abstract boolean getIsAppDisabled();

    public abstract int getNoRetryTtlRemainingMillis();

    public abstract RegistrationInfo getRegistrationInfo();

    public abstract boolean isRegistered();

    public abstract void register();

    public abstract void setIsAppDisabled(boolean flag);

    public abstract void setNoRetryTtl(int i);
}
