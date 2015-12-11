// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.activities.deeplink.a;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.shazam.android.activities.MainCompatActivity;
import com.shazam.android.k.f.j;
import com.shazam.model.analytics.event.DefinedEventParameterKey;

// Referenced classes of package com.shazam.android.activities.deeplink.a:
//            b

public final class c
    implements b
{

    private final j b;

    public c(j j1)
    {
        b = j1;
    }

    public final void a(Uri uri, Activity activity)
    {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("myshazam"), activity, com/shazam/android/activities/MainCompatActivity);
        com.shazam.android.k.f.i.a a1 = new com.shazam.android.k.f.i.a();
        a1.a = com.shazam.model.analytics.AnalyticsInfo.Builder.a().a(DefinedEventParameterKey.SCREEN_ORIGIN, uri.getQueryParameter("screenorigin")).b();
        j.a(a1.a(), intent);
        activity.startActivity(intent);
    }
}
