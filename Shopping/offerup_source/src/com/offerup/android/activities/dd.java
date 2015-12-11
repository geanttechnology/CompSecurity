// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.offerup.android.tracker.a;

// Referenced classes of package com.offerup.android.activities:
//            MyAccountActivity, a

final class dd
    implements android.view.View.OnClickListener
{

    private MyAccountActivity a;

    dd(MyAccountActivity myaccountactivity)
    {
        a = myaccountactivity;
        super();
    }

    public final void onClick(View view)
    {
        com.offerup.android.tracker.a.b("MyAccount_EnablePush-Button_click");
        view = a.f;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse((new StringBuilder("package:")).append(((com.offerup.android.activities.a) (view)).a.getApplicationContext().getPackageName()).toString()));
        ((com.offerup.android.activities.a) (view)).a.startActivity(intent);
    }
}
