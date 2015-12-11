// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.registrar;

import android.content.Context;
import com.amazon.device.messaging.ADM;
import com.arellomobile.android.push.ADMRegistrar;
import com.arellomobile.android.push.utils.GeneralUtils;
import com.arellomobile.android.push.utils.PreferenceUtils;

// Referenced classes of package com.arellomobile.android.push.registrar:
//            PushRegistrar

public class PushRegistrarADM
    implements PushRegistrar
{

    private final ADM mAdm;

    public PushRegistrarADM(Context context)
    {
        mAdm = new ADM(context);
    }

    public void checkDevice(Context context)
    {
        GeneralUtils.checkNotNullOrEmpty(PreferenceUtils.getApplicationId(context), "mAppId");
        ADMRegistrar.checkDevice(mAdm);
        ADMRegistrar.checkManifest(context);
    }

    public void registerPW(Context context)
    {
        mAdm.startRegister();
    }

    public void unregisterPW(Context context)
    {
        mAdm.startUnregister();
    }
}
