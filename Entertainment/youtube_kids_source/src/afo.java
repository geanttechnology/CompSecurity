// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public final class afo extends bxg
{

    private final agd a;
    private final FrameLayout b;

    public afo(Activity activity, bqe bqe, blu blu, bov bov, bxe bxe)
    {
        super(bqe, bov, bxe);
        b.a(activity);
        b = (FrameLayout)LayoutInflater.from(activity).inflate(0x7f040058, null);
        activity = new byc(blu, (ImageView)b.findViewById(0x7f10008a));
        a = new afp(this, (TextView)b.findViewById(0x7f1000c8), activity, b);
    }

    static void a(afo afo1)
    {
        afo1.a();
    }

    public final volatile View a(bxh bxh, bsn bsn)
    {
        return a(bxh, (bta)bsn);
    }

    public final View a(bxh bxh, bta bta1)
    {
        super.a(bxh, bta1);
        bxh = a;
        android.text.Spanned spanned = byf.a(bta1.a.a);
        if (bta1.b == null)
        {
            bta1.b = new btu(bta1.a.b);
        }
        bxh.a(new age(spanned, bta1.b));
        b.setTag(0x7f100016, new afq(this));
        return b;
    }

    public final volatile View a(bxh bxh, bvz bvz)
    {
        return a(bxh, (bta)bvz);
    }
}
