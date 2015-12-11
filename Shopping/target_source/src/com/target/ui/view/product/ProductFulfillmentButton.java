// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view.product:
//            a

public class ProductFulfillmentButton extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        View buttonContainer;
        ImageView imageView;
        ProgressBar progressBar;
        TextView subTitle;
        TextView title;

        public Views(View view)
        {
            super(view);
        }
    }

    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a ACTIVE;
        public static final a INACTIVE;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/view/product/ProductFulfillmentButton$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            ACTIVE = new a("ACTIVE", 0);
            INACTIVE = new a("INACTIVE", 1);
            $VALUES = (new a[] {
                ACTIVE, INACTIVE
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int INVALID_RESOURCE_ID = -1;
    private a mFulfillmentState;
    private com.target.ui.view.product.a mFulfillmentType;
    private String mSubTitle;
    private Views mViews;

    public ProductFulfillmentButton(Context context)
    {
        super(context);
        a(context, ((AttributeSet) (null)));
    }

    public ProductFulfillmentButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context, attributeset);
    }

    public ProductFulfillmentButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(context, attributeset);
    }

    private int a(com.target.ui.view.product.a a1, a a2)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$view$product$FulfillmentType[];
            static final int $SwitchMap$com$target$ui$view$product$ProductFulfillmentButton$FulfillmentState[];

            static 
            {
                $SwitchMap$com$target$ui$view$product$ProductFulfillmentButton$FulfillmentState = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$view$product$ProductFulfillmentButton$FulfillmentState[a.INACTIVE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$ProductFulfillmentButton$FulfillmentState[a.ACTIVE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                $SwitchMap$com$target$ui$view$product$FulfillmentType = new int[com.target.ui.view.product.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[com.target.ui.view.product.a.EMAIL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[com.target.ui.view.product.a.SMS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[com.target.ui.view.product.a.MAIL.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[com.target.ui.view.product.a.SHIP_IT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[com.target.ui.view.product.a.PICK_UP.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[com.target.ui.view.product.a.ADD_TO_LIST.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[com.target.ui.view.product.a.FIND_IN_STORE.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$FulfillmentType[com.target.ui.view.product.a.UNKNOWN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.view.product.ProductFulfillmentButton.FulfillmentState[a2.ordinal()])
        {
        default:
            return c(a1);

        case 1: // '\001'
            return d(a1);
        }
    }

    private String a(com.target.ui.view.product.a a1)
    {
        switch (_cls1..SwitchMap.com.target.ui.view.product.FulfillmentType[a1.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return getResources().getString(0x7f0902f2);

        case 2: // '\002'
            return getResources().getString(0x7f090502);

        case 3: // '\003'
            return getResources().getString(0x7f0904fd);

        case 4: // '\004'
            return getResources().getString(0x7f0900d3);

        case 5: // '\005'
            return getResources().getString(0x7f0900d3);

        case 6: // '\006'
            return getResources().getString(0x7f0900d4);

        case 7: // '\007'
            return getResources().getString(0x7f0902fe);
        }
    }

    private void a()
    {
        int i = a(mFulfillmentType, mFulfillmentState);
        if (i != -1)
        {
            mViews.imageView.setImageResource(i);
        }
        String s = a(mFulfillmentType);
        mViews.title.setText(s);
        s = b(mFulfillmentType);
        if (o.g(s))
        {
            mViews.subTitle.setText(s);
            al.b(mViews.subTitle);
        }
    }

    private void a(Context context, AttributeSet attributeset)
    {
        inflate(context, 0x7f03018a, this);
        mViews = new Views(this);
        setDefaultAttributes(attributeset);
    }

    private String b(com.target.ui.view.product.a a1)
    {
        switch (_cls1..SwitchMap.com.target.ui.view.product.FulfillmentType[a1.ordinal()])
        {
        default:
            return "";

        case 4: // '\004'
            return getResources().getString(0x7f0904fd);

        case 5: // '\005'
            return getResources().getString(0x7f090405);
        }
    }

    private int c(com.target.ui.view.product.a a1)
    {
        int i = 0x7f0201e6;
        switch (_cls1..SwitchMap.com.target.ui.view.product.FulfillmentType[a1.ordinal()])
        {
        default:
            i = -1;
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

        case 6: // '\006'
            return 0x7f020181;

        case 7: // '\007'
            return 0x7f0201e2;
        }
    }

    private int d(com.target.ui.view.product.a a1)
    {
        int i = 0x7f0201e5;
        switch (_cls1..SwitchMap.com.target.ui.view.product.FulfillmentType[a1.ordinal()])
        {
        default:
            i = -1;
            // fall through

        case 3: // '\003'
        case 4: // '\004'
            return i;

        case 1: // '\001'
            return 0x7f0201df;

        case 2: // '\002'
            return 0x7f0201e7;

        case 5: // '\005'
            return 0x7f0201e9;

        case 6: // '\006'
            return 0x7f0201b3;

        case 7: // '\007'
            return 0x7f0201e1;
        }
    }

    private void setDefaultAttributes(AttributeSet attributeset)
    {
        mFulfillmentType = com.target.ui.view.product.a.UNKNOWN;
        mFulfillmentState = a.ACTIVE;
        attributeset = getContext().obtainStyledAttributes(attributeset, com.target.ui.a.a.pdp_fulfillment);
        if (attributeset == null)
        {
            return;
        }
        attributeset.getInteger(0, 7);
        JVM INSTR tableswitch 0 6: default 80
    //                   0 128
    //                   1 138
    //                   2 148
    //                   3 158
    //                   4 168
    //                   5 178
    //                   6 188;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8
_L1:
        mFulfillmentType = com.target.ui.view.product.a.UNKNOWN;
_L11:
        attributeset.getInteger(1, 0);
        JVM INSTR tableswitch 1 1: default 112
    //                   1 198;
           goto _L9 _L10
_L9:
        mFulfillmentState = a.ACTIVE;
_L12:
        attributeset.recycle();
        a();
        return;
_L2:
        mFulfillmentType = com.target.ui.view.product.a.EMAIL;
          goto _L11
_L3:
        mFulfillmentType = com.target.ui.view.product.a.SMS;
          goto _L11
_L4:
        mFulfillmentType = com.target.ui.view.product.a.SHIP_IT;
          goto _L11
_L5:
        mFulfillmentType = com.target.ui.view.product.a.PICK_UP;
          goto _L11
_L6:
        mFulfillmentType = com.target.ui.view.product.a.ADD_TO_LIST;
          goto _L11
_L7:
        mFulfillmentType = com.target.ui.view.product.a.FIND_IN_STORE;
          goto _L11
_L8:
        mFulfillmentType = com.target.ui.view.product.a.MAIL;
          goto _L11
_L10:
        mFulfillmentState = a.INACTIVE;
          goto _L12
    }

    public void a(boolean flag)
    {
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        setEnabled(flag1);
        if (flag)
        {
            al.a(mViews.progressBar, new View[] {
                mViews.buttonContainer
            });
            return;
        } else
        {
            al.a(mViews.buttonContainer, new View[] {
                mViews.progressBar
            });
            return;
        }
    }

    public void setButtonSubText(String s)
    {
        if (!o.g(s))
        {
            al.c(mViews.subTitle);
            return;
        } else
        {
            mSubTitle = s;
            mViews.subTitle.setText(s);
            al.b(mViews.subTitle);
            return;
        }
    }

    public void setButtonText(String s)
    {
        if (o.g(s))
        {
            mViews.title.setText(s);
        }
    }

    public void setButtonType(com.target.ui.view.product.a a1)
    {
        mFulfillmentType = a1;
        int i = a(mFulfillmentType, mFulfillmentState);
        if (i != -1)
        {
            mViews.imageView.setImageResource(i);
        }
    }

    public void setEnabled(boolean flag)
    {
        super.setEnabled(flag);
        a a1;
        int i;
        if (flag)
        {
            a1 = a.ACTIVE;
        } else
        {
            a1 = a.INACTIVE;
        }
        mFulfillmentState = a1;
        i = a(mFulfillmentType, mFulfillmentState);
        if (i != -1)
        {
            mViews.imageView.setImageResource(i);
        }
        if (flag)
        {
            mViews.title.setTextColor(getResources().getColor(0x7f0f00f3));
        } else
        {
            mViews.title.setTextColor(getResources().getColor(0x7f0f00f6));
        }
        if (!o.g(mSubTitle))
        {
            return;
        } else
        {
            al.a(mViews.subTitle, flag);
            return;
        }
    }
}
