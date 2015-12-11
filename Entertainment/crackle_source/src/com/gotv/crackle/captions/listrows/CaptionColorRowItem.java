// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions.listrows;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.gotv.crackle.captions.model.CaptionColor;

public class CaptionColorRowItem extends RelativeLayout
{

    private CaptionColor _captionColor;
    private boolean _selected;
    private ImageView _selectionView;

    public CaptionColorRowItem(Context context, CaptionColor captioncolor)
    {
        super(context);
        _selected = false;
        LayoutInflater.from(context).inflate(0x7f030022, this);
        _selectionView = (ImageView)findViewById(0x7f0a0083);
        _captionColor = captioncolor;
        ((ImageView)findViewById(0x7f0a0082)).setImageResource(_captionColor.getResourceId());
    }

    public CaptionColor getCaptionColor()
    {
        return _captionColor;
    }

    public boolean getIsSelected()
    {
        return _selected;
    }

    public void setIsSelected(boolean flag)
    {
        _selected = flag;
        if (_selected)
        {
            _selectionView.setVisibility(0);
            return;
        } else
        {
            _selectionView.setVisibility(4);
            return;
        }
    }
}
