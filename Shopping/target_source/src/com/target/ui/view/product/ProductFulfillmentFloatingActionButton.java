// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.target.mothership.util.o;
import com.target.ui.util.ah;
import com.target.ui.view.TargetFloatingActionButton;

// Referenced classes of package com.target.ui.view.product:
//            a

public class ProductFulfillmentFloatingActionButton extends TargetFloatingActionButton
{
    public static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a ACTIVE;
        public static final a INACTIVE;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/view/product/ProductFulfillmentFloatingActionButton$a, s);
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

    public ProductFulfillmentFloatingActionButton(Context context)
    {
        super(context);
        a(((AttributeSet) (null)));
    }

    public ProductFulfillmentFloatingActionButton(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(attributeset);
    }

    public ProductFulfillmentFloatingActionButton(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a(attributeset);
    }

    private int a(com.target.ui.view.product.a a1, a a2)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$view$product$FulfillmentType[];
            static final int $SwitchMap$com$target$ui$view$product$ProductFulfillmentFloatingActionButton$FulfillmentState[];

            static 
            {
                $SwitchMap$com$target$ui$view$product$ProductFulfillmentFloatingActionButton$FulfillmentState = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$view$product$ProductFulfillmentFloatingActionButton$FulfillmentState[a.INACTIVE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$target$ui$view$product$ProductFulfillmentFloatingActionButton$FulfillmentState[a.ACTIVE.ordinal()] = 2;
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

        switch (_cls1..SwitchMap.com.target.ui.view.product.ProductFulfillmentFloatingActionButton.FulfillmentState[a2.ordinal()])
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

    private void a(AttributeSet attributeset)
    {
        setColorNormal(getResources().getColor(0x7f0f00f9));
        setColorPressed(getResources().getColor(0x7f0f00e4));
        setColorDisabled(getResources().getColor(0x7f0f00f9));
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

    private void b()
    {
        int i = a(mFulfillmentType, mFulfillmentState);
        if (i != -1)
        {
            setImageResource(i);
        }
        a(mFulfillmentType);
        setTitle(b(mFulfillmentType));
    }

    private int c(com.target.ui.view.product.a a1)
    {
        int i = 0x7f020125;
        switch (_cls1..SwitchMap.com.target.ui.view.product.FulfillmentType[a1.ordinal()])
        {
        default:
            i = -1;
            // fall through

        case 3: // '\003'
        case 4: // '\004'
            return i;

        case 1: // '\001'
            return 0x7f02011d;

        case 2: // '\002'
            return 0x7f020127;

        case 5: // '\005'
            return 0x7f020123;

        case 6: // '\006'
            return 0x7f020122;

        case 7: // '\007'
            return 0x7f02011f;
        }
    }

    private int d(com.target.ui.view.product.a a1)
    {
        int i = 0x7f020126;
        switch (_cls1..SwitchMap.com.target.ui.view.product.FulfillmentType[a1.ordinal()])
        {
        default:
            i = -1;
            // fall through

        case 3: // '\003'
        case 4: // '\004'
            return i;

        case 1: // '\001'
            return 0x7f02011e;

        case 2: // '\002'
            return 0x7f020128;

        case 5: // '\005'
            return 0x7f020124;

        case 6: // '\006'
            return 0x7f020122;

        case 7: // '\007'
            return 0x7f020120;
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
        b();
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

    public void setButtonText(String s)
    {
        if (o.g(s))
        {
            setTitle(ah.a(getContext(), com.target.ui.util.ah.a.REGULAR, s));
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
            setImageResource(i);
        }
        if (flag)
        {
            setTextColor(0x7f0f00f3);
            return;
        } else
        {
            setTextColor(0x7f0f00f6);
            return;
        }
    }
}
