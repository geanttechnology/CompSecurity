// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class ber
{

    public static String a = "FONT_DOWNLOAD_SUCCESS";
    private static ber b;
    private Context c;
    private bev d;
    private bie e;
    private bfa f;
    private beu g;
    private boolean h;

    public ber()
    {
        h = true;
        e = new bes(this);
        f = new bet(this);
    }

    public static ber a(Context context)
    {
        if (b == null)
        {
            b = new ber();
        }
        b.b(context);
        return b;
    }

    static bev a(ber ber1)
    {
        return ber1.d;
    }

    public static String a()
    {
        return beq.a().b();
    }

    static Context b(ber ber1)
    {
        return ber1.c;
    }

    static boolean c(ber ber1)
    {
        return ber1.h;
    }

    static bfa d(ber ber1)
    {
        return ber1.f;
    }

    static beu e(ber ber1)
    {
        return ber1.g;
    }

    public void a(beu beu1)
    {
        g = beu1;
    }

    public void a(bev bev1, boolean flag)
    {
        d = bev1;
        h = flag;
        if (bev1.b != null && bev1.b.length() > 0)
        {
            bev1 = new bic(bev1.b, (new StringBuilder()).append(a()).append("/fonts/").toString(), (new StringBuilder()).append(bev1.d).append(".zip").toString(), c, flag);
            bev1.a(e);
            bev1.execute(new Void[0]);
        } else
        if (g != null)
        {
            g.a();
            return;
        }
    }

    public void b(Context context)
    {
        c = context;
    }

}
