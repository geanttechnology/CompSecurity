// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package netswipe:
//            dc, as, ar

public class cc extends RelativeLayout
{

    private ProgressBar a;
    private ImageView b;
    private TextView c;

    public cc(Context context)
    {
        super(context);
        int i = dc.a(context, 51);
        int j = dc.a(context, 10);
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, i);
        layoutparams.addRule(10);
        setLayoutParams(layoutparams);
        a = new ProgressBar(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
        layoutparams.addRule(10);
        layoutparams.addRule(12);
        layoutparams.addRule(9);
        int k = dc.a(context, 10);
        layoutparams.bottomMargin = k;
        layoutparams.topMargin = k;
        layoutparams.leftMargin = dc.a(context, 6);
        a.setLayoutParams(layoutparams);
        a.setId(as.b);
        a.setVisibility(8);
        addView(a);
        b = new ImageView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(dc.a(context, 50), i);
        layoutparams.addRule(10);
        layoutparams.addRule(12);
        layoutparams.addRule(11);
        b.setLayoutParams(layoutparams);
        b.setId(as.c);
        b.setScaleType(android.widget.ImageView.ScaleType.CENTER_INSIDE);
        b.setVisibility(8);
        addView(b);
        c = new TextView(context);
        layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
        layoutparams.addRule(1, as.b);
        c.setLayoutParams(layoutparams);
        c.setId(as.d);
        c.setTextColor(-1);
        c.setTypeface(null, 1);
        c.setTextSize(0, dc.a(context, 13));
        c.setText(ar.a(context, "top_info_align_card"));
        c.setGravity(17);
        c.setPadding(j, 0, j, 0);
        addView(c);
        setBackgroundColor(0x99000000);
    }

    public void a(boolean flag)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)getLayoutParams();
        Context context = getContext();
        byte byte0;
        if (flag)
        {
            byte0 = 51;
        } else
        {
            byte0 = 34;
        }
        layoutparams.height = dc.a(context, byte0);
        setLayoutParams(layoutparams);
    }

    public void setRightImage(Bitmap bitmap)
    {
        b.setImageBitmap(bitmap);
        if (bitmap == null)
        {
            b.setEnabled(false);
            b.setVisibility(8);
            return;
        } else
        {
            b.setEnabled(true);
            b.setVisibility(0);
            return;
        }
    }

    public void setRightImageViewClickListener(android.view.View.OnClickListener onclicklistener)
    {
        b.setOnClickListener(onclicklistener);
    }

    public void setShowLoading(boolean flag)
    {
        ProgressBar progressbar = a;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        progressbar.setVisibility(i);
    }

    public void setText(String s)
    {
        c.setText(s);
    }
}
