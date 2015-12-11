// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.target.mothership.model.common.GiftCardTender;
import com.target.ui.adapter.b.e;
import com.target.ui.util.u;
import java.util.List;

public class com.target.ui.adapter.a.a extends e
    implements android.view.View.OnClickListener
{
    public static interface a
    {

        public abstract void a(GiftCardTender giftcardtender);
    }

    private class b
    {

        public TextView giftCardAccessNumber;
        public TextView giftCardBalance;
        public TextView giftCardNumber;
        public int position;
        final com.target.ui.adapter.a.a this$0;

        public b(View view)
        {
            this$0 = com.target.ui.adapter.a.a.this;
            super();
            position = -1;
            giftCardNumber = (TextView)view.findViewById(0x7f1002c3);
            giftCardAccessNumber = (TextView)view.findViewById(0x7f1002c4);
            giftCardBalance = (TextView)view.findViewById(0x7f1002c5);
        }
    }


    private static final int NULL_INT = -1;
    private a mListener;

    public com.target.ui.adapter.a.a(Context context, List list, a a1)
    {
        super(context, list);
        mListener = a1;
    }

    public View getView(int i, View view, ViewGroup viewgroup)
    {
        GiftCardTender giftcardtender = (GiftCardTender)getItem(i);
        String s;
        if (view == null)
        {
            view = mInflater.inflate(0x7f0300eb, null, false);
            viewgroup = new b(view);
            view.setTag(viewgroup);
            view.setOnClickListener(this);
        } else
        {
            viewgroup = (b)view.getTag();
        }
        viewgroup.position = i;
        ((b) (viewgroup)).giftCardNumber.setText(com.target.ui.util.d.a.a(giftcardtender.b()));
        s = getContext().getString(0x7f090087, new Object[] {
            giftcardtender.c()
        });
        ((b) (viewgroup)).giftCardAccessNumber.setText(s);
        ((b) (viewgroup)).giftCardBalance.setText(com.target.ui.util.d.a.a(giftcardtender.d()));
        return view;
    }

    public void onClick(View view)
    {
        view = (b)u.a(view.getTag(), com/target/ui/adapter/a/a$b);
        int i;
        if (view != null)
        {
            if ((i = ((b) (view)).position) >= 0 && i < getCount())
            {
                mListener.a((GiftCardTender)getItem(i));
                return;
            }
        }
    }
}
