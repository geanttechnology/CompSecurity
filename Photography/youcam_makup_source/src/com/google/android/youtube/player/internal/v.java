// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.youtube.player.internal;

import java.lang.reflect.Field;

// Referenced classes of package com.google.android.youtube.player.internal:
//            u

public final class v extends u.a
{

    private final Object a;

    private v(Object obj)
    {
        a = obj;
    }

    public static u a(Object obj)
    {
        return new v(obj);
    }

    public static Object a(u u1)
    {
        if (u1 instanceof v)
        {
            return ((v)u1).a;
        }
        u1 = u1.asBinder();
        Field afield[] = u1.getClass().getDeclaredFields();
        if (afield.length == 1)
        {
            Field field = afield[0];
            if (!field.isAccessible())
            {
                field.setAccessible(true);
                try
                {
                    u1 = ((u) (field.get(u1)));
                }
                // Misplaced declaration of an exception variable
                catch (u u1)
                {
                    throw new IllegalArgumentException("Binder object is null.", u1);
                }
                // Misplaced declaration of an exception variable
                catch (u u1)
                {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", u1);
                }
                // Misplaced declaration of an exception variable
                catch (u u1)
                {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", u1);
                }
                return u1;
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
