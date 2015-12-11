// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.preference.Preference;
import com.google.android.apps.youtube.kids.activities.DebugOnlineAdActivity;
import com.google.android.apps.youtube.kids.activities.DeveloperActivity;

public final class ws
    implements android.preference.Preference.OnPreferenceClickListener
{

    private DeveloperActivity a;

    public ws(DeveloperActivity developeractivity)
    {
        a = developeractivity;
        super();
    }

    public final boolean onPreferenceClick(Preference preference)
    {
        preference = new Intent(a, com/google/android/apps/youtube/kids/activities/DebugOnlineAdActivity);
        a.startActivity(preference);
        return true;
    }
}
