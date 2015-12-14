// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.nuance.nmsp.client.sdk.oem;

import bm;
import cz;
import d;
import java.util.Vector;

public class EndPointerOEM
{
    public static final class a
    {

        public static final a a = new a(1);
        public static final a b = new a(2);
        public static final a c = new a(3);
        private int d;

        public static a a(int i)
        {
            if (b.d == i)
            {
                return b;
            }
            if (c.d == i)
            {
                return c;
            } else
            {
                return a;
            }
        }


        private a(int i)
        {
            d = 1;
            d = i;
        }
    }

    final class b
    {

        int a;
        int b;
        int c;
        int d;
        int e;
        int f;
        int g;
        int h;
        int i;

        private b()
        {
        }

        b(byte byte0)
        {
            this();
        }
    }


    private bm a;
    private boolean b;
    private b c;

    public EndPointerOEM()
    {
        a = d.a(getClass());
        b = false;
        c = new b((byte)0);
    }

    private static native int getCurrentEndPointerState();

    private static native void initializeEndPointer(int i, int j, int k, int l, int i1, int j1, int k1, int l1, 
            int i2);

    private static native int resetVad();

    public final a a()
    {
        if (b)
        {
            return a.a(getCurrentEndPointerState());
        } else
        {
            return a.a;
        }
    }

    public final void a(Vector vector)
    {
        boolean flag = false;
        c.a = 0;
        c.b = 0;
        c.c = 50;
        c.d = 15;
        c.e = 7;
        c.g = 50;
        c.h = 5;
        c.i = 35;
        c.f = 0;
        if (vector != null)
        {
            int i = 0;
            while (i < vector.size()) 
            {
                Object obj = (cz)vector.get(i);
                String s = ((cz) (obj)).a();
                if (s.equals("ep.enable"))
                {
                    if ((new String(((cz) (obj)).b())).equalsIgnoreCase("TRUE"))
                    {
                        if (a.b())
                        {
                            a.b("Stop on end of speech is activated.");
                        }
                        c.a = 1;
                    }
                } else
                if (s.equals("ep.VadLongUtterance"))
                {
                    if ((new String(((cz) (obj)).b())).equalsIgnoreCase("TRUE"))
                    {
                        c.b = 1;
                    }
                } else
                if (s.equals("ep.VadHistoryLength"))
                {
                    obj = new String(((cz) (obj)).b());
                    c.c = Integer.parseInt(((String) (obj)));
                } else
                if (s.equals("ep.VadBeginLength"))
                {
                    obj = new String(((cz) (obj)).b());
                    c.d = Integer.parseInt(((String) (obj)));
                } else
                if (s.equals("ep.VadBeginThreshold"))
                {
                    obj = new String(((cz) (obj)).b());
                    c.e = Integer.parseInt(((String) (obj)));
                } else
                if (s.equals("ep.VadEndLength"))
                {
                    obj = new String(((cz) (obj)).b());
                    c.g = Integer.parseInt(((String) (obj)));
                } else
                if (s.equals("ep.VadEndThreshold"))
                {
                    obj = new String(((cz) (obj)).b());
                    c.h = Integer.parseInt(((String) (obj)));
                } else
                if (s.equals("ep.VadInterSpeechLength"))
                {
                    obj = new String(((cz) (obj)).b());
                    c.i = Integer.parseInt(((String) (obj)));
                } else
                if (s.equals("ep.VadBeginDelay"))
                {
                    obj = new String(((cz) (obj)).b());
                    c.f = Integer.parseInt(((String) (obj)));
                }
                i++;
            }
        }
        if (c.a == 1)
        {
            flag = true;
        }
        b = flag;
        if (b)
        {
            initializeEndPointer(c.a, c.b, c.c, c.d, c.e, c.f, c.g, c.h, c.i);
            b();
        }
    }

    public final void b()
    {
        if (b)
        {
            resetVad();
        }
    }
}
