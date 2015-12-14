// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.picsinphoto;

import android.app.Fragment;
import com.socialin.android.constants.EventParam;
import com.socialin.android.photo.notifications.a;
import com.socialin.android.picsart.profile.invite.i;
import myobfuscated.cs.d;

// Referenced classes of package com.socialin.android.photo.picsinphoto:
//            MainPagerActivity

final class a
    implements d
{

    private MainPagerActivity a;

    public final void a(boolean flag)
    {
        if (flag)
        {
            if (MainPagerActivity.f(a) != null && MainPagerActivity.f(a).isAdded())
            {
                ((a)MainPagerActivity.f(a)).a();
            }
            i.a(a, "ad_remover", EventParam.AUTO.getName(), 0, com.socialin.android.constants.eMode.AD_REMOVER_AUTO);
        }
    }

    public final void f()
    {
    }

    A(MainPagerActivity mainpageractivity)
    {
        a = mainpageractivity;
        super();
    }
}
