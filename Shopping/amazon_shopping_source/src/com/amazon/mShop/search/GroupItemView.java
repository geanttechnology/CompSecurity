// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.search;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.util.Util;

public class GroupItemView extends LinearLayout
{

    private ImageView mExpandableMark;
    private TextView mGroupItemSubTitle;
    private TextView mGroupItemTitle;

    public GroupItemView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mGroupItemTitle = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.group_title);
        mGroupItemSubTitle = (TextView)findViewById(com.amazon.mShop.android.lib.R.id.group_subtitle);
        mExpandableMark = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.expanded_mark);
    }

    public void update(String s, String s1, boolean flag)
    {
        mGroupItemTitle.setText(s);
        int i;
        if (!Util.isEmpty(s1))
        {
            mGroupItemSubTitle.setVisibility(0);
            mGroupItemSubTitle.setText(UIUtils.convertUnsupportedCharacter(getContext(), s1, com.amazon.mShop.util.UIUtils.CharacterColor.DARK_GRAY));
        } else
        {
            mGroupItemSubTitle.setVisibility(8);
        }
        s = mExpandableMark;
        if (flag)
        {
            i = com.amazon.mShop.android.lib.R.drawable.arrow_up;
        } else
        {
            i = com.amazon.mShop.android.lib.R.drawable.arrow_down;
        }
        s.setImageResource(i);
    }
}
