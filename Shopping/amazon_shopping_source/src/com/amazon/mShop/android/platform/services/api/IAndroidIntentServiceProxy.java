// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.services.api;

import android.content.Intent;
import android.os.IBinder;

// Referenced classes of package com.amazon.mShop.android.platform.services.api:
//            IAndroidServiceProxy

public interface IAndroidIntentServiceProxy
    extends IAndroidServiceProxy
{

    public abstract IBinder superOnBind(Intent intent);

    public abstract void superSetIntentRedelivery(boolean flag);
}
