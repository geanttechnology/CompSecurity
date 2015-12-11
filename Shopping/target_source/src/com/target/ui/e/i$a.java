// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.e;

import android.os.Build;
import com.pointinside.model.Venue;
import com.pointinside.model.Zone;
import com.target.ui.vlc.d;
import com.target.ui.vlc.model.a;
import java.util.List;

// Referenced classes of package com.target.ui.e:
//            i

private class mStoreId
    implements com.target.ui.helper.k.d
{

    private String mStoreId;
    final i this$0;

    public void a(Venue venue)
    {
        venue = (Zone)venue.getAllZones().get(0);
        com.target.ui.e.i.a(i.this, new a(mStoreId, venue.getUUID()));
        i.this.a(new d(Build.DEVICE, com.target.ui.e.i.a(i.this)));
    }

    public void p_()
    {
    }

    public l.Venue(String s)
    {
        this$0 = i.this;
        super();
        mStoreId = s;
    }
}
