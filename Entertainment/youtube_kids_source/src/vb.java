// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import java.util.HashMap;
import java.util.Map;

final class vb
    implements Runnable
{

    private va a;

    vb(va va1)
    {
        a = va1;
        super();
    }

    public final void run()
    {
        if (a.h)
        {
            return;
        }
        va va1 = a;
        va1.h = true;
        bnf bnf1 = bnf.a(va1.d);
        bnf1.a("cpn", va1.f);
        Uri uri = bnf1.a.build();
        HashMap hashmap = new HashMap();
        Object obj1 = bnf.a(va1.c.a());
        if (va1.c.a("c3a"))
        {
            Object obj = va1.c;
            int i;
            if (((bsv) (obj)).a() != null)
            {
                obj = ((bsv) (obj)).a().getQueryParameter("c3a");
            } else
            {
                obj = null;
            }
            i = Integer.parseInt(((String) (obj)));
            ((bnf) (obj1)).a("r3a", Integer.toString(va1.g % i));
        }
        if (va1.c.a("c5a"))
        {
            b.b();
            obj = new HashMap();
            ((Map) (obj)).put("challenge", va1.c.a.a);
            ((bnf) (obj1)).a("r5a", va1.b.a("yt_player", ((Map) (obj))));
        }
        hashmap.put("atr", ((bnf) (obj1)).a.build().getEncodedQuery());
        obj = String.valueOf(uri);
        obj1 = String.valueOf(hashmap);
        bmo.e((new StringBuilder(String.valueOf(obj).length() + 17 + String.valueOf(obj1).length())).append("Pinging ").append(((String) (obj))).append("\nParams: ").append(((String) (obj1))).toString());
        obj = va1.a;
        obj = new cqd(1, "atr", 0x323467f);
        ((cqd) (obj)).a(uri);
        obj.g = hashmap;
        obj.d = true;
        va1.a.a(((cqd) (obj)), cni.b);
    }
}
