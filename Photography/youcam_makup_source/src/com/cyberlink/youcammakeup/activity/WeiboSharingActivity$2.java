// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.activity;

import android.content.DialogInterface;

// Referenced classes of package com.cyberlink.youcammakeup.activity:
//            WeiboSharingActivity

class a
    implements android.content.ssListener
{

    final WeiboSharingActivity a;

    public void onDismiss(DialogInterface dialoginterface)
    {
        a.finish();
    }

    (WeiboSharingActivity weibosharingactivity)
    {
        a = weibosharingactivity;
        super();
    }
}
