// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            s, cl, aw, k, 
//            cn, dc

final class a
    implements Runnable
{

    final s a;

    public final void run()
    {
        s s1;
        s1 = a;
        s1.b().c(.e);
        s1.b().b(.f);
        if (s1.e.b()) goto _L2; else goto _L1
_L1:
        s1.c = new k(e, "Unable to create the assets needed to display ads");
        s1.d.d("Unable to create the assets needed to display ads", null);
        s1.a(s1.c);
_L4:
        s.a(a);
        return;
_L2:
        Object obj = s1.a();
        boolean flag;
        if ((() (obj)).a == 200)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            obj = (new StringBuilder()).append((() (obj)).a).append(" - ").append((() (obj)).b).toString();
            s1.c = new k(a, ((String) (obj)));
            s1.d.d(((String) (obj)), null);
            s1.a(s1.c);
        } else
        {
            obj = (() (obj)).a().b();
            if (obj == null)
            {
                s1.c = new k(d, "Unable to parse response");
                s1.d.d("Unable to parse response", null);
                s1.a(s1.c);
            } else
            {
                s1.a(((org.json.JSONObject) (obj)));
                s1.b().c(.g);
                s1.b().b(.h);
            }
        }
        continue; /* Loop/switch isn't completed */
        obj;
        s1.c = ((.h) (obj)).a;
        s1.d.d((() (obj)).a.b, null);
        s1.a(s1.c);
        if (true) goto _L4; else goto _L3
_L3:
    }

    (s s1)
    {
        a = s1;
        super();
    }
}
