// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class yu
    implements mj
{

    private String a;
    private boolean b;
    private com.google.android.apps.youtube.kids.activities.SettingsActivity.SettingsPrefsFragment c;

    public yu(com.google.android.apps.youtube.kids.activities.SettingsActivity.SettingsPrefsFragment settingsprefsfragment, String s, boolean flag)
    {
        c = settingsprefsfragment;
        a = s;
        b = flag;
        super();
    }

    public final void a(Object obj)
    {
        obj = a;
        boolean flag = b;
        bmo.e((new StringBuilder(String.valueOf(obj).length() + 13)).append("Set ").append(((String) (obj))).append(" to ").append(flag).toString());
        com.google.android.apps.youtube.kids.activities.SettingsActivity.SettingsPrefsFragment.b(c);
    }

    public final void a(mp mp)
    {
        mp = String.valueOf(a);
        if (mp.length() != 0)
        {
            mp = "Could not toggle ".concat(mp);
        } else
        {
            mp = new String("Could not toggle ");
        }
        bmo.c(mp);
    }
}
