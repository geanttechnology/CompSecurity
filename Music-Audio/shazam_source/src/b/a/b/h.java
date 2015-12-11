// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.b;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package b.a.b:
//            i

public final class h
{

    private i a;

    public h()
    {
        a = new i();
    }

    static void a(Object obj, Class class1)
    {
        class1 = i.a(obj.getClass(), class1);
        int k = class1.length;
        int j = 0;
        while (j < k) 
        {
            Method method = class1[j];
            try
            {
                method.invoke(obj, new Object[0]);
            }
            catch (IllegalAccessException illegalaccessexception)
            {
                illegalaccessexception.printStackTrace();
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                invocationtargetexception.printStackTrace();
            }
            j++;
        }
    }
}
