// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.attribute;

import android.content.Context;
import com.amazon.identity.auth.device.utils.DeviceTypeHelpers;

// Referenced classes of package com.amazon.identity.auth.device.attribute:
//            DeviceAttribute

static final class nit> extends DeviceAttribute
{

    public Object fetchValue(Context context)
    {
        return DeviceTypeHelpers.getCentralDeviceType(context);
    }

    A(String s, int i)
    {
        super(s, i, null);
    }
}
