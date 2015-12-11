// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.os.Handler;
import java.lang.ref.WeakReference;

// Referenced classes of package com.groupon.fragment:
//            NearbyDealsFragment

protected static class fragmentRef
    implements Runnable
{

    private WeakReference fragmentRef;

    public void run()
    {
        NearbyDealsFragment nearbydealsfragment = (NearbyDealsFragment)fragmentRef.get();
        if (nearbydealsfragment == null)
        {
            return;
        } else
        {
            NearbyDealsFragment.access$2700(nearbydealsfragment).postDelayed(this, 0x36ee80L);
            nearbydealsfragment.refresh(iodicReload);
            return;
        }
    }

    public (NearbyDealsFragment nearbydealsfragment)
    {
        fragmentRef = new WeakReference(nearbydealsfragment);
    }
}
