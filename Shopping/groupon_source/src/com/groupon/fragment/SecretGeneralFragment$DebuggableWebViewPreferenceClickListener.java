// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.Preference;
import android.webkit.WebView;

// Referenced classes of package com.groupon.fragment:
//            SecretGeneralFragment

private class <init>
    implements android.preference.r
{

    final SecretGeneralFragment this$0;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        if (android.os.kListener >= 19)
        {
            WebView.setWebContentsDebuggingEnabled(((Boolean)obj).booleanValue());
            return true;
        } else
        {
            return false;
        }
    }

    private Y()
    {
        this$0 = SecretGeneralFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
