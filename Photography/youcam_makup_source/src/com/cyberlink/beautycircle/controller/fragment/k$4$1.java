// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            k

class a extends m
{

    final a a;

    protected void a(String s)
    {
        if (s == null)
        {
            Globals.b("Dump logcat failed");
            return;
        } else
        {
            Globals.b((new StringBuilder()).append("Dump logcat to '").append(s).append("'").toString());
            return;
        }
    }

    protected void b(Object obj)
    {
        a((String)obj);
    }

    a(a a1)
    {
        a = a1;
        super();
    }

    // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/k$4

/* anonymous class */
    class k._cls4
        implements android.view.View.OnClickListener
    {

        final k a;

        public void onClick(View view)
        {
            (new k._cls4._cls2()).d(null).a(new k._cls4._cls1(this));
        }

            
            {
                a = k1;
                super();
            }

        // Unreferenced inner class com/cyberlink/beautycircle/controller/fragment/k$4$2

/* anonymous class */
        class k._cls4._cls2 extends j
        {

            final k._cls4 a;

            protected volatile Object a(Object obj)
            {
                return a((Void)obj);
            }

            protected String a(Void void1)
            {
                return e.b(true);
            }

                    
                    {
                        a = k._cls4.this;
                        super();
                    }
        }

    }

}
