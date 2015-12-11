// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.for;

import android.view.View;
import io.presage.model.Zone;
import io.presage.try.h;
import io.presage.utils.n;
import shared_presage.com.google.gson.Gson;

// Referenced classes of package io.presage.for:
//            b

final class j
    implements Runnable
{

    final String a;
    final String b;
    final b c;

    j(b b1, String s, String s1)
    {
        c = b1;
        a = s;
        b = s1;
        super();
    }

    public final void run()
    {
        io.presage.try.a a1 = io.presage.for.b.a(c).a(a);
        if (a1 != null)
        {
            Zone zone = (Zone)(new Gson()).fromJson(b, io/presage/model/Zone);
            android.widget.FrameLayout.LayoutParams layoutparams = n.a(zone);
            ((View)a1).setLayoutParams(layoutparams);
            n.a((View)a1, zone);
        }
    }
}
