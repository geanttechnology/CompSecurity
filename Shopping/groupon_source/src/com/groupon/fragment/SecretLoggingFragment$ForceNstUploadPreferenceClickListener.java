// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.Preference;
import com.groupon.tracking.mobile.sdk.Logger;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretLoggingFragment

private class <init>
    implements android.preference.r
{

    final SecretLoggingFragment this$0;

    public boolean onPreferenceClick(Preference preference)
    {
        ((Logger)SecretLoggingFragment.access$600(SecretLoggingFragment.this).get()).forceLogRotate();
        return true;
    }

    private ()
    {
        this$0 = SecretLoggingFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
