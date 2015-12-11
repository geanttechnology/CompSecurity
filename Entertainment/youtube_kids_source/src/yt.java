// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.DialogInterface;

public final class yt
    implements android.content.DialogInterface.OnClickListener
{

    private com.google.android.apps.youtube.kids.activities.SettingsActivity.SettingsPrefsFragment a;

    public yt(com.google.android.apps.youtube.kids.activities.SettingsActivity.SettingsPrefsFragment settingsprefsfragment)
    {
        a = settingsprefsfragment;
        super();
    }

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        com.google.android.apps.youtube.kids.activities.SettingsActivity.SettingsPrefsFragment.a(a);
    }
}
