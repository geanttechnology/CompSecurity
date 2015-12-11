// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.captions.listrows;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

// Referenced classes of package com.gotv.crackle.captions.listrows:
//            CaptionColorRowItem

public class CaptionColorRow extends RelativeLayout
    implements android.view.View.OnClickListener
{
    public static interface CaptionColorRowSelectionChangeListener
    {

        public abstract void OnColorChanged(CaptionColorRow captioncolorrow, CaptionColorRowItem captioncolorrowitem);
    }


    private LinearLayout _colorContainer;
    private CaptionColorRowSelectionChangeListener _listener;
    private CaptionColorRowItem _selectedItem;
    private TextView _titleView;

    public CaptionColorRow(Context context)
    {
        super(context);
        LayoutInflater.from(context).inflate(0x7f030023, this);
        _titleView = (TextView)findViewById(0x7f0a0080);
        _colorContainer = (LinearLayout)findViewById(0x7f0a0084);
    }

    public void addColorItem(CaptionColorRowItem captioncolorrowitem)
    {
        captioncolorrowitem.setOnClickListener(this);
        _colorContainer.addView(captioncolorrowitem);
    }

    public TextView getTitleView()
    {
        return _titleView;
    }

    public void onClick(View view)
    {
        view = (CaptionColorRowItem)view;
        if (_selectedItem != null)
        {
            _selectedItem.setIsSelected(false);
        }
        view.setIsSelected(true);
        _selectedItem = view;
        if (_listener != null)
        {
            _listener.OnColorChanged(this, _selectedItem);
        }
    }

    public void setSelectedItem(CaptionColorRowItem captioncolorrowitem)
    {
        if (_selectedItem != null)
        {
            _selectedItem.setIsSelected(false);
        }
        captioncolorrowitem.setIsSelected(true);
        _selectedItem = captioncolorrowitem;
    }

    public void setSelectionChangeListener(CaptionColorRowSelectionChangeListener captioncolorrowselectionchangelistener)
    {
        _listener = captioncolorrowselectionchangelistener;
    }
}
