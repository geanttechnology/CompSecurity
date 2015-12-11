// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crittercism.app;

import crittercism.android.dg;
import java.util.LinkedList;
import java.util.List;

public class CrittercismConfig
{

    private String a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private String g;
    private String h;
    private String i;
    private List j;
    private List k;

    public CrittercismConfig()
    {
        a = null;
        b = false;
        c = false;
        d = true;
        e = false;
        f = a();
        g = "com.crittercism/dumps";
        h = "Developer Reply";
        i = null;
        j = new LinkedList();
        k = new LinkedList();
    }

    public CrittercismConfig(CrittercismConfig crittercismconfig)
    {
        a = null;
        b = false;
        c = false;
        d = true;
        e = false;
        f = a();
        g = "com.crittercism/dumps";
        h = "Developer Reply";
        i = null;
        j = new LinkedList();
        k = new LinkedList();
        a = crittercismconfig.a;
        b = crittercismconfig.b;
        c = crittercismconfig.c;
        d = crittercismconfig.d;
        e = crittercismconfig.e;
        f = crittercismconfig.f;
        g = crittercismconfig.g;
        h = crittercismconfig.h;
        setURLBlacklistPatterns(crittercismconfig.j);
        setPreserveQueryStringPatterns(crittercismconfig.k);
        i = crittercismconfig.i;
    }

    private static int a(String s)
    {
        int l = 0;
        if (s != null)
        {
            l = s.hashCode();
        }
        return l;
    }

    private static final boolean a()
    {
        return android.os.Build.VERSION.SDK_INT >= 10 && android.os.Build.VERSION.SDK_INT <= 19;
    }

    protected static boolean a(String s, String s1)
    {
        if (s == null)
        {
            return s1 == null;
        } else
        {
            return s.equals(s1);
        }
    }

    public final boolean delaySendingAppLoad()
    {
        return b;
    }

    public boolean equals(Object obj)
    {
        if (obj instanceof CrittercismConfig)
        {
            if (b == ((CrittercismConfig) (obj = (CrittercismConfig)obj)).b && e == ((CrittercismConfig) (obj)).e && isNdkCrashReportingEnabled() == ((CrittercismConfig) (obj)).isNdkCrashReportingEnabled() && isOptmzEnabled() == ((CrittercismConfig) (obj)).isOptmzEnabled() && isVersionCodeToBeIncludedInVersionString() == ((CrittercismConfig) (obj)).isVersionCodeToBeIncludedInVersionString() && a(a, ((CrittercismConfig) (obj)).a) && a(h, ((CrittercismConfig) (obj)).h) && a(g, ((CrittercismConfig) (obj)).g) && j.equals(((CrittercismConfig) (obj)).j) && k.equals(((CrittercismConfig) (obj)).k) && a(i, ((CrittercismConfig) (obj)).i))
            {
                return true;
            }
        }
        return false;
    }

    public final String getCustomVersionName()
    {
        return a;
    }

    public final String getNativeDumpPath()
    {
        return g;
    }

    public List getOptmzBlackListURLPatterns()
    {
        return getURLBlacklistPatterns();
    }

    public List getPreserveQueryStringPatterns()
    {
        return new LinkedList(k);
    }

    public List getURLBlacklistPatterns()
    {
        return new LinkedList(j);
    }

    public int hashCode()
    {
        int l1 = 1;
        int i2 = a(a);
        int j2 = a(h);
        int k2 = a(g);
        int l2 = a(i);
        int i3 = j.hashCode();
        int j3 = k.hashCode();
        int l;
        int i1;
        int j1;
        int k1;
        if (b)
        {
            l = 1;
        } else
        {
            l = 0;
        }
        if (e)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (isNdkCrashReportingEnabled())
        {
            j1 = 1;
        } else
        {
            j1 = 0;
        }
        if (isOptmzEnabled())
        {
            k1 = 1;
        } else
        {
            k1 = 0;
        }
        if (!isVersionCodeToBeIncludedInVersionString())
        {
            l1 = 0;
        }
        return Integer.valueOf((k1 + (j1 + (i1 + (l + 0 << 1) << 1) << 1) << 1) + l1).hashCode() + (j3 + (((((i2 + 0) * 31 + j2) * 31 + k2) * 31 + l2) * 31 + i3) * 31) * 31;
    }

    public final boolean isLogcatReportingEnabled()
    {
        return e;
    }

    public final boolean isNdkCrashReportingEnabled()
    {
        return d;
    }

    public final boolean isOptmzEnabled()
    {
        return f;
    }

    public final boolean isVersionCodeToBeIncludedInVersionString()
    {
        return c;
    }

    public final void setLogcatReportingEnabled(boolean flag)
    {
        e = flag;
    }

    public final void setOptmzEnabled(boolean flag)
    {
        if (!a() && flag)
        {
            dg.a("Crittercism", "OPTMZ is currently only allowed for api levels 10 to 19.  APM will not be installed");
            return;
        } else
        {
            f = flag;
            return;
        }
    }

    public void setPreserveQueryStringPatterns(List list)
    {
        k.clear();
        if (list != null)
        {
            k.addAll(list);
        }
    }

    public void setURLBlacklistPatterns(List list)
    {
        j.clear();
        if (list != null)
        {
            j.addAll(list);
        }
    }
}
