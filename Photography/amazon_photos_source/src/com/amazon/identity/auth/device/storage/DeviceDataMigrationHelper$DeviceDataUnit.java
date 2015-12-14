// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import java.util.Map;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DeviceDataMigrationHelper

public static class mData
{

    final Map mData;
    final String mNamespace;

    public (String s, Map map)
    {
        if (s == null || map == null)
        {
            throw new IllegalArgumentException("namespace and data should not be null!");
        } else
        {
            mNamespace = s;
            mData = map;
            return;
        }
    }
}
