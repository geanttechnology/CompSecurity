// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.utils;

import b.a.a;
import java.util.TimeZone;

public final class m
{

    public static final TimeZone a = TimeZone.getTimeZone("UTC");

    public static String a(a a1)
    {
        a a2 = b.a.a.b(a);
        if (a1 == null)
        {
            return "";
        }
        double d = (a2.a(a) - a1.a(a)) / 1000L;
        if (d < 0.0D)
        {
            return "";
        }
        int j1 = (int)Math.floor(d / 31536000D);
        int j = (int)Math.floor(d / 2592000D);
        int i = j;
        if (j < 0)
        {
            i = j + 12;
        }
        int k = (int)Math.floor(d / 604800D);
        j = k;
        if (k < 0)
        {
            j = k + 52;
        }
        int k1 = (int)Math.floor(d / 86400D);
        int l = (int)Math.floor(d / 3600D);
        k = l;
        if (l < 0)
        {
            k = l + 24;
        }
        int i1 = (int)Math.floor(d / 60D);
        l = i1;
        if (i1 < 0)
        {
            l = i1 + 60;
        }
        if (j1 == 1)
        {
            return (new StringBuilder()).append(j1).append(" year ago").toString();
        }
        if (j1 > 1)
        {
            return (new StringBuilder()).append(j1).append(" years ago").toString();
        }
        if (i == 1)
        {
            return (new StringBuilder()).append(i).append(" month ago").toString();
        }
        if (i > 1)
        {
            return (new StringBuilder()).append(i).append(" months ago").toString();
        }
        if (j == 1)
        {
            return (new StringBuilder()).append(j).append(" week ago").toString();
        }
        if (j > 1)
        {
            return (new StringBuilder()).append(j).append(" weeks ago").toString();
        }
        if (k1 == 1)
        {
            return (new StringBuilder()).append(k1).append(" day ago").toString();
        }
        if (k1 > 1)
        {
            return (new StringBuilder()).append(k1).append(" days ago").toString();
        }
        if (k == 1)
        {
            return (new StringBuilder()).append(k).append(" hour ago").toString();
        }
        if (k > 1)
        {
            return (new StringBuilder()).append(k).append(" hours ago").toString();
        }
        if (l > 1)
        {
            return (new StringBuilder()).append(l).append(" minutes ago").toString();
        } else
        {
            return "less than a minute ago";
        }
    }

}
