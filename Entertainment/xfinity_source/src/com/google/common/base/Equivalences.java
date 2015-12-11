// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.base;

import java.io.Serializable;

// Referenced classes of package com.google.common.base:
//            Equivalence

public final class Equivalences
{
    private static final class Equals extends Equivalence
        implements Serializable
    {

        static final Equals INSTANCE = new Equals();

        private Object readResolve()
        {
            return INSTANCE;
        }

        protected boolean doEquivalent(Object obj, Object obj1)
        {
            return obj.equals(obj1);
        }

        public int doHash(Object obj)
        {
            return obj.hashCode();
        }


        private Equals()
        {
        }
    }

    private static final class Identity extends Equivalence
        implements Serializable
    {

        static final Identity INSTANCE = new Identity();

        private Object readResolve()
        {
            return INSTANCE;
        }

        protected boolean doEquivalent(Object obj, Object obj1)
        {
            return false;
        }

        protected int doHash(Object obj)
        {
            return System.identityHashCode(obj);
        }


        private Identity()
        {
        }
    }


    public static Equivalence equals()
    {
        return Equals.INSTANCE;
    }

    public static Equivalence identity()
    {
        return Identity.INSTANCE;
    }
}
