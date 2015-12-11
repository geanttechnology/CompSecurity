// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.account;

import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.shazam.android.analytics.event.EventAnalyticsFromView;
import com.shazam.android.analytics.event.factory.AccountLoginEventFactory;
import java.util.List;

// Referenced classes of package com.shazam.android.activities.account:
//            CheckEmailActivity

private final class <init>
    implements android.content.ckListener
{

    final CheckEmailActivity a;
    private final List b;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        CheckEmailActivity.a(a).logEvent(CheckEmailActivity.d(a), AccountLoginEventFactory.checkEmail());
        dialoginterface = ((ResolveInfo)b.get(i)).activityInfo.packageName;
        a.startActivity(CheckEmailActivity.e(a).getLaunchIntentForPackage(dialoginterface));
    }

    private tFactory(CheckEmailActivity checkemailactivity, List list)
    {
        a = checkemailactivity;
        super();
        b = list;
    }

    b(CheckEmailActivity checkemailactivity, List list, byte byte0)
    {
        this(checkemailactivity, list);
    }
}
