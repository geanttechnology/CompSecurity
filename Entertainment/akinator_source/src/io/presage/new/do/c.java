// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.new.do;

import android.app.Activity;
import io.presage.new.b;
import io.presage.utils.e;

// Referenced classes of package io.presage.new.do:
//            b

final class c
    implements a.a
{

    final io.presage.new.do.b a;

    c(io.presage.new.do.b b1)
    {
        a = b1;
        super();
    }

    public final void a(Activity activity)
    {
        e.b(new String[] {
            io/presage/new/do/b.getName(), "onEnter", activity.getClass().getName()
        });
        if (b.a(a) != null)
        {
            io.presage.new.do.b.b(a).a();
        }
    }
}
