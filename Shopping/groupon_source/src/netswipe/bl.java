// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

// Referenced classes of package netswipe:
//            dc, as, ap, ao

public abstract class bl extends LinearLayout
{

    protected RelativeLayout a;
    protected Button b;

    public bl(Context context)
    {
        super(context);
        int i = dc.a(context, 10);
        int j = dc.a(context, 25);
        int k = dc.a(context, 10);
        setOrientation(1);
        a = new RelativeLayout(context);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        a.setLayoutParams(layoutparams);
        a.setPadding(j, 0, k, 0);
        a.setBackgroundColor(0xccffffff);
        a.setId(as.x);
        addView(a);
        b = new Button(context);
        context = new android.widget.LinearLayout.LayoutParams(-1, -2);
        context.setMargins(i, i, i, 0);
        b.setLayoutParams(context);
        b.setId(as.y);
        ao.a(b, ap.a(getResources()));
        b.setTextColor(-1);
        b.setTextSize(2, 20F);
        addView(b);
        context = new android.widget.RelativeLayout.LayoutParams(-1, -2);
        context.addRule(15);
        setLayoutParams(context);
    }

    public void setButtonOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        b.setOnClickListener(onclicklistener);
    }

    public void setButtonText(CharSequence charsequence)
    {
        b.setText(charsequence);
    }
}
