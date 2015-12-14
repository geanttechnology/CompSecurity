// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.frontia;

import android.content.Context;
import com.baidu.frontia.framework.IModule;
import java.lang.reflect.Method;

class a
{

    a()
    {
    }

    public static void a(Context context, String s)
    {
        String as[] = a();
        int i;
        if (as == null)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        i = 0;
_L1:
        if (i >= as.length)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        Object obj;
        obj = as[i];
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        if (((String) (obj)).length() <= 0)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        obj = Class.forName(((String) (obj)));
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        obj = ((Class) (obj)).getMethod("newInstance", new Class[] {
            android/content/Context
        });
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        obj = (IModule)((Method) (obj)).invoke(null, new Object[] {
            context
        });
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        ((IModule) (obj)).init(s);
        i++;
          goto _L1
        context;
    }

    public static String[] a()
    {
        return (new String[] {
            "com.baidu.frontia.api.FrontiaPush"
        });
    }
}
