// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tremorvideo.sdk.android.videoad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.view.KeyEvent;
import java.util.List;

// Referenced classes of package com.tremorvideo.sdk.android.videoad:
//            aw, n

public abstract class com.tremorvideo.sdk.android.videoad.a
{
    public static interface a
    {

        public abstract int a(aw aw);

        public abstract int a(aw aw, int i1);

        public abstract int a(aw aw, int i1, List list);

        public abstract void a(int i1);

        public abstract void a(com.tremorvideo.sdk.android.videoad.a a1);

        public abstract void b(int i1);

        public abstract n g();

        public abstract Context h();

        public abstract int i();

        public abstract int j();
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        public static final b c;
        public static final b d;
        private static final b e[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/tremorvideo/sdk/android/videoad/a$b, s);
        }

        public static b[] values()
        {
            return (b[])e.clone();
        }

        static 
        {
            a = new b("Coupon", 0);
            b = new b("SurveyInternal", 1);
            c = new b("SurveyExternal", 2);
            d = new b("Exit", 3);
            e = (new b[] {
                a, b, c, d
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }


    protected Activity c;
    protected a d;

    public com.tremorvideo.sdk.android.videoad.a(a a1, Activity activity)
    {
        d = a1;
        c = activity;
    }

    public void a()
    {
    }

    public void a(int i, int i1, Intent intent)
    {
    }

    public void a(Configuration configuration)
    {
    }

    public boolean a(int i, KeyEvent keyevent)
    {
        return false;
    }

    public void b()
    {
    }

    public void c()
    {
    }

    public void d()
    {
    }

    public boolean j()
    {
        return true;
    }

    public void k()
    {
    }

    public void l()
    {
    }

    public boolean m()
    {
        return false;
    }

    public b n()
    {
        return b.d;
    }

    public void o()
    {
    }
}
