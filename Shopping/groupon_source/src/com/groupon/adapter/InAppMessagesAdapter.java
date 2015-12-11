// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.groupon.db.models.InAppMessage;
import com.groupon.util.Dates;
import commonlib.adapter.JavaPagerAdapter;
import java.util.List;

public class InAppMessagesAdapter extends JavaPagerAdapter
{

    private final Context context;
    private final LayoutInflater layoutInflater;
    private com.groupon.view.InAppMessagesView.OnMessageClickedListener onMessageClickedListener;
    private final int readColor;
    private final int unreadColor;

    public InAppMessagesAdapter(Context context1)
    {
        context = context1;
        layoutInflater = LayoutInflater.from(context1);
        readColor = context1.getResources().getColor(0x7f0e00f4);
        unreadColor = context1.getResources().getColor(0x7f0e010b);
    }

    public void destroyItem(ViewGroup viewgroup, int i, Object obj)
    {
        viewgroup.removeView((View)obj);
    }

    public InAppMessage getItemAt(int i)
    {
        return (InAppMessage)list.get(i);
    }

    public int getItemPosition(Object obj)
    {
        return -2;
    }

    public List getMessages()
    {
        return list;
    }

    public float getPageWidth(int i)
    {
        return i == getCount() - 1 ? 1.0F : 0.9F;
    }

    public Object instantiateItem(ViewGroup viewgroup, final int position)
    {
        final InAppMessage message = (InAppMessage)list.get(position);
        View view = layoutInflater.inflate(0x7f030160, null);
        TextView textview = (TextView)view.findViewById(0x7f100413);
        textview.setText(message.title);
        int i;
        if (message.viewed)
        {
            i = readColor;
        } else
        {
            i = unreadColor;
        }
        textview.setTextColor(i);
        ((TextView)view.findViewById(0x7f100415)).setText(message.message);
        ((TextView)view.findViewById(0x7f100414)).setText(Dates.getTimeStampString(context, message.timestamp));
        view.setTag(Integer.valueOf(position));
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final InAppMessagesAdapter this$0;
            final InAppMessage val$message;
            final int val$position;

            public void onClick(View view1)
            {
                if (onMessageClickedListener != null)
                {
                    onMessageClickedListener.onMessageClicked(message, position);
                }
            }

            
            {
                this$0 = InAppMessagesAdapter.this;
                message = inappmessage;
                position = i;
                super();
            }
        });
        viewgroup.addView(view);
        viewgroup.setBackground(context.getResources().getDrawable(0x7f02023a));
        return view;
    }

    public void setOnMessageClickedListener(com.groupon.view.InAppMessagesView.OnMessageClickedListener onmessageclickedlistener)
    {
        onMessageClickedListener = onmessageclickedlistener;
    }

}
