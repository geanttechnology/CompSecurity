// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.network;

import android.content.SharedPreferences;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.DiscoverTabItem;
import com.cyberlink.beautycircle.utility.t;
import com.cyberlink.beautycircle.utility.v;
import com.perfectcorp.utility.j;
import java.util.ArrayList;

// Referenced classes of package com.cyberlink.beautycircle.model.network:
//            NetworkManager

final class a extends j
{

    final ArrayList a;

    protected volatile Object a(Object obj)
    {
        return a((Void)obj);
    }

    protected Void a(Void void1)
    {
        if (a != null)
        {
            void1 = new DiscoverTabItem();
            void1.tabList = a;
            Globals.D().edit().putString("BeautyOptoinList", void1.toString()).commit();
            t.f.a();
        }
        return null;
    }

    (ArrayList arraylist)
    {
        a = arraylist;
        super();
    }
}
