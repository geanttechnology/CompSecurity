// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.mediation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.sponsorpay.mediation:
//            SPMediationAdapter

class val.args extends Thread
{

    final SPMediationAdapter this$0;
    private final Object val$args[];
    private final Class val$classes[];
    private final String val$methodName;

    public void run()
    {
        Iterator iterator = getListeners().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                return;
            }
            Object obj = iterator.next();
            try
            {
                obj.getClass().getDeclaredMethod(val$methodName, val$classes).invoke(obj, val$args);
            }
            catch (SecurityException securityexception) { }
            catch (NoSuchMethodException nosuchmethodexception) { }
            catch (IllegalArgumentException illegalargumentexception) { }
            catch (IllegalAccessException illegalaccessexception) { }
            catch (InvocationTargetException invocationtargetexception) { }
        } while (true);
    }

    (Object aobj[])
    {
        this$0 = final_spmediationadapter;
        val$methodName = s1;
        val$classes = _5B_Ljava.lang.Class_3B_.this;
        val$args = aobj;
        super(final_s);
    }
}
