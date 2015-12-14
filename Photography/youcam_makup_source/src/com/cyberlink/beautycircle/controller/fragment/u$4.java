// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            u

class a extends m
{

    final u a;

    protected void a(int i)
    {
        super.a(i);
    }

    protected void a(Boolean boolean1)
    {
        if (boolean1 != null && boolean1.booleanValue())
        {
            u.a(a).setVisibility(0);
            u.b(a).notifyDataSetChanged();
            u.a(a, u.c(a).size());
            u.d(a).onPageSelected(0);
            return;
        } else
        {
            u.a(a).setVisibility(8);
            return;
        }
    }

    protected void b(Object obj)
    {
        a((Boolean)obj);
    }

    ner(u u1)
    {
        a = u1;
        super();
    }
}
