// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;

// Referenced classes of package com.helpshift:
//            l, s

public final class com.helpshift.a
{
    protected static final class a extends Enum
    {

        public static final a a;
        public static final a b;
        public static final a c;
        public static final a d;
        private static final a e[];

        public static a valueOf(String s1)
        {
            return (a)Enum.valueOf(com/helpshift/a$a, s1);
        }

        public static a[] values()
        {
            return (a[])e.clone();
        }

        static 
        {
            a = new a("ACTION_BAR", 0);
            b = new a("SEARCH_FOOTER", 1);
            c = new a("QUESTION_FOOTER", 2);
            d = new a("QUESTION_ACTION_BAR", 3);
            e = (new a[] {
                a, b, c, d
            });
        }

        private a(String s1, int i)
        {
            super(s1, i);
        }
    }


    private static l a;
    private static s b;
    private static t.a c;

    public static void a(Context context)
    {
        if (a == null)
        {
            a = new l(context);
            b = a.a;
        }
    }

    protected static void a(HashMap hashmap)
    {
        HashMap hashmap1 = hashmap;
        if (hashmap == null)
        {
            hashmap1 = new HashMap();
        }
        hashmap = ((HashMap) (hashmap1.get("enableContactUs")));
        if (hashmap instanceof t.a)
        {
            c = (t.a)hashmap1.get("enableContactUs");
        } else
        if (hashmap instanceof Boolean)
        {
            if (((Boolean)hashmap).booleanValue())
            {
                c = t.a.a;
                return;
            } else
            {
                c = t.a.b;
                return;
            }
        }
    }

    protected static boolean a(a a1)
    {
        static class _cls1
        {

            static final int a[];
            static final int b[];

            static 
            {
                b = new int[t.a.values().length];
                try
                {
                    b[t.a.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    b[t.a.b.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    b[t.a.c.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                a = new int[a.values().length];
                try
                {
                    a[a.b.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    a[a.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[a.d.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[a.a.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1.b[c.ordinal()])
        {
        case 2: // '\002'
            return false;

        case 3: // '\003'
            switch (_cls1.a[a1.ordinal()])
            {
            default:
                return true;

            case 4: // '\004'
                a1 = b.f(a.B());
                String s1 = b.h(a.B());
                if (TextUtils.isEmpty(a1) && TextUtils.isEmpty(s1))
                {
                    return false;
                }
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
                break;
            }
            break;
        }
        while (true) 
        {
            return true;
        }
    }

    static 
    {
        c = t.a.a;
    }
}
