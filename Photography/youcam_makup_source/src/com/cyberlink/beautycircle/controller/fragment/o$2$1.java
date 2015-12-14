// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.app.Activity;
import android.view.View;
import com.cyberlink.beautycircle.c;
import com.cyberlink.beautycircle.controller.a.e;
import com.cyberlink.beautycircle.controller.a.s;
import com.cyberlink.beautycircle.controller.activity.HotTopicActivity;
import com.cyberlink.beautycircle.model.CircleType;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.a.b;
import com.perfectcorp.utility.m;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            o

class a
    implements android.view.nClickListener
{

    final Activity a;
    final b b;

    public void onClick(View view)
    {
        com.perfectcorp.a.b.a(new e(com.cyberlink.beautycircle.controller.fragment.o.b(b.b), 0L, "createpost", b.b.s, b.b.n()));
        c.a(a, o.a(b.b).longValue(), null, null, false, null, null, com.cyberlink.beautycircle.controller.fragment.o.b(b.b));
    }

    icActivity(icActivity icactivity, Activity activity)
    {
        b = icactivity;
        a = activity;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/o$2

/* anonymous class */
    class o._cls2 extends m
    {

        final o a;

        protected void a()
        {
            a(0x80000005);
        }

        protected void a(int i)
        {
            com.perfectcorp.utility.e.e(new Object[] {
                Integer.valueOf(i)
            });
        }

        protected void a(d d1)
        {
            if (d1 != null && d1.b != null && !d1.b.isEmpty()) goto _L2; else goto _L1
_L1:
            a(0x80000003);
_L8:
            return;
_L2:
            android.support.v4.app.FragmentActivity fragmentactivity;
            fragmentactivity = a.getActivity();
            d1 = d1.b.iterator();
_L4:
            CircleType circletype;
            do
            {
                if (!d1.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                circletype = (CircleType)d1.next();
            } while (circletype == null || !o.a(a).equals(circletype.id));
            if (!circletype.defaultType.equals("HOW-TO"))
            {
                break; /* Loop/switch isn't completed */
            }
            s.a = "bc_howto";
            ((HotTopicActivity)fragmentactivity).a(true);
_L6:
            o.a(a, circletype.circleTypeName);
            if (true) goto _L4; else goto _L3
_L3:
            if (a.l == null) goto _L6; else goto _L5
_L5:
            a.f = true;
            a.l.setVisibility(0);
            a.l.setOnClickListener(new o._cls2._cls1(this, fragmentactivity));
              goto _L6
            if (fragmentactivity == null || !(fragmentactivity instanceof HotTopicActivity)) goto _L8; else goto _L7
_L7:
            ((HotTopicActivity)fragmentactivity).f(com.cyberlink.beautycircle.controller.fragment.o.c(a));
            return;
        }

        protected void b(Object obj)
        {
            a((d)obj);
        }

            
            {
                a = o1;
                super();
            }
    }

}
