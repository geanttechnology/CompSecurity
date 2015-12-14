// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.text.TextUtils;
import java.util.Arrays;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            ReflectionHelper, GenericUtils

private static class mParamTypes
{

    private final Class mClass;
    private final String mMethodName;
    private final Class mParamTypes[];

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj == null || getClass() != obj.getClass())
            {
                return false;
            }
            obj = (mParamTypes)obj;
            if (!TextUtils.equals(mMethodName, ((mMethodName) (obj)).mMethodName) || !Arrays.equals(mParamTypes, ((mParamTypes) (obj)).mParamTypes) || !GenericUtils.equals(mClass, ((mClass) (obj)).mClass))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int j = 0;
        int i;
        if (mClass == null)
        {
            i = 0;
        } else
        {
            i = mClass.hashCode();
        }
        if (mMethodName != null)
        {
            j = mMethodName.hashCode();
        }
        return ((i + 31) * 31 + j) * 31 + Arrays.hashCode(mParamTypes);
    }

    public transient (Class class1, String s, Class aclass[])
    {
        mClass = class1;
        mMethodName = s;
        mParamTypes = aclass;
    }
}
