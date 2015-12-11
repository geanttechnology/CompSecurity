// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public final class aer extends bxf
    implements blt, bn
{

    private final blu a;
    private final TextView b;
    private final TextView c;
    private final byc d;
    private ViewGroup e;

    public aer(Activity activity, blu blu1, bov bov, bxe bxe)
    {
        super(bov, bxe);
        a = (blu)b.a(blu1);
        e = (ViewGroup)LayoutInflater.from(activity).inflate(0x7f040020, null);
        activity = (ImageView)e.findViewById(0x7f1000bc);
        d = new byc(a, activity);
        b = (TextView)e.findViewById(0x7f1000bd);
        c = (TextView)e.findViewById(0x7f1000be);
    }

    private void a()
    {
        d.a(0x7f0201e9);
    }

    public final View a(bxh bxh, bqx bqx1)
    {
        super.a(bxh, bqx1);
        TextView textview = b;
        if (bqx1.a.a != null)
        {
            bxh = bqx1.a.a;
        } else
        {
            bxh = "";
        }
        textview.setText(bxh);
        bxh = c;
        if (bqx1.c == null)
        {
            bqx1.c = byf.a(bqx1.a.d);
        }
        bxh.setText(bqx1.c);
        if (bqx1.b == null)
        {
            bqx1.b = new btu(bqx1.a.b);
        }
        bxh = bqx1.b;
        if (bxh.a())
        {
            d.a(bxh, this);
        } else
        {
            a();
        }
        return e;
    }

    public final volatile View a(bxh bxh, bvz bvz)
    {
        return a(bxh, (bqx)bvz);
    }

    public final void a(ImageView imageview)
    {
        a();
    }

    public final void a(ImageView imageview, Bitmap bitmap)
    {
    }
}
