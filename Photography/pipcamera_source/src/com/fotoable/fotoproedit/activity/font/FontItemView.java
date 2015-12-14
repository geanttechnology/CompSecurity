// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ew;
import hb;
import iq;

public class FontItemView extends RelativeLayout
{

    private RelativeLayout bg;
    private ImageView font_image;
    private TextView font_label;
    private ImageView font_tip;
    private Boolean selected;

    public FontItemView(Context context)
    {
        super(context);
    }

    public FontItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300d1, this, true);
        selected = Boolean.valueOf(false);
        font_image = (ImageView)findViewById(0x7f0c0326);
        font_label = (TextView)findViewById(0x7f0c0327);
        font_tip = (ImageView)findViewById(0x7f0c0328);
        bg = (RelativeLayout)findViewById(0x7f0c0325);
        setSelected(false);
    }

    public void setIsselected(boolean flag)
    {
        if (flag)
        {
            bg.setBackgroundColor(-27599);
            return;
        } else
        {
            bg.setBackgroundColor(-1);
            return;
        }
    }

    public void setTextWithFont(hb hb1)
    {
        if (!hb1.a && !hb1.e)
        {
            font_label.setVisibility(0);
            font_image.setVisibility(4);
            font_tip.setVisibility(4);
            font_label.setTypeface(hb1.b());
            hb1 = hb1.a().replace(".ttf", "").replace(".TTF", "");
            font_label.setText(hb1);
            font_label.setTextSize(23F);
        } else
        {
            font_image.setVisibility(0);
            font_label.setVisibility(8);
            font_tip.setVisibility(4);
            Object obj = BitmapFactory.decodeResource(getResources(), hb1.c);
            font_image.setImageResource(hb1.c);
            float f = (float)((Bitmap) (obj)).getWidth() / (float)((Bitmap) (obj)).getHeight();
            obj = new android.widget.FrameLayout.LayoutParams(-1, -1);
            obj.height = ew.a(getContext(), 24F);
            obj.width = (int)(f * (float)ew.a(getContext(), 24F)) + ew.a(getContext(), 10F);
            obj.gravity = 51;
            obj.leftMargin = ew.a(getContext(), 5F);
            obj.topMargin = ew.a(getContext(), 8F);
            font_image.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            font_image.setColorFilter(0xff000000, android.graphics.PorterDuff.Mode.MULTIPLY);
            if (!iq.a().b(hb1))
            {
                font_tip.setVisibility(0);
                return;
            }
        }
    }
}
