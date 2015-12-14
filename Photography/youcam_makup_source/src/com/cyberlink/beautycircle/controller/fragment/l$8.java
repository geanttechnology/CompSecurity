// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.fragment;

import android.content.SharedPreferences;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.DiscoverTabItem;
import com.perfectcorp.model.Model;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.controller.fragment:
//            l

class a extends j
{

    final l a;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected ArrayList a(Void void1)
    {
        void1 = (DiscoverTabItem)Model.a(com/cyberlink/beautycircle/model/DiscoverTabItem, Globals.D().getString("BeautyOptoinList", ""));
        if (void1 == null)
        {
            return null;
        } else
        {
            return ((DiscoverTabItem) (void1)).tabList;
        }
    }

    (l l1)
    {
        a = l1;
        super();
    }
}
