// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import android.content.DialogInterface;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.sdk:
//            eb, a, b, aw

class it>
    implements android.content.gInterface.OnClickListener
{

    final a a;
    final int b;
    final eb c;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        HashMap hashmap = new HashMap();
        hashmap.put("sourceEvent", a.c().a.a());
        c.a(aw.q, hashmap, c.getAdController(), b + 1);
        dialoginterface.dismiss();
    }

    ogInterface(eb eb1, a a1, int i)
    {
        c = eb1;
        a = a1;
        b = i;
        super();
    }
}
