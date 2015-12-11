// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.a.a.a;

import java.lang.reflect.Field;

// Referenced classes of package com.google.android.a.a.a:
//            v

public final class w extends v.a
{

    private final Object a;

    private w(Object obj)
    {
        a = obj;
    }

    public static v a(Object obj)
    {
        return new w(obj);
    }

    public static Object a(v v1)
    {
        if (v1 instanceof w)
        {
            return ((w)v1).a;
        }
        v1 = v1.asBinder();
        Field afield[] = v1.getClass().getDeclaredFields();
        if (afield.length == 1)
        {
            Field field = afield[0];
            if (!field.isAccessible())
            {
                field.setAccessible(true);
                try
                {
                    v1 = ((v) (field.get(v1)));
                }
                // Misplaced declaration of an exception variable
                catch (v v1)
                {
                    throw new IllegalArgumentException("Binder object is null.", v1);
                }
                // Misplaced declaration of an exception variable
                catch (v v1)
                {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", v1);
                }
                // Misplaced declaration of an exception variable
                catch (v v1)
                {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", v1);
                }
                return v1;
            } else
            {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
        } else
        {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
    }
}
