// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.model.cart.Incentive;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.shared.ui.TextCountViewHolder;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            RemindersActivity

private class <init> extends com.ebay.shared.ui.ter
{

    final RemindersActivity this$0;

    public int getCount()
    {
        return 1;
    }

    public Incentive getItem(int i)
    {
        if (RemindersActivity.access$200(RemindersActivity.this) == null || RemindersActivity.access$200(RemindersActivity.this).isEmpty())
        {
            return null;
        } else
        {
            return (Incentive)RemindersActivity.access$200(RemindersActivity.this).get(i);
        }
    }

    public volatile Object getItem(int i)
    {
        return getItem(i);
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        if (view == null)
        {
            view = RemindersActivity.access$100(RemindersActivity.this).inflate(0x7f03007b, viewgroup, false);
            viewgroup = new TextCountViewHolder(view);
            view.setTag(viewgroup);
        } else
        {
            viewgroup = (TextCountViewHolder)view.getTag();
        }
        if (RemindersActivity.access$200(RemindersActivity.this) == null || RemindersActivity.access$200(RemindersActivity.this).isEmpty())
        {
            ((TextCountViewHolder) (viewgroup)).count.setVisibility(8);
            view.findViewById(0x7f100147).setVisibility(4);
            view.setBackgroundDrawable(null);
            ((TextCountViewHolder) (viewgroup)).text.setText(getString(0x7f070658));
            return view;
        } else
        {
            ((TextCountViewHolder) (viewgroup)).text.setText(RemindersActivity.access$300());
            ((TextCountViewHolder) (viewgroup)).count.setText(Util.countAsString(RemindersActivity.this, RemindersActivity.access$200(RemindersActivity.this).size()));
            return view;
        }
    }

    public void itemClick(int i)
    {
        if (RemindersActivity.access$200(RemindersActivity.this) == null || RemindersActivity.access$200(RemindersActivity.this).isEmpty())
        {
            return;
        } else
        {
            ActivityStarter.startCouponItems(RemindersActivity.this, 666, RemindersActivity.access$300());
            return;
        }
    }

    private ()
    {
        this$0 = RemindersActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
