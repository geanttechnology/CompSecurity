// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities.do;

import io.presage.activities.PresageActivity;
import io.presage.ads.d;

// Referenced classes of package io.presage.activities.do:
//            e, b, d

public final class c
{
    public static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        private static final a c[];

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(io/presage/activities/do/c$a, s);
        }

        public static a[] values()
        {
            return (a[])c.clone();
        }

        static 
        {
            a = new a("ACTIVITY_HELPER_TYPE_WEB_VIEW", 0);
            b = new a("ACTIVITY_HELPER_TYPE_VIDEO", 1);
            c = (new a[] {
                a, b
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static c a = null;

    private c()
    {
    }

    public static c a()
    {
        if (a == null)
        {
            a = new c();
        }
        return a;
    }

    public static io.presage.activities.do.d a(PresageActivity presageactivity, b b, d d)
    {
        static final class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[a.values().length];
                try
                {
                    a[a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror) { }
            }
        }

        switch (_cls1.a[a.a.ordinal()])
        {
        default:
            return null;

        case 1: // '\001'
            return new e(a.a, presageactivity, b, d);
        }
    }

}
