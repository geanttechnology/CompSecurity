// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import org.json.JSONObject;

// Referenced classes of package android.support.v7:
//            ms, ul

class b
    implements Runnable
{

    final String a;
    final JSONObject b;
    final ms c;

    public void run()
    {
        ms.a(c).b(a, b);
    }

    (ms ms1, String s, JSONObject jsonobject)
    {
        c = ms1;
        a = s;
        b = jsonobject;
        super();
    }
}
