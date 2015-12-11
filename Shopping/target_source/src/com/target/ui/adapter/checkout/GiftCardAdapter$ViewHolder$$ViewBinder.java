// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.adapter.checkout;

import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import butterknife.internal.DebouncingOnClickListener;

public class _cls2.val.target
    implements butterknife.Holder..ViewBinder
{

    public void bind(butterknife.Holder..ViewBinder viewbinder, final _cls2.val.target target, Object obj)
    {
        View view = (View)viewbinder.Holder(obj, 0x7f1003b1, "field 'radioButton' and method 'onRadioClicked'");
        target.target = (RadioButton)viewbinder.radioButton(view, 0x7f1003b1, "field 'radioButton'");
        view.setOnClickListener(new DebouncingOnClickListener() {

            final GiftCardAdapter.ViewHolder..ViewBinder this$0;
            final GiftCardAdapter.ViewHolder val$target;

            public void doClick(View view1)
            {
                target.onRadioClicked();
            }

            
            {
                this$0 = GiftCardAdapter.ViewHolder..ViewBinder.this;
                target = viewholder;
                super();
            }
        });
        target.ed = (TextView)viewbinder.cardNumber((View)viewbinder.cardNumber(obj, 0x7f1003b3, "field 'cardNumber'"), 0x7f1003b3, "field 'cardNumber'");
        target.ed = (TextView)viewbinder.cardBalance((View)viewbinder.cardBalance(obj, 0x7f1003b4, "field 'cardBalance'"), 0x7f1003b4, "field 'cardBalance'");
        ((View)viewbinder.cardBalance(obj, 0x7f1003b0, "method 'onItemClicked'")).setOnClickListener(new DebouncingOnClickListener() {

            final GiftCardAdapter.ViewHolder..ViewBinder this$0;
            final GiftCardAdapter.ViewHolder val$target;

            public void doClick(View view1)
            {
                target.onItemClicked();
            }

            
            {
                this$0 = GiftCardAdapter.ViewHolder..ViewBinder.this;
                target = viewholder;
                super();
            }
        });
    }

    public volatile void bind(butterknife.Holder..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public _cls2.val.target()
    {
    }
}
