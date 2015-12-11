// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.registrar;

import android.content.Context;
import com.arellomobile.android.push.utils.GeneralUtils;
import com.arellomobile.android.push.utils.PreferenceUtils;
import com.google.android.gcm.GCMRegistrar;

// Referenced classes of package com.arellomobile.android.push.registrar:
//            PushRegistrar

public class PushRegistrarGCM
    implements PushRegistrar
{

    public PushRegistrarGCM(Context context)
    {
    }

    public void checkDevice(Context context)
    {
        String s = PreferenceUtils.getApplicationId(context);
        String s1 = PreferenceUtils.getProjectId(context);
        GeneralUtils.checkNotNullOrEmpty(s, "mAppId");
        GeneralUtils.checkNotNullOrEmpty(s1, "mSenderId");
        GCMRegistrar.checkDevice(context);
        GCMRegistrar.checkManifest(context);
    }

    public void registerPW(Context context)
    {
        GCMRegistrar.register(context, new String[] {
            PreferenceUtils.getProjectId(context)
        });
    }

    public void unregisterPW(Context context)
    {
        GCMRegistrar.unregister(context);
    }
}
