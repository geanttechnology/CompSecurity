// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.network.NetworkCircle;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CirclePager, g, CircleList

class e extends m
{

    final Long a;
    final CirclePager b;
    private final int c = 5000;
    private final int d = 1;
    private int e;

    protected void a()
    {
        a(0x80000005);
    }

    protected void a(int i)
    {
        if (i == 0x80000005) goto _L2; else goto _L1
_L1:
        int k;
        k = e;
        e = k + 1;
        if (k >= 1) goto _L2; else goto _L3
_L3:
        com.perfectcorp.utility.e.d(new Object[] {
            "listCircleByUser retry: code=", Integer.valueOf(i), ", retryCount=", Integer.valueOf(e), ", retryInterval=", Integer.valueOf(5000)
        });
        b.postDelayed(new Runnable(this) {

            final m a;
            final CirclePager._cls2 b;

            public void run()
            {
                NetworkCircle.a(b.a.longValue(), b.a.longValue()).a(a);
            }

            
            {
                b = CirclePager._cls2.this;
                a = m1;
                super();
            }
        }, 5000L);
_L5:
        return;
_L2:
        if (com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(b) != null)
        {
            com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(b).c();
            com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(b).a(i);
            return;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    protected void a(d d1)
    {
        if (d1 != null && d1.b != null) goto _L2; else goto _L1
_L1:
        a(0x80000003);
_L8:
        return;
_L2:
        Iterator iterator = d1.b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            CircleBasic circlebasic1 = (CircleBasic)iterator.next();
            if (circlebasic1 != null && "HOW-TO".equals(circlebasic1.defaultType))
            {
                iterator.remove();
                Integer integer = d1.a;
                d1.a = Integer.valueOf(d1.a.intValue() - 1);
            }
        } while (true);
        CirclePager.a(b, d1.a.intValue());
        if (CirclePager.a(b) != eateCircleBtnPos.b) goto _L4; else goto _L3
_L3:
        d1.b.add(0, null);
_L6:
        int l = CirclePager.b(b) * 2;
        int k = 0;
        for (int i = 0; k < d1.b.size(); i++)
        {
            CirclePager.c(b).put(Integer.valueOf(i), new ArrayList(d1.b.subList(k, Math.min(k + l, d1.b.size()))));
            k += l;
        }

        break; /* Loop/switch isn't completed */
_L4:
        if (CirclePager.a(b) == eateCircleBtnPos.c)
        {
            d1.b.add(null);
        }
        if (true) goto _L6; else goto _L5
_L5:
        if (com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(b) != null)
        {
            com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.d(b).c();
        }
        if (com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.e(b))
        {
            CirclePager.f(b);
            CirclePager.g(b).onPageSelected(0);
            return;
        }
        CirclePager.h(b).clear();
        if (CirclePager.i(b) == null && com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.j(b) == -1L)
        {
            continue; /* Loop/switch isn't completed */
        }
        Iterator iterator1 = d1.b.iterator();
        CircleBasic circlebasic = null;
        CircleBasic circlebasic2 = null;
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            CircleBasic circlebasic3 = (CircleBasic)iterator1.next();
            if (circlebasic3 != null)
            {
                if (CirclePager.i(b) != null && circlebasic3.defaultType != null && CirclePager.i(b).equals(circlebasic3.defaultType))
                {
                    circlebasic2 = circlebasic3;
                } else
                if (circlebasic3.id.equals(Long.valueOf(com.cyberlink.beautycircle.view.widgetpool.common.CirclePager.j(b))))
                {
                    com.perfectcorp.utility.e.b(new Object[] {
                        "set default: ", circlebasic3.id
                    });
                    circlebasic = circlebasic3;
                }
            }
        } while (true);
        if (circlebasic2 != null)
        {
            circlebasic = circlebasic2;
        } else
        if (circlebasic == null)
        {
            circlebasic = null;
        }
        if (circlebasic != null)
        {
            CirclePager.f(b);
            CirclePager.a(b, null, circlebasic, true, true, true);
        }
        if (!CirclePager.h(b).isEmpty()) goto _L8; else goto _L7
_L7:
        CircleList.a().a(new m(d1) {

            final d a;
            final CirclePager._cls2 b;

            protected void a(ArrayList arraylist)
            {
                Iterator iterator2 = a.b.iterator();
                do
                {
                    if (!iterator2.hasNext())
                    {
                        break;
                    }
                    CircleBasic circlebasic5 = (CircleBasic)iterator2.next();
                    if (circlebasic5 == null || !arraylist.contains(circlebasic5.id))
                    {
                        continue;
                    }
                    com.perfectcorp.utility.e.b(new Object[] {
                        "set default: ", circlebasic5.id
                    });
                    CirclePager.f(b.b);
                    CirclePager.a(b.b, null, circlebasic5, true, true, true);
                    break;
                } while (true);
                if (CirclePager.h(b.b).isEmpty() && a.b.size() > 1)
                {
                    arraylist = a.b.iterator();
                    do
                    {
                        if (!arraylist.hasNext())
                        {
                            break;
                        }
                        CircleBasic circlebasic4 = (CircleBasic)arraylist.next();
                        if (circlebasic4 == null || circlebasic4.id.longValue() == -1L)
                        {
                            continue;
                        }
                        com.perfectcorp.utility.e.b(new Object[] {
                            "set default: ", circlebasic4.id
                        });
                        CirclePager.f(b.b);
                        CirclePager.a(b.b, null, circlebasic4, true, true, true);
                        break;
                    } while (true);
                    return;
                } else
                {
                    CirclePager.f(b.b);
                    return;
                }
            }

            protected void b(Object obj)
            {
                a((ArrayList)obj);
            }

            
            {
                b = CirclePager._cls2.this;
                a = d1;
                super();
            }
        });
        return;
    }

    protected void b(Object obj)
    {
        a((d)obj);
    }

    _cls2.a(CirclePager circlepager, Long long1)
    {
        b = circlepager;
        a = long1;
        super();
        e = 0;
    }
}
