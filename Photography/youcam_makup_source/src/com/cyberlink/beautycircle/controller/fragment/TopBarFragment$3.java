// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            TopBarFragment, z

class a
    implements android.view.ner
{

    final TopBarFragment a;

    public void onClick(View view)
    {
        for (view = TopBarFragment.e(a).iterator(); view.hasNext(); ((z)view.next()).g()) { }
    }

    (TopBarFragment topbarfragment)
    {
        a = topbarfragment;
        super();
    }
}
