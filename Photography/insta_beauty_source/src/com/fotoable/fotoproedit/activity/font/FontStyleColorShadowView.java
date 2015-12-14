// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fotoable.fotoproedit.activity.font;

import ajt;
import aju;
import ajv;
import ajw;
import ajx;
import ajy;
import ajz;
import aka;
import ako;
import ama;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.ImageView;
import java.util.ArrayList;

// Referenced classes of package com.fotoable.fotoproedit.activity.font:
//            FontTextureAdapter, FontStyleGridView, FontShadowOutlineEditView, FontTextLabelInfo

public class FontStyleColorShadowView extends FrameLayout
{

    private FontTextureAdapter backgroundColorAdapter;
    private ArrayList fontColorList;
    private FontStyleGridView fontStyleGridView;
    private GridView forgroundColorGridView;
    private aka hiddenListener;
    private ImageView imgBackgroundColor;
    private ImageView imgFontStyle;
    private ImageView imgShadowOutline;
    private FrameLayout lyFontStyle;
    private FrameLayout lyForground;
    private FrameLayout lyShadowOutline;
    Context mContext;
    private ajz mListener;
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
        ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f030104, this, true);
        lyFontStyle = (FrameLayout)findViewById(0x7f0d03c1);
        lyForground = (FrameLayout)findViewById(0x7f0d03c3);
        lyShadowOutline = (FrameLayout)findViewById(0x7f0d03c4);
        imgFontStyle = (ImageView)findViewById(0x7f0d03c2);
        imgBackgroundColor = (ImageView)findViewById(0x7f0d0237);
        imgShadowOutline = (ImageView)findViewById(0x7f0d03c5);
        imgFontStyle.setBackgroundResource(0x7f020183);
        imgBackgroundColor.setBackgroundResource(0x7f020181);
        imgShadowOutline.setBackgroundResource(0x7f020184);
        lyFontStyle.setBackgroundColor(getResources().getColor(0x7f0c004b));
        imgFontStyle.getBackground().mutate().setColorFilter(0xff007aff, android.graphics.PorterDuff.Mode.SRC_IN);
        lyFontStyle.setOnClickListener(new ajt(this));
        lyForground.setOnClickListener(new aju(this));
        lyShadowOutline.setOnClickListener(new ajv(this));
        forgroundColorGridView = (GridView)findViewById(0x7f0d03c7);
        fontColorList = ako.a().c();
        backgroundColorAdapter = new FontTextureAdapter(mContext);
        backgroundColorAdapter.setColorList(fontColorList);
        forgroundColorGridView.setAdapter(backgroundColorAdapter);
        forgroundColorGridView.setOnItemClickListener(new ajw(this));
        fontStyleGridView = (FontStyleGridView)findViewById(0x7f0d03c6);
        fontStyleGridView.setFontStyleListener(new ajx(this));
        shadowOutlineEditView = (FontShadowOutlineEditView)findViewById(0x7f0d03c8);
        shadowOutlineEditView.setShadowOutlineListener(new ajy(this));
    }

    public void setHiddenpPromptListener(aka aka)
    {
        hiddenListener = aka;
    }

    public void setStyleColorShadowListener(ajz ajz)
    {
        mListener = ajz;
    }

    public void setStyleFontAndTxt(FontTextLabelInfo fonttextlabelinfo, ama ama)
    {
        fontStyleGridView.setFontAndTxt(fonttextlabelinfo, ama);
    }













}
