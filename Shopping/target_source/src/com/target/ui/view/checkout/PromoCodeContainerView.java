// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.target.mothership.model.cart.interfaces.OrderReview;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.model.cart.interfaces.a.e;
import com.target.mothership.model.cart.interfaces.a.g;
import com.target.mothership.util.o;
import com.target.ui.util.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.checkout:
//            g, PromoCodeAppliedView, PromoCodeInputView

public class PromoCodeContainerView extends LinearLayout
    implements com.target.ui.view.checkout.g
{
    static class Views extends com.target.ui.view.a
    {

        PromoCodeInputView inputView;

        Views(View view)
        {
            super(view);
        }
    }

    private static final class a
    {

        final boolean found;
        final PromoCodeAppliedView view;

        a(boolean flag, PromoCodeAppliedView promocodeappliedview)
        {
            found = flag;
            view = promocodeappliedview;
        }
    }


    private static final String TAG = com/target/ui/view/checkout/PromoCodeContainerView.getSimpleName();
    private Handler mHandler;
    private com.target.ui.view.checkout.g mListener;
    private Views mViews;

    public PromoCodeContainerView(Context context)
    {
        super(context);
        mHandler = new Handler();
        a(context);
    }

    public PromoCodeContainerView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mHandler = new Handler();
        a(context);
    }

    public PromoCodeContainerView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mHandler = new Handler();
        a(context);
    }

    static Views a(PromoCodeContainerView promocodecontainerview)
    {
        return promocodecontainerview.mViews;
    }

    private List a(List list)
    {
        ArrayList arraylist = new ArrayList();
        int j = getChildCount();
        for (int i = 0; i < j; i++)
        {
            Object obj = getChildAt(i);
            if (!(obj instanceof PromoCodeAppliedView))
            {
                continue;
            }
            obj = (PromoCodeAppliedView)obj;
            if (!list.contains(((PromoCodeAppliedView) (obj)).getDisplayedPromoCode()))
            {
                arraylist.add(obj);
            }
        }

        return arraylist;
    }

    private void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f03013c, this);
        mViews = new Views(this);
        mViews.inputView.setPromoCodeInputListener(this);
    }

    private PromoCodeAppliedView b()
    {
        return (PromoCodeAppliedView)((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(0x7f03013b, this, false);
    }

    private void b(OrderReview orderreview)
    {
        Object obj = orderreview.s();
        ArrayList arraylist = new ArrayList(((List) (obj)).size());
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); arraylist.add(((PromoCode)((Iterator) (obj)).next()).b())) { }
        if (o.d(orderreview.y()))
        {
            arraylist.add(orderreview.y());
        }
        for (orderreview = a(arraylist).iterator(); orderreview.hasNext(); removeView((View)orderreview.next())) { }
    }

    private void b(String s)
    {
        if (o.c(s))
        {
            q.a(TAG, "can't show empty or null team member numbers");
        } else
        if (!f(s).found)
        {
            c(s);
            return;
        }
    }

    private void c(PromoCode promocode)
    {
        if (promocode == null || o.c(promocode.b()))
        {
            q.a(TAG, "Can't show a null promo code");
        } else
        if (!f(promocode.b()).found)
        {
            d(promocode);
            return;
        }
    }

    private void c(String s)
    {
        mViews.inputView.a(false);
        mViews.inputView.a();
        final PromoCodeAppliedView appliedView = b();
        appliedView.setRemovalListener(this);
        mHandler.post(new Runnable() {

            final PromoCodeContainerView this$0;
            final PromoCodeAppliedView val$appliedView;

            public void run()
            {
                if (PromoCodeContainerView.a(PromoCodeContainerView.this) != null)
                {
                    addView(appliedView, 1);
                }
            }

            
            {
                this$0 = PromoCodeContainerView.this;
                appliedView = promocodeappliedview;
                super();
            }
        });
        appliedView.b(s);
    }

    private void d(PromoCode promocode)
    {
        mViews.inputView.a(false);
        mViews.inputView.a();
        final PromoCodeAppliedView appliedView = b();
        appliedView.setRemovalListener(this);
        mHandler.post(new Runnable() {

            final PromoCodeContainerView this$0;
            final PromoCodeAppliedView val$appliedView;

            public void run()
            {
                if (PromoCodeContainerView.a(PromoCodeContainerView.this) != null)
                {
                    addView(appliedView, 1);
                }
            }

            
            {
                this$0 = PromoCodeContainerView.this;
                appliedView = promocodeappliedview;
                super();
            }
        });
        appliedView.a(promocode);
    }

    private a f(String s)
    {
        int j = getChildCount();
        for (int i = 0; i < j; i++)
        {
            Object obj = getChildAt(i);
            if (!(obj instanceof PromoCodeAppliedView))
            {
                continue;
            }
            obj = (PromoCodeAppliedView)obj;
            if (((PromoCodeAppliedView) (obj)).a(s))
            {
                return new a(true, ((PromoCodeAppliedView) (obj)));
            }
        }

        return new a(false, null);
    }

    public void a()
    {
        mViews.inputView.a(false);
        int j = getChildCount();
        for (int i = 0; i < j; i++)
        {
            View view = getChildAt(i);
            if (view instanceof PromoCodeAppliedView)
            {
                ((PromoCodeAppliedView)view).a(false);
            }
        }

    }

    public void a(OrderReview orderreview)
    {
        mViews.inputView.a(false);
        Object obj = orderreview.s();
        if (o.d(orderreview.y()))
        {
            b(orderreview.y());
        }
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); c((PromoCode)((Iterator) (obj)).next())) { }
        b(orderreview);
    }

    public void a(PromoCode promocode)
    {
        if (mListener == null)
        {
            q.a(TAG, "tried to remove promo code but listener was null");
            return;
        } else
        {
            mListener.a(promocode);
            return;
        }
    }

    public void a(e e1)
    {
        e1 = (com.target.mothership.model.cart.interfaces.a.e.a)e1.f().get(0);
        mViews.inputView.a(e1);
        mViews.inputView.a(false);
    }

    public void a(g g1)
    {
        g1 = (com.target.mothership.model.cart.interfaces.a.g.a)g1.f().get(0);
        mViews.inputView.a(g1);
        mViews.inputView.a(false);
    }

    public void a(String s)
    {
        s = f(s);
        if (((a) (s)).found)
        {
            ((a) (s)).view.a();
        }
    }

    public void a(boolean flag)
    {
        mViews.inputView.a(flag);
    }

    public void b(PromoCode promocode)
    {
        promocode = f(promocode.b());
        if (((a) (promocode)).found)
        {
            ((a) (promocode)).view.a();
        }
    }

    public void d(String s)
    {
        if (mListener == null)
        {
            q.a(TAG, "tried to pass a promocode to PromoCodeInputListener, but the listener was null");
            return;
        } else
        {
            mViews.inputView.a(true);
            mListener.d(s);
            return;
        }
    }

    public void e(String s)
    {
        if (mListener == null)
        {
            q.a(TAG, "tried to remove team member discount, but listener was null");
            return;
        } else
        {
            mListener.e(s);
            return;
        }
    }

    public void setPromoCodeActionListener(com.target.ui.view.checkout.g g1)
    {
        mListener = g1;
    }

}
