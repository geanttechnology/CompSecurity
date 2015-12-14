// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import com.socialin.android.adapter.RecyclerViewAdapter;
import com.socialin.android.apiv3.controllers.RequestControllerFactory;
import com.socialin.android.picsart.profile.adapter.aw;
import com.socialin.android.util.Utils;
import myobfuscated.cr.a;
import myobfuscated.cr.f;
import myobfuscated.f.m;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            UserConnectionsFragment

public final class y extends UserConnectionsFragment
{

    public y()
    {
    }

    protected final a a(RecyclerViewAdapter recyclerviewadapter, long l)
    {
        return myobfuscated.cr.a.a(RequestControllerFactory.createGetViewerFollowersController(l), recyclerviewadapter);
    }

    public final void a()
    {
label0:
        {
            boolean flag = true;
            super.a();
            m = true;
            if (Utils.e(getActivity()) <= 380F)
            {
                flag = false;
            }
            if (c.isEmpty())
            {
                if (!d)
                {
                    break label0;
                }
                a(m.a(getActivity(), 0x7f080628, flag));
            }
            return;
        }
        a(m.a(getActivity(), 0x7f0803f6));
    }

    public final void onResume()
    {
        super.onResume();
        if (c.isEmpty() && !m)
        {
            a(false, true, true);
        }
    }
}
