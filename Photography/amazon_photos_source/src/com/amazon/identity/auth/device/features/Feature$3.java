// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.features;

import android.content.Context;
import com.amazon.identity.auth.device.framework.SystemPropertiesWrapper;
import com.amazon.identity.auth.device.utils.CentralApkUtils;

// Referenced classes of package com.amazon.identity.auth.device.features:
//            Feature

static final class nit> extends Feature
{

    boolean fetchValue(Context context)
    {
        while ("panda".equals((new SystemPropertiesWrapper()).get("com.amazon.map.registration")) || !CentralApkUtils.hasCentralAPK(context)) 
        {
            return true;
        }
        return false;
    }

    ls(String s, int i)
    {
        super(s, i, null);
    }
}
