// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership;

import android.content.Context;
import com.target.a.a.b;
import com.target.mothership.a.a;
import com.target.mothership.cache.j;
import com.target.mothership.cache.list.e;

// Referenced classes of package com.target.mothership:
//            a, b

public final class com.target.mothership.c
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a Debug;
        public static final a Live;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/mothership/c$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            Live = new a("Live", 0);
            Debug = new a("Debug", 1);
            $VALUES = (new a[] {
                Live, Debug
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class b extends Enum
    {

        private static final b $VALUES[];
        public static final b InStore;
        public static final b NoLocation;
        public static final b OutOfStore;

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/target/mothership/c$b, s);
        }

        public static b[] values()
        {
            return (b[])$VALUES.clone();
        }

        static 
        {
            InStore = new b("InStore", 0);
            OutOfStore = new b("OutOfStore", 1);
            NoLocation = new b("NoLocation", 2);
            $VALUES = (new b[] {
                InStore, OutOfStore, NoLocation
            });
        }

        private b(String s, int i)
        {
            super(s, i);
        }
    }

    public static class c extends RuntimeException
    {

        c()
        {
            super("initialize() may only be called once!");
        }
    }


    private static Context sApplicationContext;
    private static boolean sIsInitialized = false;
    private static b sMockLocationMode;
    private static boolean sShouldReturnMockErrors = false;

    public static void a(com.target.mothership.a a1)
        throws c
    {
        if (sIsInitialized)
        {
            throw new c();
        }
        sIsInitialized = true;
        sApplicationContext = a1.b();
        com.target.a.a.b.a(a1.j());
        com.target.mothership.b.a(a1);
        com.target.mothership.util.b.a(sApplicationContext);
        j.init(sApplicationContext);
        if (a1.l())
        {
            j.getInstance().updateStoreCache();
        }
        com.target.mothership.cache.b.init(sApplicationContext);
        com.target.mothership.model.guest.b.a(new e());
        com.target.mothership.a.a.a(sApplicationContext);
    }

    public static boolean a()
    {
        return com.target.mothership.b.a().m() && sShouldReturnMockErrors;
    }

    public static b b()
    {
        return sMockLocationMode;
    }

    public static Context c()
    {
        if (sApplicationContext == null)
        {
            throw new IllegalStateException("Context was not set.  Have you called TargetLibrary.initialize()?");
        } else
        {
            return sApplicationContext;
        }
    }

    static 
    {
        sMockLocationMode = b.OutOfStore;
    }
}
