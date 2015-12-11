// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.preference.EditTextPreference;
import android.preference.Preference;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            SecretProxyFragment

private static class odoName
    implements android.preference.r
{

    private final EditTextPreference odoName;

    public boolean onPreferenceChange(Preference preference, Object obj)
    {
        odoName.setSummary(Strings.toString(obj));
        return true;
    }

    public (EditTextPreference edittextpreference)
    {
        odoName = edittextpreference;
    }
}
