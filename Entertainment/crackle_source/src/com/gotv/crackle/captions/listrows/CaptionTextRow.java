// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions.listrows;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CaptionTextRow extends RelativeLayout
{

    private TextView _subtitleView;
    private TextView _titleView;

    public CaptionTextRow(Context context)
    {
        super(context);
        LayoutInflater.from(context).inflate(0x7f030027, this);
        _titleView = (TextView)findViewById(0x7f0a0080);
        _subtitleView = (TextView)findViewById(0x7f0a008b);
    }

    public TextView getSubtitleView()
    {
        return _subtitleView;
    }

    public TextView getTitleView()
    {
        return _titleView;
    }
}
