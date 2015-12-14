// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.cm;

import android.app.Activity;
import android.graphics.Point;
import com.photo.effect.Effect;
import com.socialin.android.photo.effects.factory.b;
import myobfuscated.ay.e;
import myobfuscated.ck.a;
import myobfuscated.ck.c;

public class h
{

    public boolean a;
    public a b;

    public h(a a1, boolean flag)
    {
        b = a1;
        a = flag;
        super();
    }

    public void a(Effect effect, boolean flag, long l, Point point)
    {
        if (effect == myobfuscated.ck.a.a(b).i)
        {
            if (!a && flag)
            {
                Activity activity = b.getActivity();
                if (activity != null)
                {
                    String s = myobfuscated.ck.a.a(b).k.a(effect.d);
                    e.a(activity.getApplicationContext(), s, point.x, point.y, l);
                }
            }
            myobfuscated.ck.a.a(b, effect, flag);
        }
    }
}
