// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.view.View;

// Referenced classes of package jumiomobile:
//            kt, gs, hq, bq, 
//            ld, nu, ku

class lc
    implements android.view.View.OnClickListener
{

    final kt a;

    private lc(kt kt1)
    {
        a = kt1;
        super();
    }

    lc(kt kt1, ku ku)
    {
        this(kt1);
    }

    public void onClick(View view)
    {
        int i = 0;
        view.setEnabled(false);
        kt.b(a).E();
        view = kt.b(a).s();
        bq bq1;
        boolean flag;
        if (view != hq.j && view != hq.k && kt.b(a).l())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bq1 = a.c;
        if (!flag)
        {
            i = 8;
        }
        bq1.setVisibility(i);
        a.c.setEnabled(flag);
        a.e();
        kt.h(a);
        kt.a(a, new ld(this, view));
        kt.a(a).a();
    }
}
