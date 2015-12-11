// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g;

import android.view.ViewGroup;
import org.json.JSONObject;

// Referenced classes of package com.j.a.g:
//            o

final class r
    implements Runnable
{

    final boolean a;
    final int b;
    final ViewGroup c;
    final int d;
    final JSONObject e;

    r(boolean flag, int i, ViewGroup viewgroup, int j, JSONObject jsonobject)
    {
        a = flag;
        b = i;
        c = viewgroup;
        d = j;
        e = jsonobject;
        super();
    }

    public void run()
    {
        if (a)
        {
            o.a(b, c, d, e);
            return;
        } else
        {
            o.b(b, c, d, e);
            return;
        }
    }
}
