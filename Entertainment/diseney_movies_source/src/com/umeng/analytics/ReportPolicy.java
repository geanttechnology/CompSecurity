// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.umeng.analytics;

import android.content.Context;
import u.aly.bi;
import u.aly.q;
import u.aly.w;

public class ReportPolicy
{
    public static class a extends e
    {

        public boolean a(boolean flag)
        {
            return flag;
        }

        public a()
        {
        }
    }

    public static class b extends e
    {

        private long a;
        private long b;
        private w c;

        public long a()
        {
            return b;
        }

        public boolean a(boolean flag)
        {
            return System.currentTimeMillis() - c.c >= b;
        }

        public b(w w1, long l)
        {
            a = 10000L;
            c = w1;
            long l1 = l;
            if (l < a)
            {
                l1 = a;
            }
            b = l1;
        }
    }

    public static class c extends e
    {

        private final int a;
        private q b;

        public boolean a(boolean flag)
        {
            return b.b() > a;
        }

        public c(q q1, int i)
        {
            a = i;
            b = q1;
        }
    }

    public static class d extends e
    {

        private long a;
        private w b;

        public boolean a(boolean flag)
        {
            return System.currentTimeMillis() - b.c >= a;
        }

        public d(w w1)
        {
            a = 0x5265c00L;
            b = w1;
        }
    }

    public static class e
    {

        public boolean a(boolean flag)
        {
            return true;
        }

        public e()
        {
        }
    }

    public static class f extends e
    {

        private Context a;

        public boolean a(boolean flag)
        {
            return bi.k(a);
        }

        public f(Context context)
        {
            a = null;
            a = context;
        }
    }


    public static final int BATCH_AT_LAUNCH = 1;
    public static final int BATCH_BY_INTERVAL = 6;
    public static final int BATCH_BY_SIZE = 7;
    public static final int DAILY = 4;
    public static final int REALTIME = 0;
    public static final int WIFIONLY = 5;
    static final int a = 2;
    static final int b = 3;

    public ReportPolicy()
    {
    }
}
