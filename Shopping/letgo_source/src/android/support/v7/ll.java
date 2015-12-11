// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.lang.reflect.Field;

// Referenced classes of package android.support.v7:
//            lk

public final class ll extends lk.a
{

    private final Object a;

    private ll(Object obj)
    {
        a = obj;
    }

    public static lk a(Object obj)
    {
        return new ll(obj);
    }

    public static Object a(lk lk1)
    {
        if (lk1 instanceof ll)
        {
            return ((ll)lk1).a;
        }
        lk1 = lk1.asBinder();
        Field afield[] = lk1.getClass().getDeclaredFields();
        if (afield.length == 1)
        {
            Field field = afield[0];
            if (!field.isAccessible())
            {
                field.setAccessible(true);
                try
                {
                    lk1 = ((lk) (field.get(lk1)));
                }
                // Misplaced declaration of an exception variable
                catch (lk lk1)
                {
                    throw new IllegalArgumentException("Binder object is null.", lk1);
                }
                // Misplaced declaration of an exception variable
                catch (lk lk1)
                {
                    throw new IllegalArgumentException("remoteBinder is the wrong class.", lk1);
                }
                // Misplaced declaration of an exception variable
                catch (lk lk1)
                {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", lk1);
                }
                return lk1;
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
