// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.view.ViewGroup;
import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            o

final class p
    implements Runnable
{

    final ViewGroup a;
    final int b;
    final JSONObject c;

    p(ViewGroup viewgroup, int i, JSONObject jsonobject)
    {
        a = viewgroup;
        b = i;
        c = jsonobject;
        super();
    }

    public void run()
    {
        o.a(a, b, c);
    }
}
