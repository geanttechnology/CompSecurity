// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;

class pp
    implements Runnable
{

    final String a;
    final aqe b;
    final String c;
    final Context d;
    final ImageView e;
    final pn f;

    pp(pn pn1, String s, aqe aqe1, String s1, Context context, ImageView imageview)
    {
        f = pn1;
        a = s;
        b = aqe1;
        c = s1;
        d = context;
        e = imageview;
        super();
    }

    public void run()
    {
        android.graphics.Bitmap bitmap = yo.a(a, b.a(), b.b(), true);
        pn.a(f, c, bitmap);
        ((Activity)d).runOnUiThread(new pq(this, bitmap));
    }
}
