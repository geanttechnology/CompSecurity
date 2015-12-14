// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.picsart.profile.fragment;

import android.app.Activity;
import android.content.Intent;

// Referenced classes of package com.socialin.android.picsart.profile.fragment:
//            NavigationFragment, au

final class a
    implements Runnable
{

    private NavigationFragment a;

    public final void run()
    {
label0:
        {
            if (a.getActivity() != null)
            {
                if (NavigationFragment.c(a) == null)
                {
                    break label0;
                }
                NavigationFragment.c(a).a(13);
            }
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(a.getActivity().getPackageName(), "com.socialin.android.photo.picsinphoto.MainPagerActivity");
        intent.setFlags(0x4000000);
        intent.putExtra("souorce", "navigation");
        a.startActivity(intent);
    }

    (NavigationFragment navigationfragment)
    {
        a = navigationfragment;
        super();
    }
}
