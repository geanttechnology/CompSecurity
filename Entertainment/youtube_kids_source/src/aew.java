// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.concurrent.ExecutorService;

public final class aew extends bxg
{

    private final ExecutorService a;
    private final agd b;
    private final FrameLayout c;
    private final TextView d;
    private final ImageView e;
    private afa f;
    private final blo g;
    private final aga h;

    public aew(ExecutorService executorservice, Activity activity, View view, bqe bqe, bov bov, bxe bxe)
    {
        super(bqe, bov, bxe);
        g = new aex(this);
        h = new aey(this);
        b.a(activity);
        a = executorservice;
        f = null;
        c = (FrameLayout)view;
        c.setTag(0x7f10001a, h);
        b = (agd)view.getTag(0x7f100019);
        d = (TextView)view.getTag(0x7f10001d);
        e = (ImageView)view.getTag(0x7f10001c);
    }

    public aew(ExecutorService executorservice, Activity activity, bqe bqe, blu blu, bov bov, bxe bxe)
    {
        super(bqe, bov, bxe);
        g = new aex(this);
        h = new aey(this);
        b.a(activity);
        a = executorservice;
        f = null;
        c = (FrameLayout)View.inflate(activity, 0x7f040023, null);
        d = (TextView)c.findViewById(0x7f1000c5);
        e = (ImageView)c.findViewById(0x7f10008a);
        executorservice = new byc(blu, e);
        executorservice.a(0x7f020060);
        b = new agd((TextView)c.findViewById(0x7f1000c6), executorservice, c, g);
        c.setTag(0x7f100019, b);
        c.setTag(0x7f10001a, h);
        c.setTag(0x7f10001d, d);
        c.setTag(0x7f10001c, e);
    }

    static afa a(aew aew1)
    {
        return aew1.f;
    }

    static afa a(aew aew1, afa afa)
    {
        aew1.f = afa;
        return afa;
    }

    static ExecutorService b(aew aew1)
    {
        return aew1.a;
    }

    static FrameLayout c(aew aew1)
    {
        return aew1.c;
    }

    static ImageView d(aew aew1)
    {
        return aew1.e;
    }

    static void e(aew aew1)
    {
        aew1.a();
    }

    public final View a(bxh bxh, brd brd1)
    {
        Object obj = brd1.a.d;
        if (obj != null && ((dre) (obj)).e == null && ((dre) (obj)).h == null && ((dre) (obj)).c != null)
        {
            String s = ((dre) (obj)).c.a;
            if (!TextUtils.isEmpty(s))
            {
                eda eda1 = new eda();
                eda1.b = s.substring(2);
                obj.e = eda1;
            }
        }
        super.a(bxh, brd1);
        bxh = b;
        if (brd1.b == null)
        {
            brd1.b = byf.a(brd1.a.b);
        }
        obj = brd1.b;
        btc btc1 = brd1.d;
        if (btc1.b == null)
        {
            btc1.b = new btu(btc1.a);
        }
        bxh.a(new age(((CharSequence) (obj)), btc1.b));
        bxh = d;
        if (brd1.c == null)
        {
            brd1.c = byf.a(brd1.a.c);
        }
        bxh.setText(brd1.c);
        c.setTag(0x7f100016, new aez(this));
        return c;
    }

    public final volatile View a(bxh bxh, bsn bsn)
    {
        return a(bxh, (brd)bsn);
    }

    public final volatile View a(bxh bxh, bvz bvz)
    {
        return a(bxh, (brd)bvz);
    }
}
