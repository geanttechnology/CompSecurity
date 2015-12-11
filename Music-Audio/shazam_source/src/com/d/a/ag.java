// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a;

import android.content.Context;
import android.widget.RelativeLayout;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.d.a:
//            aj, al

final class ag extends RelativeLayout
{

    aj a;
    Context b;
    boolean c;
    boolean d;
    private String e;
    private int f;

    static android.widget.RelativeLayout.LayoutParams a()
    {
        return new android.widget.RelativeLayout.LayoutParams(-1, -1);
    }

    final al b()
    {
        this;
        JVM INSTR monitorenter ;
        List list = a.a(b, Arrays.asList(new String[] {
            e
        }), f);
        al al1 = null;
        if (!list.isEmpty())
        {
            al1 = (al)list.get(0);
            al1.setOnClickListener(a);
        }
        this;
        JVM INSTR monitorexit ;
        return al1;
        Exception exception;
        exception;
        throw exception;
    }
}
