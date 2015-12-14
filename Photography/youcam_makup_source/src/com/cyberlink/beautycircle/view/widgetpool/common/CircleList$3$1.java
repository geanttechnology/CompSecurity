// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import com.cyberlink.beautycircle.BaseActivity;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CircleList, g, f

class a extends m
{

    final a a;

    protected void a(ArrayList arraylist)
    {
label0:
        {
            if (arraylist == null || arraylist.isEmpty())
            {
                break label0;
            }
            Iterator iterator = CircleList.c(a.a).iterator();
            CircleBasic circlebasic;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                circlebasic = (CircleBasic)iterator.next();
            } while (!arraylist.contains(circlebasic.id));
            CircleList.a(a.a, circlebasic);
        }
        if (CircleList.b(a.a).isEmpty())
        {
            CircleList.a(a.a, (CircleBasic)CircleList.c(a.a).get(0));
        }
    }

    protected void b(Object obj)
    {
        a((ArrayList)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/view/widgetpool/common/CircleList$3

/* anonymous class */
    class CircleList._cls3 extends m
    {

        final boolean a;
        final CircleList b;

        protected void a()
        {
            if (Globals.d != null)
            {
                Globals.d.l();
            }
            CircleList.e(b).a(0x80000005);
        }

        protected void a(int i)
        {
            if (Globals.d != null)
            {
                Globals.d.l();
            }
            CircleList.e(b).a(i);
        }

        protected void a(d d1)
        {
            if (d1 != null && d1.b != null)
            {
                if (!d1.b.isEmpty())
                {
                    CircleList.c(b).addAll(d1.b);
                    d1 = CircleList.c(b).iterator();
                    do
                    {
                        if (!d1.hasNext())
                        {
                            break;
                        }
                        CircleBasic circlebasic = (CircleBasic)d1.next();
                        if (circlebasic != null && "HOW-TO".equals(circlebasic.defaultType))
                        {
                            d1.remove();
                        }
                    } while (true);
                    com.cyberlink.beautycircle.view.widgetpool.common.CircleList.d(b).a();
                }
                if (a && !CircleList.a(b))
                {
                    CircleList.a().a(new CircleList._cls3._cls1(this));
                }
                if (Globals.d != null)
                {
                    Globals.d.l();
                    return;
                }
            }
        }

        protected void b(Object obj)
        {
            a((d)obj);
        }

            
            {
                b = circlelist;
                a = flag;
                super();
            }
    }

}
