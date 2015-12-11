// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.os.Bundle;

// Referenced classes of package com.ebay.mobile.settings:
//            NotificationPreferencesFragmentBase

public class SellingNotificationPreferencesFragment extends NotificationPreferencesFragmentBase
{

    public SellingNotificationPreferencesFragment()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(0x7f05000a);
    }
}
