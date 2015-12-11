// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

// Referenced classes of package com.offerup.android.activities:
//            SplashActivity, ChatActivity, DeeplinkRouterActivity, UserDetailActivity, 
//            AlertsActivity, RatingActivity

public final class g
{

    public Context a;

    public g(Context context)
    {
        a = context.getApplicationContext();
    }

    private void a(Intent intent)
    {
        try
        {
            intent.putExtra("activity_started_externally", true);
            a.startActivity(intent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent) { }
        try
        {
            com.b.a.a.g.a(this, intent);
            a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            com.b.a.a.g.a(this, intent);
        }
    }

    public final void a()
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(0x10000000);
        intent.setClass(a, com/offerup/android/activities/SplashActivity);
        a.startActivity(intent);
    }

    public final void a(long l)
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(0x10000000);
        intent.putExtra("discussionId", l);
        intent.setClass(a, com/offerup/android/activities/ChatActivity);
        a(intent);
    }

    public final void a(long l, long l1)
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(0x10000000);
        intent.putExtra("discussionId", l);
        intent.putExtra("orderId", l1);
        intent.setClass(a, com/offerup/android/activities/ChatActivity);
        a(intent);
    }

    public final void a(Uri uri)
    {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addCategory("android.intent.category.BROWSABLE");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setFlags(0x10000000);
        intent.setData(uri);
        a(intent);
    }

    public final void a(String s, boolean flag)
    {
        s = (new android.net.Uri.Builder()).scheme(a.getString(0x7f0900c5)).path(s).build();
        Intent intent = new Intent(a, com/offerup/android/activities/DeeplinkRouterActivity);
        intent.setAction("android.intent.action.VIEW");
        intent.setFlags(0x10000000);
        intent.putExtra("activity_started_externally", true);
        intent.setData(s);
        a(intent);
    }

    public final void b(long l)
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(0x10000000);
        intent.setClass(a, com/offerup/android/activities/UserDetailActivity);
        intent.putExtra("userId", l);
        a(intent);
    }

    public final void c(long l)
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(0x10000000);
        intent.setClass(a, com/offerup/android/activities/AlertsActivity);
        intent.putExtra("discussionId", l);
        a(intent);
    }

    public final void d(long l)
    {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setClass(a, com/offerup/android/activities/RatingActivity);
        intent.setFlags(0x10000000);
        intent.putExtra("itemId", l);
        a(intent);
    }
}
