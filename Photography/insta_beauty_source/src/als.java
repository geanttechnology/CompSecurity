// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

public class als
{

    public static String a = "FONT_DOWNLOAD_SUCCESS";
    private static als c;
    List b;
    private Context d;
    private alv e;
    private boolean f;

    public als()
    {
        f = true;
        b = new ArrayList();
    }

    public static als a(Context context)
    {
        if (c == null)
        {
            c = new als();
        }
        c.b(context);
        return c;
    }

    static Context a(als als1)
    {
        return als1.d;
    }

    public static String a()
    {
        return alr.a().d();
    }

    static void a(als als1, ama ama1)
    {
        als1.b(ama1);
    }

    private boolean a(ama ama1)
    {
        boolean flag;
        boolean flag1;
        flag1 = false;
        flag = flag1;
        if (b.size() <= 0) goto _L2; else goto _L1
_L1:
        flag = flag1;
        if (ama1 == null) goto _L2; else goto _L3
_L3:
        int i = 0;
_L8:
        flag = flag1;
        if (i >= b.size()) goto _L2; else goto _L4
_L4:
        ama ama2 = (ama)b.get(i);
        if (ama2 == null || ama2.f == null || !ama2.f.equalsIgnoreCase(ama1.f)) goto _L6; else goto _L5
_L5:
        flag = true;
_L2:
        return flag;
_L6:
        i++;
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void b(ama ama1)
    {
        if (b.size() <= 0 || ama1 == null) goto _L2; else goto _L1
_L1:
        int i = 0;
_L7:
        if (i >= b.size()) goto _L2; else goto _L3
_L3:
        if (!((ama)b.get(i)).f.equalsIgnoreCase(ama1.f)) goto _L5; else goto _L4
_L4:
        b.remove(i);
_L2:
        return;
_L5:
        i++;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static boolean b(als als1)
    {
        return als1.f;
    }

    static alv c(als als1)
    {
        return als1.e;
    }

    public void a(alv alv1)
    {
        e = alv1;
    }

    public void a(ama ama1, boolean flag)
    {
        if (!a(ama1))
        {
            f = flag;
            if (ama1.b != null && ama1.b.length() > 0)
            {
                b.add(ama1);
                alm alm1 = new alm(ama1.b, (new StringBuilder()).append(a()).append("/fonts/").toString(), (new StringBuilder()).append(ama1.f).append(".zip").toString(), d, flag);
                alm1.a(new alt(this, ama1));
                alm1.execute(new Void[0]);
                return;
            }
            if (e != null)
            {
                e.a();
                return;
            }
        }
    }

    public void b(Context context)
    {
        d = context;
    }

}
