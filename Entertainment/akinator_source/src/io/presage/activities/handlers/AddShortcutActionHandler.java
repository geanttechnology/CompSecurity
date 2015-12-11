// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.activities.handlers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import io.presage.Presage;
import io.presage.ads.NewAd;
import io.presage.ads.NewAdController;
import io.presage.ads.g;
import io.presage.utils.e;

public class AddShortcutActionHandler extends io.presage.activities.PresageActivity.ActivityHandler
{

    private NewAdController b;

    public AddShortcutActionHandler(Activity activity)
    {
        super(activity);
    }

    public void onCreate(Bundle bundle)
    {
        if (b != null)
        {
            return;
        }
        Presage.getInstance().setContext(a.getApplicationContext());
        bundle = a.getIntent().getExtras();
        if (!bundle.containsKey("ad"))
        {
            e.c(new String[] {
                "Unable to display an ad.", "The ad is not provided in the extras in the tag 'ad'."
            });
        } else
        {
            bundle = NewAd.fromJsonString(bundle.getString("ad"));
            g.a();
            b = g.a("icon").a(16).a(a.getApplicationContext(), bundle, bundle.getFormatDescriptor());
            b.showAd();
        }
        a.finish();
    }
}
