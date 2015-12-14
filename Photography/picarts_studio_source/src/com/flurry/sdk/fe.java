// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.view.View;
import android.widget.ImageView;
import java.io.File;

// Referenced classes of package com.flurry.sdk:
//            i, ab, kc, kj, 
//            dt, jm, jo

public class fe
{

    private static final String a = com/flurry/sdk/fe.getSimpleName();

    public fe()
    {
    }

    static String a()
    {
        return a;
    }

    public void a(View view, int j, String s)
    {
        Object obj = i.a().l().a(j, s);
        if (obj == null)
        {
            kc.a(3, a, (new StringBuilder("Cached asset not available for image:")).append(s).toString());
            obj = new kj();
            ((kj) (obj)).a(s);
            ((kj) (obj)).d(40000);
            ((kj) (obj)).a(kl.a.b);
            ((kj) (obj)).b(new dt());
            ((kj) (obj)).a(new _cls3(view));
            jm.a().a(this, ((ls) (obj)));
            return;
        } else
        {
            kc.a(3, a, (new StringBuilder("Cached asset present for image:")).append(s).toString());
            s = ((File) (obj)).getAbsolutePath();
            jo.a().a(new _cls4(view, s));
            return;
        }
    }

    public void a(ImageView imageview, int j, String s)
    {
        Object obj = i.a().l().a(j, s);
        if (obj == null)
        {
            kc.a(3, a, (new StringBuilder("Cached asset not available for image:")).append(s).toString());
            obj = new kj();
            ((kj) (obj)).a(s);
            ((kj) (obj)).d(40000);
            ((kj) (obj)).a(kl.a.b);
            ((kj) (obj)).b(new dt());
            ((kj) (obj)).a(new _cls1(imageview));
            jm.a().a(this, ((ls) (obj)));
            return;
        } else
        {
            kc.a(3, a, (new StringBuilder("Cached asset present for image:")).append(s).toString());
            s = ((File) (obj)).getAbsolutePath();
            jo.a().a(new _cls2(imageview, s));
            return;
        }
    }


    /* member class not found */
    class _cls3 {}


    /* member class not found */
    class _cls4 {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
