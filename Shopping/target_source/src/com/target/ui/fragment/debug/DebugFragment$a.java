// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.debug;

import com.pointinside.model.Venue;
import com.pointinside.model.Zone;
import com.target.ui.util.ai;
import java.util.List;

// Referenced classes of package com.target.ui.fragment.debug:
//            DebugFragment

private class mStoreId
    implements com.target.ui.helper.k.ent.a
{

    private String mStoreId;
    final DebugFragment this$0;

    public void a(Venue venue)
    {
        DebugFragment.e(DebugFragment.this, false);
        venue = (Zone)venue.getAllZones().get(0);
        DebugFragment.a(DebugFragment.this, mStoreId, venue.getUUID());
    }

    public void p_()
    {
        if (getActivity() == null)
        {
            return;
        } else
        {
            DebugFragment.f(DebugFragment.this, false);
            ai.a(getActivity(), "Error loading store.  Wrong id?");
            return;
        }
    }

    public (String s)
    {
        this$0 = DebugFragment.this;
        super();
        mStoreId = s;
    }
}
