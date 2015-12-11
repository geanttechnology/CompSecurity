// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package de.greenrobot.event;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

// Referenced classes of package de.greenrobot.event:
//            SubscriberIndex, EventBus, Subscribe, SubscriberMethod, 
//            EventBusException

class SubscriberMethodFinder
{

    private static final int BRIDGE = 64;
    private static final SubscriberIndex INDEX;
    private static final Map METHOD_CACHE = new HashMap();
    private static final int MODIFIERS_IGNORE = 5192;
    private static final int SYNTHETIC = 4096;
    private final boolean strictMethodVerification;

    SubscriberMethodFinder(boolean flag)
    {
        strictMethodVerification = flag;
    }

    static void clearCaches()
    {
        synchronized (METHOD_CACHE)
        {
            METHOD_CACHE.clear();
        }
        return;
        exception;
        map;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private List findSubscriberMethodsWithIndex(Class class1)
    {
        do
        {
label0:
            {
label1:
                {
                    if (class1 != null)
                    {
                        SubscriberMethod asubscribermethod[] = INDEX.getSubscribersFor(class1);
                        if (asubscribermethod != null && asubscribermethod.length > 0)
                        {
                            ArrayList arraylist = new ArrayList();
                            int j = asubscribermethod.length;
                            int i = 0;
                            do
                            {
                                class1 = arraylist;
                                if (i >= j)
                                {
                                    break;
                                }
                                arraylist.add(asubscribermethod[i]);
                                i++;
                            } while (true);
                            break label1;
                        }
                        String s = class1.getName();
                        if (!s.startsWith("java.") && !s.startsWith("javax.") && !s.startsWith("android."))
                        {
                            break label0;
                        }
                    }
                    class1 = Collections.EMPTY_LIST;
                }
                return class1;
            }
            class1 = class1.getSuperclass();
        } while (true);
    }

    private List findSubscriberMethodsWithReflection(Class class1)
    {
        ArrayList arraylist;
        HashSet hashset;
        StringBuilder stringbuilder;
        arraylist = new ArrayList();
        hashset = new HashSet();
        stringbuilder = new StringBuilder();
_L10:
        String s;
        Method amethod[];
        int i;
        int j;
label0:
        {
            if (class1 != null)
            {
                s = class1.getName();
                if (!s.startsWith("java.") && !s.startsWith("javax.") && !s.startsWith("android."))
                {
                    break label0;
                }
            }
            return arraylist;
        }
        amethod = class1.getDeclaredMethods();
        j = amethod.length;
        i = 0;
_L5:
        Method method;
        int k;
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_409;
        }
        method = amethod[i];
        k = method.getModifiers();
        if ((k & 1) == 0 || (k & 0x1448) != 0) goto _L2; else goto _L1
_L1:
        Object obj = method.getParameterTypes();
        if (obj.length != 1) goto _L4; else goto _L3
_L3:
        Subscribe subscribe = (Subscribe)method.getAnnotation(de/greenrobot/event/Subscribe);
        if (subscribe != null)
        {
            String s1 = method.getName();
            obj = obj[0];
            stringbuilder.setLength(0);
            stringbuilder.append(s1);
            stringbuilder.append('>').append(((Class) (obj)).getName());
            if (hashset.add(stringbuilder.toString()))
            {
                arraylist.add(new SubscriberMethod(method, ((Class) (obj)), subscribe.threadMode(), subscribe.priority(), subscribe.sticky()));
            }
        }
_L7:
        i++;
          goto _L5
_L4:
        if (!strictMethodVerification || !method.isAnnotationPresent(de/greenrobot/event/Subscribe)) goto _L7; else goto _L6
_L6:
        class1 = (new StringBuilder()).append(s).append(".").append(method.getName()).toString();
        throw new EventBusException((new StringBuilder()).append("@Subscribe method ").append(class1).append("must have exactly 1 parameter but has ").append(obj.length).toString());
_L2:
        if (!strictMethodVerification || !method.isAnnotationPresent(de/greenrobot/event/Subscribe)) goto _L7; else goto _L8
_L8:
        class1 = (new StringBuilder()).append(s).append(".").append(method.getName()).toString();
        throw new EventBusException((new StringBuilder()).append(class1).append(" is a illegal @Subscribe method: must be public, non-static, and non-abstract").toString());
        class1 = class1.getSuperclass();
        if (true) goto _L10; else goto _L9
_L9:
    }

    List findSubscriberMethods(Class class1, boolean flag)
    {
        String s;
        s = class1.getName();
        List list1;
        synchronized (METHOD_CACHE)
        {
            list1 = (List)METHOD_CACHE.get(s);
        }
        if (list1 != null)
        {
            return list1;
        }
        break MISSING_BLOCK_LABEL_42;
        class1;
        map;
        JVM INSTR monitorexit ;
        throw class1;
        List list;
        if (INDEX != null && !flag)
        {
            List list2 = findSubscriberMethodsWithIndex(class1);
            list = list2;
            if (list2.isEmpty())
            {
                list = findSubscriberMethodsWithReflection(class1);
            }
        } else
        {
            list = findSubscriberMethodsWithReflection(class1);
        }
        if (list.isEmpty())
        {
            throw new EventBusException((new StringBuilder()).append("Subscriber ").append(class1).append(" and its super classes have no public methods with the @Subscribe annotation").toString());
        }
        synchronized (METHOD_CACHE)
        {
            METHOD_CACHE.put(s, list);
        }
        return list;
        exception;
        class1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static 
    {
        SubscriberIndex subscriberindex;
        try
        {
            subscriberindex = (SubscriberIndex)Class.forName("de.greenrobot.event.GeneratedSubscriberIndex").newInstance();
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            Log.d(EventBus.TAG, "No subscriber index available, reverting to dynamic look-up");
            classnotfoundexception = null;
        }
        catch (Exception exception)
        {
            Log.w(EventBus.TAG, "Could not init subscriber index, reverting to dynamic look-up", exception);
            exception = null;
        }
        INDEX = subscriberindex;
    }
}
