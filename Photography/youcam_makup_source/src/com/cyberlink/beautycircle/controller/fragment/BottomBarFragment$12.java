// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.view.View;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            BottomBarFragment

class a
    implements android.view.ner
{

    final BottomBarFragment a;

    public boolean onLongClick(View view)
    {
        if (BottomBarFragment.b < 3)
        {
            BottomBarFragment.b++;
            return false;
        } else
        {
            BottomBarFragment.b = 0;
            return false;
        }
    }

    I(BottomBarFragment bottombarfragment)
    {
        a = bottombarfragment;
        super();
    }
}
