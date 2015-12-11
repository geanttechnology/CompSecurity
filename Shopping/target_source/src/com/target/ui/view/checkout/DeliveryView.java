// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.checkout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.target.ui.model.checkout.DeliveryDetailsModel;
import com.target.ui.model.checkout.DeliveryTypedProducts;
import com.target.ui.model.checkout.EmailRecipientDetailsModel;
import com.target.ui.model.checkout.PickUpPersonDetailsModel;
import com.target.ui.model.checkout.ShippingAddressDetailsModel;
import com.target.ui.model.checkout.SmsRecipientDetailsModel;
import com.target.ui.util.al;
import com.target.ui.view.account.b;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.ui.view.checkout:
//            ShippingAddressView, PickUpDetailsView, EmailRecipientDetailsView, SmsRecipientDetailsView

public class DeliveryView extends LinearLayout
    implements com.target.ui.view.account.b
{
    static class Views extends com.target.ui.view.a
    {

        View addressSpacer;
        EmailRecipientDetailsView emailRecipientDetailsView;
        View emailSpacer;
        PickUpDetailsView pickUpDetailsView;
        View pickupSpacer;
        ShippingAddressView shippingAddressView;
        SmsRecipientDetailsView smsRecipientDetailsView;
        View smsSpacer;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a(EmailRecipientDetailsModel emailrecipientdetailsmodel);

        public abstract void a(PickUpPersonDetailsModel pickuppersondetailsmodel);

        public abstract void a(SmsRecipientDetailsModel smsrecipientdetailsmodel);

        public abstract void a(List list);

        public abstract void b(List list);

        public abstract void j();

        public abstract void k();

        public abstract void o();
    }

    private class b
    {

        boolean pickUpDetailsValid;
        boolean shippingValid;
        final DeliveryView this$0;

        private b()
        {
            this$0 = DeliveryView.this;
            super();
            shippingValid = false;
            pickUpDetailsValid = false;
        }

    }

    public final class c
        implements PickUpDetailsView.b
    {

        public String firstName;
        public boolean isValid;
        public String lastName;
        final DeliveryView this$0;

        public void a()
        {
            isValid = false;
        }

        public void a(String s, String s1)
        {
            firstName = s;
            lastName = s1;
            isValid = true;
        }

        public c()
        {
            this$0 = DeliveryView.this;
            super();
        }
    }


    private a mActionListener;
    private DeliveryDetailsModel mDeliveryDetails;
    private List mEmailDeliveryProductList;
    private b mFormState;
    private com.target.ui.view.account.b mInputValidationListener;
    private List mPickUpProductList;
    private List mShipHomeProductList;
    private List mSmsDeliveryProductList;
    private Views mViews;

    public DeliveryView(Context context)
    {
        super(context);
        mViews = null;
        mShipHomeProductList = new ArrayList();
        mPickUpProductList = new ArrayList();
        mEmailDeliveryProductList = new ArrayList();
        mSmsDeliveryProductList = new ArrayList();
        a(context);
    }

    public DeliveryView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mViews = null;
        mShipHomeProductList = new ArrayList();
        mPickUpProductList = new ArrayList();
        mEmailDeliveryProductList = new ArrayList();
        mSmsDeliveryProductList = new ArrayList();
        a(context);
    }

    public DeliveryView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mViews = null;
        mShipHomeProductList = new ArrayList();
        mPickUpProductList = new ArrayList();
        mEmailDeliveryProductList = new ArrayList();
        mSmsDeliveryProductList = new ArrayList();
        a(context);
    }

    private void a(DeliveryDetailsModel deliverydetailsmodel)
    {
        deliverydetailsmodel = deliverydetailsmodel.a();
        if (deliverydetailsmodel == null)
        {
            return;
        } else
        {
            mShipHomeProductList = deliverydetailsmodel.a();
            mPickUpProductList = deliverydetailsmodel.b();
            mEmailDeliveryProductList = deliverydetailsmodel.c();
            mSmsDeliveryProductList = deliverydetailsmodel.d();
            return;
        }
    }

    private void a(boolean flag)
    {
        if (mInputValidationListener != null)
        {
            mInputValidationListener.a(this, flag);
        }
    }

    private boolean a(b b1)
    {
        return b1.shippingValid && b1.pickUpDetailsValid;
    }

    private void b()
    {
        c();
        if (d())
        {
            al.b(new View[] {
                mViews.shippingAddressView, mViews.addressSpacer
            });
            ShippingAddressDetailsModel shippingaddressdetailsmodel = mDeliveryDetails.b();
            mFormState.shippingValid = shippingaddressdetailsmodel.a();
            mViews.shippingAddressView.a(shippingaddressdetailsmodel, mShipHomeProductList, mActionListener);
        } else
        {
            mFormState.shippingValid = true;
            al.a(new View[] {
                mViews.shippingAddressView, mViews.addressSpacer
            });
        }
        if (e())
        {
            al.b(new View[] {
                mViews.pickUpDetailsView, mViews.pickupSpacer
            });
            mViews.pickUpDetailsView.setInputValidationListener(this);
            mViews.pickUpDetailsView.a(mDeliveryDetails.c(), mActionListener);
        } else
        {
            mFormState.pickUpDetailsValid = true;
            al.a(new View[] {
                mViews.pickUpDetailsView, mViews.pickupSpacer
            });
        }
        if (f())
        {
            mViews.emailRecipientDetailsView.a(mDeliveryDetails.d(), mActionListener);
            al.b(new View[] {
                mViews.emailRecipientDetailsView, mViews.emailSpacer
            });
        } else
        {
            al.a(new View[] {
                mViews.emailRecipientDetailsView, mViews.emailSpacer
            });
        }
        if (g())
        {
            mViews.smsRecipientDetailsView.a(mDeliveryDetails.e(), mActionListener);
            al.b(new View[] {
                mViews.smsRecipientDetailsView, mViews.smsSpacer
            });
        } else
        {
            al.a(new View[] {
                mViews.smsRecipientDetailsView, mViews.smsSpacer
            });
        }
        a(a(mFormState));
    }

    private void c()
    {
        mFormState.shippingValid = false;
        mFormState.pickUpDetailsValid = false;
    }

    private boolean d()
    {
        return !mShipHomeProductList.isEmpty();
    }

    private boolean e()
    {
        return !mPickUpProductList.isEmpty();
    }

    private boolean f()
    {
        return !mEmailDeliveryProductList.isEmpty();
    }

    private boolean g()
    {
        return !mSmsDeliveryProductList.isEmpty();
    }

    public void a()
    {
        if (!a(mFormState))
        {
            if (d())
            {
                mViews.shippingAddressView.a();
            }
            if (e())
            {
                mViews.pickUpDetailsView.a();
                return;
            }
        }
    }

    public void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f03012f, this);
        mViews = new Views(this);
        mFormState = new b();
    }

    public void a(View view, boolean flag)
    {
        int i = view.getId();
        if (i != mViews.shippingAddressView.getId()) goto _L2; else goto _L1
_L1:
        mFormState.shippingValid = flag;
_L4:
        a(a(mFormState));
        return;
_L2:
        if (i == mViews.pickUpDetailsView.getId())
        {
            mFormState.pickUpDetailsValid = flag;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void a(DeliveryDetailsModel deliverydetailsmodel, a a1, com.target.ui.view.account.b b1)
    {
        if (deliverydetailsmodel == null)
        {
            return;
        } else
        {
            mActionListener = a1;
            mInputValidationListener = b1;
            mDeliveryDetails = deliverydetailsmodel;
            a(mDeliveryDetails);
            b();
            return;
        }
    }

    public void a(EmailRecipientDetailsModel emailrecipientdetailsmodel)
    {
        mViews.emailRecipientDetailsView.a(emailrecipientdetailsmodel);
    }

    public void a(PickUpPersonDetailsModel pickuppersondetailsmodel)
    {
        mViews.pickUpDetailsView.a(pickuppersondetailsmodel);
    }

    public void a(SmsRecipientDetailsModel smsrecipientdetailsmodel)
    {
        mViews.smsRecipientDetailsView.a(smsrecipientdetailsmodel);
    }

    public c getPickUpNameDetails()
    {
        c c1 = new c();
        mViews.pickUpDetailsView.a(c1);
        return c1;
    }
}
