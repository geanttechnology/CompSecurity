// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package netswipe:
//            bl, dc, as, aq

public class az extends bl
{

    private TextView c;

    public az(Context context)
    {
        super(context);
        int i = dc.a(context, 117);
        Object obj = new ImageView(context);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, i);
        layoutparams.addRule(11);
        layoutparams.addRule(15);
        ((ImageView) (obj)).setLayoutParams(layoutparams);
        ((ImageView) (obj)).setId(as.A);
        ((ImageView) (obj)).setImageBitmap(aq.a(context, "info_view_error"));
        a.addView(((android.view.View) (obj)));
        c = new TextView(context);
        obj = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(9);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(15);
        ((android.widget.RelativeLayout.LayoutParams) (obj)).addRule(0, as.A);
        c.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
        c.setId(as.z);
        c.setTextColor(0xff000000);
        c.setTypeface(null, 1);
        c.setTextSize(0, dc.a(context, 12));
        a.addView(c);
    }

    public void setErrorText(String s)
    {
        c.setText(s);
    }
}
