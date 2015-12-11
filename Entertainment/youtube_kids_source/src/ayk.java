// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.lang.reflect.Field;

public final class ayk extends ayi
{

    private final Object a;

    private ayk(Object obj)
    {
        a = obj;
    }

    public static ayh a(Object obj)
    {
        return new ayk(obj);
    }

    public static Object a(ayh ayh1)
    {
        if (ayh1 instanceof ayk)
        {
            return ((ayk)ayh1).a;
        }
        ayh1 = ayh1.asBinder();
        Field afield[] = ayh1.getClass().getDeclaredFields();
        if (afield.length == 1)
        {
            Field field = afield[0];
            if (!field.isAccessible())
            {
                field.setAccessible(true);
                try
                {
                    ayh1 = ((ayh) (field.get(ayh1)));
                }
                // Misplaced declaration of an exception variable
                catch (ayh ayh1)
                {
                    throw new IllegalArgumentException("Binder object is null.", ayh1);
                }
                // Misplaced declaration of an exception variable
                catch (ayh ayh1)
                {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", ayh1);
                }
                // Misplaced declaration of an exception variable
                catch (ayh ayh1)
                {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", ayh1);
                }
                return ayh1;
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
