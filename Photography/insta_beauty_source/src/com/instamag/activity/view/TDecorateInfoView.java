// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.instamag.activity.view;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bfg;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import junit.framework.Assert;

public class TDecorateInfoView extends RelativeLayout
{

    private static final String TAG = "TDecorateInfoView";
    private ImageView contentImageView;
    private TextView contentTextView;
    private bfg decorateInfo;

    public TDecorateInfoView(Context context, bfg bfg1)
    {
        super(context);
        Assert.assertNotNull(bfg1);
        decorateInfo = bfg1;
        createSubViews(context);
        configSubViewByInfo(bfg1);
    }

    private void configSubViewByInfo(bfg bfg1)
    {
        Assert.assertNotNull(contentImageView);
        Assert.assertNotNull(contentTextView);
        if (bfg1.a != null)
        {
            contentImageView.setImageBitmap(bfg1.a);
        }
        if (bfg1.r)
        {
            contentTextView.setBackgroundColor(bfg1.c);
            contentTextView.setTextColor(bfg1.y);
            contentTextView.setGravity(bfg1.F);
            Object obj = contentTextView;
            int i;
            if (bfg1.G <= 0)
            {
                i = 1;
            } else
            {
                i = bfg1.G;
            }
            ((TextView) (obj)).setLines(i);
            contentTextView.setTextSize(bfg1.u);
            obj = bfg1.x;
            if (bfg1.q == 2)
            {
                obj = bfg1.x;
            } else
            if (bfg1.q == 4)
            {
                obj = (new SimpleDateFormat("h:mm a", Locale.US)).format(new Date());
            } else
            if (bfg1.q == 6)
            {
                obj = (new SimpleDateFormat("EEE, MMM d", Locale.US)).format(new Date());
            } else
            if (bfg1.q == 8)
            {
                obj = (new SimpleDateFormat("MMM d, YYYY", Locale.US)).format(new Date());
            } else
            if (bfg1.q == 12)
            {
                obj = (new SimpleDateFormat("dd", Locale.US)).format(new Date());
            }
            if (bfg1.v == null || bfg1.v.length() == 0)
            {
                contentTextView.setText(getSpanString(((String) (obj)), bfg1));
            }
            if (bfg1.B)
            {
                contentTextView.setShadowLayer(2.0F, 1.0F, 1.0F, Color.argb(126, 0, 0, 0));
            }
        }
    }

    private void createSubViews(Context context)
    {
        context = View.inflate(context, 0x7f030050, this);
        contentImageView = (ImageView)context.findViewById(0x7f0d01d5);
        contentTextView = (TextView)context.findViewById(0x7f0d01d6);
    }

    private SpannableString getSpanString(String s, bfg bfg1)
    {
        s = new SpannableString(s);
        if (bfg1.t)
        {
            s.setSpan(new StyleSpan(1), 0, s.length(), 0);
        }
        if (bfg1.D)
        {
            s.setSpan(new UnderlineSpan(), 0, s.length(), 0);
        }
        if (bfg1.E)
        {
            s.setSpan(new StyleSpan(2), 0, s.length(), 0);
        }
        return s;
    }

    public int currentTextCount()
    {
        return contentTextView.getText().length();
    }

    public bfg getDecorateInfo()
    {
        return decorateInfo;
    }

    public void setTextViewText(String s)
    {
        contentTextView.setText(getSpanString(s, decorateInfo));
    }
}
