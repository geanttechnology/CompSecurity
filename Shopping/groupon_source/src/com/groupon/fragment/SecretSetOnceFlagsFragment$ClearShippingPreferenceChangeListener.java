// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.Preference;
import com.groupon.service.ShippingService;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretSetOnceFlagsFragment

private class <init>
    implements android.preference.r
{

    final SecretSetOnceFlagsFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        if (!((Boolean)obj).booleanValue())
        {
            ((ShippingService)SecretSetOnceFlagsFragment.access$200(SecretSetOnceFlagsFragment.this).get()).clearStore();
        }
        preference.setEnabled(((ShippingService)SecretSetOnceFlagsFragment.access$200(SecretSetOnceFlagsFragment.this).get()).isStored());
        return true;
    }

    private ()
    {
        this$0 = SecretSetOnceFlagsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
