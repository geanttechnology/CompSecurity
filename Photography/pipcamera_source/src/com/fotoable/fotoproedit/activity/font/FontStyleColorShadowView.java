// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import hb;
import he;
import hf;
import hg;
import hi;
import hs;
import java.util.ArrayList;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTextureAdapter, FontStyleGridView, FontShadowOutlineEditView, FontTextLabelInfo

public class FontStyleColorShadowView extends FrameLayout
{

    private FontTextureAdapter backgroundColorAdapter;
    private ArrayList fontColorList;
    private FontStyleGridView fontStyleGridView;
    private GridView forgroundColorGridView;
    private hg hiddenListener;
    private ImageView imgBackgroundColor;
    private ImageView imgFontStyle;
    private ImageView imgShadowOutline;
    private FrameLayout lyFontStyle;
    private FrameLayout lyForground;
    private FrameLayout lyShadowOutline;
    Context mContext;
    private hf mListener;
    private FontShadowOutlineEditView shadowOutlineEditView;

    public FontStyleColorShadowView(Context context)
    {
        super(context);
        mContext = context;
        init();
    }

    public FontStyleColorShadowView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mContext = context;
        init();
    }

    private void init()
    {
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f0300bc, this, true);
        lyFontStyle = (FrameLayout)findViewById(0x7f0c02d3);
        lyForground = (FrameLayout)findViewById(0x7f0c02d5);
        lyShadowOutline = (FrameLayout)findViewById(0x7f0c02d6);
        imgFontStyle = (ImageView)findViewById(0x7f0c02d4);
        imgBackgroundColor = (ImageView)findViewById(0x7f0c0130);
        imgShadowOutline = (ImageView)findViewById(0x7f0c02d7);
        imgFontStyle.setBackgroundResource(0x7f0200b8);
        imgBackgroundColor.setBackgroundResource(0x7f0200b6);
        imgShadowOutline.setBackgroundResource(0x7f0200b9);
        lyFontStyle.setBackgroundColor(getResources().getColor(0x7f0b003c));
        imgFontStyle.getBackground().mutate().setColorFilter(0xff007aff, android.graphics.PorterDuff.Mode.SRC_IN);
        lyFontStyle.setOnClickListener(new android.view.View.OnClickListener() {

            final FontStyleColorShadowView a;

            public void onClick(View view)
            {
                a.lyFontStyle.setBackgroundColor(a.getResources().getColor(0x7f0b003c));
                a.lyForground.setBackgroundColor(a.getResources().getColor(0x7f0b003b));
                a.lyShadowOutline.setBackgroundColor(a.getResources().getColor(0x7f0b003b));
                a.imgFontStyle.getBackground().mutate().setColorFilter(0xff007aff, android.graphics.PorterDuff.Mode.SRC_IN);
                a.imgBackgroundColor.getBackground().mutate().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
                a.imgShadowOutline.getBackground().mutate().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
                a.fontStyleGridView.setVisibility(0);
                a.forgroundColorGridView.setVisibility(8);
                a.shadowOutlineEditView.setVisibility(8);
            }

            
            {
                a = FontStyleColorShadowView.this;
                super();
            }
        });
        lyForground.setOnClickListener(new android.view.View.OnClickListener() {

            final FontStyleColorShadowView a;

            public void onClick(View view)
            {
                a.lyForground.setBackgroundColor(a.getResources().getColor(0x7f0b003c));
                a.lyFontStyle.setBackgroundColor(a.getResources().getColor(0x7f0b003b));
                a.lyShadowOutline.setBackgroundColor(a.getResources().getColor(0x7f0b003b));
                a.imgBackgroundColor.getBackground().mutate().setColorFilter(0xff007aff, android.graphics.PorterDuff.Mode.SRC_IN);
                a.imgFontStyle.getBackground().mutate().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
                a.imgShadowOutline.getBackground().mutate().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
                a.fontStyleGridView.setVisibility(8);
                a.forgroundColorGridView.setVisibility(0);
                a.shadowOutlineEditView.setVisibility(8);
            }

            
            {
                a = FontStyleColorShadowView.this;
                super();
            }
        });
        lyShadowOutline.setOnClickListener(new android.view.View.OnClickListener() {

            final FontStyleColorShadowView a;

            public void onClick(View view)
            {
                a.lyShadowOutline.setBackgroundColor(a.getResources().getColor(0x7f0b003c));
                a.lyFontStyle.setBackgroundColor(a.getResources().getColor(0x7f0b003b));
                a.lyForground.setBackgroundColor(a.getResources().getColor(0x7f0b003b));
                a.imgFontStyle.getBackground().mutate().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
                a.imgBackgroundColor.getBackground().mutate().setColorFilter(-1, android.graphics.PorterDuff.Mode.SRC_IN);
                a.imgShadowOutline.getBackground().mutate().setColorFilter(0xff007aff, android.graphics.PorterDuff.Mode.SRC_IN);
                a.fontStyleGridView.setVisibility(8);
                a.forgroundColorGridView.setVisibility(8);
                a.shadowOutlineEditView.setVisibility(0);
            }

            
            {
                a = FontStyleColorShadowView.this;
                super();
            }
        });
        forgroundColorGridView = (GridView)findViewById(0x7f0c02d9);
        fontColorList = hs.a().c();
        backgroundColorAdapter = new FontTextureAdapter(mContext);
        backgroundColorAdapter.setColorList(fontColorList);
        forgroundColorGridView.setAdapter(backgroundColorAdapter);
        forgroundColorGridView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final FontStyleColorShadowView a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                if (a.mListener != null)
                {
                    adapterview = (FontTextLabelInfo)a.fontColorList.get(i);
                    a.mListener.b(adapterview);
                    a.backgroundColorAdapter.setSeclection(i);
                    a.backgroundColorAdapter.notifyDataSetChanged();
                }
            }

            
            {
                a = FontStyleColorShadowView.this;
                super();
            }
        });
        fontStyleGridView = (FontStyleGridView)findViewById(0x7f0c02d8);
        fontStyleGridView.setFontStyleListener(new hi() {

            final FontStyleColorShadowView a;

            public void a(FontTextLabelInfo fonttextlabelinfo)
            {
                if (a.mListener != null)
                {
                    a.mListener.a(fonttextlabelinfo);
                    a.shadowOutlineEditView.setShadowNum((int)fonttextlabelinfo.d);
                    a.shadowOutlineEditView.setStrokeNum((int)fonttextlabelinfo.g);
                    if (a.hiddenListener != null)
                    {
                        a.hiddenListener.a();
                    }
                }
            }

            
            {
                a = FontStyleColorShadowView.this;
                super();
            }
        });
        shadowOutlineEditView = (FontShadowOutlineEditView)findViewById(0x7f0c02da);
        shadowOutlineEditView.setShadowOutlineListener(new he() {

            final FontStyleColorShadowView a;

            public void a()
            {
                if (a.mListener != null)
                {
                    a.mListener.a();
                }
            }

            public void a(int i)
            {
                if (a.mListener != null)
                {
                    a.mListener.c(i);
                }
            }

            public void b()
            {
                if (a.mListener != null)
                {
                    a.mListener.b();
                }
            }

            public void b(int i)
            {
                if (a.mListener != null)
                {
                    a.mListener.a(i);
                }
            }

            public void c(int i)
            {
                if (a.mListener != null)
                {
                    a.mListener.d(i);
                }
            }

            public void d(int i)
            {
                if (a.mListener != null)
                {
                    a.mListener.b(i);
                }
            }

            
            {
                a = FontStyleColorShadowView.this;
                super();
            }
        });
    }

    public void setHiddenpPromptListener(hg hg)
    {
        hiddenListener = hg;
    }

    public void setStyleColorShadowListener(hf hf)
    {
        mListener = hf;
    }

    public void setStyleFontAndTxt(FontTextLabelInfo fonttextlabelinfo, hb hb)
    {
        fontStyleGridView.setFontAndTxt(fonttextlabelinfo, hb);
    }













}
