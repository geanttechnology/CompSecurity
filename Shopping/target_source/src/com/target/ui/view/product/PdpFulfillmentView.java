// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view.product:
//            ProductFulfillmentButton

public class PdpFulfillmentView extends LinearLayout
    implements android.view.View.OnClickListener
{
    static class Views extends com.target.ui.view.a
    {

        ProductFulfillmentButton addToListBtn;
        ProductFulfillmentButton emailBtn;
        ProductFulfillmentButton fiatsBtn;
        ProductFulfillmentButton mailBtn;
        ProductFulfillmentButton pickUpBtn;
        ProductFulfillmentButton shipMeBtn;
        ProductFulfillmentButton smsBtn;

        public Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d();

        public abstract void e();

        public abstract void f();

        public abstract void g();
    }


    private a mListener;
    private Views mViews;

    public PdpFulfillmentView(Context context)
    {
        super(context);
        a(context);
    }

    public PdpFulfillmentView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a(context);
    }

    public PdpFulfillmentView(Context context, AttributeSet attributeset, int j)
    {
        super(context, attributeset, j);
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f030189, this);
        mViews = new Views(this);
        al.a(this, new View[] {
            mViews.addToListBtn, mViews.emailBtn, mViews.mailBtn, mViews.pickUpBtn, mViews.fiatsBtn, mViews.smsBtn, mViews.shipMeBtn
        });
    }

    private void c(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.a())
        {
            mViews.emailBtn.setEnabled(productfulfillmentoptions.i());
            mViews.emailBtn.setButtonText(getResources().getString(productfulfillmentoptions.u()));
            mViews.emailBtn.setButtonSubText("");
            al.b(mViews.emailBtn);
            return;
        } else
        {
            al.c(mViews.emailBtn);
            return;
        }
    }

    private void d(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.b())
        {
            mViews.smsBtn.setEnabled(productfulfillmentoptions.j());
            mViews.smsBtn.setButtonText(getResources().getString(productfulfillmentoptions.v()));
            mViews.smsBtn.setButtonSubText("");
            al.b(mViews.smsBtn);
            return;
        } else
        {
            al.c(mViews.smsBtn);
            return;
        }
    }

    private void e(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.d())
        {
            String s = "";
            boolean flag = productfulfillmentoptions.k();
            if (flag)
            {
                s = getResources().getString(0x7f0900d3);
                productfulfillmentoptions = getResources().getString(productfulfillmentoptions.r());
            } else
            {
                String s1 = getResources().getString(productfulfillmentoptions.r());
                productfulfillmentoptions = s;
                s = s1;
            }
            mViews.pickUpBtn.setEnabled(flag);
            mViews.pickUpBtn.setButtonText(s);
            mViews.pickUpBtn.setButtonSubText(productfulfillmentoptions);
            al.b(mViews.pickUpBtn);
            return;
        } else
        {
            al.c(mViews.pickUpBtn);
            return;
        }
    }

    private void f(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.c())
        {
            String s = "";
            boolean flag = productfulfillmentoptions.n();
            String s1 = getResources().getString(productfulfillmentoptions.s());
            productfulfillmentoptions = s;
            if (flag)
            {
                productfulfillmentoptions = getResources().getString(0x7f0903dc);
            }
            mViews.fiatsBtn.setEnabled(flag);
            mViews.fiatsBtn.setButtonText(s1);
            mViews.fiatsBtn.setButtonSubText(productfulfillmentoptions);
            al.b(mViews.fiatsBtn);
            return;
        } else
        {
            al.c(mViews.fiatsBtn);
            return;
        }
    }

    private void g(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.e())
        {
            String s = "";
            boolean flag = productfulfillmentoptions.l();
            if (flag)
            {
                s = getResources().getString(0x7f0900d3);
                productfulfillmentoptions = getResources().getString(productfulfillmentoptions.p());
            } else
            {
                String s1 = getResources().getString(productfulfillmentoptions.p());
                productfulfillmentoptions = s;
                s = s1;
            }
            mViews.shipMeBtn.setEnabled(flag);
            mViews.shipMeBtn.setButtonText(s);
            mViews.shipMeBtn.setButtonSubText(productfulfillmentoptions);
            al.b(mViews.shipMeBtn);
            return;
        } else
        {
            al.c(mViews.shipMeBtn);
            return;
        }
    }

    private void h(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.f())
        {
            mViews.mailBtn.setEnabled(productfulfillmentoptions.m());
            mViews.mailBtn.setButtonText(getResources().getString(productfulfillmentoptions.q()));
            mViews.mailBtn.setButtonSubText("");
            al.b(mViews.mailBtn);
            return;
        } else
        {
            al.c(mViews.mailBtn);
            return;
        }
    }

    private void i(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.h())
        {
            mViews.addToListBtn.setEnabled(productfulfillmentoptions.o());
            mViews.addToListBtn.setButtonText(getResources().getString(productfulfillmentoptions.w()));
            mViews.addToListBtn.setButtonSubText("");
            al.b(mViews.addToListBtn);
            return;
        } else
        {
            al.c(mViews.addToListBtn);
            return;
        }
    }

    public void a(ProductFulfillmentOptions productfulfillmentoptions)
    {
        mViews.emailBtn.setEnabled(productfulfillmentoptions.i());
        mViews.smsBtn.setEnabled(productfulfillmentoptions.j());
        mViews.mailBtn.setEnabled(productfulfillmentoptions.m());
    }

    public void a(boolean flag)
    {
        mViews.pickUpBtn.a(flag);
    }

    public void b(ProductFulfillmentOptions productfulfillmentoptions)
    {
        c(productfulfillmentoptions);
        d(productfulfillmentoptions);
        f(productfulfillmentoptions);
        e(productfulfillmentoptions);
        g(productfulfillmentoptions);
        h(productfulfillmentoptions);
        i(productfulfillmentoptions);
    }

    public void b(boolean flag)
    {
        mViews.shipMeBtn.a(flag);
    }

    public void c(boolean flag)
    {
        mViews.mailBtn.a(flag);
    }

    public void d(boolean flag)
    {
        mViews.smsBtn.a(flag);
    }

    public void e(boolean flag)
    {
        mViews.addToListBtn.a(flag);
    }

    public void f(boolean flag)
    {
        mViews.emailBtn.a(flag);
    }

    public void onClick(View view)
    {
        if (mListener == null)
        {
            return;
        }
        switch (view.getId())
        {
        default:
            return;

        case 2131756196: 
            mListener.b();
            return;

        case 2131756200: 
            mListener.f();
            return;

        case 2131756201: 
            mListener.a();
            return;

        case 2131756197: 
            mListener.c();
            return;

        case 2131756198: 
            mListener.d();
            return;

        case 2131756199: 
            mListener.e();
            return;

        case 2131756202: 
            mListener.g();
            break;
        }
    }

    public void setClickListener(a a1)
    {
        mListener = a1;
    }
}
