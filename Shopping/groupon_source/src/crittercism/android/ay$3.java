// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package crittercism.android;

import org.json.JSONObject;

// Referenced classes of package crittercism.android:
//            cq, ay, df, de

final class nit> extends cq
{

    final ay a;
    final JSONObject b;
    final ay c;

    public final void a()
    {
        if (!a.g.c())
        {
            a.z.a(b);
            if (a.z.b())
            {
                a.y();
                return;
            }
        }
    }

    (ay ay1, ay ay2, JSONObject jsonobject)
    {
        c = ay1;
        a = ay2;
        b = jsonobject;
        super();
    }
}
