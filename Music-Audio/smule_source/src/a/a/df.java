// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package a.a;


public final class df extends Enum
{

    public static final df a;
    public static final df b;
    public static final df c;
    public static final df d;
    public static final df e;
    public static final df f;
    public static final df g;
    public static final df h;
    public static final df i;
    public static final df j;
    public static final df k;
    public static final df l;
    private static final df o[];
    private String m;
    private String n;

    private df(String s, int i1, String s1, String s2)
    {
        super(s, i1);
        m = s1;
        n = s2;
    }

    public static df valueOf(String s)
    {
        return (df)Enum.valueOf(a/a/df, s);
    }

    public static df[] values()
    {
        return (df[])o.clone();
    }

    public final String a()
    {
        return m;
    }

    public final String b()
    {
        return n;
    }

    static 
    {
        a = new df("APP_LOADS_FILES", 0, "com.crittercism.apploads", "appLoadFiles");
        b = new df("HANDLED_EXCEPTION_FILES", 1, "com.crittercism.exceptions", "handledExceptionFiles");
        c = new df("SDK_CRASHES_FILES", 2, "com.crittercism.sdkcrashes", "sdkCrashFiles");
        d = new df("NDK_CRASHES_FILES", 3, "com.crittercism.ndkcrashes", "ndkCrashFiles");
        e = new df("CURRENT_BREADCRUMBS_FILES", 4, "com.crittercism.breadcrumbs", "currentBreadcrumbFiles");
        f = new df("PREVIOUS_BREADCRUMBS_FILES", 5, "com.crittercism.breadcrumbs", "previousBreadcrumbFiles");
        g = new df("NETWORK_BREADCRUMBS_FILES", 6, "com.crittercism.breadcrumbs", "networkBreadcrumbFiles");
        h = new df("CRASHED_ON_LAST_LOAD_SETTING", 7, "com.crittercism.usersettings", "crashedOnLastLoad");
        i = new df("OPT_OUT_STATUS_SETTING", 8, "com.crittercism.usersettings", "optOutStatusSettings");
        j = new df("SESSION_ID_SETTING", 9, "com.crittercism.usersettings", "sessionIDSetting");
        k = new df("OLD_SESSION_ID_SETTING", 10, "com.crittercism.prefs", "com.crittercism.prefs.sessid");
        l = new df("OLD_OPT_OUT_STATUS_SETTING", 11, "com.crittercism.prefs", "optOutStatus");
        o = (new df[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l
        });
    }
}
