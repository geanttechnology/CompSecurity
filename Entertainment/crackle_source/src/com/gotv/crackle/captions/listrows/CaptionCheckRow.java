// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions.listrows;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CaptionCheckRow extends RelativeLayout
{

    private RadioButton _radioButton;
    private TextView _titleView;

    public CaptionCheckRow(Context context)
    {
        super(context);
        LayoutInflater.from(context).inflate(0x7f030021, this);
        _titleView = (TextView)findViewById(0x7f0a0080);
        _radioButton = (RadioButton)findViewById(0x7f0a0081);
    }

    public RadioButton getCheckBox()
    {
        return _radioButton;
    }

    public TextView getTitleView()
    {
        return _titleView;
    }
}
