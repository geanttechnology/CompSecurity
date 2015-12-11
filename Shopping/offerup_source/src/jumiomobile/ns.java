// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import android.content.Context;
import android.widget.RelativeLayout;
import com.jumio.netverify.sdk.gui.view.TemplateMatcherDrawView;

// Referenced classes of package jumiomobile:
//            mt, bg, mn, nl, 
//            mf, nu

public class ns extends RelativeLayout
    implements mt
{

    private nl a;
    private TemplateMatcherDrawView b;
    private mn c;

    public ns(Context context, nu nu)
    {
        super(context);
        int i = (int)bg.a(context, 2.0F);
        int j = (int)bg.a(context, 100F);
        c = new mn(context, nu);
        c.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        addView(c);
        a = new nl(context);
        a.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(j, j));
        a.setBorderWidth(i);
        a.setVisibility(8);
        a.setId(mf.X);
        addView(a);
        b = new TemplateMatcherDrawView(context);
        b.setLayoutParams(new android.widget.RelativeLayout.LayoutParams(-1, -1));
        b.setId(mf.W);
        addView(b);
    }

    public int a(int i)
    {
        return c.a(i);
    }

    public void a(boolean flag)
    {
        c.a(flag);
    }

    public nl getProgressView()
    {
        return a;
    }

    public int getROIXOffset()
    {
        return c.getROIXOffset();
    }

    public TemplateMatcherDrawView getResultView()
    {
        return b;
    }

    public void setIsFrontCam(boolean flag)
    {
        c.setIsFrontCam(flag);
    }
}
