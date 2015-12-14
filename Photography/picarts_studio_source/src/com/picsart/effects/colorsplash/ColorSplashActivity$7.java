// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.effects.colorsplash;

import android.app.ProgressDialog;
import android.content.Intent;
import com.socialin.android.util.Utils;
import java.io.File;
import java.util.HashMap;
import org.json.JSONArray;

// Referenced classes of package com.picsart.effects.colorsplash:
//            ColorSplashActivity, b, c

final class c
    implements Runnable
{

    private boolean a;
    private File b;
    private HashMap c;
    private ColorSplashActivity d;

    public final void run()
    {
        if (ColorSplashActivity.c(d) != null && ColorSplashActivity.c(d).isShowing())
        {
            ColorSplashActivity.c(d).dismiss();
        }
        if (!a)
        {
            Utils.a(d, 0x7f08024e);
        }
        Intent intent = new Intent();
        boolean flag;
        if (b != null)
        {
            intent.putExtra("path", b.getAbsolutePath());
        } else
        if (c != null)
        {
            intent.putExtra("result_buffer_Data", c);
        }
        intent.putExtra("effects_dynamic_processing_time", System.currentTimeMillis() - d.e);
        if (!ColorSplashActivity.g(d).b.m.f)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        intent.putExtra("effects_default_settings_changed", flag);
        ColorSplashActivity.g(d).b.c();
        intent.putExtra("effects_color_splash_options", ColorSplashActivity.g(d).b.c().toString());
        d.setResult(-1, intent);
        d.finish();
    }

    (ColorSplashActivity colorsplashactivity, boolean flag, File file, HashMap hashmap)
    {
        d = colorsplashactivity;
        a = flag;
        b = file;
        c = hashmap;
        super();
    }
}
