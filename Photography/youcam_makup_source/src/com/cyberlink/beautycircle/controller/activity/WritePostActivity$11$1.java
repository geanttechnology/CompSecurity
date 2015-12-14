// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.content.Intent;
import com.cyberlink.beautycircle.utility.u;
import com.cyberlink.beautycircle.view.widgetpool.common.CircleList;
import com.cyberlink.beautycircle.view.widgetpool.common.CirclePager;
import com.perfectcorp.utility.e;
import com.perfectcorp.utility.j;
import com.perfectcorp.utility.m;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a extends m
{

    final a a;

    protected void a(Void void1)
    {
        com.cyberlink.beautycircle.controller.activity.WritePostActivity.e(a.a).a();
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

    // Unreferenced inner class com/cyberlink/beautycircle/controller/activity/WritePostActivity$11

/* anonymous class */
    class WritePostActivity._cls11
        implements u
    {

        final WritePostActivity a;

        public void a()
        {
            e.b(new Object[] {
                "OnNewCircle"
            });
            WritePostActivity.a(a, false, false);
            Intent intent = a.getIntent();
            if (intent != null)
            {
                intent.removeExtra("CategoryId");
            }
            CircleList.a(null).a(new WritePostActivity._cls11._cls1(this));
        }

            
            {
                a = writepostactivity;
                super();
            }
    }

}
