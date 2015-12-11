// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.widget.Toast;

public final class yv
    implements mj
{

    private com.google.android.apps.youtube.kids.activities.SettingsActivity.SettingsPrefsFragment a;

    public yv(com.google.android.apps.youtube.kids.activities.SettingsActivity.SettingsPrefsFragment settingsprefsfragment)
    {
        a = settingsprefsfragment;
        super();
    }

    public final void a(Object obj)
    {
        Toast.makeText(a.getActivity(), 0x7f0b01bc, 1).show();
        com.google.android.apps.youtube.kids.activities.SettingsActivity.SettingsPrefsFragment.b(a);
    }

    public final void a(mp mp)
    {
        bmo.c("Could not clear watch history.");
    }
}
