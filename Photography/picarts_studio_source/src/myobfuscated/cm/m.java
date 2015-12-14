// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cm;

import android.app.Activity;
import android.graphics.Point;
import myobfuscated.ay.e;
import myobfuscated.cj.b;
import myobfuscated.ck.a;
import myobfuscated.ck.c;

public class m
{

    public boolean a;
    public a b;

    public m(a a1, boolean flag)
    {
        b = a1;
        a = flag;
        super();
    }

    public void a(boolean flag, long l)
    {
        myobfuscated.ck.a.a(b).e = false;
        if (flag && a)
        {
            myobfuscated.ck.a.w(b).a(null, null);
            Activity activity = b.getActivity();
            if (activity != null)
            {
                e.a(activity.getApplicationContext(), myobfuscated.ck.a.a(b).k.a("None"), myobfuscated.ck.a.c(b).x, myobfuscated.ck.a.c(b).y, l);
            }
        }
        myobfuscated.ck.a.a(b, flag, a);
    }
}
