// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.preference;

import android.preference.EditTextPreference;

// Referenced classes of package com.ebay.mobile.preference:
//            DcsOverridePreferenceFragment

private static final class text
    implements Runnable
{

    private final EditTextPreference pref;
    private final String text;

    public void run()
    {
        pref.setText(text);
    }

    public I(EditTextPreference edittextpreference, String s)
    {
        pref = edittextpreference;
        text = s;
    }
}
