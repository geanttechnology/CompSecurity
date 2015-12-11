// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Intent;
import android.os.Bundle;

public final class wg
{

    bok a;
    mj b;
    public dre c;

    public wg(bok bok1, mj mj)
    {
        a = bok1;
        b = mj;
    }

    public final String a(Intent intent)
    {
        String s = null;
        if (intent != null)
        {
            s = intent.getStringExtra("browseId");
        }
        intent = s;
        if (s == null)
        {
            intent = "FEkids_home";
            dfu dfu1 = new dfu();
            dfu1.a = "FEkids_home";
            dre dre1 = new dre();
            dre1.c = dfu1;
            c = dre1;
        }
        return intent;
    }

    public final void a(String s)
    {
        bom bom1 = a.a();
        bom1.a(s);
        bom1.a(aco.b(c));
        a.a(bom1, b);
    }

    public final void b(Intent intent)
    {
        intent = intent.getExtras();
        if (intent != null)
        {
            intent = intent.getByteArray("navigation_endpoint");
            if (intent != null)
            {
                c = bqf.a(intent);
            }
        }
    }
}
