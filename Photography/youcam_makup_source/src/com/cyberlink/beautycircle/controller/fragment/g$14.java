// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.widget.ListView;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            g

class a
    implements Runnable
{

    final ListView a;
    final g b;

    public void run()
    {
        a.setSelection(0);
    }

    _cls9(g g1, ListView listview)
    {
        b = g1;
        a = listview;
        super();
    }
}
