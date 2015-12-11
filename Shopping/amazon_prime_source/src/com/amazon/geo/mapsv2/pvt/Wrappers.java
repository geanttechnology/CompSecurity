// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import com.amazon.geo.mapsv2.internal.IObjectDelegate;

public class Wrappers
{
    public static interface WrapperCreator
    {

        public abstract Object newWrapper(IObjectDelegate iobjectdelegate);
    }


    public Wrappers()
    {
    }

    public static Object create(IObjectDelegate iobjectdelegate, WrapperCreator wrappercreator)
    {
        Object obj;
        if (iobjectdelegate == null)
        {
            obj = null;
        } else
        {
            Object obj1 = iobjectdelegate.getWrapper();
            obj = obj1;
            if (obj1 == null)
            {
                return wrappercreator.newWrapper(iobjectdelegate);
            }
        }
        return obj;
    }

    public static Object unwrapAs(IObjectDelegate iobjectdelegate, Class class1)
    {
        if (iobjectdelegate == null)
        {
            return null;
        } else
        {
            return class1.cast(iobjectdelegate.getWrapper());
        }
    }
}
