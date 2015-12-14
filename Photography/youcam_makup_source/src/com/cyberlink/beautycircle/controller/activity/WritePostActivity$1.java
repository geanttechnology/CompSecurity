// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;

import com.cyberlink.beautycircle.controller.fragment.c;
import java.util.Comparator;

// Referenced classes of package com.cyberlink.beautycircle.controller.activity:
//            WritePostActivity

class a
    implements Comparator
{

    final WritePostActivity a;

    public int a(c c1, c c2)
    {
        return c1.hashCode() - c2.hashCode();
    }

    public int compare(Object obj, Object obj1)
    {
        return a((c)obj, (c)obj1);
    }

    (WritePostActivity writepostactivity)
    {
        a = writepostactivity;
        super();
    }
}
