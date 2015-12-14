// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import java.util.Comparator;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            BottomBarFragment

class a
    implements Comparator
{

    final BottomBarFragment a;

    public int a(View view, View view1)
    {
        return view.hashCode() - view1.hashCode();
    }

    public int compare(Object obj, Object obj1)
    {
        return a((View)obj, (View)obj1);
    }

    (BottomBarFragment bottombarfragment)
    {
        a = bottombarfragment;
        super();
    }
}
