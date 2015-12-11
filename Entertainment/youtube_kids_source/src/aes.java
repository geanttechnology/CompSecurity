// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public final class aes extends bxg
{

    final FrameLayout a;
    ImageView b;
    private final agd c;
    private final aga d;

    public aes(Activity activity, View view, bqe bqe, bov bov, bxe bxe)
    {
        super(bqe, bov, bxe);
        d = new aet(this);
        b.a(activity);
        a = (FrameLayout)view;
        a.setTag(0x7f10001a, d);
        c = (agd)view.getTag(0x7f100019);
        b = (ImageView)view.getTag(0x7f10001b);
    }

    public aes(Activity activity, bqe bqe, blu blu, bov bov, bxe bxe)
    {
        super(bqe, bov, bxe);
        d = new aet(this);
        b.a(activity);
        a = (FrameLayout)View.inflate(activity, 0x7f040022, null);
        b = (ImageView)a.findViewById(0x7f10008a);
        b.setImageResource(0x7f020060);
        activity = new byc(blu, b);
        bqe = new byc(blu, (ImageView)a.findViewById(0x7f1000c2));
        c = new agd((TextView)a.findViewById(0x7f1000bd), activity, bqe, a);
        a.setTag(0x7f10001a, d);
        a.setTag(0x7f100019, c);
        a.setTag(0x7f10001b, b);
    }

    static ImageView a(aes aes1)
    {
        return aes1.b;
    }

    static void b(aes aes1)
    {
        aes1.a();
    }

    public final View a(bxh bxh, bra bra1)
    {
        super.a(bxh, bra1);
        bxh = c;
        if (bra1.b == null)
        {
            bra1.b = byf.a(bra1.a.c);
        }
        CharSequence charsequence = bra1.b;
        if (bra1.c == null)
        {
            bra1.c = new btu(bra1.a.a);
        }
        btu btu1 = bra1.c;
        if (bra1.d == null)
        {
            bra1.d = new btu(bra1.a.e);
        }
        bxh.a(new age(charsequence, btu1, bra1.d));
        a.setTag(0x7f100016, new aeu(this));
        return a;
    }

    public final volatile View a(bxh bxh, bsn bsn)
    {
        return a(bxh, (bra)bsn);
    }

    public final volatile View a(bxh bxh, bvz bvz)
    {
        return a(bxh, (bra)bvz);
    }
}
