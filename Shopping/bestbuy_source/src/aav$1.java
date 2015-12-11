// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.fh;
import com.google.android.gms.internal.gu;

final class ang.Object
    implements Runnable
{

    final Context a;
    final fh b;
    final aax c;
    final acf d;
    final String e;

    public void run()
    {
        gu gu1 = gu.a(a, new ay(), false, false, null, b.k);
        gu1.setWillNotDraw(true);
        c.a(gu1);
        ace ace1 = gu1.f();
        ace1.a("/invalidRequest", c.b);
        ace1.a("/loadAdURL", c.c);
        ace1.a("/log", vc.h);
        ace1.a(d);
        acb.a("Loading the JS library.");
        gu1.loadUrl(e);
    }

    (Context context, fh fh1, aax aax1, acf acf, String s)
    {
        a = context;
        b = fh1;
        c = aax1;
        d = acf;
        e = s;
        super();
    }
}
