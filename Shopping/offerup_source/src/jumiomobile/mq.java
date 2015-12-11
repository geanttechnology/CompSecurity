// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

// Referenced classes of package jumiomobile:
//            nu, bg, mf, at

public class mq extends nu
{

    protected ProgressBar a;

    public mq(Context context)
    {
        super(context);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, (int)bg.a(context, 59F));
        layoutparams.addRule(10);
        setLayoutParams(layoutparams);
        a = new ProgressBar(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams((int)bg.a(context, 28F), -2);
        layoutparams.addRule(10);
        layoutparams.addRule(12);
        layoutparams.addRule(9);
        int i = (int)bg.a(context, 11F);
        layoutparams.bottomMargin = i;
        layoutparams.topMargin = i;
        layoutparams.leftMargin = (int)bg.a(context, 7F);
        a.setLayoutParams(layoutparams);
        a.setId(mf.e);
        a.setVisibility(8);
        at.a(a.getIndeterminateDrawable(), -1);
        bg.a(context, 10F);
        addView(a);
        e.setPadding(this.i + h + f, 0, this.i + h + f, 0);
    }

    public mq(Context context, boolean flag, boolean flag1)
    {
        this(context);
        a(flag, flag);
        setCenterText(flag1);
    }

    public void setShowLoading(boolean flag)
    {
        byte byte0 = 8;
        Object obj = a;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((ProgressBar) (obj)).setVisibility(i);
        obj = g;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((ImageView) (obj)).setVisibility(i);
    }
}
