// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.content.Context;
import android.content.Intent;
import io.presage.activities.PresageActivity;
import io.presage.ads.NewAd;
import io.presage.ads.NewAdController;
import io.presage.ads.NewAdViewer;
import io.presage.ads.g;
import io.presage.utils.e;
import shared_presage.com.google.gson.Gson;

public class NewLaunchActivityFormat extends NewAdViewer
{

    public NewLaunchActivityFormat(NewAdController newadcontroller, NewAd newad, int i)
    {
        super(newadcontroller, newad, i);
    }

    public void hide()
    {
        e.c(new String[] {
            "Once launched, the launch activity cannot be hidden in this context."
        });
    }

    public void show()
    {
        Intent intent = new Intent(a, io/presage/activities/PresageActivity);
        intent.addFlags(0x10000000);
        intent.putExtra("activity_handler", "launch_activity");
        intent.putExtra("ad", (new Gson()).toJson(c));
        g.a();
        intent.putExtra("controller", g.a(b));
        intent.putExtra("flags", d);
        a.startActivity(intent);
    }
}
