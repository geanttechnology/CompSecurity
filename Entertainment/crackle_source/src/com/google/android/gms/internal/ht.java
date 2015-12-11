// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.c;
import com.google.android.gms.plus.PlusOneDummyView;

// Referenced classes of package com.google.android.gms.internal:
//            hp, eg

public final class ht
{
    public static class a extends Exception
    {

        public a(String s)
        {
            super(s);
        }
    }


    private static Context Ci;
    private static hp DQ;

    public static View a(Context context, int i, int j, String s, int k)
    {
        if (s == null)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return new PlusOneDummyView(context, i);
            }
        }
        s = (View)c.b(x(context).a(c.h(context), i, j, s, k));
        return s;
    }

    public static View a(Context context, int i, int j, String s, String s1)
    {
        if (s == null)
        {
            try
            {
                throw new NullPointerException();
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return new PlusOneDummyView(context, i);
            }
        }
        s = (View)c.b(x(context).a(c.h(context), i, j, s, s1));
        return s;
    }

    private static hp x(Context context)
        throws a
    {
        eg.f(context);
        if (DQ == null)
        {
            if (Ci == null)
            {
                Ci = GooglePlayServicesUtil.getRemoteContext(context);
                if (Ci == null)
                {
                    throw new a("Could not get remote context.");
                }
            }
            context = Ci.getClassLoader();
            try
            {
                DQ = hp.a.av((IBinder)context.loadClass("com.google.android.gms.plus.plusone.PlusOneButtonCreatorImpl").newInstance());
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new a("Could not load creator class.");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new a("Could not instantiate creator.");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw new a("Could not access creator.");
            }
        }
        return DQ;
    }
}
