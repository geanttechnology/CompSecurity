// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.actions;

import android.content.Context;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

// Referenced classes of package io.presage.actions:
//            k, NewAction

public final class j
{
    public static final class a
    {

        private Class a;

        public final NewAction a(Context context, String s)
        {
            context = (NewAction)a.getConstructor(new Class[] {
                android/content/Context, java/lang/String
            }).newInstance(new Object[] {
                context, s
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

        public final Class a()
        {
            return a;
        }

        private a(Class class1)
        {
            a = class1;
        }

        a(Class class1, byte byte0)
        {
            this(class1);
        }
    }


    private static final Map a = new k();
    private static j b;

    private j()
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

    public static j a()
    {
        if (b == null)
        {
            b = new j();
        }
        return b;
    }

}
