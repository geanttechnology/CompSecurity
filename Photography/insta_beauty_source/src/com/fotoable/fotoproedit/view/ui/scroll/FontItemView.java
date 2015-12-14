// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.view.ui.scroll;

import alr;
import ama;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import yp;

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
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030127, this, true);
        selected = Boolean.valueOf(false);
        font_image = (ImageView)findViewById(0x7f0d043a);
        font_label = (TextView)findViewById(0x7f0d043b);
        font_tip = (ImageView)findViewById(0x7f0d043c);
        bg = (RelativeLayout)findViewById(0x7f0d0439);
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

    public void setTextWithFont(ama ama1)
    {
        if (!ama1.a && !ama1.e)
        {
            font_label.setVisibility(0);
            font_image.setVisibility(4);
            font_tip.setVisibility(4);
            font_label.setTypeface(ama1.b());
            ama1 = ama1.a().replace(".ttf", "").replace(".TTF", "");
            font_label.setText(ama1);
            font_label.setTextSize(23F);
        } else
        {
            font_image.setVisibility(0);
            font_label.setVisibility(8);
            font_tip.setVisibility(4);
            Object obj = BitmapFactory.decodeResource(getResources(), ama1.c);
            font_image.setImageResource(ama1.c);
            float f = (float)((Bitmap) (obj)).getWidth() / (float)((Bitmap) (obj)).getHeight();
            obj = new android.widget.FrameLayout.LayoutParams(-1, -1);
            obj.height = yp.a(getContext(), 24F);
            obj.width = (int)(f * (float)yp.a(getContext(), 24F)) + yp.a(getContext(), 10F);
            obj.gravity = 51;
            obj.leftMargin = yp.a(getContext(), 5F);
            obj.topMargin = yp.a(getContext(), 8F);
            font_image.setLayoutParams(((android.view.ViewGroup.LayoutParams) (obj)));
            font_image.setColorFilter(0xff000000, android.graphics.PorterDuff.Mode.MULTIPLY);
            if (!alr.a().b(ama1))
            {
                font_tip.setVisibility(0);
                return;
            }
        }
    }
}
