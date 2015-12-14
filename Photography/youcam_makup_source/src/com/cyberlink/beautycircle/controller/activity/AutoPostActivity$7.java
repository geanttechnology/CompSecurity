// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import android.widget.Button;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.m;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            AutoPostActivity

class a extends m
{

    final AutoPostActivity a;

    protected void a(Boolean boolean1)
    {
        if (AutoPostActivity.h(a) != AutoPostActivity.j(a).size()) goto _L2; else goto _L1
_L1:
        Globals.b("Auto post finished.");
        AutoPostActivity.d(a).setVisibility(8);
        AutoPostActivity.e(a).setVisibility(8);
_L4:
        if (boolean1.booleanValue())
        {
            t.b.a();
        }
        return;
_L2:
        AutoPostActivity.d(a).setVisibility(0);
        AutoPostActivity.e(a).setVisibility(8);
        if (AutoPostActivity.l(a))
        {
            AutoPostActivity.a(a, false);
            Globals.b("Stop auto post.");
            AutoPostActivity.d(a).setEnabled(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void b(Object obj)
    {
        a((Boolean)obj);
    }

    (AutoPostActivity autopostactivity)
    {
        a = autopostactivity;
        super();
    }
}
