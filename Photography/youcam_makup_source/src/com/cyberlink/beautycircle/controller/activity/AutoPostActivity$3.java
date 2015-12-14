// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.view.widgetpool.common.CircleList;
import com.cyberlink.beautycircle.view.widgetpool.common.CirclePager;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AutoPostActivity

class a
    implements u
{

    final AutoPostActivity a;

    public void a()
    {
        AutoPostActivity.a(a, false, false);
        CircleList.a(null).a(new m() {

            final AutoPostActivity._cls3 a;

            protected void a(Void void1)
            {
                AutoPostActivity.b(a.a).a();
            }

            protected void b(Object obj)
            {
                a((Void)obj);
            }

            
            {
                a = AutoPostActivity._cls3.this;
                super();
            }
        });
    }

    _cls1.a(AutoPostActivity autopostactivity)
    {
        a = autopostactivity;
        super();
    }
}
