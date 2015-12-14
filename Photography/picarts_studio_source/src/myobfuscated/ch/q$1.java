// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import com.photo.effect.EffectParameter;

// Referenced classes of package myobfuscated.ch:
//            q

final class it>
    implements android.view..OnClickListener
{

    private LinearLayout a;
    private q b;

    public final void onClick(View view)
    {
        EffectParameter effectparameter = EffectParameter.a(q.a(b), "Mode");
        String s = effectparameter.g;
        q.a(a, s);
        Log.e("ex1", "onClick suntan");
        if (view.getId() == 0x7f100482)
        {
            Log.e("ex1", "suntan_mode1");
            if (s.compareTo("Mode1") != 0)
            {
                Log.e("ex1", "compareTo mode1");
                effectparameter.a("Mode1");
                q.a(b, q.b(b));
            }
            a.findViewById(0x7f100481).setVisibility(0);
        } else
        {
            if (view.getId() == 0x7f100484)
            {
                if (s.compareTo("Mode2") != 0)
                {
                    effectparameter.a("Mode2");
                    q.b(b, q.c(b));
                }
                a.findViewById(0x7f100483).setVisibility(0);
                return;
            }
            if (view.getId() == 0x7f100486)
            {
                if (s.compareTo("Mode3") != 0)
                {
                    effectparameter.a("Mode3");
                    q.c(b, q.d(b));
                }
                a.findViewById(0x7f100485).setVisibility(0);
                return;
            }
            if (view.getId() == 0x7f100488)
            {
                if (s.compareTo("Mode4") != 0)
                {
                    effectparameter.a("Mode4");
                    q.d(b, q.e(b));
                }
                a.findViewById(0x7f100487).setVisibility(0);
                return;
            }
            if (view.getId() == 0x7f10048a)
            {
                if (s.compareTo("Mode5") != 0)
                {
                    effectparameter.a("Mode5");
                    q.e(b, q.f(b));
                }
                a.findViewById(0x7f100489).setVisibility(0);
                return;
            }
        }
    }

    rLayout(q q1, LinearLayout linearlayout)
    {
        b = q1;
        a = linearlayout;
        super();
    }
}
