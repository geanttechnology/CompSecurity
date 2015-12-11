// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.google.gson.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import shared_presage.com.google.gson.InstanceCreator;
import shared_presage.com.google.gson.reflect.TypeToken;

// Referenced classes of package shared_presage.com.google.gson.internal:
//            f, g, h, i, 
//            j, k, l, b, 
//            c, d, a, e, 
//            ObjectConstructor

public final class ConstructorConstructor
{

    private final Map instanceCreators;

    public ConstructorConstructor(Map map)
    {
        instanceCreators = map;
    }

    private ObjectConstructor newDefaultConstructor(Class class1)
    {
        try
        {
            class1 = class1.getDeclaredConstructor(new Class[0]);
            if (!class1.isAccessible())
            {
                class1.setAccessible(true);
            }
            class1 = new f(this, class1);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    private ObjectConstructor newDefaultImplementationConstructor(Type type, Class class1)
    {
        if (java/util/Collection.isAssignableFrom(class1))
        {
            if (java/util/SortedSet.isAssignableFrom(class1))
            {
                return new g(this);
            }
            if (java/util/EnumSet.isAssignableFrom(class1))
            {
                return new h(this, type);
            }
            if (java/util/Set.isAssignableFrom(class1))
            {
                return new i(this);
            }
            if (java/util/Queue.isAssignableFrom(class1))
            {
                return new j(this);
            } else
            {
                return new k(this);
            }
        }
        if (java/util/Map.isAssignableFrom(class1))
        {
            if (java/util/SortedMap.isAssignableFrom(class1))
            {
                return new l(this);
            }
            if ((type instanceof ParameterizedType) && !java/lang/String.isAssignableFrom(TypeToken.get(((ParameterizedType)type).getActualTypeArguments()[0]).getRawType()))
            {
                return new b(this);
            } else
            {
                return new c(this);
            }
        } else
        {
            return null;
        }
    }

    private ObjectConstructor newUnsafeAllocator(Type type, Class class1)
    {
        return new d(this, class1, type);
    }

    public final ObjectConstructor get(TypeToken typetoken)
    {
        Type type = typetoken.getType();
        Class class1 = typetoken.getRawType();
        typetoken = (InstanceCreator)instanceCreators.get(type);
        if (typetoken != null)
        {
            typetoken = new a(this, typetoken, type);
        } else
        {
            typetoken = (InstanceCreator)instanceCreators.get(class1);
            if (typetoken != null)
            {
                return new e(this, typetoken, type);
            }
            ObjectConstructor objectconstructor = newDefaultConstructor(class1);
            typetoken = objectconstructor;
            if (objectconstructor == null)
            {
                ObjectConstructor objectconstructor1 = newDefaultImplementationConstructor(type, class1);
                typetoken = objectconstructor1;
                if (objectconstructor1 == null)
                {
                    return newUnsafeAllocator(type, class1);
                }
            }
        }
        return typetoken;
    }

    public final String toString()
    {
        return instanceCreators.toString();
    }
}
