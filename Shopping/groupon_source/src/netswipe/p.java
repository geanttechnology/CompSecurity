// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.view.OrientationEventListener;

// Referenced classes of package netswipe:
//            o, cz, an, c

class p extends OrientationEventListener
{

    final o a;

    p(o o1, Context context, int i)
    {
        a = o1;
        super(context, i);
    }

    public void onOrientationChanged(int i)
    {
        if (i != -1)
        {
            an an1 = o.a(a).c();
            o.a(a).d();
            if (o.a(a).j() && (an1 == an.b && o.a(a).c() == an.d || an1 == an.d && o.a(a).c() == an.b || o.a(a).b() && an1 == an.a && o.a(a).c() == an.c || o.a(a).b() && an1 == an.c && o.a(a).c() == an.a))
            {
                o.b(a).l();
                return;
            }
        }
    }
}
