// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mobileads;

import android.content.Context;
import android.widget.ArrayAdapter;

// Referenced classes of package com.amazon.mShop.mobileads:
//            DebugSettingsActivityForAds

private static class add extends ArrayAdapter
{

    public (Context context)
    {
        super(context, 0x1090008);
        setDropDownViewResource(0x1090009);
        for (int i = 0; i < DebugSettingsActivityForAds.access$200().length; i++)
        {
            add(DebugSettingsActivityForAds.access$200()[i]);
        }

    }
}
