// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.ch;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import com.photo.effect.EffectParameter;
import java.util.ArrayList;
import myobfuscated.cg.g;

// Referenced classes of package myobfuscated.ch:
//            n

final class it>
    implements android.view..OnClickListener
{

    private LinearLayout a;
    private n b;

    public final void onClick(View view)
    {
        EffectParameter effectparameter = EffectParameter.a(n.a(b), "Shape");
        String s = effectparameter.g;
        n.a(a, false, s);
        g g1 = (g)n.b(b).get(0);
        g g2 = (g)n.c(b).get(1);
        if (view.getId() == 0x7f10045e)
        {
            g2.a.setVisibility(0);
            a.findViewById(0x7f100469).setVisibility(0);
            a.findViewById(0x7f100465).setVisibility(0);
            g1.a.setVisibility(0);
            view = "Lines";
        } else
        if (view.getId() == 0x7f10045c)
        {
            g2.a.setVisibility(8);
            a.findViewById(0x7f100469).setVisibility(8);
            a.findViewById(0x7f100465).setVisibility(0);
            g1.a.setVisibility(0);
            view = "Cross";
        } else
        if (view.getId() == 0x7f100460)
        {
            g2.a.setVisibility(8);
            a.findViewById(0x7f100469).setVisibility(8);
            a.findViewById(0x7f100465).setVisibility(0);
            g1.a.setVisibility(0);
            view = "Circles";
        } else
        if (view.getId() == 0x7f100462)
        {
            g2.a.setVisibility(8);
            a.findViewById(0x7f100469).setVisibility(8);
            a.findViewById(0x7f100465).setVisibility(0);
            g1.a.setVisibility(0);
            view = "Squares";
        } else
        {
            if (view.getId() == 0x7f100464)
            {
                s = "Random";
                g2.a.setVisibility(8);
                a.findViewById(0x7f100469).setVisibility(8);
                a.findViewById(0x7f100465).setVisibility(8);
                g1.a.setVisibility(8);
            }
            view = s;
        }
        effectparameter.a(view);
        n.a(a, true, view);
        n.a(b, n.d(b));
    }

    rLayout(n n1, LinearLayout linearlayout)
    {
        b = n1;
        a = linearlayout;
        super();
    }
}
