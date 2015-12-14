// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.facebook;

import android.content.DialogInterface;
import com.socialin.android.apiv3.SocialinV3;

// Referenced classes of package com.socialin.android.facebook:
//            FacebookMainActivity

final class a
    implements android.content.Listener
{

    private FacebookMainActivity a;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        SocialinV3.getInstance().removeFbConnection();
        FacebookMainActivity.b(a);
    }

    (FacebookMainActivity facebookmainactivity)
    {
        a = facebookmainactivity;
        super();
    }
}
