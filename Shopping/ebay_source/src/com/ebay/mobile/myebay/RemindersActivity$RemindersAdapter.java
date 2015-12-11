// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.myebay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.shared.ui.TextCountViewHolder;
import java.util.List;

// Referenced classes of package com.ebay.mobile.myebay:
//            RemindersActivity

private class type extends com.ebay.shared.ui.ter
{

    List reminders;
    final RemindersActivity this$0;
    Text type;

    public int getCount()
    {
        if (reminders == null || reminders.isEmpty())
        {
            return 1;
        } else
        {
            return reminders.size();
        }
    }

    public reminders getItem(int i)
    {
        if (reminders == null || reminders.isEmpty())
        {
            return null;
        } else
        {
            return (reminders)reminders.get(i);
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
        if (reminders == null || reminders.isEmpty())
        {
            ((TextCountViewHolder) (viewgroup)).count.setVisibility(8);
            view.findViewById(0x7f100147).setVisibility(4);
            view.setBackgroundDrawable(null);
            switch (ebay.mobile.myebay.RemindersActivity.Type[type.type()])
            {
            default:
                return view;

            case 1: // '\001'
                ((TextCountViewHolder) (viewgroup)).text.setText(getString(0x7f070665));
                return view;

            case 2: // '\002'
                ((TextCountViewHolder) (viewgroup)).text.setText(getString(0x7f070656));
                return view;

            case 3: // '\003'
                ((TextCountViewHolder) (viewgroup)).text.setText(getString(0x7f070683));
                return view;

            case 4: // '\004'
                ((TextCountViewHolder) (viewgroup)).text.setText(getString(0x7f070658));
                break;
            }
            return view;
        } else
        {
            getItem getitem = getItem(i);
            ((TextCountViewHolder) (viewgroup)).text.setText(getitem.Text);
            ((TextCountViewHolder) (viewgroup)).count.setText(Util.countAsString(RemindersActivity.this, getitem.t));
            return view;
        }
    }

    public void itemClick(int i)
    {
        if (reminders == null || reminders.isEmpty())
        {
            return;
        } else
        {
            t t = getItem(i);
            ActivityStarter.startReminderItems(RemindersActivity.this, t., t.Text);
            return;
        }
    }

    public (List list,  )
    {
        this$0 = RemindersActivity.this;
        super();
        reminders = list;
        type = ;
    }
}
