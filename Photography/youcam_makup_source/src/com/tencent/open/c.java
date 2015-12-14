// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open;

import com.tencent.open.a.k;
import java.lang.reflect.Method;
import java.util.List;

// Referenced classes of package com.tencent.open:
//            b

public class c
{

    public c()
    {
    }

    public void a(String s, List list, b b1)
    {
        Object obj;
        Method amethod[];
        int i;
        int j;
        amethod = getClass().getDeclaredMethods();
        obj = null;
        j = amethod.length;
        i = 0;
_L12:
        Method method;
        method = obj;
        if (i < j)
        {
            method = amethod[i];
            if (!method.getName().equals(s) || method.getParameterTypes().length != list.size())
            {
                break MISSING_BLOCK_LABEL_572;
            }
        }
        if (method == null)
        {
            break MISSING_BLOCK_LABEL_559;
        }
        list.size();
        JVM INSTR tableswitch 0 5: default 568
    //                   0 258
    //                   1 272
    //                   2 296
    //                   3 330
    //                   4 374
    //                   5 428;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_428;
_L1:
        s = ((String) (method.invoke(this, new Object[] {
            list.get(0), list.get(1), list.get(2), list.get(3), list.get(4), list.get(5)
        })));
_L9:
        list = method.getReturnType();
        k.b("openSDK_LOG.JsBridge", (new StringBuilder()).append("-->call, result: ").append(s).append(" | ReturnType: ").append(list.getName()).toString());
          goto _L8
_L2:
        s = ((String) (method.invoke(this, new Object[0])));
          goto _L9
_L3:
        s = ((String) (method.invoke(this, new Object[] {
            list.get(0)
        })));
          goto _L9
_L4:
        s = ((String) (method.invoke(this, new Object[] {
            list.get(0), list.get(1)
        })));
          goto _L9
_L5:
        s = ((String) (method.invoke(this, new Object[] {
            list.get(0), list.get(1), list.get(2)
        })));
          goto _L9
_L6:
        s = ((String) (method.invoke(this, new Object[] {
            list.get(0), list.get(1), list.get(2), list.get(3)
        })));
          goto _L9
        s = ((String) (method.invoke(this, new Object[] {
            list.get(0), list.get(1), list.get(2), list.get(3), list.get(4)
        })));
          goto _L9
_L8:
        if ("void".equals(list.getName()) || list == java/lang/Void)
        {
            if (b1 == null)
            {
                break MISSING_BLOCK_LABEL_571;
            }
            try
            {
                b1.a(null);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                k.b("openSDK_LOG.JsBridge", (new StringBuilder()).append("-->handler call mehtod ex. targetMethod: ").append(method).toString(), s);
            }
            if (b1 != null)
            {
                b1.a();
                return;
            }
            break MISSING_BLOCK_LABEL_571;
        }
        if (b1 == null)
        {
            break MISSING_BLOCK_LABEL_571;
        }
        if (!a())
        {
            break MISSING_BLOCK_LABEL_571;
        }
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_554;
        }
        s = s.toString();
_L10:
        b1.a(s);
        return;
        s = null;
          goto _L10
        if (b1 != null)
        {
            b1.a();
            return;
        }
        return;
        i++;
        if (true) goto _L12; else goto _L11
_L11:
    }

    public boolean a()
    {
        return false;
    }
}
