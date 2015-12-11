// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.annotation;


public abstract class ObjectIdGenerator
{
    public static final class IdKey
    {

        private final int hashCode;
        private final Object key;
        private final Class scope;
        private final Class type;

        public boolean equals(Object obj)
        {
            if (obj != this)
            {
                if (obj == null)
                {
                    return false;
                }
                if (obj.getClass() != getClass())
                {
                    return false;
                }
                obj = (IdKey)obj;
                if (!((IdKey) (obj)).key.equals(key) || ((IdKey) (obj)).type != type || ((IdKey) (obj)).scope != scope)
                {
                    return false;
                }
            }
            return true;
        }

        public int hashCode()
        {
            return hashCode;
        }

        public IdKey(Class class1, Class class2, Object obj)
        {
            type = class1;
            scope = class2;
            key = obj;
            int j = obj.hashCode() + class1.getName().hashCode();
            int i = j;
            if (class2 != null)
            {
                i = j ^ class2.getName().hashCode();
            }
            hashCode = i;
        }
    }


    public ObjectIdGenerator()
    {
    }

    public abstract boolean canUseFor(ObjectIdGenerator objectidgenerator);

    public abstract ObjectIdGenerator forScope(Class class1);

    public abstract Object generateId(Object obj);

    public abstract Class getScope();

    public abstract IdKey key(Object obj);

    public abstract ObjectIdGenerator newForSerialization(Object obj);
}
