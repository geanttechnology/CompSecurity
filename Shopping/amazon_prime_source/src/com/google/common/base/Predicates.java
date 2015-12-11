// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.Serializable;
import java.util.Collection;

// Referenced classes of package com.google.common.base:
//            Joiner, Predicate, Preconditions

public final class Predicates
{
    private static class InPredicate
        implements Predicate, Serializable
    {

        private final Collection target;

        public boolean apply(Object obj)
        {
            boolean flag;
            try
            {
                flag = target.contains(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                return false;
            }
            return flag;
        }

        public boolean equals(Object obj)
        {
            if (obj instanceof InPredicate)
            {
                obj = (InPredicate)obj;
                return target.equals(((InPredicate) (obj)).target);
            } else
            {
                return false;
            }
        }

        public int hashCode()
        {
            return target.hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append("In(").append(target).append(")").toString();
        }

        private InPredicate(Collection collection)
        {
            target = (Collection)Preconditions.checkNotNull(collection);
        }

    }

    private static class IsEqualToPredicate
        implements Predicate, Serializable
    {

        private final Object target;

        public boolean apply(Object obj)
        {
            return target.equals(obj);
        }

        public boolean equals(Object obj)
        {
            if (obj instanceof IsEqualToPredicate)
            {
                obj = (IsEqualToPredicate)obj;
                return target.equals(((IsEqualToPredicate) (obj)).target);
            } else
            {
                return false;
            }
        }

        public int hashCode()
        {
            return target.hashCode();
        }

        public String toString()
        {
            return (new StringBuilder()).append("IsEqualTo(").append(target).append(")").toString();
        }

        private IsEqualToPredicate(Object obj)
        {
            target = obj;
        }

    }

    static abstract class ObjectPredicate extends Enum
        implements Predicate
    {

        private static final ObjectPredicate $VALUES[];
        public static final ObjectPredicate ALWAYS_FALSE;
        public static final ObjectPredicate ALWAYS_TRUE;
        public static final ObjectPredicate IS_NULL;
        public static final ObjectPredicate NOT_NULL;

        public static ObjectPredicate valueOf(String s)
        {
            return (ObjectPredicate)Enum.valueOf(com/google/common/base/Predicates$ObjectPredicate, s);
        }

        public static ObjectPredicate[] values()
        {
            return (ObjectPredicate[])$VALUES.clone();
        }

        Predicate withNarrowedType()
        {
            return this;
        }

        static 
        {
            ALWAYS_TRUE = new ObjectPredicate("ALWAYS_TRUE", 0) {

                public boolean apply(Object obj)
                {
                    return true;
                }

            };
            ALWAYS_FALSE = new ObjectPredicate("ALWAYS_FALSE", 1) {

                public boolean apply(Object obj)
                {
                    return false;
                }

            };
            IS_NULL = new ObjectPredicate("IS_NULL", 2) {

                public boolean apply(Object obj)
                {
                    return obj == null;
                }

            };
            NOT_NULL = new ObjectPredicate("NOT_NULL", 3) {

                public boolean apply(Object obj)
                {
                    return obj != null;
                }

            };
            $VALUES = (new ObjectPredicate[] {
                ALWAYS_TRUE, ALWAYS_FALSE, IS_NULL, NOT_NULL
            });
        }

        private ObjectPredicate(String s, int i)
        {
            super(s, i);
        }

    }


    private static final Joiner COMMA_JOINER = Joiner.on(",");

    private Predicates()
    {
    }

    public static Predicate equalTo(Object obj)
    {
        if (obj == null)
        {
            return isNull();
        } else
        {
            return new IsEqualToPredicate(obj);
        }
    }

    public static Predicate in(Collection collection)
    {
        return new InPredicate(collection);
    }

    public static Predicate isNull()
    {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

}
