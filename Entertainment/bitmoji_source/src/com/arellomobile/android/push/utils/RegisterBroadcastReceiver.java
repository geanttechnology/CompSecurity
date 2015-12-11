// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.arellomobile.android.push.utils:
//            GeneralUtils

public abstract class RegisterBroadcastReceiver extends BroadcastReceiver
{

    public RegisterBroadcastReceiver()
    {
    }

    public final void onReceive(Context context, Intent intent)
    {
        onRegisterActionReceive(context, intent);
        if (GeneralUtils.checkStickyBroadcastPermissions(context))
        {
            context.removeStickyBroadcast(new Intent("com.arellomobile.android.push.REGISTER_BROAD_CAST_ACTION"));
        }
    }

    protected abstract void onRegisterActionReceive(Context context, Intent intent);
}
