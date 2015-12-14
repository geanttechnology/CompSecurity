// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.widget.Button;
import com.socialin.android.picsart.profile.fragment.at;
import myobfuscated.cr.f;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class b extends BroadcastReceiver
{

    private MainPagerActivity a;

    private b(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }

    b(MainPagerActivity mainpageractivity, byte byte0)
    {
        this(mainpageractivity);
    }

    public final void onReceive(Context context, Intent intent)
    {
        if (intent != null && intent.hasExtra("myNetworkNewItemsCount") && intent.getIntExtra("myNetworkNewItemsCount", -1) > 0)
        {
            context = a.getFragmentManager().findFragmentByTag("my.network.fragment");
            if (context != null && context.isVisible())
            {
                context = (at)context;
                if (context.isResumed() && ((at) (context)).g > 0.0F)
                {
                    context.a(context.getResources().getString(0x7f080495));
                    ((f) (context)).h.setVisibility(0);
                }
            }
        }
    }
}
