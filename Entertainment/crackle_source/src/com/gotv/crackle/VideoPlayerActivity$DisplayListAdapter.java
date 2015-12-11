// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.gotv.crackle:
//            VideoPlayerActivity

private final class mContext extends ArrayAdapter
{

    private int curIndex;
    final Context mContext;
    final VideoPlayerActivity this$0;

    public int getCurIndex()
    {
        return curIndex;
    }

    public Display getCurrentItem()
    {
        if (getCount() > 0)
        {
            return (Display)getItem(curIndex);
        } else
        {
            return null;
        }
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        viewgroup = view;
        view = viewgroup;
        if (viewgroup == null)
        {
            view = ((LayoutInflater)mContext.getSystemService("layout_inflater")).inflate(0x7f030042, null);
        }
        viewgroup = (TextView)view.findViewById(0x7f0a00d2);
        if (viewgroup != null)
        {
            viewgroup.setText(((Display)getItem(i)).getName());
        }
        viewgroup = (ImageView)view.findViewById(0x7f0a00d4);
        viewgroup.setVisibility(4);
        view.setClickable(false);
        if (i == curIndex)
        {
            viewgroup.setVisibility(0);
        }
        return view;
    }

    public void setCurIndex(int i)
    {
        curIndex = i;
    }

    public void unselectItem()
    {
        curIndex = -1;
    }

    public (Context context, Display adisplay[])
    {
        this$0 = VideoPlayerActivity.this;
        super(context, 0x7f030042, adisplay);
        curIndex = -1;
        mContext = context;
    }
}
