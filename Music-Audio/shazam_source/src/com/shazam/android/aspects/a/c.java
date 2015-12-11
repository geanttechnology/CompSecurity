// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aspects.a;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.shazam.android.aspects.a:
//            a

public final class c
    implements a
{

    private Class a;

    public c(Class class1)
    {
        a = class1;
    }

    private void a(Class class1, List list, Set set)
    {
        do
        {
            b(class1, list, set);
            if (class1.getSuperclass() != null)
            {
                class1 = class1.getSuperclass();
            } else
            {
                return;
            }
        } while (true);
    }

    private void b(Class class1, List list, Set set)
    {
        class1 = class1.getAnnotations();
        int j = class1.length;
        int i = 0;
        while (i < j) 
        {
            Annotation annotation = class1[i];
            Class class2 = annotation.annotationType();
            if (a.isAssignableFrom(class2))
            {
                list.add(annotation);
            } else
            if (!set.contains(class2))
            {
                set.add(class2);
                b(class2, list, set);
            }
            i++;
        }
    }

    public final List a(Object obj)
    {
        ArrayList arraylist = new ArrayList();
        HashSet hashset = new HashSet();
        a(obj.getClass(), ((List) (arraylist)), ((Set) (hashset)));
        return arraylist;
    }
}
