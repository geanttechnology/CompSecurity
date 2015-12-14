// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wantu.ResourceOnlineLibrary.Types;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import uk;

public class MaterialParentView extends LinearLayout
{

    private static final String TAG = "MaterialParentView";
    private TextView mParentText;
    private uk mParentType;

    public MaterialParentView(Context context)
    {
        super(context);
        ContructView();
    }

    private void ContructView()
    {
        mParentText = (TextView)((ViewGroup)View.inflate(getContext(), 0x7f030059, this)).findViewById(0x7f0c0087);
    }

    public void SetDataItem(uk uk1)
    {
        if (uk1 == null)
        {
            Log.e("MaterialParentView", "Set empty data!");
        } else
        {
            mParentType = uk1;
            if (mParentType != null)
            {
                mParentText.setText(mParentType.b);
                return;
            }
        }
    }

    public TextView getTitleView()
    {
        return mParentText;
    }
}
