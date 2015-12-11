// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions.listrows;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class CaptionSizeRow extends RelativeLayout
{

    private TextView _largeTextView;
    private SeekBar _sizeSeekBar;
    private TextView _smallTextView;
    private TextView _titleView;

    public CaptionSizeRow(Context context, boolean flag)
    {
        super(context);
        context = LayoutInflater.from(context);
        if (flag)
        {
            context.inflate(0x7f030025, this);
        } else
        {
            context.inflate(0x7f030026, this);
        }
        _titleView = (TextView)findViewById(0x7f0a0080);
        _smallTextView = (TextView)findViewById(0x7f0a0088);
        _largeTextView = (TextView)findViewById(0x7f0a0089);
        _sizeSeekBar = (SeekBar)findViewById(0x7f0a008a);
    }

    public TextView getLargeTextView()
    {
        return _largeTextView;
    }

    public SeekBar getSeekBar()
    {
        return _sizeSeekBar;
    }

    public TextView getSmallTextView()
    {
        return _smallTextView;
    }

    public TextView getTitleView()
    {
        return _titleView;
    }
}
