// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.Globals;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AutoPostActivity

class a extends m
{

    final AutoPostActivity a;

    protected void a(ArrayList arraylist)
    {
        int i;
        if (arraylist != null)
        {
            i = arraylist.size();
        } else
        {
            i = 0;
        }
        AutoPostActivity.a(a, AutoPostActivity.h(a), i);
        Globals.b("Query file finished, stat to auto post.");
        AutoPostActivity.i(a);
    }

    protected void b(Object obj)
    {
        a((ArrayList)obj);
    }

    (AutoPostActivity autopostactivity)
    {
        a = autopostactivity;
        super();
    }
}
