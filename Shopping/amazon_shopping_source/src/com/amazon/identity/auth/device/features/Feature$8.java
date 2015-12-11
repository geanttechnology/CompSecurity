// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.features;

import android.content.Context;
import com.amazon.identity.platform.setting.PlatformSettings;
import com.amazon.identity.platform.util.PlatformUtils;

// Referenced classes of package com.amazon.identity.auth.device.features:
//            Feature

static final class nit> extends Feature
{

    boolean fetchValue(Context context)
    {
        if (PlatformUtils.isGen6Tablet(context) || PlatformUtils.isGen7Tablet(context))
        {
            return PlatformSettings.getInstance(context).getSettingBoolean("use_central_local_database", true);
        } else
        {
            return false;
        }
    }

    gs(String s, int i)
    {
        super(s, i, null);
    }
}
