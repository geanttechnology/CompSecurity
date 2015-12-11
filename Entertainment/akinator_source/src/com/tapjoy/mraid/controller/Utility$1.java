// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.mraid.controller;

import android.content.DialogInterface;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.tapjoy.mraid.controller:
//            Utility

final class d
    implements android.content.rface.OnClickListener
{

    final List a;
    final String b;
    final String c;
    final String d;
    final Utility e;

    public final void onClick(DialogInterface dialoginterface, int i)
    {
        Map map = (Map)a.get(i);
        Utility.a(e, Integer.parseInt((String)map.get("ID")), b, c, d);
        dialoginterface.cancel();
    }

    kListener(Utility utility, List list, String s, String s1, String s2)
    {
        e = utility;
        a = list;
        b = s;
        c = s1;
        d = s2;
        super();
    }
}
