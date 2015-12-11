// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.getbase.floatingactionbutton.FloatingActionsMenu;
import com.target.ui.common.ProductFulfillmentOptions;
import com.target.ui.util.al;

// Referenced classes of package com.target.ui.view.product:
//            ProductFulfillmentFloatingActionButton

public class PdpFulfillmentFloatingMenuView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        ProductFulfillmentFloatingActionButton addToListBtn;
        ProductFulfillmentFloatingActionButton emailBtn;
        ProductFulfillmentFloatingActionButton fiatsBtn;
        ProductFulfillmentFloatingActionButton mailBtn;
        ProductFulfillmentFloatingActionButton pickUpBtn;
        FloatingActionsMenu rootMenu;
        final View rootView;
        ProductFulfillmentFloatingActionButton shipMeBtn;
        ProductFulfillmentFloatingActionButton smsBtn;

        public Views(View view)
        {
            super(view);
            rootView = view;
        }
    }

    private static interface a
    {

        public abstract void h();

        public abstract void i();
    }

    private class b
        implements com.getbase.floatingactionbutton.FloatingActionsMenu.b
    {

        final PdpFulfillmentFloatingMenuView this$0;

        public void a()
        {
            if (PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this) != null)
            {
                PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this).h();
            }
        }

        public void b()
        {
            if (PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this) != null)
            {
                PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this).i();
            }
        }

        private b()
        {
            this$0 = PdpFulfillmentFloatingMenuView.this;
            super();
        }

    }

    private class c
        implements android.view.View.OnClickListener
    {

        final PdpFulfillmentFloatingMenuView this$0;

        public void onClick(View view)
        {
            if (PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this) == null)
            {
                return;
            }
            switch (view.getId())
            {
            default:
                return;

            case 2131756209: 
                PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this).g();
                return;

            case 2131756211: 
                PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this).b();
                return;

            case 2131756210: 
                PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this).a();
                return;

            case 2131756215: 
                PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this).c();
                return;

            case 2131756214: 
                PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this).d();
                return;

            case 2131756213: 
                PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this).e();
                return;

            case 2131756212: 
                PdpFulfillmentFloatingMenuView.a(PdpFulfillmentFloatingMenuView.this).f();
                return;
            }
        }

        private c()
        {
            this$0 = PdpFulfillmentFloatingMenuView.this;
            super();
        }

    }

    public static interface d
        extends a
    {

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public abstract void d();

        public abstract void e();

        public abstract void f();

        public abstract void g();
    }


    private d mListener;
    private Views mViews;

    public PdpFulfillmentFloatingMenuView(Context context)
    {
        super(context);
        c();
    }

    public PdpFulfillmentFloatingMenuView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        c();
    }

    public PdpFulfillmentFloatingMenuView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        c();
    }

    static d a(PdpFulfillmentFloatingMenuView pdpfulfillmentfloatingmenuview)
    {
        return pdpfulfillmentfloatingmenuview.mListener;
    }

    private void b(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.a())
        {
            mViews.emailBtn.setEnabled(productfulfillmentoptions.i());
            mViews.emailBtn.setButtonText(getResources().getString(productfulfillmentoptions.u()));
            al.b(mViews.emailBtn);
            return;
        } else
        {
            al.c(mViews.emailBtn);
            return;
        }
    }

    private void c()
    {
        inflate(getContext(), 0x7f03018b, this);
        mViews = new Views(this);
        d();
    }

    private void c(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.b())
        {
            mViews.smsBtn.setEnabled(productfulfillmentoptions.j());
            mViews.smsBtn.setButtonText(getResources().getString(productfulfillmentoptions.v()));
            al.b(mViews.smsBtn);
            return;
        } else
        {
            al.c(mViews.smsBtn);
            return;
        }
    }

    private void d()
    {
        mViews.addToListBtn.setOnClickListener(new c());
        mViews.emailBtn.setOnClickListener(new c());
        mViews.mailBtn.setOnClickListener(new c());
        mViews.pickUpBtn.setOnClickListener(new c());
        mViews.fiatsBtn.setOnClickListener(new c());
        mViews.smsBtn.setOnClickListener(new c());
        mViews.shipMeBtn.setOnClickListener(new c());
        mViews.rootMenu.setOnFloatingActionsMenuUpdateListener(new b());
    }

    private void d(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.d())
        {
            boolean flag = productfulfillmentoptions.k();
            productfulfillmentoptions = getResources().getString(productfulfillmentoptions.r());
            mViews.pickUpBtn.setEnabled(flag);
            mViews.pickUpBtn.setButtonText(productfulfillmentoptions);
            al.b(mViews.pickUpBtn);
            return;
        } else
        {
            al.c(mViews.pickUpBtn);
            return;
        }
    }

    private void e(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.c())
        {
            boolean flag = productfulfillmentoptions.n();
            productfulfillmentoptions = getResources().getString(productfulfillmentoptions.s());
            mViews.fiatsBtn.setEnabled(flag);
            mViews.fiatsBtn.setButtonText(productfulfillmentoptions);
            al.b(mViews.fiatsBtn);
            return;
        } else
        {
            al.c(mViews.fiatsBtn);
            return;
        }
    }

    private void f(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.e())
        {
            boolean flag = productfulfillmentoptions.l();
            productfulfillmentoptions = getResources().getString(productfulfillmentoptions.p());
            mViews.shipMeBtn.setEnabled(flag);
            mViews.shipMeBtn.setButtonText(productfulfillmentoptions);
            al.b(mViews.shipMeBtn);
            return;
        } else
        {
            al.c(mViews.shipMeBtn);
            return;
        }
    }

    private void g(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.f())
        {
            mViews.mailBtn.setEnabled(productfulfillmentoptions.m());
            mViews.mailBtn.setButtonText(getResources().getString(productfulfillmentoptions.q()));
            al.b(mViews.mailBtn);
            return;
        } else
        {
            al.c(mViews.mailBtn);
            return;
        }
    }

    private void h(ProductFulfillmentOptions productfulfillmentoptions)
    {
        if (productfulfillmentoptions.h())
        {
            mViews.addToListBtn.setEnabled(productfulfillmentoptions.o());
            mViews.addToListBtn.setButtonText(getResources().getString(productfulfillmentoptions.w()));
            al.b(mViews.addToListBtn);
            return;
        } else
        {
            al.c(mViews.addToListBtn);
            return;
        }
    }

    public void a()
    {
        if (mViews.rootMenu.d())
        {
            return;
        } else
        {
            mViews.rootMenu.b();
            return;
        }
    }

    public void a(ProductFulfillmentOptions productfulfillmentoptions)
    {
        b(productfulfillmentoptions);
        c(productfulfillmentoptions);
        e(productfulfillmentoptions);
        d(productfulfillmentoptions);
        f(productfulfillmentoptions);
        g(productfulfillmentoptions);
        h(productfulfillmentoptions);
    }

    public void b()
    {
        if (!mViews.rootMenu.d())
        {
            return;
        } else
        {
            mViews.rootMenu.b();
            return;
        }
    }

    public void setClickListener(d d1)
    {
        mListener = d1;
    }
}
