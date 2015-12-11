// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.notifications;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.bl;
import com.leanplum.LeanplumPushNotificationCustomizer;

public final class a
    implements LeanplumPushNotificationCustomizer
{

    private Context a;

    public a(Context context)
    {
        a = context;
    }

    public final void customize(bl bl1, Bundle bundle)
    {
        bundle = BitmapFactory.decodeResource(a.getResources(), 0x7f020172);
        bl bl2 = bl1.a(0x7f020172);
        bl2.e = bundle;
        bl2.a();
        bl1.a(Uri.parse((new StringBuilder("android.resource://")).append(a.getPackageName()).append("/2131230725").toString()));
    }
}
