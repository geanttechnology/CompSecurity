// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.ads;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package io.presage.ads:
//            h, NewAdController, NewAd, NewAdViewerDescriptor

public final class g
{
    public static final class a
    {

        private int a;
        private Class b;

        public final NewAdController a(Context context, NewAd newad, NewAdViewerDescriptor newadviewerdescriptor)
        {
            context = (NewAdController)b.getConstructor(new Class[] {
                android/content/Context, io/presage/ads/NewAd, io/presage/ads/NewAdViewerDescriptor, Integer.TYPE
            }).newInstance(new Object[] {
                context, newad, newadviewerdescriptor, Integer.valueOf(a)
            });
            return context;
            context;
            context.printStackTrace();
_L2:
            return null;
            context;
            context.printStackTrace();
            continue; /* Loop/switch isn't completed */
            context;
            context.printStackTrace();
            continue; /* Loop/switch isn't completed */
            context;
            context.printStackTrace();
            if (true) goto _L2; else goto _L1
_L1:
        }

        public final a a(int i)
        {
            a = a | i;
            return this;
        }

        private a(Class class1)
        {
            b = class1;
        }

        a(Class class1, byte byte0)
        {
            this(class1);
        }
    }


    private static final Map a = new h();
    private static g b;

    private g()
    {
    }

    public static a a(String s)
    {
        if (!a.containsKey(s))
        {
            return null;
        } else
        {
            return new a((Class)a.get(s), (byte)0);
        }
    }

    public static g a()
    {
        if (b == null)
        {
            b = new g();
        }
        return b;
    }

    public static String a(NewAdController newadcontroller)
    {
        for (Iterator iterator = a.keySet().iterator(); iterator.hasNext();)
        {
            String s = (String)iterator.next();
            if (newadcontroller.getClass().equals(a.get(s)))
            {
                return s;
            }
        }

        return null;
    }

}
