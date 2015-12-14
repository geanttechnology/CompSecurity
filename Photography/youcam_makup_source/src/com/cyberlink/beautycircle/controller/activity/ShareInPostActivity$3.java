// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.model.CircleBasic;
import com.cyberlink.beautycircle.model.network.d;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            ShareInPostActivity

class a extends j
{

    final ShareInPostActivity a;

    protected CircleBasic a(d d1)
    {
        if (d1 != null && d1.b != null && !d1.b.isEmpty())
        {
            return (CircleBasic)d1.b.get(0);
        } else
        {
            return null;
        }
    }

    protected volatile Object a(Object obj)
    {
        return a((d)obj);
    }

    (ShareInPostActivity shareinpostactivity)
    {
        a = shareinpostactivity;
        super();
    }
}
