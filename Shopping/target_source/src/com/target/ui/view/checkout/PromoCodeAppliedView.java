// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.target.mothership.model.cart.interfaces.PromoCode;
import com.target.mothership.util.o;
import com.target.ui.i.b.b;
import com.target.ui.util.al;
import com.target.ui.util.q;

// Referenced classes of package com.target.ui.view.checkout:
//            g

public class PromoCodeAppliedView extends FrameLayout
{
    static class Views extends com.target.ui.view.a
    {

        TextView codeText;
        TextView discount;
        View progress;
        View removeBtn;

        Views(View view)
        {
            super(view);
        }
    }

    private static final class a extends Enum
    {

        private static final a $VALUES[];
        public static final a PROMO_CODE;
        public static final a TEAM_MEMBER_DISCOUNT;

        public static a valueOf(String s)
        {
            return (a)Enum.valueOf(com/target/ui/view/checkout/PromoCodeAppliedView$a, s);
        }

        public static a[] values()
        {
            return (a[])$VALUES.clone();
        }

        static 
        {
            PROMO_CODE = new a("PROMO_CODE", 0);
            TEAM_MEMBER_DISCOUNT = new a("TEAM_MEMBER_DISCOUNT", 1);
            $VALUES = (new a[] {
                PROMO_CODE, TEAM_MEMBER_DISCOUNT
            });
        }

        private a(String s, int i)
        {
            super(s, i);
        }
    }

    private final class b
    {

        PromoCode code;
        String teamMemberNumber;
        final PromoCodeAppliedView this$0;
        a type;

        private b()
        {
            this$0 = PromoCodeAppliedView.this;
            super();
        }

    }


    private static final String TAG = com/target/ui/view/checkout/PromoCodeAppliedView.getSimpleName();
    private g mRemovalListener;
    private final android.view.View.OnClickListener mRemoveClickListener;
    private b mViewState;
    private Views mViews;

    public PromoCodeAppliedView(Context context)
    {
        super(context);
        mRemoveClickListener = new android.view.View.OnClickListener() {

            final PromoCodeAppliedView this$0;

            public void onClick(View view)
            {
                PromoCodeAppliedView.a(PromoCodeAppliedView.this, PromoCodeAppliedView.a(PromoCodeAppliedView.this));
            }

            
            {
                this$0 = PromoCodeAppliedView.this;
                super();
            }
        };
        a(context);
    }

    public PromoCodeAppliedView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mRemoveClickListener = new _cls1();
        a(context);
    }

    public PromoCodeAppliedView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mRemoveClickListener = new _cls1();
        a(context);
    }

    static b a(PromoCodeAppliedView promocodeappliedview)
    {
        return promocodeappliedview.mViewState;
    }

    private void a(Context context)
    {
        setLayoutParams(new android.widget.FrameLayout.LayoutParams(-1, -2));
        inflate(context, 0x7f03013a, this);
        mViews = new Views(this);
        mViews.removeBtn.setOnClickListener(mRemoveClickListener);
        mViewState = new b();
    }

    private void a(b b1)
    {
        if (mRemovalListener != null)
        {
            a(true);
            if (b1.type == a.PROMO_CODE)
            {
                mRemovalListener.a(b1.code);
                return;
            }
            if (b1.type == a.TEAM_MEMBER_DISCOUNT)
            {
                mRemovalListener.e(b1.teamMemberNumber);
                return;
            }
        }
    }

    static void a(PromoCodeAppliedView promocodeappliedview, b b1)
    {
        promocodeappliedview.a(b1);
    }

    public void a()
    {
        a(false);
    }

    public void a(PromoCode promocode)
    {
        if (promocode == null)
        {
            q.a(TAG, "Can't display a null PromoCode");
            return;
        } else
        {
            mViewState.code = promocode;
            mViewState.type = a.PROMO_CODE;
            String s = com.target.ui.i.b.b.b(promocode);
            promocode = com.target.ui.i.b.b.a(promocode);
            mViews.codeText.setText(promocode);
            mViews.discount.setText(s);
            return;
        }
    }

    public void a(boolean flag)
    {
        if (flag)
        {
            al.a(mViews.progress, new View[] {
                mViews.removeBtn
            });
            return;
        } else
        {
            al.a(mViews.removeBtn, new View[] {
                mViews.progress
            });
            return;
        }
    }

    public boolean a(String s)
    {
        String s1;
        if (mViewState.type == a.PROMO_CODE)
        {
            s1 = mViewState.code.b();
        } else
        {
            s1 = mViewState.teamMemberNumber;
        }
        if (o.c(s))
        {
            return false;
        } else
        {
            return s1.equalsIgnoreCase(s);
        }
    }

    public void b(String s)
    {
        if (o.c(s))
        {
            q.a(TAG, "Can't show a blank team member number discount");
            return;
        } else
        {
            mViewState.teamMemberNumber = s;
            mViewState.type = a.TEAM_MEMBER_DISCOUNT;
            mViews.codeText.setText(s);
            mViews.discount.setText(0x7f090262);
            return;
        }
    }

    public String getDisplayedPromoCode()
    {
        static class _cls2
        {

            static final int $SwitchMap$com$target$ui$view$checkout$PromoCodeAppliedView$PromoCodeType[];

            static 
            {
                $SwitchMap$com$target$ui$view$checkout$PromoCodeAppliedView$PromoCodeType = new int[a.values().length];
                try
                {
                    $SwitchMap$com$target$ui$view$checkout$PromoCodeAppliedView$PromoCodeType[a.PROMO_CODE.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$target$ui$view$checkout$PromoCodeAppliedView$PromoCodeType[a.TEAM_MEMBER_DISCOUNT.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls2..SwitchMap.com.target.ui.view.checkout.PromoCodeAppliedView.PromoCodeType[mViewState.type.ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return mViewState.code.b();

        case 2: // '\002'
            return mViewState.teamMemberNumber;
        }
    }

    public void setRemovalListener(g g1)
    {
        mRemovalListener = g1;
    }

}
