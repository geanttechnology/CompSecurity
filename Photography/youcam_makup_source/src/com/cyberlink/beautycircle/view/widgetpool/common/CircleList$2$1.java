// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.view.widgetpool.common;

import com.cyberlink.beautycircle.utility.u;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.view.widgetpool.common:
//            CircleList

class a extends m
{

    final a a;

    protected void a(Void void1)
    {
        a.a.a(true);
    }

    protected void b(Object obj)
    {
        a((Void)obj);
    }

    ( )
    {
        a = ;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/view/widgetpool/common/CircleList$2

/* anonymous class */
    class CircleList._cls2
        implements u
    {

        final CircleList a;

        public void a()
        {
            e.b(new Object[] {
                "OnNewCircle"
            });
            if (CircleList.a(a))
            {
                a.a(true);
            } else
            {
                CircleList.b(a).clear();
                CircleList.a(CircleList.b(a)).a(new CircleList._cls2._cls1(this));
            }
            a.scrollTo(0, 0);
        }

            
            {
                a = circlelist;
                super();
            }
    }

}
