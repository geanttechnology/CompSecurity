// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.e;

import com.j.a.d.e;
import org.json.JSONObject;

// Referenced classes of package com.j.a.e:
//            ah

class ai
    implements Runnable
{

    final JSONObject a;
    final ah b;

    ai(ah ah, JSONObject jsonobject)
    {
        b = ah;
        a = jsonobject;
        super();
    }

    public void run()
    {
        e.e().a(a);
    }
}
