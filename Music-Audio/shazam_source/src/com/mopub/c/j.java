// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.c;

import android.content.Context;
import android.net.Uri;
import com.mopub.common.i;

public final class j
    implements com.mopub.d.a.f.a
{

    private final String a;
    private final Context b;

    public j(String s, Context context)
    {
        a = s;
        b = context.getApplicationContext();
    }

    public final String a(String s)
    {
        Object obj1;
        if (!s.contains("mp_tmpl_advertising_id") && !s.contains("mp_tmpl_do_not_track"))
        {
            return s;
        }
        obj1 = new com.mopub.common.i.a(a, false);
        if (!i.a(b)) goto _L2; else goto _L1
_L1:
        Object obj = i.b(b);
        if (obj == null) goto _L2; else goto _L3
_L3:
        obj1 = "ifa:";
_L5:
        obj1 = s.replace("mp_tmpl_advertising_id", Uri.encode((new StringBuilder()).append(((String) (obj1))).append(((com.mopub.common.i.a) (obj)).a).toString()));
        if (((com.mopub.common.i.a) (obj)).b)
        {
            s = "1";
        } else
        {
            s = "0";
        }
        return ((String) (obj1)).replace("mp_tmpl_do_not_track", s);
_L2:
        obj = obj1;
        obj1 = "";
        if (true) goto _L5; else goto _L4
_L4:
    }
}
