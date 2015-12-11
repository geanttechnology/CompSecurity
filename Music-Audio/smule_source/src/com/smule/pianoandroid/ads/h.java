// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.c.a;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.ads:
//            g, j

public class h extends g
{

    private static final String a = com/smule/pianoandroid/ads/j.getName();
    private static final String b;
    private static final String c = MagicApplication.getContext().getString(0x7f0c00cd);
    private boolean d;

    public h()
    {
        d = true;
        b("PIANDROID_FreeDownload_FullScreen");
        a("adcolony_free_song_zone_id", b);
        c(c);
        a("pre_free_download_source");
    }

    protected boolean a()
    {
        return com.smule.pianoandroid.magicpiano.c.a.a().f() < 3;
    }

    public boolean a(Activity activity, int i)
    {
        d = true;
        return super.a(activity, i);
    }

    public boolean a(Activity activity, int i, Runnable runnable, Map map)
    {
        boolean flag = true;
        boolean flag1 = true;
        if (d)
        {
            boolean flag2 = super.a(activity, i, runnable, map);
            if (!flag2)
            {
                flag = flag1;
            } else
            {
                flag = false;
            }
            d = flag;
            flag = flag2;
        }
        return flag;
    }

    static 
    {
        int i = MagicApplication.getContext().getResources().getIdentifier("adcolony_free_song_zone_id", "string", MagicApplication.getInstance().getPackageName());
        b = MagicApplication.getContext().getString(i);
    }
}
