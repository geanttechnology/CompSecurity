// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.b;

import com.shazam.android.aspects.a.b;
import com.shazam.android.aspects.a.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.shazam.android.aspects.b:
//            c, b

public final class a
    implements com.shazam.android.aspects.b.c
{

    private Object a;
    private Class b;
    private com.shazam.android.aspects.a.a c;
    private Class d;

    private a(Object obj, Class class1, com.shazam.android.aspects.a.a a1, Class class2)
    {
        a = obj;
        b = class1;
        c = a1;
        d = class2;
    }

    public static com.shazam.android.aspects.b.c a(Object obj, Class class1, Class class2)
    {
        return new a(obj, class1, new c(com/shazam/android/aspects/a/b), class2);
    }

    public final Collection a()
    {
        Object obj = new ArrayList();
        for (Iterator iterator = c.a(a).iterator(); iterator.hasNext();)
        {
            Class aclass[] = ((b)iterator.next()).a();
            int j = aclass.length;
            int i = 0;
            while (i < j) 
            {
                Class class1 = aclass[i];
                if (b.isAssignableFrom(class1))
                {
                    try
                    {
                        com.shazam.android.aspects.b.b b1 = (com.shazam.android.aspects.b.b)class1.newInstance();
                        if (b1.classActingOn().isAssignableFrom(d))
                        {
                            ((Collection) (obj)).add(b1);
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (Object obj)
                    {
                        throw new IllegalArgumentException((new StringBuilder("Could not instantiate all aspects (specifically ")).append(class1).append(").").toString(), ((Throwable) (obj)));
                    }
                }
                i++;
            }
        }

        return ((Collection) (obj));
    }
}
