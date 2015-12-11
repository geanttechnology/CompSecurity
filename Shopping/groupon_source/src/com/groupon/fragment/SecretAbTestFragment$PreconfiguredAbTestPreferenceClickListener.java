// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.Preference;
import com.groupon.activity.IntentFactory;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.fragment:
//            SecretAbTestFragment

private class <init>
    implements android.preference.r
{

    final SecretAbTestFragment this$0;

    public boolean onPreferenceClick(Preference preference)
    {
        startActivityForResult(((IntentFactory)SecretAbTestFragment.access$500(SecretAbTestFragment.this).get()).newPreconfigedABTestsIntent(), 10148);
        return true;
    }

    private ()
    {
        this$0 = SecretAbTestFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
