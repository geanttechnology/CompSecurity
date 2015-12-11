// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.google.android.apps.youtube.kids.ui.NumberPad;
import java.util.Arrays;
import java.util.Random;

public final class xx extends za
    implements afn, android.view.View.OnClickListener
{

    public xy a;
    private View c;
    private View d;
    private View e;
    private View f;
    private Animation g;
    private int h;
    private int i[];
    private int j[];
    private int k[];

    public xx()
    {
        h = 0;
    }

    private void a(int l, String s)
    {
        if (l >= 4 || l < 0)
        {
            return;
        } else
        {
            ((TextView)c.findViewById(k[l])).setText(s);
            return;
        }
    }

    public final void a(int l)
    {
        boolean flag = false;
        a(h, Integer.toString(l));
        j[h] = l;
        h = h + 1;
        if (h >= 4)
        {
            if (Arrays.equals(i, j))
            {
                a.a(true);
            } else
            {
                if (f != null)
                {
                    f.startAnimation(g);
                }
                h = 0;
                l = ((flag) ? 1 : 0);
                while (l < 4) 
                {
                    a(l, "");
                    l++;
                }
            }
        }
    }

    public final void onClick(View view)
    {
        if (view == d)
        {
            a.a(false);
        } else
        if (view == e && h > 0)
        {
            h = h - 1;
            a(h, "");
            return;
        }
    }

    public final View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        c = layoutinflater.inflate(0x7f040050, viewgroup, false);
        layoutinflater.inflate(0x7f040048, (ViewGroup)c.findViewById(0x7f100171));
        d = c.findViewById(0x7f1000f3);
        e = c.findViewById(0x7f10015e);
        f = c.findViewById(0x7f100159);
        layoutinflater = c.findViewById(0x7f10016f);
        ((NumberPad)c.findViewById(0x7f100172)).a = this;
        e.setOnClickListener(this);
        d.setOnClickListener(this);
        layoutinflater.setOnClickListener(this);
        g = AnimationUtils.loadAnimation(getActivity(), 0x7f05001c);
        layoutinflater = getResources().getStringArray(0x7f0f0001);
        viewgroup = new Random();
        i = new int[4];
        j = new int[4];
        bundle = new StringBuilder();
        for (int l = 0; l < 4; l++)
        {
            if (l != 0)
            {
                bundle.append(", ");
            }
            int i1 = viewgroup.nextInt(10);
            i[l] = i1;
            bundle.append(layoutinflater[i1].toUpperCase());
        }

        ((TextView)c.findViewById(0x7f100170)).setText(bundle.toString());
        k = new int[4];
        k[0] = 0x7f10015a;
        k[1] = 0x7f10015b;
        k[2] = 0x7f10015c;
        k[3] = 0x7f10015d;
        return c;
    }
}
