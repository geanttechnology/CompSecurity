// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import java.util.Comparator;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            BottomBarFragment, b

class a
    implements Comparator
{

    final BottomBarFragment a;

    public int a(b b1, b b2)
    {
        if (b1 == null || b2 == null)
        {
            return 0;
        } else
        {
            return b1.hashCode() - b2.hashCode();
        }
    }

    public int compare(Object obj, Object obj1)
    {
        return a((b)obj, (b)obj1);
    }

    I(BottomBarFragment bottombarfragment)
    {
        a = bottombarfragment;
        super();
    }
}
