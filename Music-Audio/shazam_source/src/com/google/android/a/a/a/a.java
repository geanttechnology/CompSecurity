// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import android.app.Activity;
import android.content.Context;

// Referenced classes of package com.google.android.a.a.a:
//            c, d, f

public abstract class a
{

    private static final a a = b();

    public a()
    {
    }

    public static a a()
    {
        return a;
    }

    private static a b()
    {
        Object obj = Class.forName("com.google.android.youtube.api.locallylinked.LocallyLinkedFactory").asSubclass(com/google/android/a/a/a/a);
        obj = (a)((Class) (obj)).newInstance();
        return ((a) (obj));
        Object obj1;
        obj1;
        try
        {
            throw new IllegalStateException(((Throwable) (obj1)));
        }
        // Misplaced declaration of an exception variable
        catch (Object obj1)
        {
            return new c();
        }
        obj1;
        throw new IllegalStateException(((Throwable) (obj1)));
    }

    public abstract d a(Context context, String s, u.a a1, u.b b1);

    public abstract f a(Activity activity, d d, boolean flag);

}
