// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class afe extends bxg
{

    private final agd a;
    private final LinearLayout b;
    private final TextView c;
    private final ImageView d;
    private final aga e;

    public afe(Activity activity, View view, bqe bqe, bov bov, bxe bxe)
    {
        super(bqe, bov, bxe);
        e = new aff(this);
        b.a(activity);
        b = (LinearLayout)view;
        b.setTag(0x7f10001a, e);
        a = (agd)view.getTag(0x7f100019);
        d = (ImageView)view.getTag(0x7f10001f);
        c = (TextView)view.getTag(0x7f10001e);
    }

    public afe(Activity activity, bqe bqe, blu blu, bov bov, bxe bxe)
    {
        super(bqe, bov, bxe);
        e = new aff(this);
        b.a(activity);
        b = (LinearLayout)View.inflate(activity, 0x7f040024, null);
        c = (TextView)b.findViewById(0x7f1000c7);
        d = (ImageView)b.findViewById(0x7f10008a);
        activity = new byc(blu, d);
        a = new agd((TextView)b.findViewById(0x7f1000c8), activity, b);
        b.setTag(0x7f100019, a);
        b.setTag(0x7f10001a, e);
        b.setTag(0x7f10001f, d);
        b.setTag(0x7f10001e, c);
    }

    static ImageView a(afe afe1)
    {
        return afe1.d;
    }

    static void b(afe afe1)
    {
        afe1.a();
    }

    public final View a(bxh bxh, brg brg1)
    {
        super.a(bxh, brg1);
        bxh = a;
        if (brg1.b == null)
        {
            brg1.b = byf.a(brg1.a.b);
        }
        CharSequence charsequence = brg1.b;
        if (brg1.d == null)
        {
            brg1.d = new btu(brg1.a.a);
        }
        bxh.a(new age(charsequence, brg1.d));
        bxh = c;
        if (brg1.c == null)
        {
            brg1.c = byf.a(brg1.a.c);
        }
        bxh.setText(brg1.c);
        b.setTag(0x7f100016, new afg(this));
        return b;
    }

    public final volatile View a(bxh bxh, bsn bsn)
    {
        return a(bxh, (brg)bsn);
    }

    public final volatile View a(bxh bxh, bvz bvz)
    {
        return a(bxh, (brg)bvz);
    }
}
