// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.common.coupon_wallets.CouponPromotionId;
import com.target.mothership.model.product.interfaces.ProductCartWheel;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.mothership.util.o;
import com.target.ui.common.g;
import com.target.ui.util.al;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.view.product:
//            FixedHeightListView

public class PdpCartwheelAndPromotionView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        View applyCouponButtonProgressView;
        TextView applyCouponButtonText;
        View applyCouponButtonWrapper;
        View cartwheelDiv;
        FixedHeightListView cartwheelListView;
        FixedHeightListView promotionListView;

        Views(View view)
        {
            super(view);
        }
    }

    private class a
        implements android.view.View.OnClickListener
    {

        private CouponPromotionId mCouponPromotionId;
        final PdpCartwheelAndPromotionView this$0;

        public void onClick(View view)
        {
            if (PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this) == null)
            {
                return;
            } else
            {
                PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this).a(mCouponPromotionId);
                return;
            }
        }

        public a(CouponPromotionId couponpromotionid)
        {
            this$0 = PdpCartwheelAndPromotionView.this;
            super();
            mCouponPromotionId = couponpromotionid;
        }
    }

    private class b
        implements android.widget.AdapterView.OnItemClickListener
    {

        final PdpCartwheelAndPromotionView this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            if (PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this) != null && i >= PdpCartwheelAndPromotionView.b(PdpCartwheelAndPromotionView.this).cartwheelListView.getHeaderViewsCount() && i < PdpCartwheelAndPromotionView.c(PdpCartwheelAndPromotionView.this).size())
            {
                adapterview = (ProductCartWheel)PdpCartwheelAndPromotionView.c(PdpCartwheelAndPromotionView.this).get(i);
                if (adapterview != null && o.g(adapterview.b()))
                {
                    PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this).a(adapterview);
                    return;
                }
            }
        }

        private b()
        {
            this$0 = PdpCartwheelAndPromotionView.this;
            super();
        }

    }

    public static interface c
    {

        public abstract void a(CouponPromotionId couponpromotionid);

        public abstract void a(ProductCartWheel productcartwheel);

        public abstract void a(ProductPromotion productpromotion);
    }

    private class d extends com.target.ui.adapter.b.e
    {

        private boolean displayCartWheelIcon;
        private int displayCartWheelTextColorResourceId;
        final PdpCartwheelAndPromotionView this$0;

        private List b(List list)
        {
            ArrayList arraylist = new ArrayList();
            PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this, list);
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                if (o.g(((ProductCartWheel)list.next()).b()))
                {
                    StringBuilder stringbuilder = new StringBuilder();
                    stringbuilder.append(getContext().getString(0x7f090425));
                    stringbuilder.append(" ");
                    stringbuilder.append(getContext().getString(0x7f090424));
                    arraylist.add(stringbuilder.toString());
                }
            } while (true);
            return arraylist;
        }

        public void a(int i)
        {
            displayCartWheelTextColorResourceId = i;
        }

        public void a(List list)
        {
            clear();
            a(((java.util.Collection) (b(list))));
            notifyDataSetChanged();
        }

        public void a(boolean flag)
        {
            displayCartWheelIcon = flag;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            String s = (String)getItem(i);
            if (view == null)
            {
                view = mInflater.inflate(0x7f030185, null, false);
                viewgroup = new a(view);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (a)view.getTag();
            }
            ((a) (viewgroup)).cartwheel.setText(s);
            if (displayCartWheelTextColorResourceId != -1)
            {
                ((a) (viewgroup)).cartwheel.setTextColor(getResources().getColor(displayCartWheelTextColorResourceId));
            }
            al.a(((a) (viewgroup)).cartwheelIcon, displayCartWheelIcon);
            return view;
        }

        public d(Context context)
        {
            this$0 = PdpCartwheelAndPromotionView.this;
            super(context, new ArrayList());
            displayCartWheelTextColorResourceId = -1;
            setNotifyOnChange(false);
            PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this, Collections.emptyList());
        }
    }

    private class d.a
    {

        final TextView cartwheel;
        final ImageView cartwheelIcon;
        final d this$1;

        public d.a(View view)
        {
            this$1 = d.this;
            super();
            cartwheel = (TextView)view.findViewById(0x7f100498);
            cartwheelIcon = (ImageView)view.findViewById(0x7f100497);
        }
    }

    private class e extends com.target.ui.adapter.b.e
    {

        private boolean displayPromoIcon;
        private int displayTextColorResourceId;
        final PdpCartwheelAndPromotionView this$0;

        private List b(List list)
        {
            ArrayList arraylist = new ArrayList();
            PdpCartwheelAndPromotionView.b(PdpCartwheelAndPromotionView.this, list);
            for (list = list.iterator(); list.hasNext(); arraylist.add(((ProductPromotion)list.next()).b())) { }
            return arraylist;
        }

        public void a(int i)
        {
            displayTextColorResourceId = i;
        }

        public void a(List list)
        {
            clear();
            a(((java.util.Collection) (b(list))));
            notifyDataSetChanged();
        }

        public void a(boolean flag)
        {
            displayPromoIcon = flag;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            String s = (String)getItem(i);
            if (view == null)
            {
                view = mInflater.inflate(0x7f030192, null, false);
                viewgroup = new a(view);
                view.setTag(viewgroup);
            } else
            {
                viewgroup = (a)view.getTag();
            }
            ((a) (viewgroup)).promotion.setText(s);
            if (displayTextColorResourceId != -1)
            {
                ((a) (viewgroup)).promotion.setTextColor(getResources().getColor(displayTextColorResourceId));
            }
            al.a(((a) (viewgroup)).promotionTag, displayPromoIcon);
            return view;
        }

        public e(Context context)
        {
            this$0 = PdpCartwheelAndPromotionView.this;
            super(context, new ArrayList());
            displayTextColorResourceId = -1;
            setNotifyOnChange(false);
        }
    }

    private class e.a
    {

        final TextView promotion;
        final ImageView promotionTag;
        final e this$1;

        public e.a(View view)
        {
            this$1 = e.this;
            super();
            promotion = (TextView)view.findViewById(0x7f1004d4);
            promotionTag = (ImageView)view.findViewById(0x7f1004d3);
        }
    }

    private class f
        implements android.widget.AdapterView.OnItemClickListener
    {

        final PdpCartwheelAndPromotionView this$0;

        public void onItemClick(AdapterView adapterview, View view, int i, long l)
        {
            while (PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this) == null || i < PdpCartwheelAndPromotionView.b(PdpCartwheelAndPromotionView.this).cartwheelListView.getHeaderViewsCount() || i >= PdpCartwheelAndPromotionView.d(PdpCartwheelAndPromotionView.this).size()) 
            {
                return;
            }
            adapterview = (ProductPromotion)PdpCartwheelAndPromotionView.d(PdpCartwheelAndPromotionView.this).get(i);
            PdpCartwheelAndPromotionView.a(PdpCartwheelAndPromotionView.this).a(adapterview);
        }

        private f()
        {
            this$0 = PdpCartwheelAndPromotionView.this;
            super();
        }

    }


    private static final int INVALID_RES = -1;
    private List mCartWheel;
    private d mCartwheelAdapter;
    private c mListener;
    private e mPromotionAdapter;
    private List mPromotions;
    private Views mViews;

    public PdpCartwheelAndPromotionView(Context context)
    {
        super(context);
        d();
    }

    public PdpCartwheelAndPromotionView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        d();
    }

    public PdpCartwheelAndPromotionView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        d();
    }

    private int a(com.target.ui.common.g.a a1)
    {
        static class _cls1
        {

            static final int $SwitchMap$com$target$ui$common$ProductPromoOptions$PromoColor[];

            static 
            {
                $SwitchMap$com$target$ui$common$ProductPromoOptions$PromoColor = new int[com.target.ui.common.g.a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$common$ProductPromoOptions$PromoColor[com.target.ui.common.g.a.RED.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$common$ProductPromoOptions$PromoColor[com.target.ui.common.g.a.BLACK.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.target.ui.common.ProductPromoOptions.PromoColor[a1.ordinal()])
        {
        default:
            return 0x7f0f00f3;

        case 1: // '\001'
            return 0x7f0f00eb;
        }
    }

    static c a(PdpCartwheelAndPromotionView pdpcartwheelandpromotionview)
    {
        return pdpcartwheelandpromotionview.mListener;
    }

    static List a(PdpCartwheelAndPromotionView pdpcartwheelandpromotionview, List list)
    {
        pdpcartwheelandpromotionview.mCartWheel = list;
        return list;
    }

    private void a(boolean flag)
    {
        View view;
        int i;
        int j;
        if (flag)
        {
            j = 0x7f09041b;
            i = 0x7f0f00f6;
        } else
        {
            j = 0x7f09041c;
            i = 0x7f0f00eb;
        }
        mViews.applyCouponButtonText.setText(getResources().getString(j));
        mViews.applyCouponButtonText.setTextColor(getResources().getColor(i));
        view = mViews.applyCouponButtonWrapper;
        if (!flag)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        view.setClickable(flag);
    }

    static Views b(PdpCartwheelAndPromotionView pdpcartwheelandpromotionview)
    {
        return pdpcartwheelandpromotionview.mViews;
    }

    static List b(PdpCartwheelAndPromotionView pdpcartwheelandpromotionview, List list)
    {
        pdpcartwheelandpromotionview.mPromotions = list;
        return list;
    }

    static List c(PdpCartwheelAndPromotionView pdpcartwheelandpromotionview)
    {
        return pdpcartwheelandpromotionview.mCartWheel;
    }

    static List d(PdpCartwheelAndPromotionView pdpcartwheelandpromotionview)
    {
        return pdpcartwheelandpromotionview.mPromotions;
    }

    private void d()
    {
        setOrientation(1);
        inflate(getContext(), 0x7f030186, this);
        mViews = new Views(this);
        e();
        f();
        mCartWheel = Collections.emptyList();
        mPromotions = Collections.emptyList();
    }

    private void e()
    {
        mCartwheelAdapter = new d(getContext());
        mPromotionAdapter = new e(getContext());
        mViews.cartwheelListView.setAdapter(mCartwheelAdapter);
        mViews.promotionListView.setAdapter(mPromotionAdapter);
    }

    private void f()
    {
        mViews.cartwheelListView.setOnItemClickListener(new b(null));
        mViews.promotionListView.setOnItemClickListener(new f(null));
    }

    private void g()
    {
        al.a(mViews.applyCouponButtonText, new View[] {
            mViews.applyCouponButtonProgressView
        });
    }

    public void a()
    {
        a(true);
        g();
    }

    public void b()
    {
        a(false);
        g();
    }

    public void c()
    {
        mViews.applyCouponButtonWrapper.setClickable(false);
        al.a(mViews.applyCouponButtonProgressView, new View[] {
            mViews.applyCouponButtonText
        });
    }

    public void setClickListener(c c1)
    {
        mListener = c1;
    }

    public void setData(g g1)
    {
        if (mViews == null)
        {
            return;
        }
        if (g1.b().isEmpty())
        {
            al.a(new View[] {
                mViews.cartwheelListView, mViews.cartwheelDiv
            });
        } else
        {
            mCartwheelAdapter.a(g1.e());
            mCartwheelAdapter.a(a(g1.g()));
            mCartwheelAdapter.a(g1.b());
            al.b(new View[] {
                mViews.cartwheelListView, mViews.cartwheelDiv
            });
        }
        if (g1.c().isEmpty())
        {
            al.c(mViews.promotionListView);
        } else
        {
            mPromotionAdapter.a(g1.f());
            mPromotionAdapter.a(a(g1.g()));
            mPromotionAdapter.a(g1.c());
            al.b(mViews.promotionListView);
        }
        if (!g1.h().b())
        {
            al.c(mViews.applyCouponButtonWrapper);
            return;
        }
        mViews.applyCouponButtonWrapper.setOnClickListener(new a((CouponPromotionId)g1.h().c()));
        if (g1.d())
        {
            a();
        } else
        {
            b();
        }
        al.b(mViews.applyCouponButtonWrapper);
    }
}
