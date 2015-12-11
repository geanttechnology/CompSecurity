// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions.listrows;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class CaptionTransparencyRow extends RelativeLayout
{

    private ImageView _clearView;
    private ImageView _opaqueView;
    private SeekBar _sizeSeekBar;
    private TextView _titleView;

    public CaptionTransparencyRow(Context context, boolean flag)
    {
        super(context);
        context = LayoutInflater.from(context);
        if (flag)
        {
            context.inflate(0x7f030028, this);
        } else
        {
            context.inflate(0x7f030029, this);
        }
        _titleView = (TextView)findViewById(0x7f0a0080);
        _clearView = (ImageView)findViewById(0x7f0a008c);
        _opaqueView = (ImageView)findViewById(0x7f0a008d);
        _sizeSeekBar = (SeekBar)findViewById(0x7f0a008a);
    }

    public ImageView getClearView()
    {
        return _clearView;
    }

    public ImageView getOpaqueView()
    {
        return _opaqueView;
    }

    public SeekBar getSeekBar()
    {
        return _sizeSeekBar;
    }

    public TextView getTitleView()
    {
        return _titleView;
    }
}
