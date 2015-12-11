// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.util.al;
import com.target.ui.view.a;

// Referenced classes of package com.target.ui.view.product:
//            a

public class ProductDialogPriceView extends LinearLayout
{
    static class Views extends a
    {

        ImageView fulfillmentImage;
        TextView fulfillmentTitle;
        TextView price;

        public Views(View view)
        {
            super(view);
        }
    }


    private static int INVALID_RESOURCE_ID = -1;
    private Views mViews;

    public ProductDialogPriceView(Context context)
    {
        super(context);
        a();
    }

    public ProductDialogPriceView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ProductDialogPriceView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    private void a()
    {
        inflate(getContext(), 0x7f0301b2, this);
        mViews = new Views(this);
    }

    protected String a(com.target.ui.view.product.a a1)
    {
        int i = 0x7f0904fd;
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$view$product$FulfillmentType[];

            static 
            {
                $SwitchMap$com$target$ui$view$product$FulfillmentType = new int[com.target.ui.view.product.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[a.EMAIL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[a.SMS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[a.MAIL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[a.SHIP_IT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[a.PICK_UP.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[a.ADD_TO_LIST.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[a.FIND_IN_STORE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[a.UNKNOWN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.target.ui.view.product.FulfillmentType[a1.ordinal()];
        JVM INSTR tableswitch 1 7: default 52
    //                   1 66
    //                   2 72
    //                   3 56
    //                   4 56
    //                   5 78
    //                   6 84
    //                   7 90;
           goto _L1 _L2 _L3 _L4 _L4 _L5 _L6 _L7
_L7:
        break MISSING_BLOCK_LABEL_90;
_L4:
        break; /* Loop/switch isn't completed */
_L1:
        i = INVALID_RESOURCE_ID;
_L8:
        if (i == INVALID_RESOURCE_ID)
        {
            return "";
        } else
        {
            return getResources().getString(i);
        }
_L2:
        i = 0x7f0902f2;
          goto _L8
_L3:
        i = 0x7f090502;
          goto _L8
_L5:
        i = 0x7f090405;
          goto _L8
_L6:
        i = 0x7f0900d4;
          goto _L8
        i = 0x7f0902fe;
          goto _L8
    }

    protected int b(com.target.ui.view.product.a a1)
    {
        int i = 0x7f0201e6;
        int j = INVALID_RESOURCE_ID;
        switch (_cls1..SwitchMap.com.target.ui.view.product.FulfillmentType[a1.ordinal()])
        {
        default:
            i = j;
            // fall through

        case 3: // '\003'
        case 4: // '\004'
            return i;

        case 1: // '\001'
            return 0x7f0201e0;

        case 2: // '\002'
            return 0x7f0201e8;

        case 5: // '\005'
            return 0x7f0201ea;
        }
    }

    public void setFulfillmentType(com.target.ui.view.product.a a1)
    {
        int i = b(a1);
        a1 = a(a1);
        if (!o.g(a1) || i == INVALID_RESOURCE_ID)
        {
            al.a(new View[] {
                mViews.fulfillmentImage, mViews.fulfillmentTitle
            });
            return;
        } else
        {
            mViews.fulfillmentImage.setImageResource(i);
            mViews.fulfillmentTitle.setText(a1);
            al.b(new View[] {
                mViews.fulfillmentImage, mViews.fulfillmentTitle
            });
            return;
        }
    }

    public void setPrice(String s)
    {
        mViews.price.setText(s);
    }

}
