// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.preference.Preference;
import com.google.android.apps.youtube.kids.activities.DeveloperActivity;

public final class wt
    implements android.preference.Preference.OnPreferenceClickListener
{

    private DeveloperActivity a;

    public wt(DeveloperActivity developeractivity)
    {
        a = developeractivity;
        super();
    }

    public final boolean onPreferenceClick(Preference preference)
    {
        DeveloperActivity.a(a);
        return true;
    }
}
