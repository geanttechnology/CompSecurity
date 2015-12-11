// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;

public final class cxf
{

    final bje a;
    public final cxl b;
    boolean c;
    public cxu d;
    public bhv e;
    private final SharedPreferences f;
    private cxg g;

    public cxf(bje bje1, Context context, cxn cxn, SharedPreferences sharedpreferences)
    {
        a = (bje)b.a(bje1);
        f = (SharedPreferences)b.a(sharedpreferences);
        g = new cxg(this);
        b = new cxl(new Handler(context.getMainLooper()), sharedpreferences, g, cxn, context.getString(0x7f0b00b6));
    }

    private void handleVideoStageEvent(ctd ctd1)
    {
        if (ctd1.b == ctt.a)
        {
            e = null;
            b.b();
            a(null);
        } else
        {
            if (ctd1.b == ctt.b)
            {
                e = null;
                b.a(ctd1.c);
                return;
            }
            if (ctd1.b == ctt.i)
            {
                boolean flag;
                if (b.b != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (!flag)
                {
                    e = null;
                    b.a(ctd1.c);
                }
                a.c(new csz(d));
                return;
            }
        }
    }

    public final void a(cxu cxu1)
    {
        if (cxu1 != null)
        {
            if (cxu1 == null || TextUtils.isEmpty(cxu1.a))
            {
                f.edit().remove("subtitles_language_code").apply();
                f.edit().putBoolean("subtitles_enabled", false).apply();
            } else
            {
                f.edit().putString("subtitles_language_code", cxu1.a).apply();
                f.edit().putBoolean("subtitles_enabled", true).apply();
            }
        }
        d = cxu1;
        if (cxu1 != null && TextUtils.isEmpty(cxu1.a))
        {
            d = null;
        }
        a.c(new csz(d));
    }
}
