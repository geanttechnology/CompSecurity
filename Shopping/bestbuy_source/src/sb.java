// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.reflect.Field;

public final class sb extends rz
{

    private final Object a;

    private sb(Object obj)
    {
        a = obj;
    }

    public static Object a(ry ry1)
    {
        if (ry1 instanceof sb)
        {
            return ((sb)ry1).a;
        }
        ry1 = ry1.asBinder();
        Field afield[] = ry1.getClass().getDeclaredFields();
        if (afield.length == 1)
        {
            Field field = afield[0];
            if (!field.isAccessible())
            {
                field.setAccessible(true);
                try
                {
                    ry1 = ((ry) (field.get(ry1)));
                }
                // Misplaced declaration of an exception variable
                catch (ry ry1)
                {
                    throw new IllegalArgumentException("Binder object is null.", ry1);
                }
                // Misplaced declaration of an exception variable
                catch (ry ry1)
                {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", ry1);
                }
                // Misplaced declaration of an exception variable
                catch (ry ry1)
                {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", ry1);
                }
                return ry1;
            } else
            {
                throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly one declared *private* field for the wrapped object. Preferably, this is an instance of the ObjectWrapper<T> class.");
            }
        } else
        {
            throw new IllegalArgumentException("The concrete class implementing IObjectWrapper must have exactly *one* declared private field for the wrapped object.  Preferably, this is an instance of the ObjectWrapper<T> class.");
        }
    }

    public static ry a(Object obj)
    {
        return new sb(obj);
    }
}
