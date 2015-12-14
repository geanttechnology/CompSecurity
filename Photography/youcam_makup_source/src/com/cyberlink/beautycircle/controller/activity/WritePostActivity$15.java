// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import com.cyberlink.beautycircle.controller.fragment.c;
import com.cyberlink.beautycircle.controller.fragment.d;
import com.cyberlink.beautycircle.j;
import com.perfectcorp.utility.e;
import java.util.ArrayList;
import java.util.TreeSet;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a
    implements d
{

    final WritePostActivity a;

    public void a(c c1)
    {
        while (WritePostActivity.o(a) || c1 != WritePostActivity.i(a).get(WritePostActivity.i(a).size() - 1)) 
        {
            return;
        }
        com.cyberlink.beautycircle.controller.activity.WritePostActivity.j(a);
        WritePostActivity.p(a).addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

            final WritePostActivity._cls15 a;

            public void onLayoutChange(View view, int i, int k, int l, int i1, int j1, int k1, 
                    int l1, int i2)
            {
                WritePostActivity.p(a.a).removeOnLayoutChangeListener(this);
                WritePostActivity.p(a.a).fullScroll(130);
            }

            
            {
                a = WritePostActivity._cls15.this;
                super();
            }
        });
    }

    public void a(c c1, boolean flag)
    {
        e.b(new Object[] {
            "isCompleted: ", Boolean.valueOf(flag), ", ", c1
        });
        if (flag)
        {
            WritePostActivity.q(a).add(c1);
            WritePostActivity.r(a).remove(c1);
            WritePostActivity.s(a);
            return;
        } else
        {
            WritePostActivity.q(a).remove(c1);
            WritePostActivity.r(a).add(c1);
            WritePostActivity.s(a);
            return;
        }
    }

    public void b(c c1)
    {
        e.e(new Object[] {
            c1
        });
        WritePostActivity.t(a);
    }

    public void c(c c1)
    {
        if (WritePostActivity.i(a).get(WritePostActivity.i(a).size() - 1) == c1)
        {
            return;
        } else
        {
            ((ViewGroup)a.findViewById(j.write_post_layout)).removeView(c1.b());
            WritePostActivity.i(a).remove(c1);
            ((c)WritePostActivity.i(a).get(0)).a();
            WritePostActivity.r(a).remove(c1);
            return;
        }
    }

    _cls1.a(WritePostActivity writepostactivity)
    {
        a = writepostactivity;
        super();
    }
}
