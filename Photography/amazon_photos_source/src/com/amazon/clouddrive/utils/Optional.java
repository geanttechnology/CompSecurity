// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.utils;


public abstract class Optional
{
    private static final class None extends Optional
    {

        public Object get()
        {
            return null;
        }

        private None()
        {
            super(false);
        }

    }

    private static final class Some extends Optional
    {

        private final Object item;

        public boolean equals(Object obj)
        {
            if (this != obj) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (Some)obj;
            if (item == null) goto _L4; else goto _L3
_L3:
            if (item.equals(((Some) (obj)).item)) goto _L1; else goto _L5
_L5:
            return false;
_L4:
            if (((Some) (obj)).item == null)
            {
                return true;
            }
            if (true) goto _L5; else goto _L6
_L6:
        }

        public Object get()
        {
            return item;
        }

        public int hashCode()
        {
            if (item != null)
            {
                return item.hashCode();
            } else
            {
                return 0;
            }
        }

        private Some(Object obj)
        {
            super(true);
            item = obj;
        }

    }


    private static final Optional NONE = new None();
    private final boolean mHasValue;

    Optional(boolean flag)
    {
        mHasValue = flag;
    }

    public static Optional absent()
    {
        return NONE;
    }

    public static Optional fromNullable(Object obj)
    {
        if (obj == null)
        {
            return absent();
        } else
        {
            return new Some(obj);
        }
    }

    public static Optional of(Object obj)
    {
        return new Some(obj);
    }

    public abstract Object get();

    public final boolean isPresent()
    {
        return mHasValue;
    }

}
