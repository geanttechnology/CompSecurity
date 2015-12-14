// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.location.Location;
import com.cyberlink.youcammakeup.kernelctrl.status.StatusManager;
import com.cyberlink.youcammakeup.pages.shareview.b;
import com.facebook.widget.PlacePickerFragment;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            FacebookPlacePickerActivity

class a extends b
{

    final FacebookPlacePickerActivity a;

    public void a(Location location)
    {
        if (!StatusManager.j().o().equals("facebookPlacePickerPage"))
        {
            return;
        }
        if (location == null)
        {
            FacebookPlacePickerActivity.a(a, "Get location null");
            return;
        } else
        {
            com.cyberlink.youcammakeup.activity.FacebookPlacePickerActivity.b(a);
            FacebookPlacePickerActivity.c(a).setLocation(location);
            FacebookPlacePickerActivity.c(a).loadData(false);
            return;
        }
    }

    (FacebookPlacePickerActivity facebookplacepickeractivity)
    {
        a = facebookplacepickeractivity;
        super();
    }
}
