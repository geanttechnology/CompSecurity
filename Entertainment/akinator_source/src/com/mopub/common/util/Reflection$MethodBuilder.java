// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.mopub.common.util:
//            Reflection

public static class mClass
{

    private Class mClass;
    private final Object mInstance;
    private boolean mIsAccessible;
    private boolean mIsStatic;
    private final String mMethodName;
    private List mParameterClasses;
    private List mParameters;

    public mClass addParam(Class class1, Object obj)
    {
        mParameterClasses.add(class1);
        mParameters.add(obj);
        return this;
    }

    public Object execute()
        throws Exception
    {
        Class aclass[] = new Class[mParameterClasses.size()];
        aclass = (Class[])mParameterClasses.toArray(aclass);
        Method method = Reflection.getDeclaredMethodWithTraversal(mClass, mMethodName, aclass);
        if (mIsAccessible)
        {
            method.setAccessible(true);
        }
        Object aobj[] = mParameters.toArray();
        if (mIsStatic)
        {
            return method.invoke(null, aobj);
        } else
        {
            return method.invoke(mInstance, aobj);
        }
    }

    public mInstance setAccessible()
    {
        mIsAccessible = true;
        return this;
    }

    public mIsAccessible setStatic(Class class1)
    {
        mIsStatic = true;
        mClass = class1;
        return this;
    }

    public (Object obj, String s)
    {
        mInstance = obj;
        mMethodName = s;
        mParameterClasses = new ArrayList();
        mParameters = new ArrayList();
        if (obj != null)
        {
            obj = obj.getClass();
        } else
        {
            obj = null;
        }
        mClass = ((Class) (obj));
    }
}
