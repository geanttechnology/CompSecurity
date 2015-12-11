// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

// Referenced classes of package jumiomobile:
//            nu, mm, bg, cv, 
//            ce, mf

public class ml extends nu
{

    private TextView a;
    private mm k;
    private ProgressBar l;

    public ml(Context context)
    {
        super(context);
        k = mm.a;
        setCenterText(false);
        (new android.widget.RelativeLayout.LayoutParams(-1, -1)).addRule(10);
        a = new TextView(context);
        Object obj = new android.widget.RelativeLayout.LayoutParams(-2, -1);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(13);
        a.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        a.setVisibility(8);
        a.setTextSize(0, bg.b(context, 14F));
        obj = ce.b(context, cv.a(context, "netverify_infoBarTextColor", "attr"), -1);
        a.setTextColor(((android.content.res.ColorStateList) (obj)));
        a.setId(mf.ax);
        a.setGravity(17);
        a.setPadding(0, 0, 0, 0);
        a.setMaxLines(1);
        addView(a);
        l = new ProgressBar(context);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(10);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(12);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
        int i = (int)bg.a(context, 11F);
        obj.bottomMargin = i;
        obj.topMargin = i;
        obj.leftMargin = (int)bg.a(context, 7F);
        l.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        l.setId(mf.e);
        l.setVisibility(8);
        l.getIndeterminateDrawable().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
        addView(l);
    }

    private void b()
    {
        a.setVisibility(8);
        e.setVisibility(0);
        g.setVisibility(0);
        b.setVisibility(0);
    }

    private void c()
    {
    }

    protected void a(Context context)
    {
        super.a(context);
        e.setTextColor(-1);
    }

    protected void b(Context context)
    {
        h = (int)bg.a(context, 28F);
        i = (int)bg.a(context, 10F);
        g = new ImageView(context);
        context = new android.widget.RelativeLayout.LayoutParams(h, -2);
        context.addRule(15);
        context.addRule(9);
        context.leftMargin = i;
        g.setLayoutParams(context);
        g.setId(mf.K);
        g.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        g.setVisibility(8);
        addView(g);
    }

    public void setShowLoading(boolean flag)
    {
        byte byte0 = 8;
        this;
        JVM INSTR monitorenter ;
        Object obj = l;
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
            i = 8;
        } else
        {
            i = 0;
        }
        ((ImageView) (obj)).setVisibility(i);
        obj = b;
        if (flag)
        {
            i = byte0;
        } else
        {
            i = 0;
        }
        ((TextView) (obj)).setVisibility(i);
        e.setTextColor(-1);
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void setText(CharSequence charsequence)
    {
        this;
        JVM INSTR monitorenter ;
        if (charsequence == null) goto _L2; else goto _L1
_L1:
        boolean flag = charsequence.toString().isEmpty();
        if (!flag) goto _L3; else goto _L2
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L3:
        if (k != mm.a)
        {
            if (k == mm.d)
            {
                c();
            }
            b();
        }
        charsequence = charsequence.toString();
        e.setText(charsequence);
        k = mm.a;
        if (true) goto _L2; else goto _L4
_L4:
        charsequence;
        throw charsequence;
    }
}
